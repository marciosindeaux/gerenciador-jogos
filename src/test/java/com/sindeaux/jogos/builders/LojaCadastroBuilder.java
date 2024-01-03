package com.sindeaux.jogos.builders;

import com.sindeaux.jogos.controller.openapi.model.LojaCadastro;

public class LojaCadastroBuilder {

    LojaCadastro lojaCadastro;

    private LojaCadastroBuilder(LojaCadastro lojaCadastro){
        this.lojaCadastro = lojaCadastro;
    }

    public static LojaCadastroBuilder with(){
        return new LojaCadastroBuilder(new LojaCadastro());
    }

    public LojaCadastroBuilder id(Integer id) {
        this.lojaCadastro.setId(id);
        return this;
    }

    public LojaCadastroBuilder nome(String nome){
        this.lojaCadastro.setNome(nome);
        return this;
    }

    public LojaCadastro build() {
        return this.lojaCadastro;
    }

}
