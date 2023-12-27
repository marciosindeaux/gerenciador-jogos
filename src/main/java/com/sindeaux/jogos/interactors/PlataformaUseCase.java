package com.sindeaux.jogos.interactors;

import com.sindeaux.jogos.entities.Plataforma;
import com.sindeaux.jogos.repositories.PlataformaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlataformaUseCase {

    private final PlataformaRepository plataformaRepository;

    public PlataformaUseCase(PlataformaRepository plataformaRepository) {
        this.plataformaRepository = plataformaRepository;
    }

    public void cadastrarPlataforma(Plataforma plataformaCadastro) {
        plataformaRepository.save(plataformaCadastro);
    }

    public List<Plataforma> buscarPlataformas() {
        return plataformaRepository.findAll();
    }

    public Plataforma editarPlataforma(Integer id, Plataforma dados ){
        Plataforma plataforma = plataformaRepository.findById(id).orElseThrow(() -> new RuntimeException("Plataforma não encontrada no sistema"));
        plataforma.setNome(dados.getNome());
        return plataformaRepository.save(plataforma);
    }
}
