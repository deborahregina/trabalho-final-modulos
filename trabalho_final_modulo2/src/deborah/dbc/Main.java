package deborah.dbc;

import deborah.dbc.service.ClienteService;
import deborah.dbc.service.ContatoService;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        ContatoService contatoService = new ContatoService();
        ClienteService clienteService = new ClienteService();
        clienteService.listarCliente();
        contatoService.listar();

        Scanner scanner = new Scanner(System.in);
        boolean programaOn = true;
        while(programaOn) {
            System.out.println("*** MENU PRINCIPAL *** \nO QUE DESEJA ACESSAR: \n1- MENU CLIENTES \n2- MENU ENDERECOS \n3- MENU CONTATOS \n4- MENU FUNCIONANRIOS \n5- MENU PEDIDOS\n6- MENU PRODUTOS\n7- MENU ENTREGAS\n8- SAIR: ");
            int opcaoPrincipal = scanner.nextInt();

            switch (opcaoPrincipal) {
                case 1:
                    Menu.menuClientes();
                    break;
                case 2:
                    System.out.println("1- Listar enderecos cadastrados    2- Listar endereco por pessoa: ");
                    int opEnderecos = scanner.nextInt();
                    if (opEnderecos == 1) {
                        //Menu.menuImprimeEnderecos();
                    }
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    Menu.menuPedido();
                    break;
                case 6:
                    Menu.menuAdicionaProduto();
                    break;
            }
        }
    }
}
