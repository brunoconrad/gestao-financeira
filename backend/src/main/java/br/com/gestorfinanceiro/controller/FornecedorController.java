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

import br.com.gestorfinanceiro.dto.FornecedorDTO;
import br.com.gestorfinanceiro.service.FornecedorService;

@RestController
@RequestMapping("/api/fornecedores")
public class FornecedorController {

	@Autowired
	FornecedorService service;

	@GetMapping
	public ResponseEntity<List<FornecedorDTO>> getFornecedores() {
		return new ResponseEntity<>(service.findAllFornecedores(), HttpStatus.ACCEPTED);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<FornecedorDTO> getFornecedorById(@PathVariable Integer id) {

		Optional<FornecedorDTO> fornecedor = service.findFornecedorById(id);

		if (fornecedor.isPresent()) {
			return new ResponseEntity<>(fornecedor.get(), HttpStatus.FOUND);
		}

		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@PostMapping
	public ResponseEntity<FornecedorDTO> saveFornecedor(@RequestBody @Valid FornecedorDTO fornecedor) {
		return new ResponseEntity<>(service.saveFornecedor(fornecedor), HttpStatus.CREATED);
	}
}
