package br.com.ada.pablo.livraria.transacao;

import br.com.ada.pablo.livraria.exception.TransacaoInvalidaException;
import br.com.ada.pablo.livraria.item.ItemTransacao;
import br.com.ada.pablo.livraria.item.ItemTransacaoRepository;
import br.com.ada.pablo.livraria.livro.Livro;
import br.com.ada.pablo.livraria.livro.LivroService;
import br.com.ada.pablo.livraria.pessoa.Pessoa;
import br.com.ada.pablo.livraria.pessoa.PessoaService;
import br.com.ada.pablo.livraria.transacao.dto.CriarTransacaoDto;
import br.com.ada.pablo.livraria.transacao.dto.ListarTransacoesDto;
import br.com.ada.pablo.livraria.transacao.dto.TransacaoDto;
import br.com.ada.pablo.livraria.util.validacoes.ValidaQuantidadeLivro;
import br.com.ada.pablo.livraria.util.validacoes.ValidaSaldo;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class TransacaoService {

    private TransacaoRepository transacaoRepository;

    private PessoaService pessoaService;
    private LivroService livroService;
    private ItemTransacaoRepository itemTransacaoRepository;

    @Autowired
    public TransacaoService(PessoaService pessoaService, LivroService livroService, TransacaoRepository transacaoRepository, ItemTransacaoRepository itemTransacaoRepository) {
        this.pessoaService = pessoaService;
        this.livroService = livroService;
        this.transacaoRepository = transacaoRepository;
        this.itemTransacaoRepository = itemTransacaoRepository;
    }

    @Transactional
    public Transacao create (@Valid TransacaoDto dados) throws TransacaoInvalidaException {
        Pessoa pessoa = pessoaService.findById(dados.idPessoa()).orElseThrow(RuntimeException::new);
        List<ItemTransacao> itens = new ArrayList<>();

        for (CriarTransacaoDto livroDto: dados.lista()) {
            Livro livro = livroService.findById(livroDto.idLivro()).orElseThrow(RuntimeException::new);
            if (ValidaQuantidadeLivro.quantidadeLivroMaiorIgualZero(livro, livroDto.quantidade()) && ValidaSaldo.saldoValido(livro, pessoa, livroDto.quantidade())){
                itens.add(itemTransacaoRepository.save(new ItemTransacao(livroDto, livro)));
                livro.setQuantidade(livro.getQuantidade() - livroDto.quantidade());
                pessoa.setSaldo(pessoa.getSaldo().subtract(livro.getPreco().multiply(BigDecimal.valueOf(livroDto.quantidade()))));
                livroService.add(livro);
            } else {
                throw new TransacaoInvalidaException();
            }
        }
        pessoaService.add(pessoa);

        Transacao transacao = new Transacao(RefTransacao.AGUARDANDO_PAGAMENTO, pessoa, itens);
        return transacaoRepository.save(transacao);
    }

    public List<Transacao> list() {
        return transacaoRepository.findAll();
    }

}
