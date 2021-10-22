package deborah.dbc.model;

public class Motoboy extends Funcionario {
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
    public String toString() {
        return "Motoboy";
    }

    @Override
    public int getFuncionario() {
        return 0;
    }


    @Override
    public void setIdFuncionario(Integer proximoId) {

    }

    @Override
    public void setIdFuncionarios(Integer proximoId) {

    }
}
