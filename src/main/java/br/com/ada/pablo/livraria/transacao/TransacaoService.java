package br.com.ada.pablo.livraria.transacao;

import br.com.ada.pablo.livraria.livro.Livro;
import br.com.ada.pablo.livraria.livro.LivroService;
import br.com.ada.pablo.livraria.pessoa.Pessoa;
import br.com.ada.pablo.livraria.pessoa.PessoaService;
import br.com.ada.pablo.livraria.util.validacoes.ValidaQuantidadeLivro;
import br.com.ada.pablo.livraria.util.validacoes.ValidaSaldo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class TransacaoService {

    private TransacaoRepository transacaoRepository;

    private PessoaService pessoaService;
    private LivroService livroService;

    @Autowired
    public TransacaoService(PessoaService pessoaService, LivroService livroService, TransacaoRepository transacaoRepository) {
        this.pessoaService = pessoaService;
        this.livroService = livroService;
        this.transacaoRepository = transacaoRepository;
    }

    public Transacao create (Long idLivro, Long idPessoa, Integer qtd) {
        Pessoa pessoa = pessoaService.findById(idPessoa).orElseThrow(RuntimeException::new);
        Livro livro = livroService.findById(idLivro).orElseThrow(RuntimeException::new);
        Transacao transacao = null;
        if (ValidaSaldo.saldoValido(livro, pessoa, qtd) && ValidaQuantidadeLivro.quantidadeLivroMaiorIgualZero(livro, qtd)) {
            transacao = new Transacao(RefTransacao.AGUARDANDO_PAGAMENTO, pessoa, livro, qtd);
            livro.setQuantidade(livro.getQuantidade() - qtd);
            livroService.add(livro);
            pessoa.setSaldo(pessoa.getSaldo().subtract(livro.getPreco().multiply(BigDecimal.valueOf(qtd))));
            pessoaService.add(pessoa);
            transacaoRepository.save(transacao);
        }else {
            throw new RuntimeException("Saldo ou quantidade negativo");
        }

        return transacaoRepository.save(transacao);
    }

    public List<Transacao> list () {
        return transacaoRepository.findAll();
    }


}
