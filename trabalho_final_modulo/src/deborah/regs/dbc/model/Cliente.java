package deborah.regs.dbc.model;

import java.util.ArrayList;


public class Cliente implements Impressao {

    Integer idCliente;
    private String cpf;
    private String nome;
    private ArrayList<Endereco> enderecos;
    private ArrayList<Contato> contatos;

    public Cliente(Integer idCliente, String cpf, String nome) {
        this.idCliente = idCliente;
        this.cpf = cpf;
        this.nome = nome;
    }

    public Cliente() {

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

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
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

    @Override
    public String imprimir() {
        return "";
    }

}
