package deborah.dbc.model;

public class Endereco {
    private Cliente cliente;
    private Integer idEndereco;
    private TipoEndereco tipo;
    private String logradouro;
    private int numero;
    private String bairro;
    private String cep;

    public Endereco() {
    }

    public Endereco(Integer idEndereco, TipoEndereco tipo, String logradouro, int numero, String bairro, String cep) {
        this.idEndereco = idEndereco;
        this.tipo = tipo;
        this.logradouro = logradouro;
        this.numero = numero;
        this.bairro = bairro;
        this.cep = cep;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Integer getIdEndereco() {
        return idEndereco;
    }

    public void setIdEndereco(Integer idEndereco) {
        this.idEndereco = idEndereco;
    }

    public TipoEndereco getTipo() {
        return tipo;
    }

    public void setTipo(TipoEndereco tipo) {
        this.tipo = tipo;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    @Override
    public String toString () {
        String tipoEndereco = "";
        if (tipo.getTipo() == 1) {
            tipoEndereco = "Residencial";
        }
        if (tipo.getTipo() == 2) {
            tipoEndereco = "Comercial";
        }
        return "\nEndereço: " + logradouro + "\nNúmero: " +  numero + "\nBairro: " + bairro + "\nCEP: " + cep + "\nTipo de endereço: " + tipoEndereco;
    }
}
