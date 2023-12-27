package com.tdm.helpdesk.domain;

import java.time.LocalDate;

import com.tdm.helpdesk.domain.enums.Status;

public class Tarifa {
	private Integer id;
	private LocalDate dataAbertura = LocalDate.now();
	private LocalDate dataFechamento;
	private Status status;
	private String observação;
	private String inicioRota;
	private String fimRota;
	private Float valorTarifa;
	
	private ADMINISTRADOR admin;
	private USUARIO usuario;
	
	public Tarifa() {
		super();
	}

	public Tarifa(Integer id, Status status, String observação, String inicioRota, String fimRota, Float valorTarifa,
			ADMINISTRADOR admin, USUARIO usuario) {
		super();
		this.id = id;
		this.status = status;
		this.observação = observação;
		this.inicioRota = inicioRota;
		this.fimRota = fimRota;
		this.valorTarifa = valorTarifa;
		this.admin = admin;
		this.usuario = usuario;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDate getDataAbertura() {
		return dataAbertura;
	}

	public void setDataAbertura(LocalDate dataAbertura) {
		this.dataAbertura = dataAbertura;
	}

	public LocalDate getDataFechamento() {
		return dataFechamento;
	}

	public void setDataFechamento(LocalDate dataFechamento) {
		this.dataFechamento = dataFechamento;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public String getObservação() {
		return observação;
	}

	public void setObservação(String observação) {
		this.observação = observação;
	}

	public String getInicioRota() {
		return inicioRota;
	}

	public void setInicioRota(String inicioRota) {
		this.inicioRota = inicioRota;
	}

	public String getFimRota() {
		return fimRota;
	}

	public void setFimRota(String fimRota) {
		this.fimRota = fimRota;
	}

	public Float getValorTarifa() {
		return valorTarifa;
	}

	public void setValorTarifa(Float valorTarifa) {
		this.valorTarifa = valorTarifa;
	}

	public ADMINISTRADOR getAdmin() {
		return admin;
	}

	public void setAdmin(ADMINISTRADOR admin) {
		this.admin = admin;
	}

	public USUARIO getUsuario() {
		return usuario;
	}

	public void setUsuario(USUARIO usuario) {
		this.usuario = usuario;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tarifa other = (Tarifa) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
	
	


}
