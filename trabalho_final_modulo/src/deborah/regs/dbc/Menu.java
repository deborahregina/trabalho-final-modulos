package deborah.regs.dbc;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
// Essa classe implementa os menus que vão ser utilizados ao longo do programa
    public static void MenuCadastroFuncionario() {

        System.out.println("***Cadastro de Funcionários***");


    }

    public static Cliente criaCliente() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o nome do Cliente: ");
        String nome = scanner.nextLine();
        System.out.println("Digite o cpf do Cliente: ");
        String cpf = scanner.nextLine();
        System.out.println("**Cadastrar Contato do Cliente**");
        Contato contato1 = criaContato();
        ArrayList <Contato> contatosCliente = new ArrayList<>();
        contatosCliente.add(contato1);
        System.out.println("Deseja cadastrar um contato secundário? 1- Sim 2- Não: ");
        int opcao = scanner.nextInt();
        if (opcao == 1){
            Contato contato2 = criaContato();
        }
        System.out.println("**Cadastrar endereço princial**");
        Endereco endereco1 = criaEndereco();
        ArrayList <Endereco> enderecosCliente = new ArrayList<>();
        enderecosCliente.add(endereco1);
        System.out.println("Deseja cadastrar um endereço secundário? 1- Sim  2- Não: ");
        int op = scanner.nextInt();
        if (op == 1) {
            Endereco endereco2 = criaEndereco();
        }
        Main.NUMERO_CLIENTES += 1;
        Cliente cliente = new Cliente(Main.NUMERO_CLIENTES,cpf,nome,enderecosCliente,contatosCliente);

        return cliente;
    }

    public static Endereco criaEndereco() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Tipo de endereço: ");
        int tipo = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Nome da rua: ");
        String rua = scanner.nextLine();
        System.out.println("Digite o número da residência: ");
        int num = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Digite o complemento do endereço: ");
        String complemento = scanner.nextLine();
        System.out.println("Digite o cep: ");
        String cep = scanner.nextLine();
        System.out.println("Digite a cidade: ");
        String cidade = scanner.nextLine();

        Endereco endereco = new Endereco(1,rua,num,complemento,cep,cidade);
        return endereco;
    }

    public  static Contato criaContato() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Descrição do contato: ");
        String descricao = scanner.nextLine();
        System.out.println("Telefone do cliente: ");
        String telefone = scanner.nextLine();
        System.out.println("Tipo de contato: 1- Residencial 2- Comercial: ");
        int num = scanner.nextInt();

        Contato contato = new Contato(descricao,telefone,num);
        return contato;

    }
    public static void MenuPrincial(){

        Scanner scanner = new Scanner(System.in);

        boolean programaOn = true;

        while (programaOn) {

            System.out.println("Qual ação deseja realizar? \n1- Cadastrar/deletar cadastro de Cliente \n2- Fazer/cancelar Pedido \n3- Financeiro \n4- Consultar Funcionários \n6- Listar itens \n7- Sair");

            int op = scanner.nextInt();

            switch (op) {

                case 1:

                    System.out.println("1 - Cadastrar novo cliente \n2- Deletar cliente: ");
                    int opCliente = scanner.nextInt();
                    if (opCliente == 1) {
                        criaCliente();
                    }
                    if (opCliente == 2) {
                        //Deleta Cliente
                    }
                    else {

                        System.out.println("Opcão inválida!");

                    }
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
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
