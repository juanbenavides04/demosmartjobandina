package com.demo.service;

import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.stubbing.Answer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.demo.entity.Usuario;
import com.demo.services.IUsuarioService;
import com.demo.services.UsuarioServiceImp;

public class UsuarioServiceImpTest {
	
    @InjectMocks
    private UsuarioServiceImp usuarioServiceImp;

    @Mock
    IUsuarioService iUsuarioService;

    @BeforeEach
    void setup() {
        MockitoAnnotations.initMocks(this);
    }
    
    @Test
    void testfindById() {
    	ResponseEntity r=new ResponseEntity(HttpStatus.ACCEPTED);

        Mockito.when(iUsuarioService.findById(Mockito.any())).thenReturn(r);
        ResponseEntity<?> usuario = iUsuarioService.findById((long)1);
            Assertions.assertTrue(usuario != null);

    }
    
    @Test
    void testsave() {
    	Usuario usuario=new Usuario();
    	usuario.setName("name");
    	usuario.setEmail("email_3@gmail.com");
    	usuario.setPassword("password_3");
    	
		when(iUsuarioService.save(Mockito.any(),Mockito.any())).then(null);
    	
		ResponseEntity<?> usuarioSave =usuarioServiceImp.save(usuario, null);
		//Assertions.assertThat("name", usuarioSave.getClass().getName());
		Assertions.assertTrue((boolean) usuarioSave.getBody());
    }
    
    
   /* @Test
    void testfindAll() {
    	List<Usuario> listUsuario=null;
    	
        Mockito.when(iUsuarioService.findAll()).thenReturn(listUsuario);
        List<Usuario> usuario = iUsuarioService.findAll();

      //  Assertions.assertFalse(usuario.isEmpty());
        System.out.println(usuario.size());
      //  List<Usuario> usuario2 =null;
          //  Assertions.assertTrue(usuario != usuario2);

    }*/

}
