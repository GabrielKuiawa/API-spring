package com.alan.projeto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.alan.projeto.domain.entity.Cliente;
import com.alan.projeto.domain.repository.Clientes;

@SpringBootApplication
public class VendasApplication {

	@Bean
	public CommandLineRunner commandLineRunner(@Autowired Clientes clientes){
		return args -> {
			Cliente c = new Cliente(null,"alan");
			clientes.save(c);
		};
	}

	public static void main(String[] 	args) {
		SpringApplication.run(VendasApplication.class, args);
	}
	

}
