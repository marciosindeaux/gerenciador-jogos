package com.sindeaux.jogos.transportlayers.impl;

import com.sindeaux.jogos.builders.PlataformaCadastroBuilder;
import com.sindeaux.jogos.controller.openapi.model.PlataformaCadastro;
import com.sindeaux.jogos.controller.openapi.model.ResponsePlataformas;
import com.sindeaux.jogos.entities.Plataforma;
import com.sindeaux.jogos.interactors.PlataformaUseCase;
import com.sindeaux.jogos.transportlayers.mappers.PlataformaCadastroMapper;
import jakarta.inject.Inject;
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
public class PlataformApiImplTest {

    @Mock
    PlataformaUseCase plataformaUseCase;

    @InjectMocks
    PlataformaApiImpl plataformaApi;

    @Test
    void deveCadastrarPlataforma(){
        PlataformaCadastro plataformaNova = PlataformaCadastroBuilder.with()
                .id(1)
                .nome("Steam")
                .build();

        Mockito.doNothing()
                .when(plataformaUseCase)
                .cadastrarPlataforma(Mockito.any(Plataforma.class));

        ResponseEntity responseCadastro =  plataformaApi.cadastroPlataforma(plataformaNova);

        Assertions.assertNotNull(responseCadastro);
        Assertions.assertEquals(HttpStatus.CREATED.value(), responseCadastro.getStatusCode().value());
    }

    @Test
    void deveBuscarTodasPlataformas() {
        PlataformaCadastro plataformaNova = PlataformaCadastroBuilder.with()
                .id(1)
                .nome("Steam")
                .build();

        Mockito.when(plataformaUseCase.buscarPlataformas())
                .thenReturn(Arrays.asList(PlataformaCadastroMapper.plataformaCadastroTo(plataformaNova)));

        ResponseEntity<ResponsePlataformas> responseBusca =  plataformaApi.buscarPlataformas();

        Assertions.assertNotNull(responseBusca);
        Assertions.assertNotNull(responseBusca.getBody());
        Assertions.assertNotNull(responseBusca.getBody().getListaPlataformas());
        Assertions.assertEquals(HttpStatus.OK ,responseBusca.getStatusCode());
    }
}
