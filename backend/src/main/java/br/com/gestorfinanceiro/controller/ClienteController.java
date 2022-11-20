package br.com.gestorfinanceiro.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.gestorfinanceiro.dto.ClienteDTO;
import br.com.gestorfinanceiro.service.ClienteService;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

	@Autowired
	ClienteService service;

	@GetMapping
	public ResponseEntity<List<ClienteDTO>> getClientes() {
		return new ResponseEntity<>(service.findAllCliente(), HttpStatus.ACCEPTED);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<ClienteDTO> getUsuarioById(@PathVariable Integer id) {

		Optional<ClienteDTO> cliente = service.findClienteById(id);

		if (cliente.isPresent()) {
			return new ResponseEntity<>(cliente.get(), HttpStatus.FOUND);
		}

		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@PostMapping
	public ResponseEntity<ClienteDTO> saveCliente(@RequestBody @Valid ClienteDTO cliente) {
		return new ResponseEntity<>(service.saveCliente(cliente), HttpStatus.CREATED);
	}
}
