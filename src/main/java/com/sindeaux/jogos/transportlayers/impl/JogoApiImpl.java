package com.sindeaux.jogos.transportlayers.impl;

import com.sindeaux.jogos.controller.openapi.api.ApiUtil;
import com.sindeaux.jogos.controller.openapi.api.JogoApi;
import com.sindeaux.jogos.controller.openapi.model.JogoCadastro;
import com.sindeaux.jogos.controller.openapi.model.ResponseJogos;
import io.swagger.v3.oas.annotations.Parameter;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class JogoApiImpl implements JogoApi {

    public ResponseEntity<ResponseJogos> buscarJogos() {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Void> cadastrarJogo(JogoCadastro jogoCadastro) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }
}
