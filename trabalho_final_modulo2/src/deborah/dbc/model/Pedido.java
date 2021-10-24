package deborah.dbc.model;


import java.util.ArrayList;

public class Pedido {
    private int idPedido;
    private Integer idCliente;
    private Cliente cliente;
    private ArrayList<Produto> produtosDoPedido;
    private double valorTotal;
    private String status;

    public Pedido(){

    }


    public void calculaValorTotal() {
        double calculaValor = 0;
        for (int i = 0; i < produtosDoPedido.size(); i++ ) {
            //calculaValor += produtosDoPedido.get(i).getValorUnitario();
        }
        setValorTotal(calculaValor);
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public void adicionaProduto(Produto produto ) {
       // this.produtosDoPedido.add(produto);

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

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    @Override
    public String toString() {
        //calculaValorTotal();
        System.out.println("++++++++++++ Itens do pedido ++++++++++++");
        if (produtosDoPedido != null) {
            for (Produto produtos : produtosDoPedido) {
                System.out.println(produtos);
            }
        }

        return "ID do pedido: " + idPedido + " Nome do cliente: " + (cliente != null?cliente.getNome():"") + " Valor total do pedido: R$ " + valorTotal;
    }
}

