package deborah.dbc.repository;

import deborah.dbc.exceptions.BancoDeDadosException;
import deborah.dbc.model.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProdutoRepository implements Repositorio<Integer, Produto>  {
    @Override
    public Integer getProximoId(Connection connection) throws BancoDeDadosException {
        try {
            String sql = "SELECT seq_produto.nextval mysequence from DUAL";
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
    public Produto adicionar(Produto produto) throws BancoDeDadosException {
        Connection con = null;
        try {
            con = ConexaoBancoDeDados.getConnection();

            Integer proximoId = this.getProximoId(con);
            produto.setIdProdutos(proximoId);

            String sql = "INSERT INTO PRODUTO\n" +
                    "(ID_PRODUTO, TIPO_PRODUTO, NOME, PRECO)\n" +
                    "VALUES(?, ?, ?, ?)\n";

            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setInt(1, produto.getIdProduto());
            stmt.setInt(2, produto.getTipoProduto().getTipo());
            stmt.setString(3, produto.getDescrição());
            stmt.setDouble(4, produto.getValorUnitario());


            int res = stmt.executeUpdate();
            System.out.println("adicionarProduto.res=" + res);
            return produto;
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

            String sql = "DELETE FROM PRODUTO WHERE ID_PRODUTO = ?";

            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setInt(1, id);

            // Executa-se a consulta
            int res = stmt.executeUpdate();
            System.out.println("removerProdutoPorId.res=" + res);

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
    public boolean editar(Integer id, Produto produto) throws BancoDeDadosException {
        Connection con = null;
        try {
            con = ConexaoBancoDeDados.getConnection();

            StringBuilder sql = new StringBuilder();
            sql.append("UPDATE PRODUTO SET \n");

            sql.append(" TIPO_PRODUTO = ?,");
            sql.append(" NOME = ?,");
            sql.append(" PRECO = ?,");
            sql.deleteCharAt(sql.length() - 1); //remove o ultimo ','
            sql.append(" WHERE id_produto = ? ");

            PreparedStatement stmt = con.prepareStatement(sql.toString());

            int index = 1;

                stmt.setInt(index++, produto.getTipoProduto().getTipo());
                stmt.setString(index++, produto.getDescrição());
                stmt.setDouble(index++, produto.getValorUnitario());
                stmt.setInt(index++, id);

            // Executa-se a consulta
            int res = stmt.executeUpdate();
            System.out.println("editarProduto.res=" + res);

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
    public List<Produto> listar() throws BancoDeDadosException {
        List<Produto> produtos = new ArrayList<>();
        Connection con = null;
        try {
            con = ConexaoBancoDeDados.getConnection();
            Statement stmt = con.createStatement();

            String sql = "SELECT * FROM PRODUTO P ";

            // Executa-se a consulta
            ResultSet res = stmt.executeQuery(sql);

            while (res.next()) {
                Produto produto = getProdutoFromResultSet(res);
                produtos.add(produto);
            }
            return produtos;
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


    private Produto getProdutoFromResultSet(ResultSet res) throws SQLException {
        Produto produto = new Produto();
        produto.setIdProduto(res.getInt("id_produto"));
        produto.setTipoProduto (TipoProduto.ofTipo(res.getInt("tipo_produto")));
        produto.setDescrição(res.getString("nome"));
        produto.setValorUnitario(res.getDouble("preco"));
        return produto;
    }

}
