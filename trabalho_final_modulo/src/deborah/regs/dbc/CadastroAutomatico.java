package deborah.regs.dbc;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class CadastroAutomatico {

    public static Caixa cadastroAutomatico() {


        Endereco endereco1 = new Endereco(TipoEndereco.RESIDENCIAL,"Carlos Gomes",200,"ap 10","303030-20","Porto Alegre");
        Contato contato1 = new Contato("Celular","90909090",TipoContato.TELEFONEFIXO);
        ArrayList<Contato> contatos1 = new ArrayList<>();
        ArrayList<Endereco> enderecos1 = new ArrayList<>();
        contatos1.add(contato1);
        enderecos1.add(endereco1);
        Cliente cliente1 = new Cliente(1,"1231234","Camile",enderecos1,contatos1);
        Main.clientes.add(cliente1);

        //Criacao do segundo cliente:
        Endereco endereco2 = new Endereco(TipoEndereco.RESIDENCIAL,"Avenida Oswaldo Aranha",200,"ap 100","909030-20","Porto Alegre");
        Contato contato2 = new Contato("Whatsapp","90909090",TipoContato.CELULAR);
        ArrayList<Contato> contatos2 = new ArrayList<>();
        ArrayList<Endereco> enderecos2 = new ArrayList<>();
        contatos2.add(contato2);
        enderecos2.add(endereco2);
        Cliente cliente2 = new Cliente(2,"123432","Deborah",enderecos2,contatos2);
        Main.clientes.add(cliente2);

        //Criacao de funcionários:
        Motoboy funcionario1 = new Motoboy(1,"Jonas",2000.00,"ABC-1020");
        Atendente funcionario2 = new Atendente(2,"Janaína",2200.00);
        Main.funcionarios.add(funcionario1);
        Main.funcionarios.add(funcionario2);

        //Cadastro de alguns produtos:
        Produto produto1 = new Produto(1,"Coca-Cola 2L",10.00);
        Produto produto2 = new Produto(2,"Cachorro-Quente",20.00);
        Produto produto3 = new Produto(3,"Hambúrguer",40.00);
        Produto produto4 = new Produto(4, "Batata Frita",18.00);
        Main.produtos.add(produto1);
        Main.produtos.add(produto2);
        Main.produtos.add(produto3);
        Main.produtos.add(produto4);

        //Criação do caixa:
        Caixa caixaPrincipal = new Caixa(funcionario2,1000.00);

        //Criação de alguns pedidos
        ArrayList<Produto> produtosPedido1 = new ArrayList<>();
        ArrayList<Produto> produtosPedido2 = new ArrayList<>();
        // para adicionar produtos no pedido, tem que criar uma arraylist de produtos
        produtosPedido1.add(produto1);
        produtosPedido1.add(produto3);
        produtosPedido1.add(produto3);

        produtosPedido2.add(produto1);
        produtosPedido2.add(produto2);
        produtosPedido2.add(produto4);

        Pedido pedido1 = new Pedido(1,1,produtosPedido1);
        Pedido pedido2 = new Pedido(2,2,produtosPedido2);

        Main.pedidos.add(pedido1);
        Main.pedidos.add(pedido2);
        return caixaPrincipal;
        //opcões de produtos

        Main.comidas.setNomeProduto("");
        Main.comidas.setValorUnitario(50);
        Main.comidas.setTipoComida(TipoComida.COMIDATAILANDESA);
        System.out.println(Main.comidas.getNomeProduto()
                + " prato do dia "
                + Main.comidas.getTipoComida().getDescricao());

        Main.Bebidas.setNomeProduto("");
        Main.Bebidas.setValorUnitario(15);
        Main.Bebidas.setTipoBebida(TipoBebida.CERVEJA);

        System.out.println(Main.comidas.getNomeProduto()
                + " prato do dia "
                + Main.comidas.getTipoBebida().getDescricao());
    }

}
