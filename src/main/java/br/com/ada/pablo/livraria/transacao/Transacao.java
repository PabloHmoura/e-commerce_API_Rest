package br.com.ada.pablo.livraria.transacao;

import br.com.ada.pablo.livraria.item.ItemTransacao;
import br.com.ada.pablo.livraria.pessoa.Pessoa;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Transacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_transacao")
    private Long id;

    @Enumerated(EnumType.STRING)
    private RefTransacao refTransacao;

    @ManyToOne(fetch = FetchType.LAZY)
    @Fetch(FetchMode.JOIN)
    @JoinColumn(name = "pessoa_id")
    private Pessoa pessoa;

    @Column(name = "qtd_livro")
    private Integer quantidadeLivro;

    @Column(name = "preco")
    private BigDecimal preco;

    @OneToMany
    @JoinColumn(name = "id_transacao")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private List<ItemTransacao> livros;

    public Transacao(RefTransacao refTransacao, Pessoa pessoa, List<ItemTransacao> livros) {
        this.refTransacao = refTransacao;
        this.pessoa = pessoa;
        this.livros = livros;
        this.quantidadeLivro = getTotalLivros(livros);
        this.preco = getTotalCompra(livros);
    }

    public Integer getTotalLivros(List<ItemTransacao> livros) {
        int totalLivros = 0;
        for(ItemTransacao item : livros) {
            totalLivros += item.getQuantidade();
        }
        return totalLivros;
    }

    public BigDecimal getTotalCompra(List<ItemTransacao> livros) {
        BigDecimal totalLivros = new BigDecimal("0");
        for(ItemTransacao item : livros) {
            totalLivros.add(item.getPrecoTotal());
        }
        return totalLivros;
    }

}
