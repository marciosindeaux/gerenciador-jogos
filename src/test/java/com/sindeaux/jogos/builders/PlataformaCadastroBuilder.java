package com.sindeaux.jogos.builders;

import com.sindeaux.jogos.controller.openapi.model.PlataformaCadastro;

public class PlataformaCadastroBuilder {

    PlataformaCadastro plataformaCadastro;

    private PlataformaCadastroBuilder(PlataformaCadastro plataformaCadastro){
        this.plataformaCadastro = plataformaCadastro;
    }

    public static PlataformaCadastroBuilder with(){
        return new PlataformaCadastroBuilder(new PlataformaCadastro());
    }

    public PlataformaCadastroBuilder id(Integer id) {
        this.plataformaCadastro.setId(id);
        return this;
    }

    public PlataformaCadastroBuilder nome(String nome){
        this.plataformaCadastro.setNome(nome);
        return this;
    }

    public PlataformaCadastro build() {
        return this.plataformaCadastro;
    }

}
