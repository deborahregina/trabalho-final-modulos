package deborah.regs.dbc;

public class Endereco implements Impressao {

    private int tipo;
    private String rua;
    private int numero;
    private String complemento;
    private String cep;
    private String cidade;

    public Endereco(int tipo, String rua, int numero, String complemento, String cep, String cidade) {
        this.tipo = tipo;
        this.rua = rua;
        this.numero = numero;
        this.complemento = complemento;
        this.cep = cep;
        this.cidade = cidade;

    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    @Override
    public String imprimir () {
        String tipoEndereco = "";
        if (tipo == 1) {
            tipoEndereco = "Residencial";
        }
        if (tipo == 2) {
            tipoEndereco = "Comercial";
        }
        return "\nTipo de endereco: " + tipoEndereco  + "\nRua: " +  rua + "\nNúmero " + numero + "\nComplemento: " + complemento + "\nCEP: " + cep + "\nCidade: "+ cidade;
    }
}
