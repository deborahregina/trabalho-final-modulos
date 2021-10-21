package deborah.regs.dbc.model;

import deborah.regs.dbc.Main;

import java.util.ArrayList;

public class Pedido {
    private integer idPedido;
    private Cliente cliente;
    private ArrayList<Produto> produtosDoPedido;
    private double valorTotal;

    public Pedido(int idPedido, Cliente cliente, ArrayList<Produto> produtosDoPedido) {
        this.idPedido = idPedido;
        this.cliente = cliente;
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

    public void adicionaProduto(Produto produto ) {
        this.produtosDoPedido.add(produto);

    }

    public ArrayList<Produto> getProdutosDoPedido() {
        return produtosDoPedido;
    }

    public void setProdutosDoPedido(ArrayList<Produto> produtosDoPedido) {
        this.produtosDoPedido = produtosDoPedido;
    }



    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @Override
    public String toString() {
        calculaValorTotal();
        System.out.println("++++++++++++ Itens do pedido ++++++++++++");
        for (Produto produtos: produtosDoPedido) {
            System.out.println(produtos);
        }

        return "ID do pedido: " + idPedido + " Nome do cliente: " + cliente.getNome() + " Valor total do pedido: R$ " + Main.df.format(valorTotal);
    }
}