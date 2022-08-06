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
public class VendasApplication {

	@Bean
	public CommandLineRunner init( @Autowired Clientes clientes){
		return args -> {
			System.out.println("\n Salvando clientes :");
			clientes.salvar(new Cliente("Alan Gabriel"));
			clientes.salvar(new Cliente("Alan Douglas"));
			
			List<Cliente> todosClientes = clientes.listar();
			todosClientes.forEach(System.out::println);

			System.out.println("\n Atualizando clientes:");
			todosClientes.forEach(c -> {
				c.setNome(c.getNome() + " Atualizado");
				clientes.atualizar(c);
			});

			todosClientes.forEach(System.out::println);

			System.out.println("\n Buscando cliente :");
			clientes.buscarPorNome("D").forEach(System.out::println);
			todosClientes = clientes.listar();

			System.out.println("\n Deletando clientes :");
			clientes.listar().forEach(c -> {
				System.out.println(c);
				clientes.deletar(c);				
			});	
			
			todosClientes = clientes.listar();
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
