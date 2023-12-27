package com.sindeaux.jogos.transportlayers.mappers;

import com.sindeaux.jogos.controller.openapi.model.DesenvolvedoraCadastro;
import com.sindeaux.jogos.entities.Desenvolvedora;

public class DesenvolvedorCadastroMapper {

    public static Desenvolvedora desenvolvedoraCadastroTo(DesenvolvedoraCadastro desenvolvedoraCadastro) {
        Desenvolvedora desenvolvedora = new Desenvolvedora();
        desenvolvedora.setId(desenvolvedoraCadastro.getIdDesenvolvedora());
        desenvolvedora.setNome( desenvolvedoraCadastro.getNome());
        return desenvolvedora;
    }
}
