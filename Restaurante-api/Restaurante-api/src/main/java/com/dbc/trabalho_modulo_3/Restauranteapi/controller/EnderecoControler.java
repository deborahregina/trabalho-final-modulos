package com.dbc.trabalho_modulo_3.Restauranteapi.controller;


import com.dbc.trabalho_modulo_3.Restauranteapi.DTO.EnderecoDTO;
import com.dbc.trabalho_modulo_3.Restauranteapi.service.EnderecoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/endereco")
@Validated
@Slf4j
@RequiredArgsConstructor

public class EnderecoControler {

    private final EnderecoService enderecoService;
    public List<EnderecoDTO> list() {
        return enderecoService.list();
    }
}
