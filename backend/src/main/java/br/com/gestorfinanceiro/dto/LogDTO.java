package br.com.gestorfinanceiro.dto;

import org.joda.time.DateTime;

public class LogDTO {

	private Integer idLog;
	private Integer tipo;
	private DateTime dataAlt;
	private String tabelaAlt;
	private Integer idUsuario;

	public Integer getIdLog() {
		return idLog;
	}

	public void setIdLog(Integer idLog) {
		this.idLog = idLog;
	}

	public Integer getTipo() {
		return tipo;
	}

	public void setTipo(Integer tipo) {
		this.tipo = tipo;
	}

	public DateTime getDataAlt() {
		return dataAlt;
	}

	public void setDataAlt(DateTime dataAlt) {
		this.dataAlt = dataAlt;
	}

	public String getTabelaAlt() {
		return tabelaAlt;
	}

	public void setTabelaAlt(String tabelaAlt) {
		this.tabelaAlt = tabelaAlt;
	}

	public Integer getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}
}
