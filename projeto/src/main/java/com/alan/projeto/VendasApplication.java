package com.alan.projeto;

import java.util.List;

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
	public CommandLineRunner init( @Autowired Clientes clientes){
		return args -> {
			System.out.println("\n Salvando clientes :");
			clientes.save(new Cliente("Alan Gabriel"));
			clientes.save(new Cliente("Alan Douglas"));
			
			List<Cliente> todosClientes = clientes.findAll();
			todosClientes.forEach(System.out::println);

			System.out.println("\n Atualizando clientes:");
			todosClientes.forEach(c -> {
				c.setNome(c.getNome() + " Atualizado");
				clientes.save(c);
			});

			todosClientes.forEach(System.out::println);

			System.out.println("\n Buscando cliente :");
			clientes.encontrarPorNome("D").forEach(System.out::println);
			todosClientes = clientes.findAll();

			System.out.println("\n Deletando clientes :");
			clientes.findAll().forEach(c -> {
				System.out.println(c);
				clientes.delete(c);				
			});	
			
			todosClientes = clientes.findAll();
			if (todosClientes.isEmpty()){
				System.out.println("\n nenhum cliente encontrado");
			} else {
				todosClientes.forEach(System.out::println);
			}
		};
	}
	
	public static void main(String[] args) {
		SpringApplication.run(VendasApplication.class, args);
	}

}
