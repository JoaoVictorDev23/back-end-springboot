package com.tdm.helpdesk.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tdm.helpdesk.domain.Tarifa;
import com.tdm.helpdesk.domain.USUARIO;
import com.tdm.helpdesk.domain.enums.Perfil;
import com.tdm.helpdesk.domain.enums.Status;
import com.tdm.helpdesk.repositories.TarifaRepository;
import com.tdm.helpdesk.repositories.UsuarioRepository;

@Service
public class DBService {
	
	@Autowired
	private UsuarioRepository usuariorepository;
	@Autowired
	private TarifaRepository tarifarepository;
	
	
	 public void instanciaDB() {
			
			USUARIO user1 = new USUARIO(null, "Rikally", "11111111111", "Rikally@tdmlogistica.com", "12345");
			user1.addPerfil(Perfil.ADMIN);
			
			Tarifa t1 = new Tarifa(null, Status.ABERTO, "Teste", "Goiania","Sao Paulo", 110.5, user1);
			
			usuariorepository.saveAll(Arrays.asList(user1));
			tarifarepository.saveAll(Arrays.asList(t1));
	 }
}
