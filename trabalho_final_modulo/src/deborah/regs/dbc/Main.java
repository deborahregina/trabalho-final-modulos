package deborah.regs.dbc;

public class Main {

    public static void main(String[] args) {

        Endereco endereco = new Endereco(1,"Ijuí",200,"Ap 200","90460-200","Porto Alegre");
        Contato contato = new Contato ("Celular","90909090",1);
        Cliente cliente = new Cliente(1,"10203040","Deborah");
        Contato [] contatos = {contato};
        Endereco [] enderecos = {endereco};
        cliente.setContatos(contatos);
        cliente.setEnderecos(enderecos);

        System.out.println(endereco.imprimir());
        System.out.println();
        System.out.println(contato.imprimir());
        System.out.println();
        System.out.println(cliente.imprimir());

    }
}
