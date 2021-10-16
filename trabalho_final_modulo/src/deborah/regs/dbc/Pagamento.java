package deborah.regs.dbc;

public interface Pagamento {
    public boolean pagar(double valorPago, double valorTroco,double valorDoPedido);
    public double calculaTroco(Pedido pedido,double valor);
}
