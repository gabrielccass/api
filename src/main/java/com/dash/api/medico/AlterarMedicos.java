package com.dash.api.medico;

import com.dash.api.endereco.Endereco;
import jakarta.validation.constraints.NotNull;

public record AlterarMedicos(
        @NotNull
        Long id,
        String nome,
        String telefone,
        String email,
        Endereco endereco) {

}
