package com.tdm.helpdesk.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.tdm.helpdesk.domain.dtos.USUARIODTO;
import com.tdm.helpdesk.domain.enums.Perfil;

@Entity
public class USUARIO extends Pessoa {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@JsonIgnore
	@OneToMany(mappedBy ="usuario")
	private List<Tarifa> tarifas = new ArrayList<>();

	public USUARIO() {
		super();
		addPerfil(Perfil.USUARIO);
	}
	

	public USUARIO(Integer id, String nome, String cpf, String email, String senha) {
		super(id, nome, cpf, email, senha);
		addPerfil(Perfil.USUARIO);
	}
	
	public USUARIO(USUARIODTO obj) {
		super();
		this.id = obj.getId();
		this.nome = obj.getNome();
		this.cpf = obj.getCpf();
		this.email = obj.getEmail();
		this.senha = obj.getSenha();
		this.perfis = obj.getPerfis().stream().map(x -> x.getCodigo()).collect(Collectors.toSet());
		this.dataCriacao = obj.getDataCriacao();
	}

	public List<Tarifa> getTarifas() {
		return tarifas;
	}

	public void setTarifas(List<Tarifa> tarifas) {
		this.tarifas = tarifas;
	}
	
	
	
	
	

}
