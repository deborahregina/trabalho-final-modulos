package deborah.regs.dbc;

public enum TipoProduto {

    COMIDA_TAILANDESA("Curry Massaman"),
    COMIDA_MEXICANA("Guacamole."),
    COMIDA_JAPONESA("Sushi"),
    REFRIGERANTE( "coca cola"),
    SUCO_NATURAL("Dellvale"),
    CERVEJA("Heineken");



    private String descricao;


    TipoProduto(String TipoDeComidas) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
