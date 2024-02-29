package com.dash.api.medico;

import com.dash.api.endereco.Endereco2;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name="medicos")
@Entity(name="Medico")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Medico {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nome;
    private String email;
    private String telefone;
    private String crm;

    @Enumerated(EnumType.STRING)
    private Especialidade especialidade;

    @Embedded
    private Endereco2 endereco;

    private boolean ativo;

    public Medico(CadastroMedicos dados) {
        this.ativo = true;
        this.nome = dados.nome();
        this.email = dados.email();
        this.telefone = dados.telefone();
        this.crm = dados.crm();
        this.especialidade = dados.especialidade();
        this.endereco = new Endereco2(dados.endereco());
    }

    public void atualizar(AlterarMedicos dadosalterados) {
        if (dadosalterados.nome() != null){
            this.nome = dadosalterados.nome();
        }
        if (dadosalterados.telefone() != null){
            this.telefone = dadosalterados.telefone();
        }
        if (dadosalterados.endereco() != null){
            this.endereco.atualizar(dadosalterados.endereco());
        }
        if (dadosalterados.email() != null){
            this.email = dadosalterados.email();
        }
    }

    public void excluir() {
        this.ativo = false;
    }
}
