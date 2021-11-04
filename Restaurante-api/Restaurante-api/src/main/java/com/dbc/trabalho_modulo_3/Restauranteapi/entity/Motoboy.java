package com.dbc.trabalho_modulo_3.Restauranteapi.entity;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Motoboy extends Funcionario {
    private String placaMoto;


    @Override
    public String toString() {
        return super.toString()+ "Motoboy";
    }


}
