package br.com.gestorfinanceiro.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gestorfinanceiro.dto.ClienteDTO;
import br.com.gestorfinanceiro.dto.EnderecoDTO;
import br.com.gestorfinanceiro.model.Endereco;
import br.com.gestorfinanceiro.repository.EnderecoRepository;

@Service
public class EnderecoServiceImpl implements EnderecoService {

	@Autowired
	EnderecoRepository repository;

	@Override
	public List<EnderecoDTO> findAllEnderecos() {

		List<Endereco> enderecos = repository.findAll();

		return enderecos.stream().map(endereco -> new ModelMapper().map(endereco, EnderecoDTO.class))
				.collect(Collectors.toList());
	}

	@Override
	public Optional<EnderecoDTO> findEnderecoById(Integer id) {

		Optional<Endereco> endereco = repository.findById(id);

		return Optional.of(new ModelMapper().map(endereco.get(), EnderecoDTO.class));
	}

	@Override
	public EnderecoDTO saveEndereco(EnderecoDTO endereco) {

		ModelMapper mapper = new ModelMapper();
		Endereco enderecoSave = mapper.map(endereco, Endereco.class);
		enderecoSave = repository.save(enderecoSave);

		return mapper.map(enderecoSave, EnderecoDTO.class);
	}

	@Override
	public void deleteEnderecoById(Integer id) {
		repository.deleteById(id);
	}

	@Override
	public Optional<EnderecoDTO> updateEnderecoById(Integer id, ClienteDTO endereco) {

		ModelMapper mapper = new ModelMapper();
		Optional<Endereco> enderecoExiste = repository.findById(id);
		Endereco enderecoSave = mapper.map(endereco, Endereco.class);

		if (enderecoExiste.isPresent()) {
			enderecoSave.setIdEndereco(id);
			enderecoSave = repository.save(enderecoSave);

			return Optional.of(mapper.map(enderecoSave, EnderecoDTO.class));
		}

		return Optional.empty();
	}

}
