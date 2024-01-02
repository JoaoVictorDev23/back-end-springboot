package com.tdm.helpdesk.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tdm.helpdesk.domain.USUARIO;
import com.tdm.helpdesk.services.USUARIOService;

@RestController
@RequestMapping(value = "/usuarios")
public class UsuarioResource {
	
	@Autowired
	private USUARIOService service;

	@GetMapping(value = "/{id}")
	public ResponseEntity<USUARIO> findById(@PathVariable Integer id) {
		USUARIO obj = this.service.findById(id);
		return ResponseEntity.ok().body(obj);	

	}
}
