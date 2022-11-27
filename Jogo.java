package com.company;

import java.util.List;

public class Jogo implements Produto, Genero {
    private Integer id;
    private String nome;
    private Double preco;
    private List<String> generos;
    private String distribuidora;
    private String studio;
    private Rotulo rotulo;

    public Jogo(Integer id, String nome, Double preco, Rotulo rotulo) {
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

    @Override
    public List<String> getGeneros() {
        return generos;
    }

    @Override
    public void adcionarGenero(String genero) {
        generos.add(genero);
    }

    @Override
    public Rotulo getRotulo() {
        return rotulo;
    }

    @Override
    public void setRotulo(Rotulo rotulo) {
        this.rotulo = rotulo;
    }

    public String getdistribuidora() {
        return distribuidora;
    }

    public String getstudio() {
        return studio;
    }
}
