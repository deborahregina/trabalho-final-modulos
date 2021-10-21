package deborah.regs.dbc.model;

public interface Pagamento {
    public boolean pagar(double valorPago, double valorTroco,double valorDoPedido);
    public double calculaTroco(Pedido pedido, double valor);
}
