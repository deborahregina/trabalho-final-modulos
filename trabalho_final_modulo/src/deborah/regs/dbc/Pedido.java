package deborah.regs.dbc;

import java.util.ArrayList;

public class Pedido {
    private int idPedido;
    private int idCliente;
    private ArrayList<Produto> produtosDoPedido = new ArrayList<>();
    private double valorTotal;

    public Pedido(int idPedido, int idCliente, ArrayList<Produto> produtosDoPedido) {
        this.idPedido = idPedido;
        this.idCliente = idCliente;
        this.produtosDoPedido = produtosDoPedido;
    }

    public double calculaValorTotal() {
        double calculaValor = 0;
        for (int i = 0; i < produtosDoPedido.size(); i++ ) {
            calculaValor += produtosDoPedido.get(i).getValorUnitario();
        }
        return calculaValor;
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
        for (int i = 0; i < produtosDoPedido.size(); i ++) {
            System.out.println(produtosDoPedido.get(i).toString());
        }
        if (valorTotal == 0) {
            System.out.println("O total do pedido é calculado no ato de entrega! ");
        }
        else {
            System.out.println("Valor total do pedido: " + valorTotal);
        }
        return "ID do pedido: " + idPedido + " ID do cliente: " + idCliente;
    }
}