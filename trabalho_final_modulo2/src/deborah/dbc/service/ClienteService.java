package deborah.dbc.service;

import deborah.dbc.exceptions.BancoDeDadosException;
import deborah.dbc.model.Cliente;
import deborah.dbc.model.Contato;
import deborah.dbc.model.Endereco;
import deborah.dbc.model.Pedido;
import deborah.dbc.repository.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClienteService {
    private ClienteRepository clienteRepository;
    private ContatoRepository contatoRepository = new ContatoRepository();
    private PedidoRepository pedidoRepository = new PedidoRepository();



    static EnderecoRepository enderecoRepository = new EnderecoRepository();

    public ClienteService() {
        clienteRepository = new ClienteRepository();
    }

    // criação de um objeto
    public void adicionarCliente(Cliente cliente) {
        try {
            Cliente clienteAdicionado = clienteRepository.adicionar(cliente);
            System.out.println("cliente adicinado com sucesso! " + clienteAdicionado);
        } catch (BancoDeDadosException e) {
            e.printStackTrace();
        }
    }

    // remoção
    public void removerCliente(Integer id) {
        try {
            enderecoRepository.removeEnderecoPorIdCliente(id);
            contatoRepository.removeContatoPorIdCliente(id);
            pedidoRepository.removePedidoPorIdCliente(id);
            boolean conseguiuRemover = clienteRepository.remover(id);
            System.out.println("cliente removida? " + conseguiuRemover + "| com id=" + id);
        } catch (BancoDeDadosException e) {
            e.printStackTrace();
        }
    }

    // atualização de um objeto
    public void editarCliente(Integer id, Cliente cliente) {
        try {
            boolean conseguiuEditar = clienteRepository.editar(id, cliente);
            System.out.println("cliente editada? " + conseguiuEditar + "| com id=" + id);
        } catch (BancoDeDadosException e) {
            e.printStackTrace();
        }
    }

    // leitura
    public void listarCliente() {
        try {
            List<Cliente> listar = clienteRepository.listar();
            listar.forEach(System.out::println);
        } catch (BancoDeDadosException e) {
            e.printStackTrace();
        }
    }

}
