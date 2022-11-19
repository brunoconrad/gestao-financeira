package br.com.gestorfinanceiro.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tipo_despesa")
public class TipoDespesa {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_tipo_despesa")
	private Integer idTipoDespesa;

	@Column(name = "ds_tipo_despesa", nullable = false)
	private String dsTipoDespesa;

	public Integer getIdTipoDespesa() {
		return idTipoDespesa;
	}

	public void setIdTipoDespesa(Integer idTipoDespesa) {
		this.idTipoDespesa = idTipoDespesa;
	}

	public String getDsTipoDespesa() {
		return dsTipoDespesa;
	}

	public void setDsTipoDespesa(String dsTipoDespesa) {
		this.dsTipoDespesa = dsTipoDespesa;
	}

}
