package deborah.dbc.model;

import java.util.Arrays;

public enum TipoProduto {
    COMIDA(1),
    BEBIDA(2);

    private Integer tipo;

    TipoProduto(Integer tipo) {
        this.tipo = tipo;
    }

    public Integer getTipo() {
        return tipo;
    }

    public static TipoProduto ofTipo(Integer tipo){
        return Arrays.stream(TipoProduto.values())
                .filter(tp -> tp.getTipo().equals(tipo))
                .findFirst()
                .get();
    }
}
