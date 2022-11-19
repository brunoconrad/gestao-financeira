package br.com.gestorfinanceiro.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.gestorfinanceiro.model.Log;

public interface LogRepository extends JpaRepository<Log, Integer>{

}
