package br.com.gestorfinanceiro.service;

import java.util.List;
import java.util.Optional;

import br.com.gestorfinanceiro.dto.FornecedorDTO;

public interface FornecedorService {

	List<FornecedorDTO> findAllFornecedores();

	Optional<FornecedorDTO> findFornecedorById(Integer id);

	FornecedorDTO saveFornecedor(FornecedorDTO fornecedor);

	void deleteFornecedorById(Integer id);

	Optional<FornecedorDTO> updateFornecedorById(Integer id, FornecedorDTO fornecedor);

}
