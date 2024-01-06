package com.sindeaux.jogos.transportlayers.impl;

import com.sindeaux.jogos.controller.openapi.model.LojaCadastro;
import com.sindeaux.jogos.controller.openapi.model.ResponseLojas;
import com.sindeaux.jogos.entities.Loja;
import com.sindeaux.jogos.fixture.LojaCadastroFixture;
import com.sindeaux.jogos.interactors.LojaUseCase;
import com.sindeaux.jogos.transportlayers.mappers.LojaCadastroMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;

@ExtendWith(MockitoExtension.class)
public class LojaApiImplTest {

    @Mock
    LojaUseCase lojaUseCase;

    @InjectMocks
    LojaApiImpl lojaApiImpl;

    @Test
    void deveCadastrarLoja(){
        LojaCadastro lojaNova = LojaCadastroFixture.getSample(1,"Steam");

        Mockito.doNothing()
                .when(lojaUseCase)
                .cadastrarLoja(Mockito.any(Loja.class));

        ResponseEntity responseCadastro =  lojaApiImpl.cadastroLoja(lojaNova);

        Assertions.assertNotNull(responseCadastro);
        Assertions.assertEquals(HttpStatus.CREATED.value(), responseCadastro.getStatusCode().value());
    }

    @Test
    void deveBuscarTodasLojas() {
        LojaCadastro lojaNova = LojaCadastroFixture.getSample(1,"Steam");

        Mockito.when(lojaUseCase.buscarLojass())
                .thenReturn(Arrays.asList(LojaCadastroMapper.lojaCadastroTo(lojaNova)));

        ResponseEntity<ResponseLojas> responseBusca =  lojaApiImpl.buscarLojas();

        Assertions.assertNotNull(responseBusca);
        Assertions.assertNotNull(responseBusca.getBody());
        Assertions.assertNotNull(responseBusca.getBody().getListaLojas());
        Assertions.assertEquals(HttpStatus.OK ,responseBusca.getStatusCode());
    }
}
