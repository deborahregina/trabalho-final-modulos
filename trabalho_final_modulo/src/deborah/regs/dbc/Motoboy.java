package deborah.regs.dbc;

public class Motoboy extends Funcionario implements Impressao {
    private String placaMoto;

    public Motoboy(int id, String nome, double salario) {
        super(id, nome, salario);
    }

    public Motoboy(int id, String nome, double salario, String placaMoto) {
        super(id, nome, salario);
        this.placaMoto = placaMoto;
    }

    public String getPlacaMoto() {
        return placaMoto;
    }

    public void setPlacaMoto(String placaMoto) {
        this.placaMoto = placaMoto;
    }

    @Override
    public String imprimir() {
        return super.imprimir() + "\nFunção: Motoboy \nPlaca da moto" + placaMoto;
    }
}
