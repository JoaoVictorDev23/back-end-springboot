package com.tdm.helpdesk.domain;

import java.util.ArrayList;
import java.util.List;

public class USUARIO extends Pessoa {
	
	private List<Tarifa> tarifas = new ArrayList<>();

	public USUARIO() {
		super();
	}

	public USUARIO(Integer id, String nome, String cpf, String email, String senha) {
		super(id, nome, cpf, email, senha);
	}

	public List<Tarifa> getTarifas() {
		return tarifas;
	}

	public void setTarifas(List<Tarifa> tarifas) {
		this.tarifas = tarifas;
	}
	
	
	
	
	

}
