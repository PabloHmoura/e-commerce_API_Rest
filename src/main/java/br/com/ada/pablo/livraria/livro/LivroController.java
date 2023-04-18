package br.com.ada.pablo.livraria.livro;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/livro")
public class LivroController{

    private LivroService livroService;

    @Autowired
    public LivroController (LivroService livroService) {
        this.livroService = livroService;
    }

    @GetMapping(
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    public Iterable<Livro> list() {
        return livroService.listByName();
    }

    @PostMapping(
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    public Livro saveLivro(@RequestBody Livro livro) {
        return livroService.add(livro);
    }

    @GetMapping(
            value = "{id}",
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    public ResponseEntity<Livro> findById(@PathVariable("id") Long id){
        Livro livro = livroService.findById(id).orElse(null);
        if (livro == null) {
            return ResponseEntity.notFound().build();
        }
        return new ResponseEntity<>(livro, HttpStatus.OK);
    }

}
