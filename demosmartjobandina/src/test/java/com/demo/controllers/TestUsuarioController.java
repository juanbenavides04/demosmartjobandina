package com.demo.controllers;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.http.MediaType;

import com.demo.entity.Usuario;
import com.demo.services.UsuarioServiceImp;

@ExtendWith(SpringExtension.class)
public class TestUsuarioController {
	
    @MockBean
    private UsuarioServiceImp usuarioServiceImp;


    private MockMvc mockMvc;

    @SuppressWarnings("deprecation")
	@BeforeEach
    void setUp(){
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders
            .standaloneSetup(new UsuarioController()).build();
    }	
    
    @Test
    void testConsultaProductosPorRut() throws Exception {
        Mockito.when(this.usuarioServiceImp.findAll())
        .thenReturn(new ArrayList<Usuario>());

    mockMvc.perform(MockMvcRequestBuilders.get("/mostrarlista")
            .contentType(MediaType.APPLICATION_JSON_VALUE))
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_VALUE));
    	
    }

}
