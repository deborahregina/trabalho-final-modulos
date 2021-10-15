package deborah.regs.dbc;

public enum TipoContato {
    CELULAR("Celular"),
    TELEFONEFIXO("Telefone Fixo");

    private String descricao;

    TipoContato(String descricao) {
        this.descricao = descricao;
    }

    TipoContato() {
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
