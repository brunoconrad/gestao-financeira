package br.com.gestorfinanceiro.service;

import java.util.List;
import java.util.Optional;

import br.com.gestorfinanceiro.dto.UsuarioDTO;

public interface UsuarioService {

	List<UsuarioDTO> findAllUsuarios();

	Optional<UsuarioDTO> findUsuarioById(Integer id);

	UsuarioDTO saveUsuario(UsuarioDTO usuario);

	void deleteUsuarioById(Integer id);

	Optional<UsuarioDTO> updateUsuarioById(Integer id, UsuarioDTO usuario);

}
