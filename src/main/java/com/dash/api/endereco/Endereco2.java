package com.dash.api.endereco;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Endereco2 {
    private String rua;
    private String bairro;
    private String cep;
    private String numero;
    private String complemento;
    private String cidade;
    private String uf;

    public Endereco2(Endereco endereco) {
        this.rua = endereco.rua();
        this.bairro = endereco.bairro();
        this.cep = endereco.cep();
        this.numero = endereco.numero();
        this.complemento = endereco.complemento();
        this.cidade = endereco.cidade();
        this.uf = endereco.uf();
    }

    public void atualizar(Endereco dados) {
        if (dados.rua() != null){
            this.rua = dados.rua();
        }
        if (dados.bairro() != null){
            this.rua = dados.bairro();
        }
        if (dados.cep() != null){
            this.rua = dados.cep();
        }
        if (dados.numero() != null){
            this.rua = dados.numero();
        }
        if (dados.complemento() != null){
            this.rua = dados.complemento();
        }
        if (dados.cidade() != null){
            this.rua = dados.cidade();
        }
        if (dados.uf() != null){
            this.rua = dados.uf();
        }
    }
}
