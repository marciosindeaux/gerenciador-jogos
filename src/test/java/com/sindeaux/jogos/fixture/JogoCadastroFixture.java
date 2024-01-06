package com.sindeaux.jogos.fixture;

import com.sindeaux.jogos.controller.openapi.model.JogoCadastro;

import java.time.LocalDate;
import java.time.Month;

public class JogoCadastroFixture {

    public static JogoCadastro getSample(){
         return new JogoCadastro()
                 .id(1)
                 .nome("Quake 2")
                 .idLoja(1)
                 .dataLancamento(LocalDate.of(1997, Month.DECEMBER, 9))
                 .idDesenvolvedora(1)
                 .sinopse("Quake II é um jogo de computador de tiro em primeira pessoa desenvolvido pela id Software, distribuído pela Activision e lançado em 9 de dezembro de 1997. Não se trata de uma sequência de Quake");
    }
}
