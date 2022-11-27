package com.company;

import java.util.List;

public class Livro implements Produto, Genero {

    private Integer id;
    private String nome;
    private Double preco;
    private List<String> generos;
    private String escritor;
    private String editora;
    private Rotulo rotulo;

    public Livro(Integer id, String nome, Double preco, Rotulo rotulo) {
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
        return null;
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

    public void setId(Integer id) {
        id = id;
    }

    public void setNome(String nome) {
        nome = nome;
    }

    public String getEscritor() {
        return escritor;
    }

    public String getEditora() {
        return editora;
    }


}
