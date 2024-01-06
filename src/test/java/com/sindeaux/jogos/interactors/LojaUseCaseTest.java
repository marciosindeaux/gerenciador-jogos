package com.sindeaux.jogos.interactors;

import com.sindeaux.jogos.controller.openapi.model.LojaCadastro;
import com.sindeaux.jogos.entities.Loja;
import com.sindeaux.jogos.fixture.LojaCadastroFixture;
import com.sindeaux.jogos.fixture.LojaFixture;
import com.sindeaux.jogos.repositories.LojaRepository;
import com.sindeaux.jogos.transportlayers.mappers.LojaCadastroMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class LojaUseCaseTest {

    @InjectMocks
    @Spy
    LojaUseCase lojaUseCase;

    @Mock
    LojaRepository lojaRepository;


    @Test
    void deveCadastrarLojaDeJogo() {
        Loja loja = LojaFixture.getSample("Steam");
        Mockito.when(lojaRepository.save(Mockito.any(Loja.class))).thenReturn(null);

        lojaUseCase.cadastrarLoja(loja);
        Mockito.verify(lojaRepository, Mockito.times(1)).save(loja);
    }

    @Test
    void deveBuscarLojas() {
        Loja loja = LojaFixture.getSample("Steam");

        Mockito.when(lojaRepository.findAll()).thenReturn(Arrays.asList(loja));

        List<Loja> lojas = lojaUseCase.buscarLojass();
        Mockito.verify(lojaRepository, Mockito.times(1)).findAll();
        Assertions.assertNotNull(lojas);
        Assertions.assertFalse(lojas.isEmpty());
        Assertions.assertEquals(loja.getNome(),lojas.get(0).getNome());
    }

    @Test
    void naoDeveEditarLojaSemId() {
        Exception e = null;
        try{
            Mockito.when(lojaRepository.findById(Mockito.any(Integer.class))).thenReturn(Optional.empty());
            lojaUseCase.editarLoja(1, null);
        } catch (RuntimeException runtimeException){
            e = runtimeException;
        }
        Assertions.assertNotNull(e);
    }

    @Test
    void deveEditar(){
        Loja loja = LojaFixture.getSample(1,"Steam");
        Loja loja2 = LojaFixture.getSample("Epic Games");

        Mockito.when(lojaRepository.findById(Mockito.any(Integer.class))).thenReturn(Optional.of(loja));
        Mockito.when(lojaRepository.save(Mockito.any(Loja.class))).thenReturn(loja);
        Loja lojaResp = lojaUseCase.editarLoja(1, loja2);

        Assertions.assertNotNull(lojaResp);
        Assertions.assertEquals(loja.getId(), lojaResp.getId());
        Assertions.assertEquals(loja2.getNome(), lojaResp.getNome());

    }
}
