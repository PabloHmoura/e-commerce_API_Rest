package br.com.ada.pablo.livraria.model;

import br.com.ada.pablo.livraria.util.enums.Categoria;
import br.com.ada.pablo.livraria.util.enums.Genero;
import jakarta.persistence.*;

import java.io.Serializable;
import java.math.BigDecimal;

@MappedSuperclass
public abstract class Produto {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "produto_id")
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
    private Integer quantidade;

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
