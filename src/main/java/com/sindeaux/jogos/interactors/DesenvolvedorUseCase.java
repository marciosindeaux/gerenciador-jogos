package com.sindeaux.jogos.interactors;

import com.sindeaux.jogos.entities.Desenvolvedora;
import com.sindeaux.jogos.repositories.DesenvolvedorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DesenvolvedorUseCase {

    private final DesenvolvedorRepository desenvolvedorRepository;

    public DesenvolvedorUseCase(DesenvolvedorRepository desenvolvedorRepository) {
        this.desenvolvedorRepository = desenvolvedorRepository;
    }

    public List<Desenvolvedora> buscarDesenvolvedoras(){
        return desenvolvedorRepository.findAll();
    }

    public Desenvolvedora editarDesenvolvedora(Integer id , Desenvolvedora dados){
        Desenvolvedora desenvolvedora = desenvolvedorRepository.findById(id).orElseThrow(() -> new RuntimeException("Loja não encontrada no sistema"));
        desenvolvedora.setNome(dados.getNome());
        return desenvolvedorRepository.save(desenvolvedora);
    }

    public void cadastrarDesenvolvedor(Desenvolvedora desenvolvedora){
        desenvolvedorRepository.save(desenvolvedora);
    }
}
