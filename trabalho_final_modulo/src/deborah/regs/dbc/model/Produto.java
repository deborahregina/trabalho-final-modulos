package deborah.regs.dbc.model;

import deborah.regs.dbc.Main;

public class Produto {
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
        return "ID do produto: " + idProdutos +  " Nome do produto: " + tipoProduto.getDescricao() + " Valor unitário: R$ " + Main.df.format(valorUnitario);
    }



}