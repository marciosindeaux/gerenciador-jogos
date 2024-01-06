package com.sindeaux.jogos.fixture;

import com.sindeaux.jogos.controller.openapi.model.LojaCadastro;

public class LojaCadastroFixture {

    public static LojaCadastro getSample(Integer id, String name){
        return new LojaCadastro().id(id)
                .nome(name);
    }

    public static LojaCadastro getSample(String name) {
        return LojaCadastroFixture.getSample(null, name);
    }

    public static LojaCadastro getSample(Integer id) {
        return LojaCadastroFixture.getSample(id, null);
    }


}
