package br.com.ada.pablo.livraria.transacao.dto;


import br.com.ada.pablo.livraria.livro.Livro;
import jakarta.validation.constraints.NotEmpty;

import java.util.List;


public record CriarTransacaoDto(
        @NotEmpty
        Long idPessoa,
        @NotEmpty
        List<ListaQuantideLivroDto> quantideLivroDtos,
        @NotEmpty
        List<Livro> livros) {
}
