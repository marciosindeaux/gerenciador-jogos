package com.sindeaux.jogos.builders;

import com.sindeaux.jogos.controller.openapi.model.DesenvolvedoraCadastro;


public class DesenvolvedoraCadastroBuilder {

    DesenvolvedoraCadastro desenvolvedoraCadastro;

    private DesenvolvedoraCadastroBuilder(DesenvolvedoraCadastro desenvolvedoraCadastro){
        this.desenvolvedoraCadastro = desenvolvedoraCadastro;
    }

    public static DesenvolvedoraCadastroBuilder with(){
        return new DesenvolvedoraCadastroBuilder(new DesenvolvedoraCadastro());
    }

    public DesenvolvedoraCadastroBuilder id(Integer id) {
        this.desenvolvedoraCadastro.setIdDesenvolvedora(id);
        return this;
    }

    public DesenvolvedoraCadastroBuilder nome(String nome){
        this.desenvolvedoraCadastro.setNome(nome);
        return this;
    }

    public DesenvolvedoraCadastro build() {
        return this.desenvolvedoraCadastro;
    }

}
