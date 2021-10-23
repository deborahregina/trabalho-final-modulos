package deborah.dbc;

import deborah.dbc.model.*;
import deborah.dbc.service.*;


import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {

    static Scanner scanner = new Scanner(System.in);
    static ContatoService contatoService = new ContatoService();
    static ClienteService clienteService = new ClienteService();
    static EnderecoService enderecoService = new EnderecoService();
    static ProdutoService produtoService = new ProdutoService();

    public static void menuClientes() {

        System.out.println("O que deseja fazer? 1- Cadastrar novo cliente  2- Imprimir dados dos clientes  3- Alterar dados cadastrais do cliente  4- Deletar registro cliente: ");
        int opCliente = scanner.nextInt();
        scanner.nextLine();
        if (opCliente == 1) {
            cadastroClienteVisual();
        }
        if (opCliente == 2) {
            clienteService.listarCliente();
        }
        if (opCliente == 3) {
            System.out.println("Deseja:  1- Alterar dados do cliente     2- Alterar endereços do cliente        3- Alterar contatos do cliente: ");
            int opAlteracao = scanner.nextInt();
            if (opAlteracao == 1) {
                alterarClienteVisual();
            }

            if (opAlteracao == 2) {
                alteraEnderecoClienteVisual();
            }
            if (opAlteracao == 3) {
                alteraContatoClienteVisual();
            }
        }
        if (opCliente == 4) {
            System.out.println("Digite o ID do cliente que deseja remover: ");
            clienteService.listarCliente();
            int idRemoveCliente = scanner.nextInt();
            clienteService.removerCliente(idRemoveCliente);
        }

    }

    public static Cliente cadastroClienteVisual() {
        Cliente clienteCadastro = new Cliente();


        System.out.println("Digite o nome do cliente: ");
        clienteCadastro.setNome(scanner.nextLine());
        System.out.println("Digite o CPF do cliente: ");
        clienteCadastro.setCpf(scanner.nextLine());

        clienteService.adicionarCliente(clienteCadastro); // adiciona o cliente na tabela de clientes

        boolean menuEnderecos = true;
        while (menuEnderecos) {
            System.out.println("CADASTRAR ENDEREÇO PARA O CLIENTE: ");
            cadastroEnderecoVisual(clienteCadastro); //Esse método adiciona o endereço no banco de dados.
            System.out.println("Deseja Cadastrar novo endereço?  1- Sim    2- Não: ");
            int opcaoNovoCadastroEndereco = scanner.nextInt();
            scanner.nextLine();
            if (opcaoNovoCadastroEndereco == 2) {
                menuEnderecos = false;
            }
        }

        boolean menuContatos = true;
        while (menuContatos) {
            System.out.println("CADASTRAR CONTATO PARA O CLIENTE: ");
            cadastroContatoVisual(clienteCadastro); // Esse método adiciona o contato no banco de dados
            System.out.println("Deseja cadastrar novo contato?  1- Sim    2- Não: ");
            int opcaoNovoCadastroContato = scanner.nextInt();
            scanner.nextLine();
            if (opcaoNovoCadastroContato == 2) {
                menuContatos = false;
            }

        }

        return clienteCadastro;
    }

    public static Endereco cadastroEnderecoVisual(Cliente cliente) {
        Endereco endereco = new Endereco();
        System.out.println("Digite o logradouro: ");
        endereco.setLogradouro(scanner.nextLine());
        System.out.println("Digite o número: ");
        endereco.setNumero(scanner.nextInt());
        scanner.nextLine();
        System.out.println("Digite o bairro: ");
        endereco.setBairro(scanner.nextLine());
        System.out.println("Digite o CEP: ");
        endereco.setCep(scanner.nextLine());
        System.out.println("Tipo de endereço:  1- Residencial   2- Comercial: ");
        endereco.setTipo(TipoEndereco.ofTipo(scanner.nextInt()));

        endereco.setCliente(cliente);
        enderecoService.adicionarEndereco(endereco);

        return endereco;
    }

    public static Contato cadastroContatoVisual(Cliente cliente) {
        Contato contato = new Contato();
        System.out.println("Digite a descrição do contato: ");
        contato.setDescricao(scanner.nextLine());
        System.out.println("Digite o telefone do cliente: ");
        contato.setTelefone(scanner.nextLine());
        System.out.println("Tipo de endereço:   1- Residencial    2- Comercial");
        contato.setTipo(TipoContato.ofTipo(scanner.nextInt()));
        contato.setCliente(cliente);

        contatoService.adicionarContato(contato);

        return contato;

    }

    public static void excluirClienteVisual() {
        clienteService.listarCliente();
        System.out.println("Digite o id do cliente que deseja deletar: ");
        int idClienteDelete = scanner.nextInt();
        //enderecoService.removerEndereco(id_endereco);
        //contatoService.removerContato(idContato);
        clienteService.removerCliente(idClienteDelete);
    }

    public static void alterarClienteVisual() {
        System.out.println("Qual Cliente você deseja editar?");
        clienteService.listarCliente();
        int index = scanner.nextInt();
        scanner.nextLine();
        Cliente ClienteNovo = new Cliente();
        System.out.println("Digite o nome do Cliente: ");
        ClienteNovo.setNome(scanner.nextLine());
        System.out.println("Digite o CPF: ");
        ClienteNovo.setCpf(scanner.nextLine());

        clienteService.editarCliente(index, ClienteNovo);
    }

    public static void alteraContatoClienteVisual() {

        System.out.println("1 - Adicionar contato       2- Editar contato existente  3- Deletar contato existente  4- Listar contados do cliente: ");
        int opAlteracaoContato = scanner.nextInt();

        if (opAlteracaoContato == 1) {

            System.out.println("Digite o ID do cliente para adicionar contato: ");
            clienteService.listarCliente();
            int index = scanner.nextInt();
            scanner.nextLine();
            Cliente clienteContato = new Cliente();
            clienteContato.setIdCliente(index);
            Contato contato = cadastroContatoVisual(clienteContato);
            contatoService.adicionarContato(contato);
        }

        if (opAlteracaoContato == 2) {
            System.out.println("Digite o contato que deseja editar: ");
            contatoService.listar();
            int index = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Digite o ID do cliente que deseja alterar o contato: ");
            //ClienteService.listarCliente();
            Cliente cliente = new Cliente();
            cliente.setIdCliente(scanner.nextInt());
            Contato contato = cadastroContatoVisual(cliente);
            contatoService.editar(index, contato);

        }
        if (opAlteracaoContato == 3) {
            System.out.println("Qual contato você deseja excluir?");
            contatoService.listar();
            boolean validouNumero = false;
            while (!validouNumero) {
                try {
                    int id = scanner.nextInt();
                    contatoService.remover(id);
                    validouNumero = true;
                } catch (InputMismatchException ex) {
                    System.err.println("numero invalido");
                }

            }
        }
        if (opAlteracaoContato == 4) {
            clienteService.listarCliente();
            System.out.println("Digite o ID do cliente para listar contato: ");
            int idCliente = scanner.nextInt();
            contatoService.listarContatoPorCodigoDaPessoa(idCliente);
        }

    }

    public static void alteraEnderecoClienteVisual() {

        System.out.println("1 - Adicionar Endereco       2- Editar Endereco existente  3- Deletar Endereco existente: ");
        int opAlteracaoEndereco = scanner.nextInt();

        if (opAlteracaoEndereco == 1) {

            System.out.println("Digite o ID do cliente para adicionar Endereco: ");
            clienteService.listarCliente();
            int index = scanner.nextInt();
            scanner.nextLine();
            Cliente clienteContato = new Cliente();
            clienteContato.setIdCliente(index);
            Endereco endereco = cadastroEnderecoVisual(clienteContato);
            enderecoService.adicionarEndereco(endereco);
        }

        if (opAlteracaoEndereco == 2) {
            System.out.println("Digite o Endereco que deseja editar: ");
            enderecoService.listar();
            int index = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Digite o ID do cliente que deseja alterar o Endereco: ");
            clienteService.listarCliente();
            Cliente cliente = new Cliente();
            cliente.setIdCliente(scanner.nextInt());
            Endereco endereco = cadastroEnderecoVisual(cliente);
            enderecoService.editar(index, endereco);

        }
        if (opAlteracaoEndereco == 3) {
            System.out.println("Qual Endereco você deseja excluir?");
            enderecoService.listar();
            boolean validouNumero = false;
            while (!validouNumero) {
                try {
                    int id = scanner.nextInt();
                    enderecoService.remover(id);
                    validouNumero = true;
                } catch (InputMismatchException ex) {
                    System.err.println("numero invalido");
                }

            }
        }
    }

    public static void menuPedido() {
        System.out.println("1- Criar novo Pedido \n2- Imprimir pedidos em aberto \n3- Alterar produto de pedido "); // O método deletar pedido não faz sentido porque é uma pilha.

        int opPedidos = scanner.nextInt();
        if (opPedidos == 1) {
            PedidoService pedidoService = new PedidoService();
            Pedido pedido = new Pedido();
            System.out.println("Digite o id do cliente que deseja fazer o pedido:");
            pedido.setIdCliente(scanner.nextInt());
            pedidoService.adicionarPedido(pedido);
        }
    }

    public static void menuAdicionaProduto() {
        Produto produto = new Produto();
        System.out.println("Digite o tipo de produto   1- Comida     2- Bebida");
        int tipoProduto = scanner.nextInt();
        scanner.nextLine();
        produto.setTipoProduto(TipoProduto.ofTipo(tipoProduto));
        System.out.println("Digite a descrição do produto: ");
        produto.setDescrição(scanner.nextLine());
        System.out.println("Digite o valor unitário do produto: ");
        produto.setValorUnitario(scanner.nextDouble());

        produtoService.adicionarProduto(produto);

    }

    public static void menuAlteraProduto() {
        Produto produto = new Produto();
        produtoService.listar();
        System.out.println("Digite o ID do produto que deseja alterar: ");
        int index = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Digite o tipo de produto   1- Comida     2- Bebida");
        int tipoProduto = scanner.nextInt();
        scanner.nextLine();
        produto.setTipoProduto(TipoProduto.ofTipo(tipoProduto));
        System.out.println("Digite a descrição do produto: ");
        produto.setDescrição(scanner.nextLine());
        System.out.println("Digite o valor unitário do produto: ");
        produto.setValorUnitario(scanner.nextDouble());

        produtoService.editar(index, produto);
    }
}

