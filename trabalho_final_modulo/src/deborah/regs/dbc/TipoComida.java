package deborah.regs.dbc;

public enum TipoComida {

    COMIDATAILANDESA("Curry Massaman"),
    COMIDAMEXICANA("Guacamole."),
    COMIDAJAPONESA("Sushi");

    private String descricao;


    TipoComida(String TipoDeComidas) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
