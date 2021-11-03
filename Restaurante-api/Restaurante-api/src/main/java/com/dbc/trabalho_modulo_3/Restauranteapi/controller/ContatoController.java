package com.dbc.trabalho_modulo_3.Restauranteapi.controller;

import com.dbc.trabalho_modulo_3.Restauranteapi.DTO.ContatoDTO;
import com.dbc.trabalho_modulo_3.Restauranteapi.entity.ContatoEntity;
import com.dbc.trabalho_modulo_3.Restauranteapi.exception.RegraDeNegocioException;
import com.dbc.trabalho_modulo_3.Restauranteapi.service.ContatoService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/contato")
@Validated
@RequiredArgsConstructor
public class ContatoController {
    private final ContatoService contatoService;
    @ApiOperation( value = "Criar contato ")
    @ApiResponses( value = {
            @ApiResponse(code =200, message = "Contato criado  sucesso"),
            @ApiResponse( code = 400, message = "contato não encontrado")
    })
    @PostMapping("/{idCliente}")
    public ContatoDTO create(@PathVariable("idCliente") Integer id, @RequestBody ContatoEntity contatoEntity) throws Exception {
        log.info("Contato criado");
        ContatoDTO contatonew = contatoService.create(id, contatoEntity);
        log.info("Contatao criado com sucesso");
        return contatonew;
    }
    @ApiOperation( value = "listar contatos ")
    @ApiResponses( value = {
            @ApiResponse(code =200, message = "Contatos listados  sucesso"),
            @ApiResponse( code = 400, message = "contatos não encontrados")
    })
    @GetMapping
    public List<ContatoDTO> list() {
        return contatoService.list();
    }
    @ApiOperation( value = "listar contato por id da pessoa")
    @ApiResponses( value = {
            @ApiResponse(code =200, message = "Contato listado com sucesso"),
            @ApiResponse( code = 400, message = "contato não encontrado")
    })
    @GetMapping("/byidCliente")
    public List<ContatoDTO> listByIdCliente(@PathVariable("idCliente") Integer id) throws RegraDeNegocioException {
        return contatoService.listPorIdCliente(id);
    }

    @ApiOperation( value = "Atualizare contato por id")
    @ApiResponses( value = {
            @ApiResponse(code =200, message = "Contato atualizado com sucesso"),
            @ApiResponse( code = 400, message = "contato não encontrado")
    })
    @PutMapping("/{idContato}")
    public ContatoDTO update(@PathVariable("idContato") Integer id,
                             @RequestBody ContatoEntity contatoEntityAtualizar) throws Exception {
        log.info("Contato Atualizado");
        ContatoDTO contatonew = contatoService.create(id, contatoEntityAtualizar);
        log.info("Contato atualizado com sucesso");
        return contatonew;
    }
    @ApiOperation( value = "Deletar contato por id")
    @ApiResponses( value = {
            @ApiResponse(code =200, message = "Contato deletado com sucesso"),
            @ApiResponse( code = 400, message = "contato não encontrado")
    })
    @DeleteMapping("/{idContato}")
    public void delete( @PathVariable("idContato") Integer id) throws Exception {
        log.info("contato será deletado");
        contatoService.delete(id);
        log.info("Contato deletado com sucesso");
    }
}


