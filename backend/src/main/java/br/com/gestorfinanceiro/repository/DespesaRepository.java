package br.com.gestorfinanceiro.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.gestorfinanceiro.model.Despesa;

public interface DespesaRepository extends JpaRepository<Despesa, Integer> {

}
