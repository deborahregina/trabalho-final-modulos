package deborah.regs.dbc.model;

import java.util.ArrayList;


public class Cliente implements Impressao {
    private int id;
    private String cpf;
    private String nome;
    private ArrayList<Endereco> enderecos = new ArrayList<>();
    private ArrayList<Contato> contatos = new ArrayList<>();


    public Cliente(int id, String cpf, String nome, ArrayList<Endereco> enderecos, ArrayList<Contato> contatos) {
        this.id = id;
        this.cpf = cpf;
        this.nome = nome;
        this.enderecos = enderecos;
        this.contatos = contatos;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
    public void imprimir() {
        String adresses = "";
        for (int i = 0; i < enderecos.size(); i++ ) {
            if (enderecos.get(i) != null && !enderecos.isEmpty()) {
                adresses = adresses.concat(" " + enderecos.get(i).imprimir() + "\n");
            }
        }
        String contacts = "";
        for (int j = 0; j < contatos.size(); j++) {
            if (contatos.get(j) != null && !enderecos.isEmpty()) {
                contacts = contacts.concat(" " + contatos.get(j).imprimir() + "\n");
            }
        }
        System.out.println("ID do cliente: " + id + "\nCPF do cliente: " + cpf + "\nNome: " + nome + "\n** Contatos Cadastrados **: ");
        for (Contato contato : contatos) {
            System.out.println(contato.imprimir());
        }
        System.out.println("** Endereços Cadastrados ** ");
        for(Endereco endereco : enderecos) {
            System.out.println(endereco.imprimir());
        }
        return "";
    }

}
