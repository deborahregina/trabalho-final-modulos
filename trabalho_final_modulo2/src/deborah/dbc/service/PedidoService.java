package deborah.dbc.service;

import deborah.dbc.exceptions.BancoDeDadosException;
import deborah.dbc.model.Pedido;
import deborah.dbc.repository.PedidoRepository;

public class PedidoService {
    private PedidoRepository pedidoRepository;

    public PedidoService() {
        pedidoRepository = new PedidoRepository();
    }
    public void adicionarPedido(Pedido pedido) {
        try {
            Pedido pedidoAdicionado = pedidoRepository.adicionar(pedido);
            System.out.println("pedido adicinado com sucesso! " + pedidoAdicionado);
        } catch (BancoDeDadosException e) {
            e.printStackTrace();
        }
    }
}
