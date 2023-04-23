package br.com.ada.pablo.livraria.util.validacoes;

import br.com.ada.pablo.livraria.livro.Livro;
import br.com.ada.pablo.livraria.pessoa.Pessoa;

import java.math.BigDecimal;

public class ValidaSaldo {

    public static boolean saldoValido(Livro livro, Pessoa pessoa, Integer qtd) {
        return pessoa.getSaldo().compareTo(livro.getPreco().multiply(BigDecimal.valueOf(qtd))) >= 0;
    }
}
