package br.com.gestorfinanceiro.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gestorfinanceiro.dto.ClienteDTO;
import br.com.gestorfinanceiro.model.Cliente;
import br.com.gestorfinanceiro.repository.ClienteRepository;

@Service
public class ClienteServiceImpl implements ClienteService {

	@Autowired
	ClienteRepository repository;

	@Override
	public List<ClienteDTO> findAllCliente() {

		List<Cliente> clientes = repository.findAll();

		return clientes.stream().map(cliente -> new ModelMapper().map(cliente, ClienteDTO.class))
				.collect(Collectors.toList());
	}

	@Override
	public Optional<ClienteDTO> findClienteById(Integer id) {

		Optional<Cliente> cliente = repository.findById(id);

		return Optional.of(new ModelMapper().map(cliente.get(), ClienteDTO.class));
	}

	@Override
	public ClienteDTO saveCliente(ClienteDTO cliente) {

		ModelMapper mapper = new ModelMapper();
		Cliente clienteSave = mapper.map(cliente, Cliente.class);
		clienteSave = repository.save(clienteSave);

		return mapper.map(clienteSave, ClienteDTO.class);
	}

	@Override
	public void deleteClienteById(Integer id) {
		repository.deleteById(id);
	}

	@Override
	public Optional<ClienteDTO> updateClienteById(Integer id, ClienteDTO cliente) {

		ModelMapper mapper = new ModelMapper();
		Optional<Cliente> clienteExiste = repository.findById(id);
		Cliente clienteSave = mapper.map(cliente, Cliente.class);

		if (clienteExiste.isPresent()) {
			clienteSave.setIdCliente(id);
			clienteSave = repository.save(clienteSave);

			return Optional.of(mapper.map(clienteSave, ClienteDTO.class));
		}

		return Optional.empty();
	}

}
