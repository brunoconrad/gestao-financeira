package br.com.gestorfinanceiro.service;

import java.util.List;
import java.util.Optional;

import br.com.gestorfinanceiro.dto.TipoPagamentoDTO;

public interface ITipoPagamentoService {

	List<TipoPagamentoDTO> findAllTipoPagamento();

	Optional<TipoPagamentoDTO> findTipoPagamentoById(Integer id);

	TipoPagamentoDTO saveTipoPagamento(TipoPagamentoDTO tipoPagamento);

	void deleteTipoPagamentoById(Integer id);

	Optional<TipoPagamentoDTO> updateTipoPagamentoByid(Integer id, TipoPagamentoDTO tipoPagamento);

}
