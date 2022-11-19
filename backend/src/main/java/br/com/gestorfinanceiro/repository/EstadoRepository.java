package br.com.gestorfinanceiro.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.gestorfinanceiro.model.Estado;

public interface EstadoRepository extends JpaRepository<Estado, String>{

}
