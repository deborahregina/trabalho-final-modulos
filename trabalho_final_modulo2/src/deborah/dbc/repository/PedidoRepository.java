package deborah.dbc.repository;

import deborah.dbc.exceptions.BancoDeDadosException;
import deborah.dbc.model.Cliente;
import deborah.dbc.model.Pedido;
import deborah.dbc.model.PedidoProduto;
import deborah.dbc.model.Produto;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PedidoRepository implements Repositorio<Integer, Pedido> {

    @Override
    public Integer getProximoId(Connection connection) throws SQLException {
        String sql = "SELECT SEQ_PEDIDO.nextval mysequence from DUAL";

        Statement stmt = connection.createStatement();
        ResultSet res = stmt.executeQuery(sql);

        if (res.next()) {
            return res.getInt("mysequence");
        }

        return null;
    }

    @Override
    public Pedido adicionar(Pedido pedido) throws BancoDeDadosException {
        Connection con = null;
        try {
            con = ConexaoBancoDeDados.getConnection();

            Integer proximoId = this.getProximoId(con);
            pedido.setIdPedido(proximoId);

            String sql = "INSERT INTO PEDIDO\n" +
                    "(ID_PEDIDO, ID_CLIENTE,VALOR_TOTAL)\n" +
                    "VALUES(?, ?, ?)\n";

            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setInt(1, pedido.getIdPedido());
            stmt.setInt(2, pedido.getIdCliente());
            stmt.setDouble(3, pedido.getValorTotal());

            int res = stmt.executeUpdate();
            System.out.println("adicionarpedido.res=" + res);
            return pedido;
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

    public boolean removePedidoPorIdCliente(Integer id_cliente) throws BancoDeDadosException {
        Connection con = null;
        try {
            con = ConexaoBancoDeDados.getConnection();

            String sql = "DELETE FROM PEDIDO WHERE ID_CLIENTE = ?";

            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setInt(1, id_cliente);

            // Executa-se a consulta
            int res = stmt.executeUpdate();
            System.out.println("removePedidoPorIdCliente.res=" + res);

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
        public boolean remover (Integer id) throws BancoDeDadosException {
            return false;
        }

        @Override
        public boolean editar (Integer id, Pedido pedido) throws BancoDeDadosException {
            return false;
        }

        @Override
        public List<Pedido> listar () throws BancoDeDadosException {
            return null;
        }

    public Pedido getPedidoPorID(Integer idPedido) throws BancoDeDadosException {
        Pedido pedido = new Pedido();
        Cliente cliente = new Cliente();
        pedido.setCliente(cliente);
        Connection con = null;
        try {
            con = ConexaoBancoDeDados.getConnection();


            String sql = "SELECT p.ID_PEDIDO, p.ID_CLIENTE, c.NOME FROM PEDIDO p, CLIENTE c WHERE p.ID_PEDIDO = ? AND p.ID_CLIENTE = c.ID_CLIENTE \n";

            //Statement stmt = con.createStatement();
            PreparedStatement stmt = con.prepareStatement(sql.toString());
            stmt.setInt(1, idPedido);

            // Executa-se a consulta
            ResultSet res = stmt.executeQuery();


            while (res.next()) {
                pedido.setIdPedido(res.getInt("ID_PEDIDO"));
                pedido.setIdCliente(res.getInt("ID_CLIENTE"));
                pedido.getCliente().setNome(res.getString("NOME"));
                //pedido.setValorTotal(res.getDouble("VALOR_TOTAL"));
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
        return pedido;

    }

    public List<Pedido> retornapedidosCliente(Integer id_cliente) throws BancoDeDadosException {
        List<Pedido> pedidos = new ArrayList<>();
        Connection con = null;
        try {
            con = ConexaoBancoDeDados.getConnection();

            String sql = "SELECT * FROM PEDIDO p WHERE p.ID_CLIENTE = ?";

            // Executa-se a consulta
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, id_cliente);

            ResultSet res = stmt.executeQuery();

            while (res.next()) {
                Pedido pedidoProduto = getPedidoIdFromResultSet(res);
                pedidos.add(pedidoProduto);
            }
            return pedidos;
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
    private Pedido getPedidoIdFromResultSet(ResultSet res) throws SQLException {

        Pedido pedido = new Pedido();
        Cliente cliente = new Cliente();

        pedido.setCliente(cliente);
        pedido.setIdPedido(res.getInt("ID_PEDIDO"));
        pedido.getCliente().setIdCliente(res.getInt("ID_CLIENTE"));
        pedido.setIdCliente(res.getInt("ID_CLIENTE"));
        pedido.setValorTotal(res.getDouble("VALOR_TOTAL"));

        return pedido;

    }
}


