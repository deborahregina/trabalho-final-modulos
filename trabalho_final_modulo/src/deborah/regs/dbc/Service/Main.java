package deborah.regs.dbc;

import deborah.regs.dbc.model.*;
import jdk.swing.interop.SwingInterOpUtils;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    static Caixa caixa = new Caixa(1000);
    static DecimalFormat df = new DecimalFormat("###,###.00");

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        boolean programaOn = true;

        do {
            System.out.println("############# Menu Principal ############# ");
            System.out.println("Qual opção deseja acessar? \n1- Menu Clientes \n2- Menu Pedidos \n3- Informações caixa \n4- Menu Funcionários \n5- Menu Produtos \n6- Realizar Entrega \n7- Sair");
            int op = scanner.nextInt();
            scanner.nextLine();
            switch (op) {

                case 1:

                    System.out.println("1- Cadastrar novo cliente \n2- Deletar cliente \n3- Imprimir Cliente(s) \n4- Alterar cadastro de cliente: ");
                    int opCliente = scanner.nextInt();
                    if (opCliente == 1) {

                        Endereco endereco = new Endereco();
                        Cliente cliente = new Cliente();
                        Contato contato = new Contato();

                        System.out.println("Digite o nome do cliente: ");
                        cliente.setNome(scanner.nextLine());
                        System.out.println("Digite o CPF do cliente: ");
                        cliente.setCpf(scanner.nextLine());
                        System.out.println("** CADASTRO DE ENDEREÇO **");
                        System.out.println("Digite o Logradouro: ");
                        endereco.setLogradouro(scanner.nextLine());
                        System.out.println("Digite o número: ");
                        endereco.setNumero(scanner.nextInt());
                        System.out.println("Digite o bairro: ");
                        endereco.setBairro(scanner.nextLine());
                        System.out.println("Digite o CEP: ");
                        endereco.setCep(scanner.nextLine());
                        System.out.println("** CADASTRO DE CONTATO **");
                        System.out.println("Digite a descrição do contato: ");
                        contato.setDescricao(scanner.nextLine());
                        System.out.println("Digite o telefone: ");
                        contato.setTelefone(scanner.nextLine());
                        System.out.println("Tipo de endereço: 1- Residencial        2- Comercial: ");
                        contato.setTipo(TipoContato.ofTipo(scanner.nextInt()));

                        // passar para tabela cliente
                        // passar para tabela endereco
                        // passar para tabela contato


                    }
                    if (opCliente == 2) {
                        // Lista de clientes cadastros
                        System.out.println("Qual o ID do cliente que deseja deletar: ");
                        Integer idDeletaCliente = scanner.nextInt();
                        // DELETA CLIENTE E DELETA CONTATOS, ENDERECOS E PEDIDOS RELACIONADO AO CLIENTE
                    }
                    if (opCliente == 3) {
                        System.out.println("Lista de clientes cadastrados: ");
                        // IMPRIME CLIENTES
                    }
                    if (opCliente == 4) {
                        // IMPRIME CLIENTES
                        Endereco endereco = new Endereco();
                        Cliente cliente = new Cliente();
                        Contato contato = new Contato();

                        System.out.println("Qual o ID do cliente que deseja alterar: ");
                        Integer idClienteAltera = scanner.nextInt();
                        System.out.println("Digite o nome do cliente: ");
                        cliente.setNome(scanner.nextLine());
                        System.out.println("Digite o CPF do cliente: ");
                        cliente.setCpf(scanner.nextLine());
                        System.out.println("Deseja alterar o o endereço principal?  1- Sim      2- Não: ");
                        int opEnderecoPrincipal = scanner.nextInt();

                        if (opEnderecoPrincipal == 1) {
                         // altera o endereço
                        }

                        System.out.println("Deseja cadastrar novo endereço? 1- Sim      2- Não: ");
                        int opEnderecoNovo = scanner.nextInt();

                        if (opEnderecoNovo == 1) {
                            // cadastra novo endereço
                        }

                        System.out.println("Deseja listar endereços do cliente? 1- Sim      2- Não: ");
                        int opListaEnderecos = scanner.nextInt();

                        if (opListaEnderecos == 1) {
                            // Lista endereços
                        }

                        System.out.println("Deseja deletar o endereço secundário do cliente? 1- Sim     2- Não: ");

                        // Implementa lógica de deletar só se o cliente tem mais de um endereço

                        System.out.println("Deseja alterar o contato principal?  1- Sim     2- Não: ");
                        int opContatoPrincipal = scanner.nextInt();

                        if (opContatoPrincipal == 1) {
                            // altera o contato
                        }

                        System.out.println("Deseja cadastrar novo contato? 1- Sim       2- Não: ");
                        int opCadastraNovoContato = scanner.nextInt();

                        if (opCadastraNovoContato == 1) {
                            // Cadastrar novo contrato
                        }





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
        } while (programaOn);
    }
}











