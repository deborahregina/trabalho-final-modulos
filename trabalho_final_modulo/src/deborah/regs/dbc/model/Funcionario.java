package deborah.regs.dbc.model;

public abstract class Funcionario implements Impressao {
    private String nome;
    private double salario;
    private String Cargo;

    public Funcionario(double salario) {
        this.salario = salario;
        this.Cargo = Cargo;
        this.nome = nome;
    }

    public String getCargo() {
        return Cargo;
    }

    public void setCargo(String cargo) {
        Cargo = cargo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    @Override
    public void imprimir() {

    }

}
