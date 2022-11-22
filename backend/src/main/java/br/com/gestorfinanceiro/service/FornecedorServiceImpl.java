package br.com.gestorfinanceiro.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gestorfinanceiro.dto.FornecedorDTO;
import br.com.gestorfinanceiro.model.Fornecedor;
import br.com.gestorfinanceiro.repository.FornecedorRepository;

@Service
public class FornecedorServiceImpl implements FornecedorService {

	@Autowired
	FornecedorRepository repository;

	@Override
	public List<FornecedorDTO> findAllFornecedores() {

		List<Fornecedor> fornecedores = repository.findAll();

		return fornecedores.stream().map(fornecedor -> new ModelMapper().map(fornecedor, FornecedorDTO.class))
				.collect(Collectors.toList());
	}

	@Override
	public Optional<FornecedorDTO> findFornecedorById(Integer id) {

		Optional<Fornecedor> fornecedor = repository.findById(id);

		return Optional.of(new ModelMapper().map(fornecedor.get(), FornecedorDTO.class));
	}

	@Override
	public FornecedorDTO saveFornecedor(FornecedorDTO fornecedor) {

		ModelMapper mapper = new ModelMapper();
		Fornecedor fornecedorSave = mapper.map(fornecedor, Fornecedor.class);
		fornecedorSave = repository.save(fornecedorSave);

		return mapper.map(fornecedorSave, FornecedorDTO.class);
	}

	@Override
	public void deleteFornecedorById(Integer id) {
		repository.deleteById(id);
	}

	@Override
	public Optional<FornecedorDTO> updateFornecedorById(Integer id, FornecedorDTO fornecedor) {

		ModelMapper mapper = new ModelMapper();
		Optional<Fornecedor> fornecedorExiste = repository.findById(id);
		Fornecedor fornecedorSave = mapper.map(fornecedor, Fornecedor.class);

		if (fornecedorExiste.isPresent()) {

			fornecedorSave.setIdFornecedor(id);
			fornecedorSave = repository.save(fornecedorSave);

			return Optional.of(mapper.map(fornecedorSave, FornecedorDTO.class));
		}

		return Optional.empty();
	}

}
