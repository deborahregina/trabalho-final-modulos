package deborah.regs.dbc;

public enum TipoProduto {

    COMIDA_TAILANDESA(1,"Curry Massaman"),
    COMIDA_MEXICANA(2,"Guacamole"),
    COMIDA_JAPONESA(3,"Sushi"),
    REFRIGERANTE( 4,"coca cola"),
    SUCO_NATURAL(5,"Dellvale"),
    CERVEJA(6,"Heineken");


    public static String imprimeCardapio() {

        return "Produtos: " +"\nCOMIDAS: " + "\n1- " +COMIDA_TAILANDESA.getDescricao() + "\n2- " + COMIDA_MEXICANA.getDescricao() + "\n3- " +
                COMIDA_JAPONESA.getDescricao() + "\nBEBIDAS: \n4- " + REFRIGERANTE.getDescricao() + "\n5- " + SUCO_NATURAL.getDescricao() + "\n6- " +CERVEJA.getDescricao();

    }

    private String descricao;
    private int opcao;

    TipoProduto(int opcao,String descricao,) {
        this.descricao = descricao;
        this.opcao = opcao;
    }

    public String getDescricao() {
        return descricao;
    }
}
