package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Compra {
    private Double valorBruto;
    private Double valorImpostos;
    private Double valorDescontos;
    private Double valorLiquido;
    private List<Produto> itensCompra;

    private Comprador comprador;
    private Caixa caixa;
    private Estoque estoque;


    private final Double percentualImposto = 0.01;
    private final Double valorCorteDesconto = 200.00;
    private final Double percentualDesconto = 0.15;

    public Compra(Comprador comprador, Caixa caixa, Estoque estoque) {
        this.comprador = comprador;
        this.caixa = caixa;
        this.estoque = estoque;
        this.itensCompra = new ArrayList<>();
    }

    public Double getValorBruto() {
        return valorBruto;
    }

    public Double getValorImpostos() {
        return valorImpostos;
    }

    public Double getValorDescontos() {
        return valorDescontos;
    }

    public Double getValorLiquido() {
        return valorLiquido;
    }

    public void adicionarItem(Produto produto) {
        this.itensCompra.add(produto);
    }

    public void removerItem(Produto produto) {
        this.itensCompra.remove(produto);
    }

    public void Registrar() throws Exception {
        Validar();
        Calcular();

        caixa.atualizarSaldoCaixa(this.valorLiquido);

        for (Produto produto : itensCompra) {
            estoque.remover(produto);
        }
    }

    private void Calcular() {
        Double valorTotalCompra = 0.0;

        for (Produto item : itensCompra) {
            valorTotalCompra += item.getPreco();
        }

        this.valorBruto = valorTotalCompra;
        this.valorDescontos = CalcularValorDescontos();
        this.valorImpostos = valorTotalCompra * percentualImposto;
        this.valorLiquido = this.valorBruto - this.valorImpostos - this.valorDescontos;
    }

    private Double CalcularValorDescontos() {
        Double valorTotalLivros = 0.0;

        for (Produto item : itensCompra) {
            if (item.getClass() == Livro.class) {
                valorTotalLivros += item.getPreco();
            }
        }

        if (valorTotalLivros > valorCorteDesconto) {
            return this.valorBruto * percentualDesconto;
        }

        return 0.0;
    }

    private void Validar() throws Exception {
        System.out.println("Idade comprador: " + this.comprador.getIdade());
        if (this.comprador.getIdade() < 18) {
            boolean possuiItenAdulto =
                    itensCompra.stream()
                            .filter(i -> i.getRotulo() == Rotulo.Adulto)
                            .count() > 0;

            if (possuiItenAdulto)
                throw new Exception("Bussness Exception: Não é permitido realizar a compra de itens de " +
                        "rótulo adulto para menores de 18 anos.");
        }
    }




}
