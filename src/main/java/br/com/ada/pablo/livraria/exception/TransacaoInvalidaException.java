package br.com.ada.pablo.livraria.exception;

public class TransacaoInvalidaException extends Exception{

    public TransacaoInvalidaException() {
        super("quantidade de livros é negativa ou saldo insuficiente");
    }
}
