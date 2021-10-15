package deborah.regs.dbc;

public class Entrega implements Pagamento {

    private Pedido pedidoEntrega;
    private Motoboy motoboy;

    public Entrega(Pedido pedidoEntrega, Motoboy motoboy) {
        this.pedidoEntrega = pedidoEntrega;
        this.motoboy = motoboy;
    }

    public Pedido getPedidoEntrega() {
        return pedidoEntrega;
    }

    public void setPedidoEntrega(Pedido pedidoEntrega) {
        this.pedidoEntrega = pedidoEntrega;
    }

    public Motoboy getMotoboy() {
        return motoboy;
    }

    public void setMotoboy(Motoboy motoboy) {
        this.motoboy = motoboy;
    }

    @Override
    public boolean pagar(double valorPago, double valorTroco) {
        return Main.caixaPrincipal.pagar(valorPago,valorTroco);
    }

    @Override
    public double calculaTroco(Pedido pedido, double valor) {
        return Main.caixaPrincipal.calculaTroco(pedido,valor);
    }


}
