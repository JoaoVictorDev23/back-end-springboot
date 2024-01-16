package com.tdm.helpdesk.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
	@Autowired
	private BCryptPasswordEncoder encoder;

	
	
	 public void instanciaDB() {
			
			USUARIO user1 = new USUARIO(null, "Rikally", "953.225.110-32", "Rikally@tdmlogistica.com", encoder.encode("12345"));
			user1.addPerfil(Perfil.ADMIN);
			USUARIO user2 = new USUARIO(null, "Fabiano", "083.447.040-30", "fabiano@tdmlogistica.com", encoder.encode("123456"));
			
			USUARIO user3 = new USUARIO(null, "Lucas", "912.146.430-86", "lucas@tdmlogistica.com", encoder.encode("12345"));
			user3.addPerfil(Perfil.ADMIN); 
			USUARIO user4 = new USUARIO(null, "Gustavo", "457.496.370-00", "gustavo@tdmlogistica.com", encoder.encode("12345"));
			
			Tarifa t1 = new Tarifa(null, Status.ABERTO, "Teste", "Goiania","Sao Paulo", 112.5, user1);
			Tarifa t2 = new Tarifa(null, Status.ENCERRADO, "Teste", "Rio","Sao Paulo", 1110.5, user2);

			Tarifa t3 = new Tarifa(null, Status.PROCESSANDO, "Teste", "Goiania","Sao Paulo", 11110.5, user3);

			Tarifa t4 = new Tarifa(null, Status.ABERTO, "Teste", "Goiania","Sao Paulo", 112220.5, user4);

			
			usuariorepository.saveAll(Arrays.asList(user1,user2,user3,user4));
			tarifarepository.saveAll(Arrays.asList(t1,t2,t3,t4));
	 }
}
