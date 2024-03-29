package com.tdm.helpdesk.domain.dtos;

import java.io.Serializable;
import java.time.LocalDate;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.tdm.helpdesk.domain.Tarifa;

public class TarifaDTO implements Serializable{
	
	
	private static final long serialVersionUID = 1L;

	private Integer id;
	
	@JsonFormat(pattern ="dd/MM/yyyy")
	private LocalDate dataAbertura = LocalDate.now();
	@JsonFormat(pattern ="dd/MM/yyyy")
	private LocalDate dataFechamento;
	
	@NotNull(message = "O Campo STATUS é requerido!")
	private Integer status;
	@NotNull(message = "O Campo OBSERVAÇÕES é requerido!")
	private String observacao;
	@NotNull(message = "O Campo INICIO DA ROTA é requerido!")
	private String inicioRota;
	@NotNull(message = "O Campo FINAL DA ROTA é requerido!")
	private String fimRota;
	@NotNull(message = "O Campo TARIFA é requerido!")
	private Double valorTarifa;
	@NotNull(message = "O Campo USUARIO é requerido!")
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
		this.observacao = obj.getObservacao();
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
