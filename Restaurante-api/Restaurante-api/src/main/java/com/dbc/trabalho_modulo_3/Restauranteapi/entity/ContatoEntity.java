package com.dbc.trabalho_modulo_3.Restauranteapi.entity;

import io.swagger.models.auth.In;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
    public class ContatoEntity {
        private Integer IdCliente;
        private Integer idContato;
        private String descricao;
        private String telefone;
        private TipoContato tipo;
    }


