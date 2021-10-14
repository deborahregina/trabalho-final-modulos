package deborah.regs.dbc;

public class Cliente implements Impressao {
    private int id;
    private String cpf;
    private String nome;
    private Endereco [] enderecos;
    private Contato [] contatos;

    public Cliente(int id, String cpf, String nome) {
        this.id = id;
        this.cpf = cpf;
        this.nome = nome;

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

    public Endereco[] getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(Endereco[] enderecos) {
        this.enderecos = enderecos;
    }

    public Contato[] getContatos() {
        return contatos;
    }

    public void setContatos(Contato[] contatos) {
        this.contatos = contatos;
    }

    @Override
    public String imprimir() {
        String adresses = "";
        for (int i = 0; i < enderecos.length; i++ ) {
            if (enderecos[i] != null) {
                adresses = adresses.concat(" " + enderecos[i].imprimir() + "\n");
            }
        }
        String contacts = "";
        for (int j = 0; j < contatos.length; j++) {
            if (contatos[j] != null) {
                contacts = contacts.concat(" " + contatos[j].imprimir() + "\n");
            }
        }
        return "CPF: " + cpf + "\nNome: " + nome + "\nContatos: " + contacts + "\nEndereços: " + adresses;
    }

}
