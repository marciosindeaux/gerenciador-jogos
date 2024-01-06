package com.sindeaux.jogos.fixture;

import com.sindeaux.jogos.controller.openapi.model.LojaCadastro;
import com.sindeaux.jogos.entities.Loja;

public class LojaFixture {
    public static Loja getSample(Integer id, String name){
        Loja loja = new Loja();
        loja.setNome(name);
        loja.setId(id);
        return  loja;
    }

    public static Loja getSample(String name) {
        return LojaFixture.getSample(null, name);
    }

    public static Loja getSample(Integer id) {
        return LojaFixture.getSample(id, null);
    }



}
