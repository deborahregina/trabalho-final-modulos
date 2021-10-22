package deborah.dbc.model;

public class Atendente extends Funcionario {
    private int horasTrabalhadas;

    public Atendente(int id, String nome, double salario, int horasTrabalhadas) {
        super(id, nome, salario);
        this.horasTrabalhadas = horasTrabalhadas;
    }

    public Atendente(int id, String nome, double salario) {
        super(id,nome,salario);
    }

    public int getHorasTrabalhadas() {
        return horasTrabalhadas;
    }

    public void setHorasTrabalhadas(int horasTrabalhadas) {
        this.horasTrabalhadas = horasTrabalhadas;
    }

    @Override
    public String toString() {
        return super.toString() + "\nFunção: Atendente \nHoras trabalhadas " + horasTrabalhadas;
    }

    @Override
    public Funcionario getFuncionario() {
        return null;
    }

    @Override
    public void setIdFuncionario(Integer proximoId) {

    }

    @Override
    public void setIdFuncionarios(Integer proximoId) {

    }
}
