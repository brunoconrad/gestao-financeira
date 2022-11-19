package br.com.gestorfinanceiro.dto;

public class FornecedorDTO {

	private Integer idFornecedor;
	private String dsRazaoSocial;
	private String dsNomeFantasia;
	private String dsNome;
	private String cpfCnpj;
	private String tipoPessoa;
	private String email;
	private String site;
	private String telefoneComercial;
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
