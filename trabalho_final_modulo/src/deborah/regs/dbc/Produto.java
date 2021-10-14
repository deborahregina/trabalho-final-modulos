package deborah.regs.dbc;

public class Produto {
    private int idProdutos;
    private String nomeProduto;

    public Produto(int idProdutos, String nomeProduto) {
        this.idProdutos = idProdutos;
        this.nomeProduto = nomeProduto;
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

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }
}