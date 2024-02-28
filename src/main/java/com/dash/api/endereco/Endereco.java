package com.dash.api.endereco;

import jakarta.validation.constraints.NotBlank;

public record Endereco(
        @NotBlank
        String rua,
        @NotBlank
        String bairro,
        @NotBlank
        String cep,
        @NotBlank
        String cidade,
        @NotBlank
        String uf,
        String complemento, String numero) {
}
