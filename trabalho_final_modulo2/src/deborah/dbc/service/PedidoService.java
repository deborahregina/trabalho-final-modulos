package deborah.dbc.service;

import deborah.dbc.exceptions.BancoDeDadosException;
import deborah.dbc.model.Pedido;
import deborah.dbc.model.PedidoProduto;
import deborah.dbc.model.Produto;
import deborah.dbc.repository.PedidoProdutoRepository;
import deborah.dbc.repository.PedidoRepository;
import deborah.dbc.repository.ProdutoRepository;

import java.util.ArrayList;
import java.util.List;

public class PedidoService {
    private PedidoRepository pedidoRepository;
    private PedidoProdutoRepository pedidoProdututoRepository;
    private ProdutoRepository produtoRepository;

    public PedidoService() {
        pedidoRepository = new PedidoRepository();
        pedidoProdututoRepository = new PedidoProdutoRepository();
    }

    public Pedido adicionarPedido(Pedido pedido) {
        try {
            Pedido pedidoAdicionado = pedidoRepository.adicionar(pedido);
            System.out.println("pedido adicinado com sucesso! " + pedidoAdicionado);
            return pedidoAdicionado;
        } catch (BancoDeDadosException e) {
            e.printStackTrace();
        }
        return null;
    }

    public PedidoProduto adicionarProdutoNoPedido(PedidoProduto pedidoProduto) {
        try {
            PedidoProduto pedidoProdutoAdicionado = pedidoProdututoRepository.adicionar(pedidoProduto);
            System.out.println("pedido produto adicionado com sucesso! " + pedidoProdutoAdicionado);
            return pedidoProdutoAdicionado;
        } catch (BancoDeDadosException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void listarPedidos() {
        try {
            List<PedidoProduto> listarPedidos = pedidoProdututoRepository.listar();
            listarPedidos.forEach(System.out::println);
        } catch (BancoDeDadosException e) {
            e.printStackTrace();
        }
    }

    public void alterarProdutoDoPedido(PedidoProduto pedidoProduto) {
        try {
            pedidoProdututoRepository.editar(pedidoProduto);
        } catch (BancoDeDadosException e) {
            e.printStackTrace();
        }
    }

    public Pedido getPedidoPorId(Integer idPedido) {
        try {
            return pedidoRepository.getPedidoPorID(idPedido);
        } catch (BancoDeDadosException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void deletarProdutoDoPedido(PedidoProduto pedidoProduto) {
        try {
            pedidoProdututoRepository.remover(pedidoProduto);
        } catch (BancoDeDadosException e) {
            e.printStackTrace();
        }
    }

    public void removerProdutoDePedidoProduto(Integer id_produto) {
        try {
            pedidoProdututoRepository.removerProdutoDePedidoProduto(id_produto);
        } catch (BancoDeDadosException e) {
            e.printStackTrace();
        }
    }


    public void deletarPedidosEprodutoPedido(Integer id_cliente) {
        try {
            List<Pedido> pedidos = new ArrayList<>();
            pedidos = pedidoRepository.retornapedidosCliente(id_cliente);
            for(Pedido peds : pedidos) {
                pedidoProdututoRepository.removerPedidoDePedidoProduto(peds.getIdPedido());
            }
            for(Pedido peds: pedidos) {
                pedidoRepository.removePedidoPorIdCliente(id_cliente);
            }
        } catch (BancoDeDadosException e) {
            e.printStackTrace();
        }
    }

    public void alterarStatusEntrega (Pedido pedido) {
        try {
            pedidoRepository.alterarStatusDoPedido(pedido);
        } catch (BancoDeDadosException e) {
            e.printStackTrace();
        }
    }


}
