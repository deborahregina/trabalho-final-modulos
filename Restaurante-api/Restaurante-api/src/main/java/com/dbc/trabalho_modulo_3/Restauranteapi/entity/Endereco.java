package com.dbc.trabalho_modulo_3.Restauranteapi.entity;

public class Endereco {
    private deborah.dbc.model.Cliente cliente;
    private Integer idEndereco;
    private deborah.dbc.model.TipoEndereco tipo;
    private String logradouro;
    private int numero;
    private String bairro;
    private String cep;

    public Endereco() {
    }

    public Endereco(Integer idEndereco, deborah.dbc.model.TipoEndereco tipo, String logradouro, int numero, String bairro, String cep) {
        this.idEndereco = idEndereco;
        this.tipo = tipo;
        this.logradouro = logradouro;
        this.numero = numero;
        this.bairro = bairro;
        this.cep = cep;
    }

    public deborah.dbc.model.Cliente getCliente() {
        return cliente;
    }

    public void setCliente(deborah.dbc.model.Cliente cliente) {
        this.cliente = cliente;
    }

    public Integer getIdEndereco() {
        return idEndereco;
    }

    public void setIdEndereco(Integer idEndereco) {
        this.idEndereco = idEndereco;
    }

    public deborah.dbc.model.TipoEndereco getTipo() {
        return tipo;
    }

    public void setTipo(deborah.dbc.model.TipoEndereco tipo) {
        this.tipo = tipo;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    @Override
    public String toString () {
        String tipoEndereco = "";
        if (tipo.getTipo() == 1) {
            tipoEndereco = "Residencial";
        }
        if (tipo.getTipo() == 2) {
            tipoEndereco = "Comercial";
        }
        return "Id do endereço: "+idEndereco + "\nId do cliente: "+ cliente.getIdCliente() +"\nNome do cliente: "+ cliente.getNome() +"\nEndereço: " + logradouro + "\nNúmero: " +  numero + "\nBairro: " + bairro + "\nCEP: " + cep + "\nTipo de endereço: " + tipoEndereco +  "\n";
    }
}
