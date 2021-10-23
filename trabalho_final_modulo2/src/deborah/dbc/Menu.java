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
        System.out.println("******* Digite o id do cliente que deseja deletar *******");
        int idClienteDelete = scanner.nextInt();
        clienteService.removerCliente(idClienteDelete);
    }

    public static void alterarClienteVisual() {
        System.out.println("******* Qual Cliente você deseja editar *******");
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

            System.out.println("******* Digite o ID do cliente para adicionar contato *******");
            clienteService.listarCliente();
            int index = scanner.nextInt();
            scanner.nextLine();
            Cliente clienteContato = new Cliente();
            clienteContato.setIdCliente(index);
            cadastroContatoVisual(clienteContato);
        }

        if (opAlteracaoContato == 2) {
            System.out.println("\n********************* Lista de Clientes *********************\n");
            clienteService.listarCliente();
            System.out.println("******************************************\n");
            System.out.println("Digite o ID do cliente que deseja alterar o contato: ");
            int index = scanner.nextInt();
            scanner.nextLine();
            System.out.println("\n********************* Contados do cliente ******************\n");
            contatoService.listarContatoPorCodigoDaPessoa(index);
            System.out.println("Digite o ID do contato que deseja editar: ");
            int idContact = scanner.nextInt();
            scanner.nextLine();
            Contato contato = new Contato();
            System.out.println("Digite a descrição do contato: ");
            contato.setDescricao(scanner.nextLine());
            System.out.println("Digite o telefone do cliente: ");
            contato.setTelefone(scanner.nextLine());
            System.out.println("Tipo de contato:   1- Residencial    2- Comercial");
            contato.setTipo(TipoContato.ofTipo(scanner.nextInt()));
            contatoService.editar(idContact, contato);

        }
        if (opAlteracaoContato == 3) {
            System.out.println("\n********************* Lista de Clientes *********************\n");
            clienteService.listarCliente();
            System.out.println("******************************************\n");
            System.out.println("Digite o ID do cliente que deseja deletar o contato: ");
            int index = scanner.nextInt();
            scanner.nextLine();
            System.out.println("\n********************* Contatos do cliente ******************\n");
            contatoService.listarContatoPorCodigoDaPessoa(index);
            System.out.println("Digite o ID do contato que deseja deletar: ");
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
            System.out.println("******* Digite o ID do cliente para listar contato *******");
            int idCliente = scanner.nextInt();
            contatoService.listarContatoPorCodigoDaPessoa(idCliente);
        }

    }

    public static void alteraEnderecoClienteVisual() {
        System.out.println("\n********************* Lista de Clientes *********************\n");
        clienteService.listarCliente();
        System.out.println("******************************************\n");
        System.out.println("Digite o ID do cliente que deseja alterar endereço: ");
        int clientePrinc = scanner.nextInt();
        scanner.nextLine();
        System.out.println("1 - Adicionar Endereco     2- Editar Endereco existente  3- Deletar Endereco existente    4- Listar Enderecos Cadastrados: ");
        int opAlteracaoEndereco = scanner.nextInt();

        if (opAlteracaoEndereco == 1) {

            scanner.nextLine();
            Cliente clienteEndereco = new Cliente();
            clienteEndereco.setIdCliente(clientePrinc);
            Endereco endereco = cadastroEnderecoVisual(clienteEndereco);
            enderecoService.adicionarEndereco(endereco);
        }

        if (opAlteracaoEndereco == 2) {

            System.out.println("\n********************* Lista de Clientes *********************\n");
            clienteService.listarCliente();
            System.out.println("******************************************\n");
            Endereco endereco = new Endereco();
            System.out.println("\n********************* Endereço do cliente ******************\n");
            enderecoService.listarEnderecosPorCodigoDaPessoa(clientePrinc);
            System.out.println("Digite o ID do endereço que deseja editar: ");
            int idEnd = scanner.nextInt();
            scanner.nextLine();
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
            enderecoService.editar(idEnd,endereco);

        }
        if (opAlteracaoEndereco == 3) {

            System.out.println("\n********************* Lista de Clientes *********************\n");
            enderecoService.listar();
            System.out.println("******************************************\n");
            System.out.println("Qual Endereco você deseja excluir");
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
        if (opAlteracaoEndereco == 4) {
            enderecoService.listar();
        }
    }

    public static void menuPedido() {
        System.out.println("1- Criar novo Pedido \n2- Imprimir pedidos em aberto \n3- Alterar produto de pedido "); // O método deletar pedido não faz sentido porque é uma pilha.
        PedidoService pedidoService = new PedidoService();
        int opPedidos = scanner.nextInt();
        if (opPedidos == 1) {

            Pedido pedido = new Pedido();
            Produto produto = new Produto();
            PedidoProduto pedidoProduto = new PedidoProduto();
            //listar clientes
            System.out.println("******* Digite o id do cliente que deseja fazer o pedido *******");
            pedido.setIdCliente(scanner.nextInt());
            pedido = pedidoService.adicionarPedido(pedido);
            System.out.println("Qual produto deseja inserir: ");
            //listar produtos
            System.out.println("Digite o id do produto que deseja inserir: ");
            produto.setIdProduto(scanner.nextInt());
            System.out.println("Digite a quantidade: ");
            pedidoProduto.setQuantidade(scanner.nextInt());
            pedidoProduto.setPedido(pedido);
            pedidoProduto.setProduto(produto);
            pedidoService.adicionarProdutoNoPedido(pedidoProduto);

        }else if (opPedidos == 2) {  // imprimir os pedidos que estão no banco de dados
            pedidoService.listarPedidos();
        }
        else if (opPedidos == 3) { //alterar produto de pedido
            PedidoProduto pedidoProdutoAlterar = new PedidoProduto();
            Produto produtoAlterar = new Produto();
            Pedido pedidoAlterar = new Pedido();

            System.out.println("Qual pedido vai ser alterado? ");
            pedidoService.listarPedidos();
            System.out.println("Digite o id do pedido que deseja alterar: ");
            pedidoAlterar.setIdPedido(scanner.nextInt());
            System.out.println("Digite o id do produto que deseja alterar: ");
            produtoAlterar.setIdProduto(scanner.nextInt());
            System.out.println("Qual a quantidade? ");
            pedidoProdutoAlterar.setQuantidade(scanner.nextInt());

            pedidoProdutoAlterar.setPedido(pedidoAlterar);
            pedidoProdutoAlterar.setProduto(produtoAlterar);

            pedidoService.alterarProdutoDoPedido(pedidoProdutoAlterar);

        }
        else if (opPedidos == 4) {
            Produto produto = new Produto();
            PedidoProduto pedidoProduto = new PedidoProduto();

            System.out.println("Em qual o pedido vai ser incluido o produto? ");
            pedidoService.listarPedidos();

            System.out.println("Digite o id do pedido: ");
            Integer idPedido = scanner.nextInt();

            Pedido pedido = pedidoService.getPedidoPorId(idPedido);

            System.out.println("Qual produto deseja incluir?");
            // listar produto

            System.out.println("qual o id do produto: ");
            produto.setIdProduto(scanner.nextInt());

            System.out.println("Digite a quantidade: ");
            pedidoProduto.setQuantidade(scanner.nextInt());

            pedidoProduto.setPedido(pedido);
            pedidoProduto.setProduto(produto);

            pedidoService.adicionarProdutoNoPedido(pedidoProduto);
        }
        else if (opPedidos == 5) { //deletar produto do pedido
            Produto produto = new Produto();
            PedidoProduto pedidoProduto = new PedidoProduto();
            System.out.println("Qual pedido: ");
            pedidoService.listarPedidos();
            System.out.println("qual id pedido: ");
            Pedido pedido = pedidoService.getPedidoPorId(scanner.nextInt());
            System.out.println("Qual o produto: ");
            Integer idProduto = scanner.nextInt();
            produto.setIdProduto(idProduto);
            pedidoProduto.setProduto(produto);
            pedidoProduto.setPedido(pedido);
            pedidoService.deletarProdutoDoPedido(pedidoProduto);

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
        System.out.println("******* Digite o ID do produto que deseja alterar *******");
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

