package deborah.dbc;

import deborah.dbc.exceptions.BancoDeDadosException;
import deborah.dbc.service.ClienteService;
import deborah.dbc.service.ContatoService;
import deborah.dbc.service.EnderecoService;
import deborah.dbc.service.ProdutoService;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws BancoDeDadosException {

        ContatoService contatoService = new ContatoService();
        ClienteService clienteService = new ClienteService();
        ProdutoService produtoService = new ProdutoService();
        EnderecoService enderecoService = new EnderecoService();

        Scanner scanner = new Scanner(System.in);
        boolean programaOn = true;
        while(programaOn) {
            System.out.println("*** MENU PRINCIPAL *** \nO QUE DESEJA ACESSAR: \n1- MENU CLIENTES \n2- MENU ENDERECOS \n3- MENU CONTATOS \n5- MENU PEDIDOS\n6- MENU PRODUTOS\n7- MENU ENTREGAS\n8- SAIR: ");
            int opcaoPrincipal = scanner.nextInt();
            scanner.nextLine();

            switch (opcaoPrincipal) {
                case 1:
                    Menu.menuClientes();
                    break;
                case 2:
                    System.out.println("1- Listar enderecos cadastrados    2- Listar endereco por pessoa  ");
                    int opEnderecos = scanner.nextInt();
                    if (opEnderecos == 1) {
                        enderecoService.listar();
                    }
                    if (opEnderecos == 2) {
                        System.out.println("Digite o ID do Cliente: ");
                        int idCliente = scanner.nextInt();
                        enderecoService.listarEnderecosPorCodigoDaPessoa(idCliente);
                    }
                    if (opEnderecos == 3) {
                        enderecoService.listar();
                        System.out.println("Digite o ID endereço que deseja deletar: ");
                        int idDeletaEnd = scanner.nextInt();
                        scanner.nextLine();
                        enderecoService.remover(idDeletaEnd);
                    }
                    if (opEnderecos == 4) {
                        enderecoService.listar();
                        System.out.println("Digite o ID do endereço que deseja alterar: ");
                        int idAlteraEnd = scanner.nextInt();
                        scanner.nextLine();
                        clienteService.listarCliente();
                    }
                    break;
                case 3:
                    System.out.println("1- Listar contatos cadastrados     2- Listar contato por pessoa   3- Deletar contato: ");
                    int opContatos = scanner.nextInt();
                    scanner.nextLine();
                    if (opContatos == 1) {
                        contatoService.listar();
                    }
                    if (opContatos == 2) {
                        System.out.println("Digite o ID do cliente: ");
                        int idClienteContato = scanner.nextInt();
                        contatoService.listarContatoPorCodigoDaPessoa(idClienteContato);
                    }
                    if (opContatos == 3) {
                        contatoService.listar();
                        System.out.println("Digite o ID do contato que deseja deletar: ");
                        int idDeletaCont = scanner.nextInt();
                        scanner.nextLine();
                        contatoService.remover(idDeletaCont);
                    }
                    break;
                case 4:
                    break;
                case 5:
                    Menu.menuPedido();
                    break;
                case 6:
                    System.out.println("1- Cadastrar novo produto     2- Deletar produto cadastrado    3- Listar produtos cadastrados    4- Alterar produto");
                    int opProduto = scanner.nextInt();
                    scanner.nextLine();
                    if (opProduto == 1) {
                        Menu.menuAdicionaProduto();
                    }
                    if (opProduto == 2) {
                        produtoService.listar();
                        System.out.println("Digite o ID do produto que deseja alterar: ");
                        int idProduto = scanner.nextInt();
                        produtoService.remover(idProduto);
                    }
                    if (opProduto == 3) {
                        produtoService.listar();
                    }
                    if (opProduto == 4) {
                        Menu.menuAlteraProduto();
                    }

                    break;
            }
        }
    }
}
