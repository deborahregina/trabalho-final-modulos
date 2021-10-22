package deborah.dbc.repository;

import deborah.dbc.exceptions.BancoDeDadosException;
import deborah.dbc.model.Cliente;

import java.sql.*;
import java.util.List;
import java.util.ArrayList;

public class ClienteRepository implements Repositorio< Integer, Cliente>{

    @Override
    public Integer getProximoId(Connection connection) throws SQLException {
        return null;
    }

    @Override
    public Cliente adicionar(Cliente object) throws BancoDeDadosException {
        return null;
    }

    @Override
    public boolean remover(Integer id) throws BancoDeDadosException {
        return false;
    }

    @Override
    public boolean editar(Integer id, Cliente cliente) throws BancoDeDadosException {
        return false;
    }

    @Override
    public List<Cliente> listar() throws BancoDeDadosException {
        return null;
    }
}
