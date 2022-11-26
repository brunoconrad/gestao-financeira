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

import br.com.gestorfinanceiro.dto.EnderecoDTO;
import br.com.gestorfinanceiro.service.EnderecoService;

@RestController
@RequestMapping("/api/enderecos")
public class EnderecoController {

	@Autowired
	EnderecoService service;

	@GetMapping
	public ResponseEntity<List<EnderecoDTO>> getEnderecos() {
		return new ResponseEntity<>(service.findAllEnderecos(), HttpStatus.OK);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<EnderecoDTO> getEnderecoById(@PathVariable Integer id) {

		Optional<EnderecoDTO> endereco = service.findEnderecoById(id);

		if (endereco.isPresent()) {
			return new ResponseEntity<>(endereco.get(), HttpStatus.OK);
		}

		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@PostMapping
	public ResponseEntity<EnderecoDTO> saveEndereco(@RequestBody @Valid EnderecoDTO endereco) {
		return new ResponseEntity<>(service.saveEndereco(endereco), HttpStatus.CREATED);
	}
}
