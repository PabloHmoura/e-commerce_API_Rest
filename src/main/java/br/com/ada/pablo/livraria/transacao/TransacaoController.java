package br.com.ada.pablo.livraria.transacao;

import br.com.ada.pablo.livraria.exception.TransacaoInvalidaException;
import br.com.ada.pablo.livraria.transacao.dto.TransacaoDto;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
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
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public Transacao criarTransacao(@RequestBody TransacaoDto dados) throws TransacaoInvalidaException {
        return transacaoService.create(dados);
    }
}
