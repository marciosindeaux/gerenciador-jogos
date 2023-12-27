package com.sindeaux.jogos.interactors;

import com.sindeaux.jogos.entities.Desenvolvedora;
import com.sindeaux.jogos.repositories.DesenvolvedorRepository;
import org.springframework.stereotype.Service;

@Service
public class DesenvolvedorUseCase {

    private final DesenvolvedorRepository desenvolvedorRepository;

    public DesenvolvedorUseCase(DesenvolvedorRepository desenvolvedorRepository) {
        this.desenvolvedorRepository = desenvolvedorRepository;
    }

    public void cadastrarDesenvolvedor(Desenvolvedora desenvolvedora){
        desenvolvedorRepository.save(desenvolvedora);
    }
}
