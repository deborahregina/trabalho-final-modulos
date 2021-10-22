package deborah.dbc.repository;

import deborah.dbc.exceptions.BancoDeDadosException;
import deborah.dbc.model.Funcionario;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface Repositorio<CHAVE, OBJETO> {
    Integer getProximoId(Connection connection) throws SQLException;

    Object adicionar(Object object) throws BancoDeDadosException;

    Funcionario adicionar(Funcionario funcionario) throws BancoDeDadosException;

    boolean remover(Object id) throws BancoDeDadosException;

    boolean editar(Object id, Object o) throws BancoDeDadosException;

    List<OBJETO> listar() throws BancoDeDadosException;
}
