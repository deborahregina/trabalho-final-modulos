package deborah.dbc;

import deborah.dbc.exceptions.BancoDeDadosException;
import deborah.dbc.model.Contato;
import deborah.dbc.model.Endereco;
import deborah.dbc.model.TipoContato;
import deborah.dbc.model.TipoEndereco;
import deborah.dbc.service.*;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws BancoDeDadosException {

        ContatoService contatoService = new ContatoService();
        ClienteService clienteService = new ClienteService();
        ProdutoService produtoService = new ProdutoService();
        EnderecoService enderecoService = new EnderecoService();
        PedidoService pedidoService = new PedidoService();

        Scanner scanner = new Scanner(System.in);
        boolean programaOn = true;
        while(programaOn) {
            System.out.println("\n*** MENU PRINCIPAL ***\n \n1- MENU CLIENTES \n2- MENU ENDERECOS \n3- MENU CONTATOS \n4- MENU PRODUTOS \n5- MENU PEDIDOS\n6- MENU ENTREGAS\n7- SAIR: \nO QUE DESEJA ACESSAR:");
            int opcaoPrincipal = scanner.nextInt();
            scanner.nextLine();

            switch (opcaoPrincipal) {
                case 1:
                    Menu.menuClientes();
                    break;
                case 2:
                    System.out.println("\n1- Listar enderecos cadastrados       2- Filtrar endereços por ID de cliente       3- Deletar endereço cadastrado       4- Alterar endereço cadastrado: ");
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
                        Endereco endereco = new Endereco();
                        enderecoService.listar();
                        System.out.println("Digite o ID do endereço que deseja alterar: ");
                        int idAlteraEnd = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Digite o logradouro: ");
                        endereco.setLogradouro(scanner.nextLine());
                        System.out.print("Digite o número: ");
                        endereco.setNumero(scanner.nextInt());
                        scanner.nextLine();
                        System.out.print("Digite o bairro: ");
                        endereco.setBairro(scanner.nextLine());
                        System.out.print("Digite o CEP: ");
                        endereco.setCep(scanner.nextLine());
                        System.out.print("Tipo de endereço:  1- Residencial   2- Comercial: ");
                        endereco.setTipo(TipoEndereco.ofTipo(scanner.nextInt()));
                        enderecoService.editar(idAlteraEnd,endereco);

                    }
                    break;
                case 3:
                    System.out.println("\n1- Listar contatos cadastrados       2- Filtrar contato por ID de cliente       3- Deletar contato       4- Alterar contato cadastrado: ");
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
                    if (opContatos == 4) {
                        contatoService.listar();
                        System.out.println("Digite o ID do contato que deseja alterar: ");
                        int idAlteraContato = scanner.nextInt();
                        scanner.nextLine();
                        Contato contato = new Contato();
                        System.out.println("Digite a descrição do contato: ");
                        contato.setDescricao(scanner.nextLine());
                        System.out.println("Digite o telefone do cliente: ");
                        contato.setTelefone(scanner.nextLine());
                        System.out.println("Tipo de contato:   1- Residencial    2- Comercial");
                        contato.setTipo(TipoContato.ofTipo(scanner.nextInt()));
                        contatoService.editar(idAlteraContato, contato);
                    }
                    break;
                case 4:
                    System.out.println("\n1- Cadastrar novo produto       2- Deletar produto cadastrado       3- Listar produtos cadastrados       4- Alterar produto       5- Filtrar produtos por pedido: ");
                    int opProduto = scanner.nextInt();
                    scanner.nextLine();
                    if (opProduto == 1) {
                        Menu.menuAdicionaProduto();
                    }
                    if (opProduto == 2) {
                        produtoService.listar();
                        System.out.println("Digite o ID do produto que deseja deletar: ");
                        int idProduto = scanner.nextInt();
                        scanner.nextLine();
                        pedidoService.removerProdutoDePedidoProduto(idProduto);
                        produtoService.remover(idProduto);
                    }
                    if (opProduto == 3) {
                        produtoService.listar();
                    }
                    if (opProduto == 4) {
                        Menu.menuAlteraProduto();
                    }
                    if (opProduto == 5) {
                        System.out.println("Digite o ID do pedido para listar produtos: ");
                        int idPedido = scanner.nextInt();
                        scanner.nextLine();
                        produtoService.listarPorPedido(idPedido);
                    }
                    break;
                case 5:
                    Menu.menuPedido();
                    break;
                case 6:
                    Menu.menuEntrega();
                    break;
                case 7:
                    programaOn = false;
                    break;
                default:
                    System.out.println("Digite opção válida!");
            }
        }
    }
}
