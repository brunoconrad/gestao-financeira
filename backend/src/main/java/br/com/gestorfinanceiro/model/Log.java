package br.com.gestorfinanceiro.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.joda.time.DateTime;

@Entity
@Table(name = "log_atividades")
public class Log {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_log")
	private Integer idLog;

	@Column(name = "tipo_log", nullable = false)
	private Integer tipo;

	@Column(name = "data_alteracao", nullable = false)
	private DateTime dataAlt;

	@Column(name = "tabela_alteracao", nullable = false)
	private String tabelaAlt;

	@Column(name = "id_usuario", nullable = false)
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
