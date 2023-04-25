package br.com.ada.pablo.livraria.util.validacoes;

import br.com.ada.pablo.livraria.livro.Livro;

public class ValidaQuantidadeLivro {

    public static boolean quantidadeLivroMaiorIgualZero(Livro livro, Integer qtd) {
        return livro.getQuantidade() - qtd >= 0;
    }
}
