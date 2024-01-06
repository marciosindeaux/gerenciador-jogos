package com.sindeaux.jogos.fixture;

import com.sindeaux.jogos.controller.openapi.model.JogoCadastro;
import com.sindeaux.jogos.entities.Desenvolvedora;
import com.sindeaux.jogos.entities.Jogo;
import com.sindeaux.jogos.entities.Loja;

import java.time.LocalDate;
import java.time.Month;

public class JogoFixture {

    public static Jogo getSample(Integer id, String nome, LocalDate dataLancamentyo, String sinopse, Loja loja, Desenvolvedora dev,
                                 LocalDate dataConclusao, Double nota, String opiniao) {
        Jogo jogo = new Jogo();
        jogo.setId(id);
        jogo.setNome(nome);
        jogo.setDataLancamento(dataLancamentyo);
        jogo.setSinopse(sinopse);
        jogo.setLoja(loja);
        jogo.setDesenvolvedora(dev);
        jogo.setDataConclusao(dataConclusao);
        jogo.setNota(nota);
        jogo.setOpiniao(opiniao);
        return jogo;
    }

    public static Jogo getSampleCadastro() {
        return getSample(
                1,
                "Quake 2",
                LocalDate.of(1997, Month.DECEMBER, 9),
                "Sinopse Quake 2",
                null,
                null,
                null,
                null,
                null
        );
    }

}
