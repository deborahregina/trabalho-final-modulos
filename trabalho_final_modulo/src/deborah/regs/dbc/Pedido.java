package deborah.regs.dbc;

public class Pedido {
    private int idPedido;
    private int idCliente;

    public Pedido(int idPedido, int idCliente) {
        this.idPedido = idPedido;
        this.idCliente = idCliente;
    }

    public void adicionaProduto(int idProduto, int qtd) {

    }

    public void retiraProduto(int idProduto) {

    }
    public void status() {

    }

    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }
}