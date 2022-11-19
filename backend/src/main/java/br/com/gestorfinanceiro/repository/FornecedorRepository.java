package br.com.gestorfinanceiro.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.gestorfinanceiro.model.Fornecedor;

public interface FornecedorRepository extends JpaRepository<Fornecedor, Integer>{

}
