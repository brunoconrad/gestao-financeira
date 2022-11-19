package br.com.gestorfinanceiro.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "fornecedores")
public class Fornecedor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_fornecedor")
	private Integer idFornecedor;

	@Column(name = "ds_razao_social", nullable = true)
	private String dsRazaoSocial;

	@Column(name = "ds_nome_fantasia", nullable = true)
	private String dsNomeFantasia;

	@Column(name = "ds_nome", nullable = false)
	private String dsNome;

	@Column(name = "cpf_cnpj", nullable = false)
	private String cpfCnpj;

	@Column(name = "tipo_pessoa", nullable = false)
	private String tipoPessoa;

	@Column(name = "ds_email", nullable = true)
	private String email;

	@Column(name = "ds_site", nullable = true)
	private String site;

	@Column(name = "ds_telefone_comercial", nullable = true)
	private String telefoneComercial;

	@Column(name = "ds_telefone_administrativo", nullable = true)
	private String telefoneAdministrativo;

	public String getTipoPessoa() {
		return tipoPessoa;
	}

	public void setTipoPessoa(String tipoPessoa) {
		this.tipoPessoa = tipoPessoa;
	}

	public String getDsNome() {
		return dsNome;
	}

	public void setDsNome(String dsNome) {
		this.dsNome = dsNome;
	}

	public Integer getIdFornecedor() {
		return idFornecedor;
	}

	public void setIdFornecedor(Integer idFornecedor) {
		this.idFornecedor = idFornecedor;
	}

	public String getDsRazaoSocial() {
		return dsRazaoSocial;
	}

	public void setDsRazaoSocial(String dsRazaoSocial) {
		this.dsRazaoSocial = dsRazaoSocial;
	}

	public String getDsNomeFantasia() {
		return dsNomeFantasia;
	}

	public void setDsNomeFantasia(String dsNomeFantasia) {
		this.dsNomeFantasia = dsNomeFantasia;
	}

	public String getCpfCnpj() {
		return cpfCnpj;
	}

	public void setCpfCnpj(String cpfCnpj) {
		this.cpfCnpj = cpfCnpj;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSite() {
		return site;
	}

	public void setSite(String site) {
		this.site = site;
	}

	public String getTelefoneComercial() {
		return telefoneComercial;
	}

	public void setTelefoneComercial(String telefoneComercial) {
		this.telefoneComercial = telefoneComercial;
	}

	public String getTelefoneAdministrativo() {
		return telefoneAdministrativo;
	}

	public void setTelefoneAdministrativo(String telefoneAdministrativo) {
		this.telefoneAdministrativo = telefoneAdministrativo;
	}

}
