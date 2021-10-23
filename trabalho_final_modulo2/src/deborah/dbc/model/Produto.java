package deborah.dbc.model;

import deborah.dbc.Main;
import deborah.dbc.service.ProdutoService;

public class Produto {
    private String nome;
    private int idProdutos;
    private double valorUnitario;
    private TipoProduto tipoProduto;


    public Produto(int idProdutos, double valorUnitario, TipoProduto tipoProduto) {
        this.idProdutos = idProdutos;
        this.valorUnitario = valorUnitario;
        this.tipoProduto = tipoProduto;
    }

    public Produto() {

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdProduto() {
        return idProdutos;
    }

    public void setIdProduto(int idProdutos) {
        this.idProdutos = idProdutos;
    }



    public double getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(double valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public TipoProduto getTipoProduto() {return tipoProduto;}

    public void setTipoProduto(TipoProduto tipoProduto) {this.tipoProduto = tipoProduto;}


    @Override
    public String toString() {
        String tipoProdutoEh = "";
        if (tipoProduto.getTipo() == 1) {
            tipoProdutoEh = "Comida";
        }
        if (tipoProduto.getTipo() == 2) {
            tipoProdutoEh = "Bebida";
        }
        return "ID do produto: " + idProdutos +  " Nome do produto: " + (tipoProduto != null?tipoProdutoEh:null) + " Valor unitário: R$ " + valorUnitario;
    }

}
