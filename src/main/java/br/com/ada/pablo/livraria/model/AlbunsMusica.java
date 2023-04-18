package br.com.ada.pablo.livraria.model;


import br.com.ada.pablo.livraria.util.Genero;

public class AlbunsMusica extends Produto {

    private String musicoOuBanda;
    private Genero generos;
    private String selos;

    /*public AlbunsMusica(Categoria categoria, String nome, Double preco, String musicoOuBanda, Genero genero, String selos) {
        super(categoria, nome, preco);
        this.musicoOuBanda = musicoOuBanda;
        this.generos = genero;
        this.selos = selos;
    }*/

    public Genero getGeneros() {
        return generos;
    }

}
