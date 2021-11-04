package com.dbc.trabalho_modulo_3.Restauranteapi.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public abstract class Funcionario {
    private int idFuncionario;
    private String nome;
    private double salario;


    @Override
    public String toString() {
        return "Id do funcionário: " + idFuncionario+ " | Nome do funcionário: " + nome;
    }

}
