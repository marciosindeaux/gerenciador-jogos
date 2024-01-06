package com.sindeaux.jogos.interactors;

import com.sindeaux.jogos.entities.Desenvolvedora;
import com.sindeaux.jogos.entities.Jogo;
import com.sindeaux.jogos.entities.Loja;
import com.sindeaux.jogos.fixture.DesenvolvedoraFixture;
import com.sindeaux.jogos.fixture.JogoFixture;
import com.sindeaux.jogos.fixture.LojaFixture;
import com.sindeaux.jogos.repositories.JogoRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class JogoUseCaseTest {

    @InjectMocks
    @Spy
    public JogoUseCase jogoUseCase;
    @Mock
    public JogoRepository jogoRepository;
    @Mock
    public LojaUseCase lojaUseCase;
    @Mock
    public DesenvolvedorUseCase desenvolvedorUseCase;

    @Test
    void deveInserirJogoNovo(){
        Desenvolvedora desenvolvedora = DesenvolvedoraFixture.getSample(1, "Playstatio PPL");
        Loja loja = LojaFixture.getSample(1, "Steam");
        Jogo jogo = JogoFixture.getSampleCadastro();

        Mockito.when(desenvolvedorUseCase.buscarPorId(Mockito.anyInt())).thenReturn(desenvolvedora);
        Mockito.when(lojaUseCase.buscarPorId(Mockito.anyInt())).thenReturn(loja);

        jogoUseCase.cadastrarNovoJogo(jogo, desenvolvedora.getId(), loja.getId());

        Mockito.verify(jogoRepository, Mockito.times(1)).save(Mockito.any(Jogo.class));

    }
}
