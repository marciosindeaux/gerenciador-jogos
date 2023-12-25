package com.sindeaux.jogos.interactors;

import com.sindeaux.jogos.builders.PlataformaCadastroBuilder;
import com.sindeaux.jogos.controller.openapi.model.PlataformaCadastro;
import com.sindeaux.jogos.entities.Plataforma;
import com.sindeaux.jogos.repositories.PlataformaRepository;
import com.sindeaux.jogos.transportlayers.mappers.PlataformaCadastroMapper;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class PlataformaUseCaseTest {

    @InjectMocks
    @Spy
    PlataformaUseCase plataformaUseCase;

    @Mock
    PlataformaRepository plataformaRepository;


    @Test
    void deveCadastrarPlataformaDeJogo() {
        PlataformaCadastro plataformaNova = PlataformaCadastroBuilder.with()
                .id(null)
                .nome("Steam")
                .build();
        Plataforma plataforma = PlataformaCadastroMapper.plataformaCadastroTo(plataformaNova);
        Mockito.when(plataformaRepository.save(Mockito.any(Plataforma.class))).thenReturn(null);

        plataformaUseCase.cadastrarPlataforma(plataforma);
        Mockito.verify(plataformaRepository, Mockito.times(1)).save(plataforma);
    }
}
