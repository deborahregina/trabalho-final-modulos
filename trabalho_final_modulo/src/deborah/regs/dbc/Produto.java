package deborah.regs.dbc;

public class Produto {
    private int idProdutos;
    private String nomeProduto;
    private double valorUnitario;
    private   TipoProduto tipoProduto;


    public Produto(int idProdutos, String nomeProduto, double valorUnitario) {
        this.idProdutos = idProdutos;
        this.nomeProduto = nomeProduto;
        this.valorUnitario = valorUnitario;
    }

    public Produto() {

    }

    public void cadastrarProduto(){


    }
    public void removerProduto(){

    }
    public void alterarProduto(int idProduto){

    }

    public int getIdProduto() {
        return idProdutos;
    }

    public void setIdProduto(int idProdutos) {
        this.idProdutos = idProdutos;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public double getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(double valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }
    public TipoProduto getTipoProduto() {return tipoProduto;}
    public void setTipoProduto(TipoProduto tipoProduto) {this.tipoProduto = tipoProduto;}


    @Override
    public String toString() {
        return "ID do produto: " + idProdutos + " Nome do produto: " + getTipoProduto().getDescricao() + " Valor unitário: R$ " + Main.df.format(valorUnitario);
    }


}