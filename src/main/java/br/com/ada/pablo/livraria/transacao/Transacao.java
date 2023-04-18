package br.com.ada.pablo.livraria.transacao;

import br.com.ada.pablo.livraria.pessoa.Pessoa;
import br.com.ada.pablo.livraria.livro.Livro;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "transacao")
public class Transacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private RefTransacao refTransacao;

    @ManyToOne
    @JoinColumn(name = "pessoa")
    private Pessoa pessoa;

    @ManyToOne
    @JoinColumn(name = "livro")
    private Livro livro;

    @Column(name = "qtd_livro")
    private Integer quantidadeLivro;

    @Column(name = "preco")
    private BigDecimal preco;

    public Transacao(RefTransacao refTransacao, Pessoa pessoa, Livro livro, Integer qtdLivro) {
        this.refTransacao = refTransacao;
        this.pessoa = pessoa;
        this.livro = livro;
        this.quantidadeLivro = qtdLivro;
        this.preco = livro.getPreco().multiply(BigDecimal.valueOf(qtdLivro));
    }


}
