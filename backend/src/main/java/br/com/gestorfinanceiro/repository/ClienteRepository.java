package br.com.gestorfinanceiro.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.gestorfinanceiro.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer>{

}
