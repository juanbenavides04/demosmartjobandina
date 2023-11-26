package com.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.demo.entity.Usuario;
import com.demo.services.IUsuarioService;

import jakarta.validation.Valid;


@RestController
@RequestMapping("/api")
public class UsuarioController {
	
	@Autowired
	private IUsuarioService ActividadService;
	
	@PostMapping("/guardar")
	public ResponseEntity<?> guardar(@Valid @RequestBody Usuario usuario, BindingResult result) {
		return ActividadService.save(usuario, result);
	}
	
	
	@PostMapping("/modificar")
	public ResponseEntity<?> modificar(@Valid @RequestBody Usuario usuario, BindingResult result) {
		return ActividadService.update(usuario,result);
	}
	
	@GetMapping("/mostrar/{id}")
	public ResponseEntity<?> mostrar(@PathVariable Long id) {
		return ActividadService.findById(id);
	}
	
	@GetMapping("/mostrarlista")
	public List<Usuario> mostrarlista() {
		return ActividadService.findAll();
	}
	
	
	@GetMapping("/eliminar/{id}")
	public ResponseEntity<?> eliminar(@PathVariable Long id) {
		 return ActividadService.delete(id);
	}
	


}
