package com.tdm.helpdesk.domain.dtos;

import java.io.Serializable;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.tdm.helpdesk.domain.Tarifa;

public class TarifaDTO implements Serializable{
	
	
	private static final long serialVersionUID = 1L;

	private Integer id;
	
	@JsonFormat(pattern ="dd/MM/yyyy")
	private LocalDate dataAbertura = LocalDate.now();
	@JsonFormat(pattern ="dd/MM/yyyy")
	private LocalDate dataFechamento;
	private Integer status;
	private String observação;
	private String inicioRota;
	private String fimRota;
	private Double valorTarifa;
	private Integer usuario;
	private String nomeUsuario;
	
	
	
	public TarifaDTO() {
		super();
	}
	
	
	public TarifaDTO(Tarifa obj) {
		super();
		this.id = obj.getId();
		this.dataAbertura = obj.getDataAbertura();
		this.dataFechamento = obj.getDataFechamento();
		this.status = obj.getStatus().getCodigo();
		this.observação = obj.getObservação();
		this.inicioRota = obj.getInicioRota();
		this.fimRota = obj.getFimRota();
		this.valorTarifa = obj.getValorTarifa();
		this.usuario = obj.getUsuario().getId();
		this.nomeUsuario = obj.getUsuario().getNome();
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


	public Integer getStatus() {
		return status;
	}


	public void setStatus(Integer status) {
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


	public Double getValorTarifa() {
		return valorTarifa;
	}


	public void setValorTarifa(Double valorTarifa) {
		this.valorTarifa = valorTarifa;
	}


	public Integer getUsuario() {
		return usuario;
	}


	public void setUsuario(Integer usuario) {
		this.usuario = usuario;
	}


	public String getNomeUsuario() {
		return nomeUsuario;
	}


	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}
	
	
	
	
	

}
