package com.sindeaux.jogos.interactors;

import com.sindeaux.jogos.entities.Loja;
import com.sindeaux.jogos.repositories.LojaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LojaUseCase {

    private final LojaRepository lojaRepository;

    public LojaUseCase(LojaRepository lojaRepository) {
        this.lojaRepository = lojaRepository;
    }

    public void cadastrarLoja(Loja loja) {
        lojaRepository.save(loja);
    }

    public List<Loja> buscarLojass() {
        return lojaRepository.findAll();
    }

    public Loja editarLoja(Integer id, Loja dados ){
        Loja loja = this.buscarPorId(id);
        loja.setNome(dados.getNome());
        return lojaRepository.save(loja);
    }

    public Loja buscarPorId(Integer id) {
        return lojaRepository.findById(id).orElseThrow(() -> new RuntimeException("Loja não encontrada no sistema"));
    }
}
