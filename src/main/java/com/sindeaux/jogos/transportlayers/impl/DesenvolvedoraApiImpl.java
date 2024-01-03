package com.sindeaux.jogos.transportlayers.impl;

import com.sindeaux.jogos.controller.openapi.api.DesenvolvedorApi;
import com.sindeaux.jogos.controller.openapi.model.DesenvolvedoraCadastro;
import com.sindeaux.jogos.controller.openapi.model.ResponseDevs;
import com.sindeaux.jogos.interactors.DesenvolvedorUseCase;
import com.sindeaux.jogos.transportlayers.mappers.DesenvolvedorCadastroMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import java.util.stream.Collectors;

@Controller
public class DesenvolvedoraApiImpl implements DesenvolvedorApi {

    private  final DesenvolvedorUseCase desenvolvedorUseCase;

    public DesenvolvedoraApiImpl(DesenvolvedorUseCase desenvolvedorUseCase) {
        this.desenvolvedorUseCase = desenvolvedorUseCase;
    }

    public ResponseEntity<ResponseDevs> buscarDevs() {
        ResponseDevs responseDevs = new ResponseDevs();
        responseDevs.setListaDevs(
                desenvolvedorUseCase.buscarDesenvolvedoras().stream()
                        .map(DesenvolvedorCadastroMapper::desenvolvedoraTo)
                        .collect(Collectors.toList())
        );
        return ResponseEntity.ok(responseDevs);
    }

    public ResponseEntity<Void> cadastroDesenvolvedor(DesenvolvedoraCadastro desenvolvedoraCadastro) {
        desenvolvedorUseCase.cadastrarDesenvolvedor(DesenvolvedorCadastroMapper.desenvolvedoraCadastroTo(desenvolvedoraCadastro));
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    public ResponseEntity<DesenvolvedoraCadastro> editarDev( Integer id,DesenvolvedoraCadastro desenvolvedoraCadastro) {
        DesenvolvedoraCadastro response = DesenvolvedorCadastroMapper.desenvolvedoraTo(
                desenvolvedorUseCase.editarDesenvolvedora(id, DesenvolvedorCadastroMapper.desenvolvedoraCadastroTo(desenvolvedoraCadastro)));
        return ResponseEntity.ok(response);
    }

}
