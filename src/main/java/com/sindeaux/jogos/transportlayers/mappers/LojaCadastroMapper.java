package com.sindeaux.jogos.transportlayers.mappers;

import com.sindeaux.jogos.controller.openapi.model.LojaCadastro;
import com.sindeaux.jogos.entities.Loja;

public class LojaCadastroMapper {

    public static Loja lojaCadastroTo(LojaCadastro lojaCadastro){
        Loja loja = new Loja();
        loja.setId(lojaCadastro.getId());
        loja.setNome(lojaCadastro.getNome());
        return loja;
    }

    public static LojaCadastro lojaTo(Loja loja){
        LojaCadastro lojaCadastro = new LojaCadastro();
        lojaCadastro.setId(loja.getId());
        lojaCadastro.setNome(loja.getNome());
        return lojaCadastro;
    }
}
