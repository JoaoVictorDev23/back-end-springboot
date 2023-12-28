package com.tdm.helpdesk.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import com.tdm.helpdesk.domain.enums.Perfil;

@Entity
public class USUARIO extends Pessoa {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
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

	public List<Tarifa> getTarifas() {
		return tarifas;
	}

	public void setTarifas(List<Tarifa> tarifas) {
		this.tarifas = tarifas;
	}
	
	
	
	
	

}
