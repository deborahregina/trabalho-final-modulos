package deborah.regs.dbc;

public class Entrega {

    private Pedido pedidoEntrega;
    private Motoboy motoboy;
    private boolean entregaRealizada = false;

    public Entrega(Pedido pedidoEntrega, Motoboy motoboy) {
        this.pedidoEntrega = pedidoEntrega;
        this.motoboy = motoboy;
    }

    public boolean realizarEntrega(){
        this.entregaRealizada = true;
        Main.pedidos.poll();
        System.out.println("Entrega realizada e pedido removido da lista");
        return entregaRealizada;
    }

    public boolean isEntregaRealizada() {
        return entregaRealizada;
    }

    public void EnderecoDaEntrega() {
        pedidoEntrega.getCliente().getEnderecos();
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

}
