package deborah.dbc.model;

public class Motoboy extends Funcionario {
    private String placaMoto;

    public Motoboy(int id, String nome, double salario) {
        super(id, nome, salario);
    }



    @Override
    public String toString() {
        return super.toString()+ "Motoboy";
    }


}
