package br.com.gestorfinanceiro.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.gestorfinanceiro.model.TipoDespesa;

public interface TipoDespesaRepository extends JpaRepository<TipoDespesa, Integer>{

}
