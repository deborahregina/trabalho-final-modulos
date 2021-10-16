package deborah.regs.dbc;

import org.junit.Test;

import java.util.ArrayList;
import java.util.concurrent.Callable;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CaixaTest {
    @Test
    private void verificarValorCaixaDepoisDoPagamento() {
    Caixa caixa1 = Main.caixaPrincipal;
    caixa1.setValorDeCaixa(1000);
//        ArrayList<Produto>produtos = new ArrayList<>();
//        produtos.add(Main.produtos.get(1));
//        produtos.add(Main.produtos.get(2));
//    Pedido pedido1 = new Pedido(1,2,produtos);
//      Double troco = caixa1.calculaTroco(pedido1,100);
//      System.out.println(caixa1.getValorDeCaixa());

        boolean t = caixa1.pagar(50,30);
        assertTrue(t);
        assertEquals(caixa1.getValorDeCaixa(), 1030,0);


    }
}
