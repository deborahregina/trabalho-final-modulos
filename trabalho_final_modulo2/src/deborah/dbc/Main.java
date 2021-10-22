package deborah.dbc;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        boolean programaOn = true;
        while(programaOn) {
            System.out.println("*** MENU PRINCIPAL *** \nO QUE DESEJA ACESSAR: \n1- MENU CLIENTES \n2- MENU ENDERECOS 3- MENU CONTATOS \n4- MENU FUNCIONANRIOS \n5- MENU PEDIDOS\n6- MENU PRODUTOS\n7- MENU ENTREGAS\n8- SAIR: ");
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
                    break;
                case 6:
                    programaOn = false;
                    break;
            }
        }
    }
}
