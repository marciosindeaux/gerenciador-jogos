package com.sindeaux.jogos.transportlayers.impl;

import com.sindeaux.jogos.controller.openapi.api.DesenvolvedorApi;
import com.sindeaux.jogos.controller.openapi.model.DesenvolvedoraCadastro;
import com.sindeaux.jogos.interactors.DesenvolvedorUseCase;
import com.sindeaux.jogos.transportlayers.mappers.DesenvolvedorCadastroMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

@Controller
public class DesenvolvedoraApiImpl implements DesenvolvedorApi {

    private  final DesenvolvedorUseCase desenvolvedorUseCase;

    public DesenvolvedoraApiImpl(DesenvolvedorUseCase desenvolvedorUseCase) {
        this.desenvolvedorUseCase = desenvolvedorUseCase;
    }

    public ResponseEntity<Void> cadastroDesenvolvedor(DesenvolvedoraCadastro desenvolvedoraCadastro) {
        desenvolvedorUseCase.cadastrarDesenvolvedor(DesenvolvedorCadastroMapper.desenvolvedoraCadastroTo(desenvolvedoraCadastro));
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

}
