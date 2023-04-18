package br.com.ada.pablo.livraria.transacao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransacaoService {

    private TransacaoRepository transacaoRepository;

    @Autowired
    public TransacaoService(TransacaoRepository transacaoRepository) {
        this.transacaoRepository = transacaoRepository;
    }

    public Transacao create (Transacao transacao) {
        return transacaoRepository.save(transacao);
    }

    public List<Transacao> list () {
        return transacaoRepository.findAll();
    }


}
