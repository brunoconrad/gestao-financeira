package br.com.gestorfinanceiro.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.gestorfinanceiro.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

}
