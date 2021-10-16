package deborah.regs.dbc;

import org.junit.Test;

import java.util.ArrayList;
import java.util.concurrent.Callable;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CaixaTest {
    @Test
    public void verificarValorCaixaDepoisDoPagamento() {
    Caixa caixa1 = Main.caixaPrincipal;
    caixa1.setValorDeCaixa(1000);
        boolean t = caixa1.pagar(50,30);
        assertTrue(t);
        assertEquals(1020,caixa1.getValorDeCaixa(),0);


    }
}
