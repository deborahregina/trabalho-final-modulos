package deborah.regs.dbc.model;

public class Contato implements Impressao {

    private String descricao;
    private String telefone;
    private TipoContato tipo;

    public Contato(String descricao, String telefone, TipoContato tipo) {
        this.descricao = descricao;
        this.telefone = telefone;
        this.tipo = tipo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public TipoContato getTipo() {
        return tipo;
    }

    public void setTipo(TipoContato tipo) {
        this.tipo = tipo;
    }

    @Override
    public String imprimir () {
        return "\nDescrição do contato: " + descricao + "\nTelefone: " +  telefone + "\nTipo: " + tipo.getDescricao();
    }
}

