package deborah.dbc.repository;

import deborah.dbc.exceptions.BancoDeDadosException;
import deborah.dbc.model.Endereco;
import deborah.dbc.model.Pedido;
import deborah.dbc.model.PedidoProduto;
import deborah.dbc.model.Produto;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PedidoProdutoRepository implements Repositorio <Integer,PedidoProduto> {

    @Override
    public Integer getProximoId(Connection connection) throws SQLException {
        return null;
    }

    @Override
    public PedidoProduto adicionar(PedidoProduto pedidoProduto) throws BancoDeDadosException {
        Connection con = null;
        try {
            con = ConexaoBancoDeDados.getConnection();

            String sql = "INSERT INTO PEDIDO_PRODUTO\n" +
                    "(ID_PEDIDO, ID_PRODUTO,QUANTIDADE)\n" +
                    "VALUES(?, ?, ?)\n";

            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setInt(1, pedidoProduto.getPedido().getIdPedido());
            stmt.setInt(2, pedidoProduto.getProduto().getIdProduto());
            stmt.setInt(3, pedidoProduto.getQuantidade());

            int res = stmt.executeUpdate();
            System.out.println("adicionar pedido produto res=" + res);
            return pedidoProduto;
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
        return false;
    }

    public boolean remover(PedidoProduto pedidoProduto) throws BancoDeDadosException {
        Connection con = null;
        try {
            con = ConexaoBancoDeDados.getConnection();

            String sql = "DELETE FROM PEDIDO_PRODUTO WHERE ID_PEDIDO = ? AND ID_PRODUTO = ?";

            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setInt(1, pedidoProduto.getPedido().getIdPedido());
            stmt.setInt(2, pedidoProduto.getProduto().getIdProduto());
            // Executa-se a consulta
            int res = stmt.executeUpdate();
            System.out.println("removerPedidoPorId.res=" + res);

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
            return false;
        }
    }

    public boolean removerPedidoDePedidoProduto(Integer idPedido) throws BancoDeDadosException {
        Connection con = null;
        try {
            con = ConexaoBancoDeDados.getConnection();

            String sql = "DELETE FROM PEDIDO_PRODUTO WHERE ID_PEDIDO = ? ";

            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setInt(1, idPedido);
            // Executa-se a consulta
            int res = stmt.executeUpdate();
            System.out.println("removerPedidoProdutoPorId.res=" + res);

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
            return false;
        }
    }

    public boolean removerProdutoDePedidoProduto(Integer idproduto) throws BancoDeDadosException {
        Connection con = null;
        try {
            con = ConexaoBancoDeDados.getConnection();

            String sql = "DELETE FROM PEDIDO_PRODUTO WHERE ID_PRODUTO = ? ";

            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setInt(1, idproduto);
            // Executa-se a consulta
            int res = stmt.executeUpdate();
            System.out.println("removerPedidoProdutoPorIdProduto.res=" + res);

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
            return false;
        }
    }

    @Override
    public boolean editar(Integer id, PedidoProduto pedidoProduto) throws BancoDeDadosException {
        Connection con = null;
        try {
            con = ConexaoBancoDeDados.getConnection();

            String sql = "UPDATE PEDIDO_PRODUTO\n" +
                    "SET QUANTIDADE = ?\n" +
                    "WHERE ID_PEDIDO = ? AND ID_PRODUTO = ?";

            PreparedStatement stmt = con.prepareStatement(sql.toString());

            stmt.setInt(1, pedidoProduto.getQuantidade());
            stmt.setInt(2, pedidoProduto.getPedido().getIdPedido());
            stmt.setInt(3, pedidoProduto.getProduto().getIdProduto());


            // Executa-se a consulta
            int res = stmt.executeUpdate();
            System.out.println("editar quantidade produto no pedido.res=" + res);

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
            return false;
        }


    }

    public boolean editar(PedidoProduto pedidoProduto) throws BancoDeDadosException {
        Connection con = null;
        try {
            con = ConexaoBancoDeDados.getConnection();

            String sql = "UPDATE PEDIDO_PRODUTO\n" +
                    "SET QUANTIDADE = ?\n" +
                    "WHERE ID_PEDIDO = ? AND ID_PRODUTO = ?";

            PreparedStatement stmt = con.prepareStatement(sql.toString());

            stmt.setInt(1, pedidoProduto.getQuantidade());
            stmt.setInt(2, pedidoProduto.getPedido().getIdPedido());
            stmt.setInt(3, pedidoProduto.getProduto().getIdProduto());


            // Executa-se a consulta
            int res = stmt.executeUpdate();
            System.out.println("editar quantidade produto no pedido.res=" + res);

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
            return false;
        }


    }

    @Override
    public List<PedidoProduto> listar() throws BancoDeDadosException {
        List<PedidoProduto> pedidoProdutos = new ArrayList<>();
        Connection con = null;
        try {
            con = ConexaoBancoDeDados.getConnection();
            Statement stmt = con.createStatement();

            String sql = "SELECT p.ID_PEDIDO ,p2.ID_PRODUTO, p2.NOME, pp.QUANTIDADE, p2.PRECO\n " +
                    "FROM  PEDIDO p\n " +
                    "INNER JOIN PEDIDO_PRODUTO pp ON (p.ID_PEDIDO = pp.ID_PEDIDO)\n " +
                    "INNER JOIN PRODUTO p2  ON (pp.ID_PRODUTO = p2.ID_PRODUTO)";

            // Executa-se a consulta
            ResultSet res = stmt.executeQuery(sql);

            while (res.next()) {
                PedidoProduto pedidoProduto = new PedidoProduto();
                Pedido pedido = new Pedido();
                Produto produto = new Produto();
                pedido.setIdPedido(res.getInt("ID_PEDIDO"));
                produto.setIdProduto(res.getInt("ID_PRODUTO"));
                produto.setDescrição(res.getString("NOME"));
                pedidoProduto.setQuantidade(res.getInt("QUANTIDADE"));
                produto.setValorUnitario(res.getDouble("PRECO"));
                pedidoProduto.setPedido(pedido);
                pedidoProduto.setProduto(produto);
                pedidoProdutos.add(pedidoProduto);
            }
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
        return pedidoProdutos;
    }

    public boolean removerProdutoFromPedido(Integer id_pedido) throws BancoDeDadosException {
        Connection con = null;
        try {
            con = ConexaoBancoDeDados.getConnection();

            String sql = "DELETE FROM PEDIDO_PRODUTO WHERE ID_PRODUTO = ?";

            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setInt(1,id_pedido);;
            // Executa-se a consulta
            int res = stmt.executeUpdate();
            System.out.println("removerProdutoFromPedido.res=" + res);

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
            return false;
        }
    }


    public List<PedidoProduto> listarPedidoProdutoPorPedido(Integer idPedido) throws BancoDeDadosException {
        List<PedidoProduto> pedidoProdutos = new ArrayList<>();
        Connection con = null;
        try {
            con = ConexaoBancoDeDados.getConnection();


            String sql = "SELECT pp.ID_PEDIDO, pp.ID_PRODUTO FROM PEDIDO_PRODUTO pp, PEDIDO p WHERE p.ID_PEDIDO = ? AND pp.ID_PEDIDO = p.ID_PEDIDO";

            // Executa-se a consulta
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, idPedido);

            ResultSet res = stmt.executeQuery();

            while (res.next()) {
                PedidoProduto pedidoProduto = getPedidoProdutoFromResultSet(res);
                pedidoProdutos.add(pedidoProduto);
            }
            return pedidoProdutos;
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

    public List<PedidoProduto> retornapedidosProdutosDoPedido(Integer id_pedido) throws BancoDeDadosException {
        List<PedidoProduto> pedidosProdutos = new ArrayList<>();
        Connection con = null;
        try {
            con = ConexaoBancoDeDados.getConnection();

            String sql = "SELECT * FROM PEDIDO_PRODUTO p WHERE p.ID_PEDIDO = ?";

            // Executa-se a consulta
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, id_pedido);

            ResultSet res = stmt.executeQuery();

            while (res.next()) {
                PedidoProduto pedidoProduto = getPedidoProdutoFromResultSet(res);
                pedidosProdutos.add(pedidoProduto);
            }
            return pedidosProdutos;
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
    private PedidoProduto getPedidoProdutoFromResultSet(ResultSet res) throws SQLException {

        PedidoProduto pedidoProduto = new PedidoProduto();
        Pedido pedido = new Pedido();
        Produto produto = new Produto();
        pedidoProduto.setPedido(pedido);
        pedidoProduto.setProduto(produto);

        pedidoProduto.getPedido().setIdPedido(res.getInt("ID_PEDIDO"));
        pedidoProduto.getProduto().setIdProduto(res.getInt("ID_PRODUTO"));
        pedidoProduto.setQuantidade(res.getInt("QUANTIDADE"));

        return pedidoProduto;

    }

}