package com.dbc.trabalho_modulo_3.Restauranteapi.DTO;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;

public class ClienteDTO extends ClienteCreateDTO{
    @NotNull
    @ApiModelProperty(value = "id Cliente")
    private Integer idCliente;
}
