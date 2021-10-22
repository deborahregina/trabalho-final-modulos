package deborah.dbc;

import deborah.dbc.model.Cliente;
import deborah.dbc.model.Contato;
import deborah.dbc.model.Endereco;
import deborah.dbc.model.TipoEndereco;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu {

    static Scanner scanner = new Scanner(System.in);
    public static void menuClientes() {

        System.out.println("O que deseja fazer? 1- Cadastrar novo cliente  2- Imprimir dados dos clientes  3- Alterar dados cadastrais do cliente  4- Deletar registro cliente: ");
        int opCliente = scanner.nextInt();
        if (opCliente == 1) {
            cadastroClienteVisual();
        }

    }

    public static Cliente cadastroClienteVisual() {
        Cliente clienteCadastro = new Cliente();

        ArrayList<Endereco> enderecosCliente = new ArrayList<>();

        System.out.println("Digite o nome do cliente: ");
        clienteCadastro.setNome(scanner.nextLine());
        System.out.println("Digite o CPF do cliente: ");
        clienteCadastro.setCpf(scanner.nextLine());

        boolean menuEnderecos = true;
        while (menuEnderecos) {
            System.out.println("CADASTRAR ENDEREÇO PARA O CLIENTE: ");
            enderecosCliente.add(cadastroEnderecoVisual());
            System.out.println("Deseja Cadastrar novo endereço?  1- Sim    2- Não: ");
            int opcaoNovoCadastroEndereco = scanner.nextInt();
            if (opcaoNovoCadastroEndereco == 2){
                menuEnderecos = false;
            }
        }
        clienteCadastro.setEnderecos(enderecosCliente);

        boolean menuContatos = true;
        while (menuContatos) {
            System.out.println("CADASTRAR CONTATO PARA O CLIENTE: ");

        }
        System.out.println("CADASTRAR CONTATO PARA O CLIENTE: ");

        return clienteCadastro;
    }

    public static Endereco cadastroEnderecoVisual() {
        Endereco endereco = new Endereco();
        System.out.println("Digite o logradouro: ");
        endereco.setLogradouro(scanner.nextLine());
        System.out.println("Digite o número: ");
        endereco.setNumero(scanner.nextInt());
        System.out.println("Digite o bairro: ");
        endereco.setBairro(scanner.nextLine());
        System.out.println("Digite o CEP: ");
        endereco.setCep(scanner.nextLine());
        System.out.println("Tipo de endereço:  1- Residencial   2- Comercial: ");
        endereco.setTipo(TipoEndereco.ofTipo(scanner.nextInt()));

        return endereco;
    }

    public static Contato cadastroContatoVisual() {
        Contato contato = new Contato();
        System.out.println("Digite a descrição do contato: ");
        

    }
}
