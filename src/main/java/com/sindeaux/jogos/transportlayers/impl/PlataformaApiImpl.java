package com.sindeaux.jogos.transportlayers.impl;

import com.sindeaux.jogos.controller.openapi.api.PlataformaApi;
import com.sindeaux.jogos.controller.openapi.model.PlataformaCadastro;
import com.sindeaux.jogos.controller.openapi.model.ResponsePlataformas;
import com.sindeaux.jogos.interactors.PlataformaUseCase;
import com.sindeaux.jogos.transportlayers.mappers.PlataformaCadastroMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import java.util.stream.Collectors;

@Controller
public class PlataformaApiImpl implements PlataformaApi {

    private final PlataformaUseCase plataformaUseCase;

    public PlataformaApiImpl(PlataformaUseCase plataformaUseCase) {
        this.plataformaUseCase = plataformaUseCase;
    }

    public ResponseEntity<ResponsePlataformas> buscarPlataformas() {
        ResponsePlataformas responsePlataformas = new ResponsePlataformas();
        responsePlataformas.setListaPlataformas(
                plataformaUseCase.buscarPlataformas().stream()
                        .map(PlataformaCadastroMapper::platafomaTo)
                        .collect(Collectors.toList())
        );
        return ResponseEntity.status(HttpStatus.OK).body(responsePlataformas);
    }

    public ResponseEntity<PlataformaCadastro> editarPlataforma(Integer id, PlataformaCadastro plataformaCadastro) {
        PlataformaCadastro response = PlataformaCadastroMapper.platafomaTo(
                plataformaUseCase.editarPlataforma(id, PlataformaCadastroMapper.plataformaCadastroTo(plataformaCadastro)));
        return ResponseEntity.ok(response);
    }

    public ResponseEntity<Void> cadastroPlataforma(PlataformaCadastro plataformaCadastro) {
        plataformaUseCase.cadastrarPlataforma(PlataformaCadastroMapper.plataformaCadastroTo(plataformaCadastro));
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
