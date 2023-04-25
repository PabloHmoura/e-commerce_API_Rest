package br.com.ada.pablo.livraria.item;

import br.com.ada.pablo.livraria.livro.Livro;
import br.com.ada.pablo.livraria.transacao.dto.CriarTransacaoDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Getter
@Setter
public class ItemTransacao {

    @Id
    @Column(name = "item_transacao_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @ManyToOne
    private Livro livro;
    @Column
    private Integer quantidade;
    @Column
    private BigDecimal precoUnitario;
    @Column
    private BigDecimal precoTotal;

    public ItemTransacao (CriarTransacaoDto dados, Livro livro) {
        this.quantidade = dados.quantidade();
        this.precoUnitario = dados.precoUnitario();
        this.precoTotal = this.precoUnitario.multiply(BigDecimal.valueOf(this.quantidade));
        this.livro = livro;
    }



}
