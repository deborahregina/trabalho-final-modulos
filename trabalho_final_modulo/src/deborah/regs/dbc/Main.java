package deborah.regs.dbc;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        ArrayList<Cliente> clientes = new ArrayList<>();
        ArrayList<Funcionario> funcionarios = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);

        boolean programaOn = true;

        while (programaOn) {

            int op = Menu.MenuPrincial();

            switch (op) {

                case 1:

                    System.out.println("1 - Cadastrar novo cliente \n2- Deletar cliente \n3- Imprimir Cliente(s): ");
                    int opCliente = scanner.nextInt();
                    if (opCliente == 1) {
                        clientes.add(Menu.criaCliente());
                    }
                    if (opCliente == 2) {
                        clientes.remove(Menu.MenuDeletaCliente(clientes));
                    }
                    if (opCliente == 3) {
                        Menu.menuImprimeCliente(clientes);
                    }
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    System.out.println("1- Cadastrar novo funcionário   2- Imprimir funcionário(s): ");
                    int opFuncionario = scanner.nextInt();
                    if (opFuncionario == 1) {
                        funcionarios.add(Menu.MenuCadastroFuncionario());
                    }
                    if (op == 2) {
                        Menu.menuImprimeFuncionario(funcionarios);
                    }
                    break;
                case 5:
                    break;
                case 6:
                    // Listar todos os itens do menu
                case 7:
                    programaOn = false;
                    break;
                default:
                    System.out.println("Digite uma opção válida!");
                    break;
            }

        }

    }
}
