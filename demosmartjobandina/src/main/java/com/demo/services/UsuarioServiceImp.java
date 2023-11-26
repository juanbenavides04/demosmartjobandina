package com.demo.services;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.demo.dao.IUsuarioDao;
import com.demo.entity.Usuario;

import jakarta.transaction.Transactional;

@Service	
public class UsuarioServiceImp implements IUsuarioService {
	
	@Autowired
	private IUsuarioDao iUsuarDao;

	@Override
	public List<Usuario> findAll() {
		// TODO Auto-generated method stub
		return iUsuarDao.findAll();
	}
	
	@Override
	public ResponseEntity<?> findById(Long id) {
		
		
		Usuario usuario=null;
		Map<String, Object> response=new HashMap<>();		
		
		try {
			usuario=iUsuarDao.findById(id).orElse(null);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar la consulta en la base de datos.");
			response.put("error",e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
		}
		
		if(usuario==null) {
			response.put("mensaje","El usuario ID : ".concat(id.toString().concat(" no existe en la base de datos!")));
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus.NOT_FOUND);
		}
		
		
		return new ResponseEntity<Usuario>(usuario,HttpStatus.OK);	
	
	}


	/*@Override
	@Transactional
	public Usuario save(Usuario actividad) {
		// TODO Auto-generated method stub
		return iUsuarDao.saveAndFlush(actividad);
	}*/
	
	@Override
	public ResponseEntity<?> save(Usuario usuario,BindingResult result) {

		Usuario usuarioNew=null;
		Map<String, Object> response=new HashMap<>();
		
		if(result.hasErrors()) {
			
			
			
			List<String> errors=result.getFieldErrors()
					.stream()
					.map(err->"El campo '"+err.getField()+"' "+err.getDefaultMessage()
						).collect(Collectors.toList());
			
			response.put("errors", errors);
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus.BAD_REQUEST);
		}
		
		try {
			usuarioNew=iUsuarDao.save(usuario);
			response.put("mensaje","El usuario ha sido creado con éxito!");
			response.put("usuario",usuarioNew);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar el insert en la base de datos.");
			response.put("error",e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		

		
		return new ResponseEntity<Map<String, Object>>(response,HttpStatus.CREATED);
	}

	@Override
	@Transactional
	public ResponseEntity<?> delete(Long id) {
		
		Map<String, Object> response=new HashMap<>();
		try {
			
			Optional<Usuario> actividad=iUsuarDao.findById(id);
			 if(actividad.isPresent()) {
				 iUsuarDao.deleteById(id);
				 response.put("mensaje","El usuario ha sido eliminado con éxito!");
			 }else {
				 response.put("mensaje", "Error esta noticia no existe en la base de datos.");
			 }
		
			
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al eliminar al usuario en la base de datos.");
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}		
		
		
		return new ResponseEntity<Map<String, Object>>(response,HttpStatus.OK);
	}

	@Override
	public ResponseEntity<?> update(Usuario usuario, BindingResult resul) {

		Usuario usuarioActual = iUsuarDao.findById(usuario.getId()).orElse(null);
		Usuario usuarioUpdated = null;

		Map<String, Object> response = new HashMap<>();

		if (resul.hasErrors()) {
			List<String> errors = resul.getFieldErrors().stream()
					.map(err -> err.getField() + ": " + err.getDefaultMessage()).collect(Collectors.toList());

			response.put("errors", errors);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
		}

		if (usuarioActual == null) {
			response.put("mensaje", "El usuario ID: ".concat(usuario.getId().toString()).concat(" no existe en la base de datos"));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}

		try {
			/*clienteActual.setApellido(usuario.getApellido());
			clienteActual.setNombre(cliente.getNombre());
			clienteActual.setEmail(cliente.getEmail());
			clienteActual.setRegion(cliente.getRegion());
*/
			usuario.setCreated(usuarioActual.getCreated());
			usuario.setModified(new Date());
			usuarioUpdated = iUsuarDao.save(usuario);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar el update en la base de datos");
			//response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		response.put("mensaje", "El usuario ha sido actualizado con éxito");
		response.put("usuario", usuarioUpdated);

		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}





}
