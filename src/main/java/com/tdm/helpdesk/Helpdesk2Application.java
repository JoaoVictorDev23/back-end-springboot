package com.tdm.helpdesk;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.tdm.helpdesk.domain.Tarifa;
import com.tdm.helpdesk.domain.USUARIO;
import com.tdm.helpdesk.domain.enums.Perfil;
import com.tdm.helpdesk.domain.enums.Status;
import com.tdm.helpdesk.repositories.TarifaRepository;
import com.tdm.helpdesk.repositories.UsuarioRepository;

@SpringBootApplication
public class Helpdesk2Application implements CommandLineRunner{
	
	@Autowired
	private UsuarioRepository usuariorepository;
	@Autowired
	private TarifaRepository tarifarepository;
	

	public static void main(String[] args) {
		SpringApplication.run(Helpdesk2Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		
		USUARIO user1 = new USUARIO(null, "Rikally", "11111111111", "Rikally@tdmlogistica.com", "12345");
		user1.addPerfil(Perfil.ADMIN);
		
		Tarifa t1 = new Tarifa(null, Status.ABERTO, "Teste", "Goiania","Sao Paulo", 110.5, user1);
		
		usuariorepository.saveAll(Arrays.asList(user1));
		tarifarepository.saveAll(Arrays.asList(t1));
		
	}

}
