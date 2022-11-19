package br.com.gestorfinanceiro.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tipo_pagamento")
public class TipoPagamento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_tipo_pagamento")
	private Integer idTipoPagamento;

	@Column(name = "ds_tipo_pagamento", nullable = false)
	private String dsTipoPagamento;

	public Integer getIdTipoPagamento() {
		return idTipoPagamento;
	}

	public void setIdTipoPagamento(Integer idTipoPagamento) {
		this.idTipoPagamento = idTipoPagamento;
	}

	public String getDsTipoPagamento() {
		return dsTipoPagamento;
	}

	public void setDsTipoPagamento(String dsTipoPagamento) {
		this.dsTipoPagamento = dsTipoPagamento;
	}

}
