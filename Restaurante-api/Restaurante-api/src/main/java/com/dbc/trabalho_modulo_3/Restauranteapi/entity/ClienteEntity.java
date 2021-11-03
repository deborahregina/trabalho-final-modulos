package com.dbc.trabalho_modulo_3.Restauranteapi.entity;

import lombok.*;

import java.util.ArrayList;
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ClienteEntity {

    private Integer idCliente;
    private String cpf;
    private String nome;

}
