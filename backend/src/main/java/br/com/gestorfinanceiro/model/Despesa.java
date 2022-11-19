package br.com.gestorfinanceiro.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.joda.time.DateTime;

@Entity
@Table(name = "despesas")
public class Despesa {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_despesa")
	private Integer idDespesa;

	@Column(name = "valor")
	private BigDecimal valor;

	@Column(name = "dt_vencimento")
	private Date dtVencimento;

	@Column(name = "ds_despesa")
	private String dsDespesa;

	@Column(name = "tipo_despesa")
	private Integer tipoDespesa;

	@Column(name = "dt_pagamento")
	private DateTime dtPagamento;

	@Column(name = "id_beneficiario")
	private Integer idBeneficiario;

	@Column(name = "tipo_pagamento")
	private Integer tipoPagamento;

	public Integer getIdDespesa() {
		return idDespesa;
	}

	public void setIdDespesa(Integer idDespesa) {
		this.idDespesa = idDespesa;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public Date getDtVencimento() {
		return dtVencimento;
	}

	public void setDtVencimento(Date dtVencimento) {
		this.dtVencimento = dtVencimento;
	}

	public String getDsDespesa() {
		return dsDespesa;
	}

	public void setDsDespesa(String dsDespesa) {
		this.dsDespesa = dsDespesa;
	}

	public Integer getTipoDespesa() {
		return tipoDespesa;
	}

	public void setTipoDespesa(Integer tipoDespesa) {
		this.tipoDespesa = tipoDespesa;
	}

	public DateTime getDtPagamento() {
		return dtPagamento;
	}

	public void setDtPagamento(DateTime dtPagamento) {
		this.dtPagamento = dtPagamento;
	}

	public Integer getIdBeneficiario() {
		return idBeneficiario;
	}

	public void setIdBeneficiario(Integer idBeneficiario) {
		this.idBeneficiario = idBeneficiario;
	}

	public Integer getTipoPagamento() {
		return tipoPagamento;
	}

	public void setTipoPagamento(Integer tipoPagamento) {
		this.tipoPagamento = tipoPagamento;
	}

}
