package deborah.dbc.model;

public class Atendente extends Funcionario {


    public Atendente(int id, String nome, double salario) {
        super(id,nome,salario);
    }



    @Override
    public String toString() {
        return super.toString() + "\nFunção: Atendente";
    }
}