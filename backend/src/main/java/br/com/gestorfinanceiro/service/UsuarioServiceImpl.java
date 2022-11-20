package br.com.gestorfinanceiro.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gestorfinanceiro.dto.UsuarioDTO;
import br.com.gestorfinanceiro.model.Usuario;
import br.com.gestorfinanceiro.repository.UsuarioRepository;

@Service
public class UsuarioServiceImpl implements UsuarioService {

	@Autowired
	UsuarioRepository repository;

	@Override
	public List<UsuarioDTO> findAllUsuarios() {

		List<Usuario> usuario = repository.findAll();

		return usuario.stream().map(user -> new ModelMapper().map(user, UsuarioDTO.class)).collect(Collectors.toList());
	}

	@Override
	public Optional<UsuarioDTO> findUsuarioById(Integer id) {

		Optional<Usuario> usuario = repository.findById(id);

		return Optional.of(new ModelMapper().map(usuario.get(), UsuarioDTO.class));
	}

	@Override
	public UsuarioDTO saveUsuario(UsuarioDTO usuario) {

		ModelMapper mapper = new ModelMapper();
		Usuario usuarioSave = mapper.map(usuario, Usuario.class);
		usuarioSave = repository.save(usuarioSave);

		return mapper.map(usuarioSave, UsuarioDTO.class);
	}

	@Override
	public void deleteUsuarioById(Integer id) {
		repository.deleteById(id);
	}

	@Override
	public Optional<UsuarioDTO> updateUsuarioById(Integer id, UsuarioDTO usuario) {

		ModelMapper mapper = new ModelMapper();
		Optional<Usuario> usuarioExiste = repository.findById(id);
		Usuario usuarioSave = mapper.map(usuario, Usuario.class);

		if (usuarioExiste.isPresent()) {

			usuarioSave.setIdUsuario(id);
			usuarioSave = repository.save(usuarioSave);

			return Optional.of(mapper.map(usuarioSave, UsuarioDTO.class));
		}

		return Optional.empty();
	}

}
