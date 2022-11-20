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

import br.com.gestorfinanceiro.dto.UsuarioDTO;
import br.com.gestorfinanceiro.service.UsuarioService;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

	@Autowired
	UsuarioService service;

	@GetMapping
	public ResponseEntity<List<UsuarioDTO>> getUsuarios() {
		return new ResponseEntity<>(service.findAllUsuarios(), HttpStatus.ACCEPTED);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<UsuarioDTO> getUsuarioById(@PathVariable Integer id) {
		Optional<UsuarioDTO> usuario = service.findUsuarioById(id);

		if (usuario.isPresent()) {
			return new ResponseEntity<>(usuario.get(), HttpStatus.FOUND);
		}

		return new ResponseEntity<>(HttpStatus.NOT_FOUND);

	}

	@PostMapping
	public ResponseEntity<UsuarioDTO> saveUsuario(@RequestBody @Valid UsuarioDTO usuario) {

		return new ResponseEntity<>(service.saveUsuario(usuario), HttpStatus.CREATED);
	}

}
