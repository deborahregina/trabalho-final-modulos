package deborah.dbc.model;

import deborah.dbc.Main;
import deborah.dbc.service.ProdutoService;

public class Produto {
    private int idProdutos;
    private double valorUnitario;
    private String descrição;
    private TipoProduto tipoProduto;


    public Produto(int idProdutos, double valorUnitario, TipoProduto tipoProduto) {
        this.idProdutos = idProdutos;
        this.valorUnitario = valorUnitario;
        this.tipoProduto = tipoProduto;
    }

    public Produto() {

    }


    public String getDescrição() {
        return descrição;
    }

    public void setDescrição(String descrição) {
        this.descrição = descrição;
    }

    public int getIdProduto() {
        return idProdutos;
    }

    public void setIdProduto(int idProdutos) {
        this.idProdutos = idProdutos;
    }

    public int getIdProdutos() {
        return idProdutos;
    }

    public void setIdProdutos(int idProdutos) {
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
        return "ID do produto: " + idProdutos +  " | Tipo do produto: " + tipoProdutoEh +" | Nome do produto: " + descrição+ " | Valor unitário: R$ " + valorUnitario +  "\n";
    }

}
