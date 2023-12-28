package com.tdm.helpdesk.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import com.tdm.helpdesk.domain.enums.Perfil;

@Entity
public class ADMINISTRADOR extends Pessoa {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@OneToMany(mappedBy = "admin")
	private List<Tarifa> tarifas = new ArrayList<>();

	public ADMINISTRADOR() {
		super();
		addPerfil(Perfil.USUARIO_CONSULTA);
	}

	public ADMINISTRADOR(Integer id, String nome, String cpf, String email, String senha) {
		super(id, nome, cpf, email, senha);
		addPerfil(Perfil.USUARIO_CONSULTA);
	}

	public List<Tarifa> getTarifas() {
		return tarifas;
	}

	public void setTarifas(List<Tarifa> tarifas) {
		this.tarifas = tarifas;
	}
	
		

}
