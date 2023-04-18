package br.com.ada.pablo.livraria.transacao;

import br.com.ada.pablo.livraria.livro.Livro;
import br.com.ada.pablo.livraria.livro.LivroService;
import br.com.ada.pablo.livraria.pessoa.Pessoa;
import br.com.ada.pablo.livraria.pessoa.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/api/transacao")
public class TransacaoController {

    private PessoaService pessoaService;
    private LivroService livroService;

    private TransacaoService transacaoService;

    @Autowired
    public TransacaoController(PessoaService pessoaService, LivroService livroService, TransacaoService transacaoService) {
        this.pessoaService = pessoaService;
        this.livroService = livroService;
        this.transacaoService = transacaoService;
    }

    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<Transacao> listarTransacoes(){
        return transacaoService.list();
    }


    @PostMapping(
            value = "/{qtd}-{idPessoa}-{idLivro}",
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    public Transacao criarTransacao(@PathVariable Integer qtd, @PathVariable Long idPessoa, @PathVariable Long idLivro) {
        Pessoa pessoa = pessoaService.findById(idPessoa).orElseThrow(RuntimeException::new);
        Livro livro = livroService.findById(idLivro).orElseThrow(RuntimeException::new);
        var transacao = new Transacao(RefTransacao.AGUARDANDO_PAGAMENTO, pessoa, livro, qtd);
//        Integer novaQtdLivro = livro.getQuantidade() - qtd;
        livro.setQuantidade(livro.getQuantidade() - qtd);
        livroService.add(livro);
        pessoa.setSaldo(pessoa.getSaldo().subtract(livro.getPreco().multiply(BigDecimal.valueOf(qtd))));
        pessoaService.add(pessoa);
        transacaoService.create(transacao);
        return transacao;
    }
}
