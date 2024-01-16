package com.tdm.helpdesk.domain;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.tdm.helpdesk.domain.enums.Status;
@Entity
public class Tarifa implements Serializable {
	private static final long serialVersionUID = 1L;

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@JsonFormat(pattern ="dd/MM/yyyy")
	private LocalDate dataAbertura = LocalDate.now();
	@JsonFormat(pattern ="dd/MM/yyyy")
	private LocalDate dataFechamento;
	
	
	private Status status;
	private String observacao;
	private String inicioRota;
	private String fimRota;
	private Double valorTarifa;
	

	@ManyToOne
	@JoinColumn(name = "usuario_id")
	private USUARIO usuario;
	
	
	public Tarifa() {
		super();
	}

	public Tarifa(Integer id, Status status, String observacao, String inicioRota, String fimRota, Double valorTarifa,USUARIO usuario) {
		super();
		this.id = id;
		this.status = status;
		this.observacao = observacao;
		this.inicioRota = inicioRota;
		this.fimRota = fimRota;
		this.valorTarifa = valorTarifa;
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

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
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

	public Double getValorTarifa() {
		return valorTarifa;
	}

	public void setValorTarifa(Double valorTarifa) {
		this.valorTarifa = valorTarifa;
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
