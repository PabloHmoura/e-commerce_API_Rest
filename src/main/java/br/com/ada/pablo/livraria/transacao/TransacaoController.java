package br.com.ada.pablo.livraria.transacao;

import br.com.ada.pablo.livraria.livro.Livro;
import br.com.ada.pablo.livraria.livro.LivroService;
import br.com.ada.pablo.livraria.pessoa.Pessoa;
import br.com.ada.pablo.livraria.pessoa.PessoaService;
import br.com.ada.pablo.livraria.util.validacoes.ValidaQuantidadeLivro;
import br.com.ada.pablo.livraria.util.validacoes.ValidaSaldo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/api/transacao")
public class TransacaoController {



    private TransacaoService transacaoService;

    @Autowired
    public TransacaoController(TransacaoService transacaoService) {
        this.transacaoService = transacaoService;
    }

    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<Transacao> listarTransacoes(){
        return transacaoService.list();
    }


    @PostMapping(
            value = "/{idPessoa}",
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    public Transacao criarTransacao(@PathVariable Integer qtd, @PathVariable Long idPessoa, @PathVariable Long idLivro) {
        return transacaoService.create(idLivro, idPessoa, qtd);
    }
}
