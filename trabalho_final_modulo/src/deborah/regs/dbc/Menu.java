package deborah.regs.dbc;

import java.util.*;

public class Menu {
// Essa classe implementa os menus que vão ser utilizados ao longo do programa

    public static int menuPrincipal() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("############# Menu Principal ############# ");
        System.out.println("Qual opção deseja acessar? \n1- Menu Clientes \n2- Menu Pedidos \n3- Informações caixa \n4- Menu Funcionários \n5- Menu Produtos \n6- Realizar Entrega \n7- Sair");

        int op = scanner.nextInt();

        return op;

    }

    // Menus de funcionários: Cadastra funcionário, lista funcionário, exclui funcionário, Edita funcionário

    public static Funcionario menuCadastroFuncionario() { // Serve para cadastrar funcionário novo, do tipo Atendente ou Motoboy

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

    public static void menuAlteraFuncionario() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o ID do funcionário para alterar suas informações: ");
        int idFunc = scanner.nextInt();
        for (int i = 0; i < Main.funcionarios.size(); i++ ) {
            if (Main.funcionarios.get(i).getId() == idFunc){
                scanner.nextLine();
                System.out.println("Digite o nome do funcionário: ");
                String nome = scanner.nextLine();
                System.out.println();
                System.out.println("Digite o salário do funcionário: ");
                double salario = scanner.nextDouble();
                Main.funcionarios.get(i).setNome(nome);
                Main.funcionarios.get(i).setSalario(salario);
            }
        }
    }

    public static void menuDeletaFuncionario() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o ID do funcionário que deseja deletar: ");
        int idDeleta = scanner.nextInt();
        for (int i = 0; i < Main.funcionarios.size(); i++ ) {
            if (Main.funcionarios.get(i).getId() == idDeleta){
                System.out.println("Funcionário " + Main.funcionarios.get(i).getNome() + " deletado!");
                Main.funcionarios.remove(i);
            }
        }
    }

    public static void menuImprimeFuncionario(ArrayList<Funcionario> funcionarios) { //Lista todos os funcionários, ou um funcionário específico, por ID

        Scanner scanner = new Scanner(System.in);

        System.out.println("Deseja imprimir: 1- Todos os funcionários cadastrados   2- Funcionário específico: ");

        int opcaoFuncionario = scanner.nextInt();
        scanner.nextLine();

        if (opcaoFuncionario == 1) {

            if (!funcionarios.isEmpty()) {
                System.out.println("+++++++++ Lista de Funcionários Cadastrados +++++++++");
                List<Funcionario> funcionarioList = funcionarios;
                for (Funcionario funcionario : funcionarioList) {
                    System.out.println(funcionario.imprimir());
                }
            } else {
                System.out.println("Não há funcionários cadastrados!");
            }
        }

        if (opcaoFuncionario == 2) {
            if (!funcionarios.isEmpty()) {

                System.out.println("Digite o id do funcionário: ");
                int id = scanner.nextInt();
                scanner.nextLine();

                for (int i = 0; i < funcionarios.size(); i++) {
                    if (funcionarios.get(i).getId() == id) {
                        System.out.println(funcionarios.get(i).imprimir());
                        System.out.println();
                    }
                }
            }
        }
    }



    // Menus produto: menuCadastraProduto, menuImprimeProdutos, menuDeletaProduto, menuEditaProduto
    public static void menuCadastraProduto() { //Serve para cadastrar um novo produto
        Scanner scanner = new Scanner(System.in);

        System.out.println("Escolha um produto: (Digitando o número indicado no cardápio)");
        System.out.println(TipoProduto.imprimeCardapio());
        TipoProduto tipoProduto = TipoProduto.COMIDA_TAILANDESA;
        tipoProduto = tipoProduto.escolheTipo(tipoProduto);
        System.out.println("Digite o id do produto: ");
        int id = scanner.nextInt();
        System.out.println("Digite o valor unitário do produto: ");
        double valorUnitario = scanner.nextDouble();

        Produto produto = new Produto(id,valorUnitario,tipoProduto);

        Main.produtos.add(produto);
    }

    public static void menuDeletaProduto() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o ID do produto que deseja deletar: ");
        int idProduto = scanner.nextInt();

        for (int i = 0; i < Main.produtos.size(); i++ ){
            if (Main.produtos.get(i).getIdProduto() == idProduto) {
                Main.produtos.remove(i);
                break;
            }
        }
    }

    public static void menuAlteraProduto() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o ID do produto que deseja alterar: ");
        int idProduto = scanner.nextInt();

        for(Produto produto : Main.produtos) {

            if (produto.getIdProduto() == idProduto) {
                System.out.println(TipoProduto.imprimeCardapio());
                TipoProduto tipoProduto = TipoProduto.COMIDA_TAILANDESA;
                tipoProduto = tipoProduto.escolheTipo(tipoProduto);

                System.out.println("Digite o novo valor unitário do produto: ");
                double valorUnitario = scanner.nextDouble();

                produto.setTipoProduto(tipoProduto);
                produto.setValorUnitario(valorUnitario);
                break;

            }
        }

    }

    public static void menuImprimeProdutos(ArrayList<Produto> produtos) {       //Imprime a lista de produtos cadastrados, ou um produto específico, por ID

        Scanner scanner = new Scanner(System.in);
        System.out.println("1- Listar todos os produtos     2- Listar produto específico: ");
        int opProduto = scanner.nextInt();

        if (opProduto == 1){
            System.out.println("+++++++++ Lista de Produtos Cadastrados +++++++++");
            for (Produto produto : produtos) {
                System.out.println(produto.toString());
            }
        }
        if (opProduto == 2) {
            System.out.println("Digite o id do produto que deseja imprimir: ");
            int id = scanner.nextInt();
            scanner.nextLine();
            for (int i = 0; i < produtos.size(); i++) {
                if (id == produtos.get(i).getIdProduto()) {
                    System.out.println(produtos.get(i).toString());
                }
            }
        }
    }



    // Menus de cliente: criacliente, imprimecliente, deletacliente, editacliente

    public static Cliente menuCriaCliente() {       //Cria cliente, tem que cadastrar os dados do cliente, pelo menos um contato e pelo menos um endereço.

        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o ID do cliente: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Digite o nome do Cliente: ");
        String nome = scanner.nextLine();
        System.out.println("Digite o cpf do Cliente: ");
        String cpf = scanner.nextLine();
        System.out.println("**Cadastrar Contato do Cliente**");
        Contato contato1 = menuCriaContato();
        ArrayList <Contato> contatosCliente = new ArrayList<>();
        contatosCliente.add(contato1);
        System.out.println("Deseja cadastrar um contato secundário? 1- Sim 2- Não: ");
        int opcao = scanner.nextInt();
        if (opcao == 1){
            Contato contato2 = menuCriaContato();
            contatosCliente.add(contato2); // Adiciona o segundo contato do cliente, caso queira ser adicionado
        }

        System.out.println("**Cadastrar endereço princial**");
        Endereco endereco1 = menuCriaEndereco();
        ArrayList <Endereco> enderecosCliente = new ArrayList<>();
        enderecosCliente.add(endereco1);
        System.out.println("Deseja cadastrar um endereço secundário? 1- Sim  2- Não: ");

        int op = scanner.nextInt();
        if (op == 1) {
            Endereco endereco2 = menuCriaEndereco();
            enderecosCliente.add(endereco2); // adiciona o segundo endereço do cliente, caso queira ser adicionado
        }

        Cliente cliente = new Cliente(id,cpf,nome,enderecosCliente,contatosCliente);

        return cliente;
    }

    public static void menuDeletaCliente(ArrayList<Cliente> clientes) {  // Serve para deletar um cliente, está funcionando ok.

        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o ID do cliente que deseja deletar: ");
        int id = scanner.nextInt();
        for (int i = 0; i < clientes.size(); i++) {
            if (clientes.get(i).getId() == id) {
                clientes.remove(i);
            }
            else {
                System.out.println("Cliente não encontrado! ");
            }
        }
    }


    public static void menuImprimeCliente(ArrayList<Cliente> clientes) {        //Imprime todos os clientes, ou um cliente específico, por ID

        Scanner scanner = new Scanner(System.in);

        System.out.println("Deseja imprimir: 1- Todos os clientes: 2- Cliente específico: ");
        int op = scanner.nextInt();

        System.out.println("+++++++++ Lista de Clientes Cadastrados +++++++++");
        if (op == 1 && !clientes.isEmpty()) {
            for (Cliente cliente : clientes) {
                System.out.println(cliente.imprimir());
                System.out.println("+++++++++++++++++++++++++++");
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

    public static void menuAlteraCliente() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o ID do cliente que deseja modificar: ");
        int idCliente = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < Main.clientes.size(); i ++) {
            if (Main.clientes.get(i).getId() == idCliente) {

                System.out.println("Digite o nome do Cliente: ");
                String nome = scanner.nextLine();
                System.out.println("Digite o cpf do Cliente: ");
                String cpf = scanner.nextLine();
                Main.clientes.get(i).setNome(nome);
                Main.clientes.get(i).setCpf(cpf);


                System.out.println("Deseja alterar o endereço principal do cliente?     1- Não      2- Sim");

                int opAlteracaoEndereco = scanner.nextInt();
                scanner.nextLine();
                if (opAlteracaoEndereco == 2) {
                   menuAlteraEndereco(i,0);
                    if (Main.clientes.get(i).getEnderecos().size() == 2) {
                        System.out.println("Deseja alterar o endereço secundário?   1- Não      2- Sim");
                        int opDeletaEnd = scanner.nextInt();

                        if (opDeletaEnd == 2) {
                            menuAlteraEndereco(i,1);
                        }
                    }


                }
                System.out.println("Deseja alterar o contato principal do cliente?      1- Não      2- Sim");
                int opAlteracaoContato = scanner.nextInt();
                scanner.nextLine();
                if (opAlteracaoContato == 2) {
                    menuAlteraContato(i,0);
                    if (Main.clientes.get(i).getContatos().size() == 2) {
                        System.out.println("Deseja alterar o contato secundário do cliente?     1- Não      2- Sim");
                        int opDeletaCont = scanner.nextInt();
                        if (opDeletaCont == 2) {
                            menuAlteraContato(i,1);
                        }
                    }
                }
            }
        }
    }

    public static Endereco menuCriaEndereco() {     //Cria endereço, é chamado por criaCliente

        Scanner scanner = new Scanner(System.in);

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
        System.out.println("Tipo de endereço: Residencial      Comercial");
        String tipoEndreco = scanner.nextLine();

        Endereco endereco = new Endereco(TipoEndereco.valueOf(tipoEndreco.toUpperCase(Locale.ROOT)),rua,num,complemento,cep,cidade);

        return endereco;

    }

    public static void menuDeletaEndereco(ArrayList<Endereco> enderecos, Endereco endereco) {
        enderecos.remove(endereco);
    }

    public static void menuAlteraContato(int i,int j) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Descrição do contato: ");
        String descricao = scanner.nextLine();
        System.out.println("Telefone do cliente: ");
        String telefone = scanner.nextLine();
        System.out.println("Tipo de contato:  Celular    Telefone Fixo: ");
        String tipoContato = scanner.nextLine();


        if (tipoContato.toUpperCase(Locale.ROOT).equalsIgnoreCase("Telefone Fixo")) {
            tipoContato = "TELEFONEFIXO";
        }

        Main.clientes.get(i).getContatos().get(j).setDescricao(descricao);
        Main.clientes.get(i).getContatos().get(j).setTelefone(telefone);
        Main.clientes.get(i).getContatos().get(j).setTipo(TipoContato.valueOf(tipoContato.toUpperCase(Locale.ROOT)));

    }

    public static void menuAlteraEndereco(int i,int j) {

        Scanner scanner = new Scanner(System.in);
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
        System.out.println("Tipo de endereço: Residencial      Comercial");
        String tipoEndreco = scanner.nextLine();

        Main.clientes.get(i).getEnderecos().get(j).setNumero(num);
        Main.clientes.get(i).getEnderecos().get(j).setComplemento(complemento);
        Main.clientes.get(i).getEnderecos().get(j).setCidade(cidade);
        Main.clientes.get(i).getEnderecos().get(j).setCep(cep);
        Main.clientes.get(i).getEnderecos().get(j).setRua(rua);
        Main.clientes.get(i).getEnderecos().get(j).setTipo(TipoEndereco.valueOf(tipoEndreco.toUpperCase(Locale.ROOT)));
    }

    public static void menuImprimeEndereco(ArrayList<Endereco> enderecos) {
        for(Endereco endereco : enderecos){
         System.out.println(endereco.imprimir());
      }
    }

    public static void menuImprimeContato(ArrayList<Contato> contatos) {
        for (Contato contato : contatos){
            System.out.println(contato.imprimir());
        }
    }

    public static Contato menuCriaContato() {      //cria contato, é chamado por cria cliente
        Scanner scanner = new Scanner(System.in);

        System.out.println("Descrição do contato: ");
        String descricao = scanner.nextLine();
        System.out.println("Telefone do cliente: ");
        String telefone = scanner.nextLine();
        System.out.println("Tipo de contato:  Celular    Telefone Fixo: ");
        String tipoContato = scanner.nextLine();
        if (tipoContato.equalsIgnoreCase("Telefone Fixo")) {
            tipoContato = "TELEFONEFIXO";
        }

        Contato contato = new Contato(descricao,telefone,TipoContato.valueOf(tipoContato.toUpperCase(Locale.ROOT)));
        return contato;

    }

    public static void menuDeletaContato(ArrayList<Contato> contatos, Contato contato) {
        contatos.remove(contato);
    }

    public static void menuImprimeCaixa(Caixa caixa) {          // Imprime as informações do caixa
        System.out.println("---------- Informações do Caixa ----------");
        System.out.println(caixa.toString());
    }


    public static void menuImprimePedidosEmAberto() { //O valor total é calculado só para o último pedido, pois ele pode ser alterado
        System.out.println("+++++++++ Lista de Pedidos Abertos +++++++++");

        for (Pedido pedido : Main.pedidos) {
            pedido.calculaValorTotal();
            System.out.println(pedido);
        }
    }

    public static void menuCriaPedido() {
        Scanner scanner = new Scanner(System.in);

        ArrayList<Produto> produtosdoPedido = new ArrayList<>();
        System.out.println("Digite o ID do cliente que realizou o pedido: ");
        int idCliente = scanner.nextInt();
        Cliente clientePedido = new Cliente();
        for(Cliente cliente : Main.clientes) {
            if (cliente.getId() == idCliente) {
                 clientePedido = cliente;
                break;
            }
        }
        System.out.println("Digite o ID do novo pedido: ");
        int idPedidoNovo = scanner.nextInt();

        System.out.println("*** Lista de produtos: ");
        menuImprimeProdutos(Main.produtos);

        int adicionaMais = 1;
        do {
            System.out.println("Digite o ID do produto que deseja incluir no pedido: ");
            int idProduto = scanner.nextInt();

            for (Produto produto : Main.produtos) {
                if (produto.getIdProduto() == idProduto) {
                    Produto produtoPedido = produto;
                    produtosdoPedido.add(produtoPedido);
                    break;
                }
            }
            System.out.println("Deseja cadastrar mais um produto no pedido?     1- Sim      2- Não");
            adicionaMais = scanner.nextInt();
            }while (adicionaMais != 2);

            Pedido novoPedido = new Pedido(idPedidoNovo,clientePedido,produtosdoPedido);
            Main.pedidos.add(novoPedido);

        }

    public static void menuAlteraItemPedido(Pedido pedido) {

        Scanner scanner = new Scanner(System.in);

        pedido.toString();

        System.out.println("Deseja 1- Excluir item      2- Incluir Item");
        int opOqueAlterar = scanner.nextInt();
        scanner.nextLine();
        if (opOqueAlterar == 1) {
            System.out.println("Digite o ID do item que deseja excluir: ");
            int idExclui = scanner.nextInt();

            for (Produto prod : pedido.getProdutosDoPedido()) {
                if (prod.getIdProduto() == idExclui) {
                    pedido.getProdutosDoPedido().remove(prod);
                }
            }
            System.out.println("Pedido Alterado: ");
            pedido.toString();
        }
        if (opOqueAlterar == 2) {
            int adicionaMais = 1;
            System.out.println("*** Lista de produtos: ");
            menuImprimeProdutos(Main.produtos);
            do {
                System.out.println("Digite o ID do produto que deseja incluir no pedido: ");
                int idProduto = scanner.nextInt();
                for (Produto produtoadd : Main.produtos) {
                    if (produtoadd.getIdProduto() == idProduto) {
                        pedido.getProdutosDoPedido().add(produtoadd);
                    }
                }
                System.out.println("Deseja cadastrar mais um produto no pedido?     1- Sim      2- Não");
                adicionaMais = scanner.nextInt();
            }while (adicionaMais != 2);

        }

    }





    public static void menuAlteraPedido() {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite ID do pedido que deseja alterar: ");
        int idAlteraPedido = scanner.nextInt();

        for(Pedido pedido : Main.pedidos) {
            if (pedido.getIdPedido() == idAlteraPedido) {
                menuAlteraItemPedido(pedido);
            }
        }

    }

    public static void menuEntregas() { // Ainda falta arrumar coisas
        Scanner scanner = new Scanner(System.in);

        System.out.println("---------- Realizar Entrega ----------");
        System.out.println("Deseja listar o pedido que deve ser entregue? 1 - Sim      2- Não");
        int opcaoEntrega = scanner.nextInt();
        scanner.nextLine();
        if (opcaoEntrega == 1) {
            System.out.println(Main.pedidos.peek().toString());
        }
        System.out.println("Alterar Pedido?     1- Sim      2- Não");
        opcaoEntrega = scanner.nextInt();
        if (opcaoEntrega == 1) {
             menuAlteraItemPedido(Main.pedidos.peek());
        }
        System.out.println("Pedido atual");
        System.out.println(Main.pedidos.peek().toString());
        System.out.println("Confirma entrega:    1- Sim     2- Não");
        opcaoEntrega = scanner.nextInt();
        scanner.nextLine();


        if (opcaoEntrega == 1) {


                    Entrega entrega = new Entrega(Main.pedidos.peek(),(Motoboy) Main.funcionarios.get(0));

                    System.out.println("Valor do pedido: " + Main.df.format(Main.pedidos.peek().getValorTotal()));

                    System.out.println("Qual é o valor pago?");

                    double valorPago = scanner.nextDouble();



                    // Parte do pagamento
                    Main.pedidos.peek().calculaValorTotal();
                    double troco = Main.caixaPrincipal.calculaTroco(Main.pedidos.peek(),valorPago);
                    boolean pagar = Main.caixaPrincipal.pagar(valorPago,troco,Main.pedidos.peek().getValorTotal());

                    if (pagar){
                        entrega.realizarEntrega();
                    }

                }
        }
    }




