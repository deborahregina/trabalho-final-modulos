package deborah.regs.dbc;

import java.util.ArrayList;

public class Pedido {
    private int idPedido;
    private int idCliente;
    private ArrayList<Produto> produtosDoPedido;
    private double valorTotal;

    public Pedido(int idPedido, int idCliente, ArrayList<Produto> produtosDoPedido) {
        this.idPedido = idPedido;
        this.idCliente = idCliente;
        this.produtosDoPedido = produtosDoPedido;
    }

    public void calculaValorTotal() {
        double calculaValor = 0;
        for (int i = 0; i < produtosDoPedido.size(); i++ ) {
            calculaValor += produtosDoPedido.get(i).getValorUnitario();
        }
        setValorTotal(calculaValor);
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public void adicionaProduto(int idProduto, int qtd) {

    }

    public ArrayList<Produto> getProdutosDoPedido() {
        return produtosDoPedido;
    }

    public void setProdutosDoPedido(ArrayList<Produto> produtosDoPedido) {
        this.produtosDoPedido = produtosDoPedido;
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

    @Override
    public String toString() {
        System.out.println("++++++++++++ Itens do pedido ++++++++++++");
        for (Produto produtos: produtosDoPedido) {
            System.out.println(produtos);
        }

        return "ID do pedido: " + idPedido + " ID do cliente: " + idCliente + " Valor total do pedido: " +valorTotal;
    }
}