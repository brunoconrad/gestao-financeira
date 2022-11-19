package br.com.gestorfinanceiro.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cidades")
public class Cidade {

	@Id
	@Column(name = "cd_cidade")
	private String cdCidade;

	@Column(name = "ds_cidade")
	private String dsCidade;

	@Column(name = "ds_uf")
	private String uf;

	public String getCdCidade() {
		return cdCidade;
	}

	public void setCdCidade(String cdCidade) {
		this.cdCidade = cdCidade;
	}

	public String getDsCidade() {
		return dsCidade;
	}

	public void setDsCidade(String dsCidade) {
		this.dsCidade = dsCidade;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

}
