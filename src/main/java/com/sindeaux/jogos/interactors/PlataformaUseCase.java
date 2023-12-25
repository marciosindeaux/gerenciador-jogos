package com.sindeaux.jogos.interactors;

import com.sindeaux.jogos.controller.openapi.model.PlataformaCadastro;
import com.sindeaux.jogos.entities.Plataforma;
import com.sindeaux.jogos.repositories.PlataformaRepository;
import org.springframework.stereotype.Service;

import java.io.Serial;

@Service
public class PlataformaUseCase {

    private final PlataformaRepository plataformaRepository;

    public PlataformaUseCase(PlataformaRepository plataformaRepository) {
        this.plataformaRepository = plataformaRepository;
    }

    public void cadastrarPlataforma(Plataforma plataformaCadastro) {
        plataformaRepository.save(plataformaCadastro);
    }
}
