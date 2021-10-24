package deborah.dbc.model;

public class PedidoProduto {
    private Produto produto;
    private Pedido pedido;
    private Integer quantidade;


    public PedidoProduto() {

    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    @Override
    public String toString() {
        return "Pedidos em aberto{" +
                "id pedido = " + pedido.getIdPedido() +
                ", id produto = " + produto.getIdProduto() +
                ", nome produto = " + produto.getDescrição() +
                ", quantidade = " + quantidade +
                ", preço = " + produto.getValorUnitario() +
                ", status = " + pedido.getStatus() +
                '}';
    }
}
