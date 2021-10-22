package deborah.dbc.model;


    public class Motoboy extends Funcionario {
        ;

        public Motoboy(int id, String nome, double salario) {
            super(id, nome, salario);
        }

        public Motoboy() {
            super();
        }

        @Override
        public String toString() {
            return super.toString() + "\nFunção: Motoboy";
        }

    }

