package com.company;

public class Brinquedo implements Produto {

    private Integer id;
    private String nome;
    private Double preco;
    private String tipo;
    private Rotulo rotulo;

    public Brinquedo(Integer id, String nome, Double preco, Rotulo rotulo) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
        this.rotulo = rotulo;
    }

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public String getNome() {
        return nome;
    }

    @Override
    public Double getPreco() {
        return preco;
    }

    public Double getTipo() {
        return preco;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public Rotulo getRotulo() {
        return rotulo;
    }

    @Override
    public void setRotulo(Rotulo rotulo) {
        this.rotulo = rotulo;
    }
}
