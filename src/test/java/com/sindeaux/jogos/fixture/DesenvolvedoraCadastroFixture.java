package com.sindeaux.jogos.fixture;

import com.sindeaux.jogos.controller.openapi.model.DesenvolvedoraCadastro;
import com.sindeaux.jogos.controller.openapi.model.LojaCadastro;

public class DesenvolvedoraCadastroFixture {

    public static DesenvolvedoraCadastro getSample(Integer id, String name){
        return new DesenvolvedoraCadastro().idDesenvolvedora(id)
                .nome(name);
    }

    public static DesenvolvedoraCadastro getSample(String name) {
        return DesenvolvedoraCadastroFixture.getSample(null, name);
    }

    public static DesenvolvedoraCadastro getSample(Integer id) {
        return DesenvolvedoraCadastroFixture.getSample(id, null);
    }

}
