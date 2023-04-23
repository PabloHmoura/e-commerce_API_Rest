package br.com.ada.pablo.livraria.transacao;

import br.com.ada.pablo.livraria.pessoa.Pessoa;
import br.com.ada.pablo.livraria.livro.Livro;
import br.com.ada.pablo.livraria.util.validacoes.ValidaQuantidadeLivro;
import br.com.ada.pablo.livraria.util.validacoes.ValidaSaldo;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

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

    @ElementCollection
    @CollectionTable(name = "lista_de_livros")
    private List<Livro> livros = new ArrayList<>();

    public Transacao(RefTransacao refTransacao, Pessoa pessoa, Livro livro, Integer qtdLivro) {
        this.refTransacao = refTransacao;
        this.pessoa = pessoa;
        this.livro = livro;
        this.quantidadeLivro = qtdLivro;
        this.preco = livro.getPreco().multiply(BigDecimal.valueOf(qtdLivro));
    }


}
