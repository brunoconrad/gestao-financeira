package br.com.gestorfinanceiro.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.gestorfinanceiro.model.TipoPagamento;

public interface TipoPagamentoRepository extends JpaRepository<TipoPagamento, Integer>{

}
