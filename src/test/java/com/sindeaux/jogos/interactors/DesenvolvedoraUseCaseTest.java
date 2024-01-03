package com.sindeaux.jogos.interactors;

import com.sindeaux.jogos.builders.DesenvolvedoraCadastroBuilder;
import com.sindeaux.jogos.controller.openapi.model.DesenvolvedoraCadastro;
import com.sindeaux.jogos.entities.Desenvolvedora;
import com.sindeaux.jogos.repositories.DesenvolvedorRepository;
import com.sindeaux.jogos.transportlayers.mappers.DesenvolvedorCadastroMapper;
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
public class DesenvolvedoraUseCaseTest {

    @InjectMocks
    @Spy
    DesenvolvedorUseCase desenvolvedoraUseCase;

    @Mock
    DesenvolvedorRepository desenvolvedorRepository;


    @Test
    void deveCadastrarDesenvolvedora() {
        DesenvolvedoraCadastro desenvolvedora = DesenvolvedoraCadastroBuilder.with()
                .id(null)
                .nome("Insomniac")
                .build();
        Desenvolvedora loja = DesenvolvedorCadastroMapper.desenvolvedoraCadastroTo(desenvolvedora);
        Mockito.when(desenvolvedorRepository.save(Mockito.any(Desenvolvedora.class))).thenReturn(null);

        desenvolvedoraUseCase.cadastrarDesenvolvedor(loja);
        Mockito.verify(desenvolvedorRepository, Mockito.times(1)).save(loja);
    }

    @Test
    void deveBuscarDesenvolvedoras() {
        DesenvolvedoraCadastro desenvolvedoraCadastro = DesenvolvedoraCadastroBuilder.with()
                .id(null)
                .nome("Insomniac")
                .build();
        Desenvolvedora desenvolvedora = DesenvolvedorCadastroMapper.desenvolvedoraCadastroTo(desenvolvedoraCadastro);

        Mockito.when(desenvolvedorRepository.findAll()).thenReturn(Arrays.asList(desenvolvedora));

        List<Desenvolvedora> desenvolvedoras = desenvolvedoraUseCase.buscarDesenvolvedoras();
        Mockito.verify(desenvolvedorRepository, Mockito.times(1)).findAll();
        Assertions.assertNotNull(desenvolvedoras);
        Assertions.assertFalse(desenvolvedoras.isEmpty());
        Assertions.assertEquals(desenvolvedoraCadastro.getNome(),desenvolvedoras.get(0).getNome());
    }

    @Test
    void naoDeveEditarDevSemId() {
        Exception e = null;
        try{
            Mockito.when(desenvolvedorRepository.findById(Mockito.any(Integer.class))).thenReturn(Optional.empty());
            desenvolvedoraUseCase.editarDesenvolvedora(1, null);
        } catch (RuntimeException runtimeException){
            e = runtimeException;
        }
        Assertions.assertNotNull(e);
    }

    @Test
    void deveEditar(){
        DesenvolvedoraCadastro desenvolvedoraCadastro = DesenvolvedoraCadastroBuilder.with()
                .id(null)
                .nome("Insomniac")
                .build();
        Desenvolvedora desenvolvedora = DesenvolvedorCadastroMapper.desenvolvedoraCadastroTo(desenvolvedoraCadastro);


        desenvolvedoraCadastro.setNome("Epic Games");
        Desenvolvedora dev2 = DesenvolvedorCadastroMapper.desenvolvedoraCadastroTo(desenvolvedoraCadastro);

        Mockito.when(desenvolvedorRepository.findById(Mockito.any(Integer.class))).thenReturn(Optional.of(desenvolvedora));
        Mockito.when(desenvolvedorRepository.save(Mockito.any(Desenvolvedora.class))).thenReturn(desenvolvedora);
        Desenvolvedora devResp = desenvolvedoraUseCase.editarDesenvolvedora(1, dev2);

        Assertions.assertNotNull(devResp);
        Assertions.assertEquals(desenvolvedora.getId(), devResp.getId());
        Assertions.assertEquals(dev2.getNome(), devResp.getNome());
    }
}
