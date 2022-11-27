package com.company;

import java.util.List;

public class Filme implements Produto, Genero {

    private Integer id;
    private String nome;
    private Double preco;
    private List<String> generos;
    private String studio;
    private List<String> diretores;
    private List<String> produtores;
    private Rotulo rotulo;

    public Filme(Integer id, String nome, Double preco, Rotulo rotulo) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
        this.rotulo = rotulo;
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
    public Integer getId() {
        return id;
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

    public void adcionarDiretor(String diretor) {
        diretores.add(diretor);
    }

    public void adcionarProdutor(String produtor) {
        produtores.add(produtor);
    }

    public List<String> getDiretores() {
        return diretores;
    }

    public List<String> getProdutores() {
        return produtores;
    }

    public String getstudio() {
        return studio;
    }

    public void setId(Integer id) {
        id = id;
    }

    public void setNome(String nome) {
        nome = nome;
    }



}
