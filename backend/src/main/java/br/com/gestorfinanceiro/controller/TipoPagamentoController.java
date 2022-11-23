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

import br.com.gestorfinanceiro.dto.TipoPagamentoDTO;
import br.com.gestorfinanceiro.service.TipoPagamentoService;

@RestController
@RequestMapping("/api/tipoPagamento")
public class TipoPagamentoController {

	@Autowired
	TipoPagamentoService service;

	@GetMapping
	public ResponseEntity<List<TipoPagamentoDTO>> getTiposPagamentos() {
		return new ResponseEntity<>(service.findAllTipoPagamento(), HttpStatus.OK);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<TipoPagamentoDTO> getTipoPagamentoById(@PathVariable Integer id) {

		Optional<TipoPagamentoDTO> tipo = service.findTipoPagamentoById(id);

		if (tipo.isPresent()) {
			return new ResponseEntity<>(tipo.get(), HttpStatus.OK);
		}

		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@PostMapping
	public ResponseEntity<TipoPagamentoDTO> saveTipoPagamento(@RequestBody @Valid TipoPagamentoDTO tipo) {
		return new ResponseEntity<>(service.saveTipoPagamento(tipo), HttpStatus.CREATED);
	}
	
	

}
