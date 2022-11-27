package com.company;

import java.awt.*;
import java.util.*;
import java.util.List;

public class Main {

    public static void main(String[] args) throws Exception {
    	Estoque<Produto> estoque = new Estoque<>();

		System.out.println("1) Você deve ser capaz de adicionar, ver, alterar e remover qualquer produto do sistema");

		System.out.println("   Adcionando produtos no estoque: 7");
    	estoque.adicionar(new Filme(1, "Intereselar", 39.90, Rotulo.Adulto));
		estoque.adicionar(new Filme(2, "A Procura da Felicidade", 29.90, Rotulo.Livre));
		estoque.adicionar(new Livro(3, "Clean Code", 19.90, Rotulo.Livre));
		estoque.adicionar(new Livro(4, "Clean Arquiteture", 59.90, Rotulo.Adulto));
		estoque.adicionar(new Filme(5, "Sete Vidas", 24.80, Rotulo.Adulto));
		estoque.adicionar(new Filme(6, "Procurando Nemo", 12.90, Rotulo.Livre));
		estoque.adicionar(new Livro(7, "É Assim que Acaba", 100.00, Rotulo.Adulto));
		estoque.adicionar(new Brinquedo(8, "Carrinho", 40.00, Rotulo.Livre));
		estoque.adicionar(new AlbumMusica(9, "Guns&Roses", 60.00, Rotulo.Adulto));
		estoque.adicionar(new Jogo(10, "FIFA23", 299.00, Rotulo.Livre));

		System.out.println("   Alterando produtos no estoque: 2");

		estoque.alterar(new Filme(1, "Interestelar 2" , 39.90, Rotulo.Adulto));
		estoque.alterar(new Livro(3, "Clean Code 2", 19.90, Rotulo.Livre));

		System.out.println("   Removendo produtos no estoque: 2");

		estoque.remover(estoque.obterPorId(3));
		estoque.remover(estoque.obterPorId(5));

		var pro= estoque.obterPorId(4);
		System.out.println("   Obtendo produto no estoque: Id: " + pro.getId() + " Nome: " + pro.getNome());

		System.out.println("--------------------------------------------------------------");
		System.out.println("2) Você deve ser capaz de ver quantos itens de um tipo específico existem no estoque.");

		List<Produto> livrosNoEstoque = estoque.listarPorTipo(TipoProduto.Livro);
		System.out.println("   Quantidade de livros no estoque: " + livrosNoEstoque.stream().count());

		List<Produto> filmesNoEstoque = estoque.listarPorTipo(TipoProduto.Filme);
		System.out.println("   Quantidade de filmes no estoque: " + filmesNoEstoque.stream().count());

		System.out.println("--------------------------------------------------------------");
		System.out.println("3) Você deve ser capaz de ver a listagem completa dos itens em estoque.");

		Map<Integer, Produto> produtos = estoque.obterTodos();
		System.out.println("   Quantidade de produtos no estoque: " + produtos.size());
		System.out.println("   Listagem de produtos do estoque:");
		produtos.forEach(
				(id, produto) -> System.out.println("      Id:" + id + " Nome:" + produto.getNome()));

		System.out.println("--------------------------------------------------------------");
		System.out.println("4) Você deve ser capaz de realizar a operação de compra, ao realizar esta operação os produtos comprados são removidos do estoque e o dinheiro pago deve ser adicionado ao caixa.");

		Comprador comprador = new Comprador("João da Silva", "111111",
				"08777723456", "24/05/1986"); //Configurar menor de idade para validar regra.

		Caixa caixa = new Caixa(0.0);

		Compra compra = new Compra(comprador, caixa, estoque);

		compra.adicionarItem(estoque.obterPorId(1));
		compra.adicionarItem(estoque.obterPorId(6));
		compra.adicionarItem(estoque.obterPorId(7));

		compra.Registrar();

		System.out.println("   Compra registrada com sucesso:");
		System.out.println("      Valor Bruto: " + compra.getValorBruto());
		System.out.println("      Valor Imposto: " + compra.getValorImpostos());
		System.out.println("      Valor Líquido: " + compra.getValorLiquido());
		System.out.println("   Estoque baixado com sucesso.");

		produtos = estoque.obterTodos();
		System.out.println(" ");
		System.out.println("   Quantidade atualizada de produtos no estoque: " + produtos.size());
		System.out.println("   Listagem atualizada de produtos do estoque:");
		produtos.forEach(
				(id, produto) -> System.out.println("      Id:" + id + " Nome:" + produto.getNome()));

    }
}
