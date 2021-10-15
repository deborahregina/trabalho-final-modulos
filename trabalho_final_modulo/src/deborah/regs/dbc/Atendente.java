package deborah.regs.dbc;

public class Atendente extends Funcionario implements Impressao {
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
    public String imprimir() {
        return super.imprimir() + "\nFunção: Atendente \nHoras trabalhadas " + horasTrabalhadas;
    }
}
