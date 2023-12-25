package com.sindeaux.jogos.transportlayers.impl;

import com.sindeaux.jogos.controller.openapi.api.PlataformaApi;
import com.sindeaux.jogos.controller.openapi.model.PlataformaCadastro;
import com.sindeaux.jogos.interactors.PlataformaUseCase;
import com.sindeaux.jogos.transportlayers.mappers.PlataformaCadastroMapper;
import io.swagger.v3.oas.annotations.Parameter;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

@Controller
public class PlataformaApiImpl implements PlataformaApi {

    private final PlataformaUseCase plataformaUseCase;

    public PlataformaApiImpl(PlataformaUseCase plataformaUseCase) {
        this.plataformaUseCase = plataformaUseCase;
    }

    public ResponseEntity<Void> cadastroPlataforma(PlataformaCadastro plataformaCadastro) {
        plataformaUseCase.cadastrarPlataforma(PlataformaCadastroMapper.plataformaCadastroTo(plataformaCadastro));
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
