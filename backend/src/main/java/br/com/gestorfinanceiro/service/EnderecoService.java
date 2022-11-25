package br.com.gestorfinanceiro.service;

import java.util.List;
import java.util.Optional;

import br.com.gestorfinanceiro.dto.ClienteDTO;
import br.com.gestorfinanceiro.dto.EnderecoDTO;

public interface EnderecoService {

	List<EnderecoDTO> findAllEnderecos();
	
	Optional<EnderecoDTO> findEnderecoById(Integer id);
	
	EnderecoDTO saveEndereco(EnderecoDTO endereco);
	
	void deleteEnderecoById(Integer id);
	
	Optional<EnderecoDTO> updateEnderecoById(Integer id, ClienteDTO endereco);

}
