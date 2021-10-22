package deborah.dbc.model;

public abstract class Funcionario {
    private int idFuncionario;
    private String nome;
    private double salario;

    public Funcionario(int id, String nome, double salario) {
        this.idFuncionario = id;
        this.nome = nome;
        this.salario = salario;
    }

    public Funcionario() {
    }

    public int getId() {
        return idFuncionario;
    }

    public void setId(int id) {
        this.idFuncionario = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    @Override
    public String toString() {
        return "Id do funcionário: " + idFuncionario+ " | Nome do funcionário: " + nome;
    }

    public abstract Funcionario getFuncionario();

    public abstract void setIdFuncionario(Integer proximoId);

    public abstract void setIdFuncionarios(Integer proximoId);
}
