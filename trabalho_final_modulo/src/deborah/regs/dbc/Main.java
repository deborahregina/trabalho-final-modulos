package deborah.regs.dbc;

import java.sql.SQLOutput;
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

            int op = Menu.menuPrincipal(); // retorno da seleção do "Menu iniciar"

            switch (op) {

                case 1:

                    System.out.println("1- Cadastrar novo cliente \n2- Deletar cliente \n3- Imprimir Cliente(s) \n4- Alterar cadastro de cliente: ");
                    int opCliente = scanner.nextInt();
                    if (opCliente == 1) {
                        clientes.add(Menu.menuCriaCliente());
                    }
                    if (opCliente == 2) {
                        System.out.println("1- Criar novo pedido \n2- Deletar pedido \n3- Imprimir pedidos \n4- Alterar pedido");
                        Menu.menuDeletaCliente(clientes);
                    }
                    if (opCliente == 3) {
                        Menu.menuImprimeCliente(clientes);
                    }
                    if (opCliente == 4) {
                        Menu.menuAlteraCliente();
                    }
                    break;
                case 2:
                    System.out.println("1- Criar novo Pedido \n2- Imprimir pedidos em aberto \n3- Alterar produto de pedido "); // O método deletar pedido não faz sentido porque é uma pilha.

                    int opPedidos = scanner.nextInt();
                    if (opPedidos == 1) {
                        Menu.menuCriaPedido();
                    }
                    if (opPedidos == 2) {
                        Menu.menuImprimePedidosEmAberto();
                    }
                    if (opPedidos == 3) {
                        Menu.menuAlteraPedido();
                    }
                    break;
                case 3:
                    Menu.menuImprimeCaixa(caixaPrincipal);
                    break;
                case 4:
                    System.out.println("1- Cadastrar novo funcionário \n2- Imprimir funcionário(s) \n3- Deletar funcionario \n4- Alterar cadastro de funcionário:  ");
                    int opFuncionario = scanner.nextInt();
                    scanner.nextLine();
                    if (opFuncionario == 1) {
                        funcionarios.add(Menu.menuCadastroFuncionario());
                    }
                    if (opFuncionario == 2) {
                        Menu.menuImprimeFuncionario(funcionarios);
                    }
                    if (opFuncionario == 3) {
                        Menu.menuDeletaFuncionario();
                    }
                    if (opFuncionario == 4) {
                        Menu.menuAlteraFuncionario();
                    }
                    break;
                case 5:
                    System.out.println("1- Cadastrar Produto \n2- Listar produtos \n3- Deletar produto \n4- Alterar cadastro de produto");
                    int opProdutos = scanner.nextInt();
                    if (opProdutos == 1) {
                        Menu.menuCadastraProduto();
                    }
                    if (opProdutos == 2) {
                        Menu.menuImprimeProdutos(produtos);
                    }
                    if (opProdutos == 3) {
                        Menu.menuDeletaProduto();
                    }
                    if (opProdutos == 4) {
                        Menu.menuAlteraProduto();
                    }
                    break;
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
