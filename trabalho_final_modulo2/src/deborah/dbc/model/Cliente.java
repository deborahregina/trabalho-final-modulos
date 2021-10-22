package deborah.dbc.model;

import java.util.ArrayList;

public class Cliente {
    private int idCliente;
    private String cpf;
    private String nome;
    private ArrayList<Endereco> enderecos = new ArrayList<>();
    private ArrayList<Contato> contatos = new ArrayList<>();

    public Cliente() {
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

    public ArrayList<Endereco> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(ArrayList<Endereco> enderecos) {
        this.enderecos = enderecos;
    }

    public ArrayList<Contato> getContatos() {
        return contatos;
    }

    public void setContatos(ArrayList<Contato> contatos) {
        this.contatos = contatos;
    }

    @Override
    public String toString() {
        return "ID do cliente: " + idCliente + "\nNome do cliente: " + nome + "\nCPF do cliente: " + cpf + "Endereços cadastrados: " + enderecos.toString() + "Contatos Cadastrados: " + contatos.toString();
    }
}
