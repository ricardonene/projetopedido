package br.senai.sc;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.senai.sc.domain.Categoria;
import br.senai.sc.domain.Produto;
import br.senai.sc.repositories.CategoriaRepository;
import br.senai.sc.repositories.ProdutoRepository;

@SpringBootApplication
public class ProjetoPedidoApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ProjetoPedidoApplication.class, args);
	
	}
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private ProdutoRepository produtoRepository;

	@Override
	public void run(String... args) throws Exception {
		Categoria cat1 = new Categoria(null, "Informática");
		Categoria cat2 = new Categoria(null, "Escritório");
		
		Produto p1 = new Produto(null, "Computador", 2000.00);
		Produto p2 = new Produto(null, "Impressora", 800.00);
		
		p1.getCategorias().add(cat1);
		cat1.getProdutos().add(p1);
		
		categoriaRepository.save(cat1);
		categoriaRepository.save(cat2);
		
		produtoRepository.save(p1);
		produtoRepository.save(p2);
		
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	
	
	
	
}
