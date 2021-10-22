package deborah.dbc.repository;

import deborah.dbc.exceptions.BancoDeDadosException;
import deborah.dbc.model.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EnderecoRepository implements Repositorio<Integer, Endereco> {

    @Override
    public Integer getProximoId(Connection connection) throws SQLException {
        try {
            String sql = "SELECT seq_endereco_cliente.nextval mysequence from DUAL";
            Statement stmt = connection.createStatement();
            ResultSet res = stmt.executeQuery(sql);

            if (res.next()) {
                return res.getInt("mysequence");
            }

            return null;
        } catch (SQLException e) {
            throw new BancoDeDadosException(e.getCause());
        }
    }


    @Override
    public Endereco adicionar(Object endereco) throws BancoDeDadosException {
        Connection con = null;
        try {
            con = ConexaoBancoDeDados.getConnection();

            Integer proximoId = this.getProximoId(con);
            endereco.setIdEndereco(proximoId);

            String sql = "INSERT INTO ENDERECO_CLIENTE\n" +
                    "(ID_ENDERECO, ID_CLIENTE,  LOGRADOURO, NUMERO, BAIRRO, CEP,TIPO)\n" +
                    "VALUES(?, ?, ?, ?, ?,?,?)\n";

            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setInt(1, endereco.getIdEndereco());
            stmt.setInt(2, endereco.getCliente().getIdCliente());
            stmt.setString(3, endereco.getLogradouro());
            stmt.setInt(4, endereco.getNumero());
            stmt.setString(5, endereco.getBairro());
            stmt.setString(6, endereco.getCep());
            stmt.setInt(7,endereco.getTipo().getTipo());

            int res = stmt.executeUpdate();
            System.out.println("adicionarContato.res=" + res);
            return endereco;
        } catch (SQLException e) {
            throw new BancoDeDadosException(e.getCause());
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public boolean remover(Integer id) throws BancoDeDadosException {
        Connection con = null;
        try {
            con = ConexaoBancoDeDados.getConnection();

            String sql = "DELETE FROM ENDERECO_CLIENTE WHERE ID_ENDERECO = ?";

            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setInt(1, id);

            // Executa-se a consulta
            int res = stmt.executeUpdate();
            System.out.println("removerEnderecoPorId.res=" + res);

            return res > 0;
        } catch (SQLException e) {
            throw new BancoDeDadosException(e.getCause());
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public boolean editar(Integer id, Endereco endereco) throws BancoDeDadosException {
        Connection con = null;
        try {
            con = ConexaoBancoDeDados.getConnection();

            StringBuilder sql = new StringBuilder();
            sql.append("UPDATE ENDERECO_CLIENTE SET \n");
            Cliente pessoa = endereco.getCliente();

            sql.append(" id_cliente = ?,");
            sql.append(" logradouro = ?,");
            sql.append(" numero = ?,");
            sql.append(" bairro = ?,");
            sql.append(" cep = ?,");
            sql.append(" tipo = ?");
            sql.deleteCharAt(sql.length() - 1); //remove o ultimo ','
            sql.append(" WHERE id_endereco = ? ");

            PreparedStatement stmt = con.prepareStatement(sql.toString());

            int index = 1;
            if (pessoa != null) {
                stmt.setInt(index++, pessoa.getIdCliente());
                stmt.setString(index++, endereco.getLogradouro());
                stmt.setInt(index++, endereco.getNumero());
                stmt.setString(index++, endereco.getBairro());
                stmt.setString(index++, endereco.getCep());
                stmt.setInt(index++, endereco.getTipo().getTipo());
            }

            stmt.setInt(index++, id);

            // Executa-se a consulta
            int res = stmt.executeUpdate();
            System.out.println("editarEndereco.res=" + res);

            return res > 0;
        } catch (SQLException e) {
            throw new BancoDeDadosException(e.getCause());
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public List<Endereco> listar() throws BancoDeDadosException {
        List<Endereco> enderecos = new ArrayList<>();
        Connection con = null;
        try {
            con = ConexaoBancoDeDados.getConnection();
            Statement stmt = con.createStatement();

            String sql = "SELECT EC.*, " +
                    "            P.NOME AS NOME_CLIENTE " +
                    "       FROM ENDERECO_CLIENTE EC " +
                    "  LEFT JOIN CLIENTE P ON (P.ID_CLIENTE = EC.ID_CLIENTE) ";

            // Executa-se a consulta
            ResultSet res = stmt.executeQuery(sql);

            while (res.next()) {
                Endereco endereco = getEnderecoFromResultSet(res);
                enderecos.add(endereco);
            }
            return enderecos;
        } catch (SQLException e) {
            throw new BancoDeDadosException(e.getCause());
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
        private Endereco getEnderecoFromResultSet(ResultSet res) throws SQLException {
            Endereco endereco = new Endereco();
            endereco.setIdEndereco(res.getInt("id_endereco"));
            Cliente pessoa = new Cliente();
            pessoa.setNome(res.getString("nome"));
            pessoa.setIdCliente(res.getInt("id_cliente"));
            endereco.setCliente(pessoa);
            endereco.setLogradouro(res.getString("logradouro"));
            endereco.setNumero(res.getInt("numero"));
            endereco.setTipo(TipoEndereco.ofTipo(res.getInt("tipo")));
            return endereco;
        }
    public List<Endereco> listarEnderecosPorPessoa(Integer idPessoa) throws BancoDeDadosException {
        List<Endereco> enderecos = new ArrayList<>();
        Connection con = null;
        try {
            con = ConexaoBancoDeDados.getConnection();


            String sql = "SELECT EC.*, " +
                    "            P.NOME AS NOME_CLIENTE " +
                    "       FROM ENDERECO_CLIENTE EC " +
                    " INNER JOIN CLIENTE P ON (P.ID_CLIENTE = EC.ID_CLIENTE) " +
                    "      WHERE EC.ID_CLIENTE = ? ";

            // Executa-se a consulta
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, idPessoa);

            ResultSet res = stmt.executeQuery();

            while (res.next()) {
                Endereco endereco = getEnderecoFromResultSet(res);
                enderecos.add(endereco);
            }
            return enderecos;
        } catch (SQLException e) {
            throw new BancoDeDadosException(e.getCause());
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}

