package deborah.regs.dbc;

import deborah.regs.dbc.model.Cliente;
import deborah.regs.dbc.model.Pedido;
import deborah.regs.dbc.model.Produto;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class CaixaTest {
    @Test
    public void verificarValorCaixaDepoisDoPagamento() {
        Caixa caixa1 = new Caixa(null,1000);
        caixa1.setValorDeCaixa(1000);
        boolean t = caixa1.pagar(50,30,50);
        assertTrue(t);
        assertEquals(1020,caixa1.getValorDeCaixa(),0);
    }
    @Test
    public void verificarValorCaixaDepoisDoPagamentoTrocoErrado(){
        Caixa caixa = new Caixa(null,1000);
        caixa.setValorDeCaixa(1000);
        boolean t = caixa.pagar(40,60,50);
        assertFalse(t);
        assertEquals(1000,caixa.getValorDeCaixa(),0);
    }

    @Test
    public void verificarCalculaTroco() {
        //SETUP
        Cliente cliente1 = new Cliente(1,"1231234","Camile",null,null);

        Produto coca = new Produto();
        Produto pizza = new Produto();
        coca.setValorUnitario(5.00);
        pizza.setValorUnitario(20.00);
        ArrayList<Produto>produtos = new ArrayList<>();
        produtos.add(coca);
        produtos.add(pizza);
        Pedido pedido = new Pedido(1,cliente1,produtos);
        pedido.calculaValorTotal();

        //ACT
        Caixa caixa = new Caixa(null,1000);
        double troco = caixa.calculaTroco(pedido,30);
        //ASSERT
        assertEquals(5.00,troco,0);
    }

    @Test
    public void verificarCalculaTrocoErro() {
        //SETUP
        Cliente cliente1 = new Cliente(1,"1231234","Camile",null,null);

        Produto coca = new Produto();
        Produto pizza = new Produto();
        coca.setValorUnitario(5.00);
        pizza.setValorUnitario(20.00);
        ArrayList<Produto>produtos = new ArrayList<>();
        produtos.add(coca);
        produtos.add(pizza);
        Pedido pedido = new Pedido(1,cliente1,produtos);
        pedido.calculaValorTotal();

        //ACT
        Caixa caixa = new Caixa(null,1000);
        double troco = caixa.calculaTroco(pedido,20);
        //ASSERT
        assertEquals(0,troco,0);
    }




}