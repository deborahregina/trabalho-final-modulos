package deborah.regs.dbc;

import java.util.Scanner;

public enum TipoProduto {

    COMIDA_TAILANDESA("Curry Massaman"),
    COMIDA_MEXICANA("Guacamole"),
    COMIDA_JAPONESA("Sushi"),
    REFRIGERANTE( "coca cola"),
    SUCO_NATURAL("Dellvale"),
    CERVEJA("Heineken");


    public static String imprimeCardapio() {

        return "Produtos: " +"\nCOMIDAS: " + "\n1- " +COMIDA_TAILANDESA.getDescricao() + "\n2- " + COMIDA_MEXICANA.getDescricao() + "\n3- " +
                COMIDA_JAPONESA.getDescricao() + "\nBEBIDAS: \n4- " + REFRIGERANTE.getDescricao() + "\n5- " + SUCO_NATURAL.getDescricao() + "\n6- " +CERVEJA.getDescricao();

    }

    TipoProduto() {
    }

    private String descricao;

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public TipoProduto escolheTipo(TipoProduto tipoProduto) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite a opção: ");
        int op = scanner.nextInt();

        if (op == 1) {
            tipoProduto = COMIDA_JAPONESA;
        }
        if (op == 2) {
            tipoProduto = COMIDA_MEXICANA;
        }
        if (op == 3) {
            tipoProduto = COMIDA_JAPONESA;
        }
        if (op == 4) {
            tipoProduto = REFRIGERANTE;
        }
        if (op == 5) {
            tipoProduto = SUCO_NATURAL;
        }
        if (op == 6) {
            tipoProduto = CERVEJA;
        }

        return tipoProduto;
    }

    TipoProduto(String descricao) {
        this.descricao = descricao;

    }

    public String getDescricao() {
        return descricao;
    }
}
