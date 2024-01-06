package com.sindeaux.jogos.fixture;

import com.sindeaux.jogos.controller.openapi.model.DesenvolvedoraCadastro;
import com.sindeaux.jogos.entities.Desenvolvedora;

public class DesenvolvedoraFixture {

    public static Desenvolvedora getSample(Integer id, String name){
        Desenvolvedora desenvolvedora = new Desenvolvedora();
        desenvolvedora.setNome(name);
        desenvolvedora.setId(id);
        return desenvolvedora;
    }

    public static Desenvolvedora getSample(String name) {
        return DesenvolvedoraFixture.getSample(null, name);
    }

    public static Desenvolvedora getSample(Integer id) {
        return DesenvolvedoraFixture.getSample(id, null);
    }
}
