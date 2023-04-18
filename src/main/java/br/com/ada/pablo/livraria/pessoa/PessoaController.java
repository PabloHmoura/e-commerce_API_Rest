package br.com.ada.pablo.livraria.pessoa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pessoa")
public class PessoaController {

    private PessoaService pessoaService;

    @Autowired
    public PessoaController(PessoaService pessoaService) {
        this.pessoaService = pessoaService;
    }

    @GetMapping(
            value = "/{id}",
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    public Pessoa findById(@PathVariable Long id) {
        return pessoaService.findById(id).orElseThrow(RuntimeException::new);
    }

    @PostMapping(
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    public Pessoa create(@RequestBody Pessoa pessoa) {
        return pessoaService.add(pessoa);
    }

    @GetMapping
    public List<Pessoa> list() {
        return pessoaService.listAll();
    }
}
