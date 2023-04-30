package br.com.ada.pablo.livraria.transacao.dto;

import br.com.ada.pablo.livraria.item.ItemTransacao;
import br.com.ada.pablo.livraria.transacao.Transacao;

import java.util.List;

public class ListarTransacoesDto {
    private Long idTransacao;
    private String nomePessoa;
    private List<ItemTransacao> listaTransacao;

    public ListarTransacoesDto(Long idTransacao, String nomePessoa, List<ItemTransacao> listaTransacao) {
        this.idTransacao = idTransacao;
        this.nomePessoa = nomePessoa;
        this.listaTransacao = listaTransacao;
    }

    public Long getIdTransacao() {
        return idTransacao;
    }

    public String getNomePessoa() {
        return nomePessoa;
    }

    public List<ItemTransacao> getListaTransacao() {
        return listaTransacao;
    }
}
