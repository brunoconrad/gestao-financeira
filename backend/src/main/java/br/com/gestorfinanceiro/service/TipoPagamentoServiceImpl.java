package br.com.gestorfinanceiro.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gestorfinanceiro.dto.TipoPagamentoDTO;
import br.com.gestorfinanceiro.model.TipoPagamento;
import br.com.gestorfinanceiro.repository.TipoPagamentoRepository;

@Service
public class TipoPagamentoServiceImpl implements ITipoPagamentoService {

	@Autowired
	TipoPagamentoRepository repository;

	@Override
	public List<TipoPagamentoDTO> findAllTipoPagamento() {

		List<TipoPagamento> tipo = repository.findAll();

		return tipo.stream().map(tipoPagamento -> new ModelMapper().map(tipoPagamento, TipoPagamentoDTO.class))
				.collect(Collectors.toList());
	}

	@Override
	public Optional<TipoPagamentoDTO> findTipoPagamentoById(Integer id) {

		Optional<TipoPagamento> tipo = repository.findById(id);

		return Optional.of(new ModelMapper().map(tipo.get(), TipoPagamentoDTO.class));
	}

	@Override
	public TipoPagamentoDTO saveTipoPagamento(TipoPagamentoDTO tipoPagamento) {

		ModelMapper mapper = new ModelMapper();
		TipoPagamento tipoSave = mapper.map(tipoPagamento, TipoPagamento.class);
		tipoSave = repository.save(tipoSave);

		return mapper.map(tipoSave, TipoPagamentoDTO.class);
	}

	@Override
	public void deleteTipoPagamentoById(Integer id) {
		repository.deleteById(id);
	}

	@Override
	public Optional<TipoPagamentoDTO> updateTipoPagamentoByid(Integer id, TipoPagamentoDTO tipoPagamento) {

		ModelMapper mapper = new ModelMapper();
		Optional<TipoPagamento> tipoExiste = repository.findById(id);
		TipoPagamento tipoSave = mapper.map(tipoPagamento, TipoPagamento.class);

		if (tipoExiste.isPresent()) {

			tipoSave.setIdTipoPagamento(id);
			tipoSave = repository.save(tipoSave);

			return Optional.of(mapper.map(tipoSave, TipoPagamentoDTO.class));
		}

		return Optional.empty();
	}

}
