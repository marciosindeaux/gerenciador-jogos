package com.sindeaux.jogos.transportlayers.mappers;

import com.sindeaux.jogos.controller.openapi.model.PlataformaCadastro;
import com.sindeaux.jogos.entities.Plataforma;

public class PlataformaCadastroMapper {

    public static Plataforma plataformaCadastroTo(PlataformaCadastro plataformaCadastro){
        Plataforma plataforma = new Plataforma();
        plataforma.setId(plataformaCadastro.getId());
        plataforma.setNome(plataformaCadastro.getNome());
        return plataforma;
    }

    public static PlataformaCadastro platafomaTo(Plataforma plataforma){
        PlataformaCadastro plataformaCadastro = new PlataformaCadastro();
        plataformaCadastro.setId(plataforma.getId());
        plataformaCadastro.setNome(plataforma.getNome());
        return plataformaCadastro;
    }
}
