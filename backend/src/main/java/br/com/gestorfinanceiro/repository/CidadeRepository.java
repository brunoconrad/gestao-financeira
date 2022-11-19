package br.com.gestorfinanceiro.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.gestorfinanceiro.model.Cidade;

public interface CidadeRepository extends JpaRepository<Cidade, String>{

}
