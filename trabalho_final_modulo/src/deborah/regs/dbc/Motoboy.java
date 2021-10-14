package deborah.regs.dbc;

public class Motoboy extends Funcionario implements Impressao {
    int placaMoto;

    public Motoboy(int id, String nome, double salario) {
        super(id, nome, salario);
    }

    public Motoboy(int id, String nome, double salario, int placaMoto) {
        super(id, nome, salario);
        this.placaMoto = placaMoto;
    }

    public int getPlacaMoto() {
        return placaMoto;
    }

    public void setPlacaMoto(int placaMoto) {
        this.placaMoto = placaMoto;
    }

    @Override
    public String imprimir() {
        return super.imprimir() + "\nFunção: Motoboy \nPlaca da moto" + placaMoto;
    }
}
