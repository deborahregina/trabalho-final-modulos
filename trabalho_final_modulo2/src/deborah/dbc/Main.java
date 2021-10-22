package deborah.dbc;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        boolean programaOn = true;
        while(programaOn) {
            System.out.println("*** MENU PRINCIPAL *** \nO QUE DESEJA ACESSAR: \n 1- MENU CLIENTES \n2- MENU FUNCIONANRIOS \n3- MENU PEDIDOS\n4- MENU PRODUTOS\n5- MENU ENTREGAS\n6- SAIR: ");
            int opcaoPrincipal = scanner.nextInt();

            switch (opcaoPrincipal) {
                case 1:
                    Menu.menuClientes();
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
                    programaOn = false;
                    break;
            }
        }
    }
}
