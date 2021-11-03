package com.dbc.trabalho_modulo_3.Restauranteapi.entity;

public class Atendente extends deborah.dbc.model.Funcionario {


    public Atendente(int id, String nome, double salario) {
        super(id, nome, salario);

    }


    @Override
    public String toString() {
        return super.toString() + "\nFunção: Atendente";
    }



}
