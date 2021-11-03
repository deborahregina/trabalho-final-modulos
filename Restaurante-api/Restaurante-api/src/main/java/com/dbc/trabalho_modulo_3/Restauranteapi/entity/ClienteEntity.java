package com.dbc.trabalho_modulo_3.Restauranteapi.entity;

import java.util.ArrayList;

public class ClienteEntity {
    private int idCliente;
    private String cpf;
    private String nome;
    private ArrayList<EnderecoEntity> enderecoEntities = new ArrayList<>();
    private ArrayList<ContatoEntity> contatoEntities = new ArrayList<>();

    public ClienteEntity() {
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public ArrayList<EnderecoEntity> getEnderecos() {
        return enderecoEntities;
    }

    public void setEnderecos(ArrayList<EnderecoEntity> enderecoEntities) {
        this.enderecoEntities = enderecoEntities;
    }

    public ArrayList<ContatoEntity> getContatos() {
        return contatoEntities;
    }

    public void setContatos(ArrayList<ContatoEntity> contatoEntities) {
        this.contatoEntities = contatoEntities;
    }

    @Override
    public String toString() {
        return "ID do cliente: " + idCliente + "\nNome do cliente: " + nome + "\nCPF do cliente: " + cpf + "\n";
    }
}
