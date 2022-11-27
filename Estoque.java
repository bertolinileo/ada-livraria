package com.company;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


public class Estoque<T extends Produto> {

    private Map<Integer, T> produtos;

    public Estoque() {
        produtos = new HashMap<>();
    }

    public Map<Integer, T> obterTodos() {
        return produtos;
    }

    public T obterPorId(Integer id) {
        return produtos.getOrDefault(id, null);
    }

    public List<Produto> listarPorTipo(TipoProduto tipoProduto) {

        //TODO: Refatorar para obter o tipo do produto sem precisar checar pela class.
        Class<?> cls = obterClass(tipoProduto);

        List<Produto> produtosPorTipo =
                produtos.values()
                        .stream()
                        .filter(p -> p.getClass() == cls)
                        .collect(Collectors.toList());

        return produtosPorTipo;
    }

    public void adicionar(T produto) {
        produtos.put(produto.getId(), produto);
    }

    public void remover(T produto) {
        produtos.remove(produto.getId(), produto);
    }

    public void alterar(T produto) {
        produtos.replace(produto.getId(), produto);
    }

    private Class<?> obterClass(TipoProduto tipoProduto) {
        switch (tipoProduto) {
            case Livro:
                return Livro.class;
            case Filme:
                return Filme.class;
            default:
                return Object.class;
        }
    }

}
