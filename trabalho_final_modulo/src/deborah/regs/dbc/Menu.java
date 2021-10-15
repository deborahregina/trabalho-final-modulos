package deborah.regs.dbc;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
// Essa classe implementa os menus que vão ser utilizados ao longo do programa
    public static Funcionario MenuCadastroFuncionario() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("***Cadastro de Funcionários***");
        System.out.println("Digite o ID do funcionário: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Digite o nome do funcionário: ");
        String nome = scanner.nextLine();
        System.out.println();
        System.out.println("Digite o salário do funcionário: ");
        double salario = scanner.nextDouble();
        System.out.println("Qual o cargo do funcionário?  1- Motoboy    2- Atendente");
        int op = scanner.nextInt();
        scanner.nextLine();
        if (op == 1) {
            System.out.println("Digite a placa da moto: ");
            String placa = scanner.nextLine();
            System.out.println("Funcionário cadastrado!");
            Motoboy motoboy = new Motoboy(id,nome,salario,placa);
            return motoboy;
        }
        if (op == 2) {
            System.out.println("Funcionário cadastrado!");
            Atendente atendente = new Atendente(id,nome,salario);
            return atendente;

        }
        return null;

    }

    public static void menuImprimeFuncionario(ArrayList<Funcionario> funcionarios) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Deseja imprimir: 1- Todos os funcionários cadastrados   2- Funcionário específico: ");

        int opcaoFuncionario = scanner.nextInt();
        scanner.nextLine();

        if (opcaoFuncionario == 1) {

            if(!funcionarios.isEmpty()) {
                for (int i = 0; i < funcionarios.size(); i++) {
                    System.out.println(funcionarios.get(i).imprimir());
                }
            }
            else {
                System.out.println("Não há funcionários cadastrados!");
            }
        }

        if(opcaoFuncionario == 2) {
            if(!funcionarios.isEmpty()) {

                System.out.println("Digit eo id do funcionário: ");
                int id = scanner.nextInt();
                scanner.nextLine();

                for (int i = 0; i < funcionarios.size(); i++ ) {
                    if(funcionarios.get(i).getId() == id) {
                        System.out.println(funcionarios.get(i).imprimir());
                    }
                }
            }
        }

    }

    public static Cliente criaCliente() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o ID do cliente: ");
        int id = scanner.nextInt();
        scanner.nextLine();
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

        Cliente cliente = new Cliente(id,cpf,nome,enderecosCliente,contatosCliente);

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
    public static int MenuPrincial() {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Qual ação deseja realizar? \n1- Cadastrar/deletar cadastro de Cliente \n2- Fazer/cancelar Pedido \n3- Financeiro \n4- Consultar/cadastrar Funcionários \n6- Listar itens \n7- Sair");

        int op = scanner.nextInt();

        return op;

    }

    public static Cliente MenuDeletaCliente(ArrayList<Cliente> clientes) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o ID do cliente que deseja deletar: ");
        int id = scanner.nextInt();

        for (int i = 0; i < clientes.size(); i++) {

            if (clientes.get(i).getId() == id) {

                return clientes.get(i);

            }

            else {

                System.out.println("Cliente não encontrado! ");

            }
        }
        return null;
    }
    public static void menuImprimeCliente(ArrayList<Cliente> clientes) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Deseja imprimir: 1- Todos os clientes: 2- Cliente específico: ");
        int op = scanner.nextInt();

        if (op == 1 && !clientes.isEmpty()) {
            for (int i = 0; i < clientes.size(); i ++) {
                System.out.println(clientes.get(i).imprimir());
            }
        }
        if (op == 2 && !clientes.isEmpty()) {
            System.out.println("Digite o id do cliente que deseja imprimir: ");
            int id = scanner.nextInt();

            for (int j = 0; j < clientes.size(); j ++) {
                if (id == clientes.get(j).getId()) {
                    System.out.println(clientes.get(j).imprimir());
                }
            }
        }
        if (clientes.isEmpty()) {
            System.out.println("É necessário cadastrar um cliente antes!");
        }

    }



}
