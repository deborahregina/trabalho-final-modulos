package deborah.regs.dbc;

public class Produto {
    private int idProdutos;
    private String nomeProduto;
    private double valorUnitario;


    public Produto(int idProdutos, String nomeProduto, double valorUnitario) {
        this.idProdutos = idProdutos;
        this.nomeProduto = nomeProduto;
        this.valorUnitario = valorUnitario;
    }

    public void cadastrarProduto(){

    }
    public void removerProduto(){

    }
    public void alterarProduto(int idProduto){

    }

    public int getIdProdutos() {
        return idProdutos;
    }

    public void setIdProdutos(int idProdutos) {
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

    @Override
    public String toString() {
        return "ID do produto: " + idProdutos + " Nome do produto: " + nomeProduto + " Valor unitário: R$ " + Main.df.format(valorUnitario);
    }
}