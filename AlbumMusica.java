package com.company;

import java.util.List;

public class AlbumMusica implements Produto, Genero {

    private Integer id;
    private String nome;
    private Double preco;
    private List<String> generos;
    private List<String> musicasBandas;
    private List<String> selos;
    private Rotulo rotulo;

    public AlbumMusica(Integer id, String nome, Double preco, Rotulo rotulo) {
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

    public List<String> getMusicasBandas() {
        return musicasBandas;
    }

    public void adcionarMusicaBanda(String musicaBanda) {
        musicasBandas.add(musicaBanda);
    }

    public List<String> getSelos() {
        return selos;
    }

    public void adcionarSelo(String selo) {
        selos.add(selo);
    }
}
