package br.com.ada.pablo.livraria.transacao.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;

import java.util.List;

public record TransacaoDto(
        @NotEmpty
        Long idPessoa,
        @NotEmpty
        @Valid
        List<CriarTransacaoDto> lista) {
}
