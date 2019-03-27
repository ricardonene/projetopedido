package br.senai.sc;


import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.senai.sc.domain.Categoria;
import br.senai.sc.domain.Cidade;
import br.senai.sc.domain.Cliente;
import br.senai.sc.domain.Endereco;
import br.senai.sc.domain.Estado;
import br.senai.sc.domain.ItemPedido;
import br.senai.sc.domain.PagamentoComCartao;
import br.senai.sc.domain.Pedido;
import br.senai.sc.domain.Produto;
import br.senai.sc.domain.enums.EstadoPagamento;
import br.senai.sc.domain.enums.TipoCliente;
import br.senai.sc.repositories.CategoriaRepository;
import br.senai.sc.repositories.CidadeRepository;
import br.senai.sc.repositories.ClienteRepository;
import br.senai.sc.repositories.EnderecoRepository;
import br.senai.sc.repositories.EstadoRepository;
import br.senai.sc.repositories.ItemPedidoRepository;
import br.senai.sc.repositories.PagamentoRepository;
import br.senai.sc.repositories.PedidoRepository;
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
	
	@Autowired
	private EstadoRepository estadoRepository;
	
	@Autowired
	private CidadeRepository cidadeRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;

	@Autowired
	private EnderecoRepository enderecoRepository;
	
	@Autowired
	private PedidoRepository pedidoRepository;
	
	@Autowired
	private ItemPedidoRepository itemPedidoRepository;
	
	@Autowired
	private PagamentoRepository pagamentoRepository;

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
		
		Estado sp = new Estado(null, "São Paulo");
		Estado mg = new Estado(null, "Minas Gerais");
		
		Cidade c1 = new Cidade(null, "Uberlandia", mg);
		Cidade c2 = new Cidade(null, "São Paulo", sp);
		Cidade c3 = new Cidade(null, "Campinas", sp);
		
		
		//sp.setCidades(Arrays.asList(c2, c3));
		
		sp.getCidades().add(c2);
		sp.getCidades().add(c3);
		
		mg.getCidades().add(c1);
		
		estadoRepository.save(sp);
		estadoRepository.save(mg);
		
		cidadeRepository.save(c1);
		cidadeRepository.save(c2);
		cidadeRepository.save(c3);
		
		Endereco e1 = new Endereco(null, "Rua A", "123", "Apto 1", "Centro", "88010-000", c1);
		Endereco e2 = new Endereco(null, "Rua B", "123", "Apto 12", "Centro", "88010-120", c2);
		
		Cliente cli1 = new Cliente(null, "Maria Silva", 
				"maria@gmail.com", 
				"032.123.486-98", 
				TipoCliente.PESSOAFISICA);
		
		
		cli1.setEnderecos(Arrays.asList(e1, e2));
		cli1.getTelefones().add("(48) 99999-8888");
		cli1.getTelefones().add("(48) 99999-7877");
		
		e1.setCliente(cli1);
		e2.setCliente(cli1);
		
		clienteRepository.save(cli1);
		
		enderecoRepository.save(e1);
		enderecoRepository.save(e2);
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		
		Pedido ped1 = new Pedido(null, 
				sdf.parse("30/09/2017 10:32"), 
				cli1, 
				e1);
		
		PagamentoComCartao pag1 = new PagamentoComCartao(null,
				EstadoPagamento.PENDENTE, 
				ped1, 6);
		ped1.setPagamento(pag1);
		
		ItemPedido item1 = new ItemPedido(ped1, p1, 0.0, 1, 1000.0);
	
		pedidoRepository.save(ped1);
		itemPedidoRepository.save(item1);
		pagamentoRepository.save(pag1);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

	
	
	
	
}
