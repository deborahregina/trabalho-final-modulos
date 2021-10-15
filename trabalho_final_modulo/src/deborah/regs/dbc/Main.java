package deborah.regs.dbc;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    // Esses são atributos do programa no geral, então os métodos adicionam e retiram coisas daqui
    static ArrayList<Cliente> clientes = new ArrayList<>();
    static ArrayList<Funcionario> funcionarios = new ArrayList<>();
    static ArrayList<Produto> produtos = new ArrayList<>();
    static Queue<Pedido> pedidos = new LinkedList<>();

    // Cadastro de clientes, funcionários, produtos, pedidos iniciais, para não poluir a Main. Aqui é tipo um SETUP das coisas que não precisamos
    // colocar manualmente
    static Caixa caixaPrincipal = CadastroAutomatico.cadastroAutomatico();

    static DecimalFormat df = new DecimalFormat("###,###.00");

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        boolean programaOn = true;

        while (programaOn) {

            int op = Menu.MenuPrincial(); // retorno da seleção do "Menu iniciar"

            switch (op) {

                case 1:

                    System.out.println("1- Cadastrar novo cliente \n2- Deletar cliente \n3- Imprimir Cliente(s): ");
                    int opCliente = scanner.nextInt();
                    if (opCliente == 1) {
                        clientes.add(Menu.criaCliente());
                    }
                    if (opCliente == 2) {
                        clientes.remove(Menu.menuDeletaCliente(clientes));
                    }
                    if (opCliente == 3) {
                        Menu.menuImprimeCliente(clientes);
                    }
                    break;
                case 2:
                    Menu.menuImprimePedidosEmAberto(pedidos);
                    break;
                case 3:
                    Menu.menuImprimeCaixa(caixaPrincipal);
                    break;
                case 4:
                    System.out.println("1- Cadastrar novo funcionário   2- Imprimir funcionário(s): ");
                    int opFuncionario = scanner.nextInt();
                    scanner.nextLine();
                    if (opFuncionario == 1) {
                        funcionarios.add(Menu.MenuCadastroFuncionario());
                    }
                    if (opFuncionario == 2) {
                        Menu.menuImprimeFuncionario(funcionarios);
                    }
                    break;
                case 5:
                    System.out.println("1- Cadastrar Produto    2- Listar produtos ");
                    int opProdutos = scanner.nextInt();
                    if (opProdutos == 1) {
                        produtos.add(Menu.menuCadastraProduto());
                    }
                    if (opProdutos == 2){
                        Menu.imprimeProdutos(produtos);
                    }
                case 6:
                    System.out.println("Realizar Entrega de produto ");
                    Menu.menuEntregas();
                    break;
                case 7:
                    programaOn = false;
                    break;
                default:
                    System.out.println("Digite uma opção válida! ");
                    break;
            }

        }

    }
}
