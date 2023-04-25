package br.com.ada.pablo.livraria.transacao.dto;


import jakarta.validation.constraints.NotEmpty;
import java.math.BigDecimal;

public record CriarTransacaoDto(
        @NotEmpty
        Long idLivro,
        @NotEmpty
        Integer quantidade,
        @NotEmpty
        BigDecimal precoUnitario,
        @NotEmpty
        BigDecimal precoTotal) {
}
