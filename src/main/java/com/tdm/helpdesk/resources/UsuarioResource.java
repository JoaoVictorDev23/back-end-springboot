package com.tdm.helpdesk.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.tdm.helpdesk.domain.USUARIO;
import com.tdm.helpdesk.domain.dtos.USUARIODTO;
import com.tdm.helpdesk.services.USUARIOService;

@RestController
@RequestMapping(value = "/usuarios")
public class UsuarioResource {
	
	@Autowired
	private USUARIOService service;

	@GetMapping(value = "/{id}")
	public ResponseEntity<USUARIODTO> findById(@PathVariable Integer id) {
		USUARIO obj = this.service.findById(id);
		return ResponseEntity.ok().body(new USUARIODTO(obj));	

	}
	
	@GetMapping
	public ResponseEntity<List<USUARIODTO>> findAll(){
		List<USUARIO> list = service.findAll();
		List<USUARIODTO> listdto = list.stream().map(obj -> new USUARIODTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listdto);
		
	}
	
	@PostMapping	
	public ResponseEntity<USUARIODTO> create(@Valid @RequestBody USUARIODTO objDTO){
		USUARIO newObj = service.create(objDTO);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newObj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
    @PutMapping(value ="/{id}")
	public ResponseEntity<USUARIODTO> update(@PathVariable Integer id,@Valid @RequestBody USUARIODTO objDTO){

    	USUARIO obj = service.update(id,objDTO);
    	return ResponseEntity.ok().body(new USUARIODTO(obj));
    }
    
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<USUARIODTO> delete(@PathVariable Integer id){
    	service.delete(id);
    	return ResponseEntity.noContent().build();
    	
    }
    
    
 	
}
