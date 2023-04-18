package br.com.ada.pablo.livraria.model;

import br.com.ada.pablo.livraria.util.Categoria;
import br.com.ada.pablo.livraria.util.Genero;
import jakarta.persistence.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@MappedSuperclass
public abstract class Produto implements Serializable {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String nome;

    @Column
    private BigDecimal preco;

    @Enumerated(EnumType.STRING)
    @Column
    private Categoria categoria;

    @Enumerated(EnumType.STRING)
    @Column
    private Genero genero;
    @Column
    private Date data;

    @Column
    private Integer quantidade;

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Long getId() {
        return id;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Genero getGenero() {
        return genero;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

}
