package br.com.gestorfinanceiro.service;

import java.util.List;
import java.util.Optional;

import br.com.gestorfinanceiro.dto.ClienteDTO;

public interface ClienteService {

	List<ClienteDTO> findAllCliente();

	Optional<ClienteDTO> findClienteById(Integer id);

	ClienteDTO saveCliente(ClienteDTO cliente);

	void deleteClienteById(Integer id);

	Optional<ClienteDTO> updateClienteById(Integer id, ClienteDTO cliente);

}
