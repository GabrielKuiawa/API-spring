package com.alan.projeto;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.alan.projeto.domain.entity.Cliente;
import com.alan.projeto.domain.repositorio.Clientes;

@SpringBootApplication
public class ProjetoApplication {

	@Bean
	public CommandLineRunner init( @Autowired Clientes clientes){
		return args -> {
			clientes.salvar(new Cliente("Alan Gabriel"));
			clientes.salvar(new Cliente("Alan Douglas"));
			
			List<Cliente> todosClientes = clientes.listar();
			todosClientes.forEach(System.out::println);
		};
	}
	
	public static void main(String[] args) {
		SpringApplication.run(ProjetoApplication.class, args);
	}

}
