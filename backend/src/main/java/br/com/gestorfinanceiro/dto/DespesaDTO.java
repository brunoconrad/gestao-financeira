package br.com.gestorfinanceiro.dto;

import java.math.BigDecimal;
import java.util.Date;

import org.joda.time.DateTime;

public class DespesaDTO {

	private Integer idDespesa;
	private BigDecimal valor;
	private Date dtVencimento;
	private String dsDespesa;
	private Integer tipoDespesa;
	private DateTime dtPagamento;
	private Integer idBeneficiario;
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
