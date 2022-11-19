package br.com.gestorfinanceiro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan(basePackages = "br.com.gestorfinanceiro.model")
@SpringBootApplication
public class GestorfinanceiroApplication {

	public static void main(String[] args) {
		SpringApplication.run(GestorfinanceiroApplication.class, args);
	}

}
