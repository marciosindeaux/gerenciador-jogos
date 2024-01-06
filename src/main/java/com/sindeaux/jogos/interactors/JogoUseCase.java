package com.sindeaux.jogos.interactors;

import com.sindeaux.jogos.entities.Desenvolvedora;
import com.sindeaux.jogos.entities.Jogo;
import com.sindeaux.jogos.entities.Loja;
import com.sindeaux.jogos.repositories.JogoRepository;
import org.springframework.stereotype.Service;

@Service
public class JogoUseCase {

    private final JogoRepository jogoRepository;
    private final LojaUseCase lojaUseCase;
    private final DesenvolvedorUseCase desenvolvedorUseCase;

    public JogoUseCase(JogoRepository jogoRepository, LojaUseCase lojaUseCase, DesenvolvedorUseCase desenvolvedorUseCase){
        this.jogoRepository = jogoRepository;
        this.lojaUseCase = lojaUseCase;
        this.desenvolvedorUseCase = desenvolvedorUseCase;
    }


    public void cadastrarNovoJogo(Jogo jogo, Integer idDev, Integer idLoja) {
        Desenvolvedora desenvolvedora = desenvolvedorUseCase.buscarPorId(idDev);
        Loja loja = lojaUseCase.buscarPorId(idLoja);

        jogo.setDesenvolvedora(desenvolvedora);
        jogo.setLoja(loja);

        jogoRepository.save(jogo);
    }




}
