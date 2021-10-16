package deborah.regs.dbc;

public enum TipoProduto {

    COMIDATAILANDESA("Curry Massaman"),
    COMIDAMEXICANA("Guacamole."),
    COMIDAJAPONESA("Sushi"),
    REFRIGERANTE( "coca cola"),
    SUCONATURAL("Dellvale"),
    CERVEJA("Heineken");



    private String descricao;


    TipoProduto(String TipoDeComidas) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
