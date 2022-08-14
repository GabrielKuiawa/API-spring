package com.alan.projeto;

import java.math.BigDecimal;
import java.time.LocalDate;	

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.alan.projeto.domain.entity.Cliente;
import com.alan.projeto.domain.entity.Pedido;
import com.alan.projeto.domain.repository.Clientes;
import com.alan.projeto.domain.repository.Pedidos;

@SpringBootApplication
public class VendasApplication {

	@Bean
	public CommandLineRunner init( 
		@Autowired Clientes clientes, 
		@Autowired Pedidos pedidos
		){
		return args -> {
			System.out.println("\n Salvando clientes :");
			Cliente cliente1 = new Cliente("Alan Gabriel");
			clientes.save(cliente1);
			System.out.println(cliente1);

			Pedido p = new Pedido();
			p.setCliente(cliente1);
			p.setDataPedido(LocalDate.now());
			p.setTotal(BigDecimal.valueOf(100.00));

			pedidos.save(p);

			pedidos.findByCliente(cliente1).forEach(System.out::println);;
			
			// Cliente cliente = clientes.findClienteFetchPedidos(cliente1.getId());
			// System.out.println(cliente);
			// System.out.println(cliente.getPedidos());
			

			// System.out.println("\n Atualizando clientes:");
			// todosClientes.forEach(c -> {
			// 	c.setNome(c.getNome() + " Atualizado");
			// 	clientes.save(c);
			// });

			// todosClientes.forEach(System.out::println);

			// System.out.println("\n Buscando cliente :");
			// clientes.encontrarPorNome("D").forEach(System.out::println);
			// todosClientes = clientes.findAll();

			// System.out.println("\n Deletando clientes :");
			// clientes.findAll().forEach(c -> {
			// 	System.out.println(c);
			// 	clientes.delete(c);				
			// });	
			
			// todosClientes = clientes.findAll();
			// if (todosClientes.isEmpty()){
			// 	System.out.println("\n nenhum cliente encontrado");
			// } else {
			// 	todosClientes.forEach(System.out::println);
			// }
		};
	}
	
	public static void main(String[] 	args) {
		SpringApplication.run(VendasApplication.class, args);
	}

}
