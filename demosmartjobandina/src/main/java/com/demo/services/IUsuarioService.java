package com.demo.services;

import java.util.List;

import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;

import com.demo.entity.Usuario;

public interface IUsuarioService {
	
	public List<Usuario> findAll();
	
	public ResponseEntity<?> findById(Long id);
	
	//public Usuario save(Usuario activiad);
	
	public ResponseEntity<?> save(Usuario activiad,BindingResult resul);
	public ResponseEntity<?> delete(Long id);
	
	public ResponseEntity<?> update(Usuario activiad,BindingResult resul);




}
