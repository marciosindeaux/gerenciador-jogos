package com.sindeaux.jogos.transportlayers.impl;

import com.sindeaux.jogos.controller.openapi.api.LojaApi;
import com.sindeaux.jogos.controller.openapi.model.LojaCadastro;
import com.sindeaux.jogos.controller.openapi.model.ResponseLojas;
import com.sindeaux.jogos.interactors.LojaUseCase;
import com.sindeaux.jogos.transportlayers.mappers.LojaCadastroMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import java.util.stream.Collectors;

@Controller
public class LojaApiImpl implements LojaApi {

    private final LojaUseCase lojaUseCase;

    public LojaApiImpl(LojaUseCase lojaUseCase) {
        this.lojaUseCase = lojaUseCase;
    }

    public ResponseEntity<ResponseLojas> buscarLojas() {
        ResponseLojas responseLojas = new ResponseLojas();
        responseLojas.setListaLojas(
                lojaUseCase.buscarLojass().stream()
                        .map(LojaCadastroMapper::lojaTo)
                        .collect(Collectors.toList())
        );
        return ResponseEntity.status(HttpStatus.OK).body(responseLojas);
    }

    public ResponseEntity<LojaCadastro> editarLoja(Integer id, LojaCadastro lojaCadastro) {
        LojaCadastro response = LojaCadastroMapper.lojaTo(
                lojaUseCase.editarLoja(id, LojaCadastroMapper.lojaCadastroTo(lojaCadastro)));
        return ResponseEntity.ok(response);
    }

    public ResponseEntity<Void> cadastroLoja(LojaCadastro lojaCadastro) {
        lojaUseCase.cadastrarLoja(LojaCadastroMapper.lojaCadastroTo(lojaCadastro));
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
