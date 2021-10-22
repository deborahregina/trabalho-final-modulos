package deborah.dbc.repository;

import deborah.dbc.exceptions.BancoDeDadosException;
import deborah.dbc.model.Contato;
import deborah.dbc.model.Funcionario;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FuncionariosRepository  implements Repositorio < Integer, Funcionario>{

    @Override
    public Integer getProximoId(Connection connection) throws SQLException {
        try {
            String sql = "SELECT seq_funcionario.nextval mysequence from DUAL";
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
    public Funcionario adicionar(Funcionario funcionario) throws BancoDeDadosException {
        Connection con = null;
        try {
            con = ConexaoBancoDeDados.getConnection();

            Integer proximoId = this.getProximoId(con);
            funcionario.setIdFuncionarios(proximoId);

            String sql = "INSERT INTO FUNCIONARIO\n" +
                    "(ID_FUNCIONARIO, NOME,  CARGO, SALARIO)\n" +
                    "VALUES(?, ?, ?, ?)\n";

            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setInt(1, funcionario.getFuncionario());
            stmt.setInt(2, funcionario.getNome());
            stmt.setInt(4, (int) funcionario.getSalario());


            int res = stmt.executeUpdate();
            System.out.println("adicionarContato.res=" + res);
            return funcionario;
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

            String sql = "DELETE FROM FUNCIONARIOS WHERE ID_FUNCIONARIO= ?";

            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setInt(1, id);

            // Executa-se a consulta
            int res = stmt.executeUpdate();
            System.out.println("removerFuncionarioPorId.res=" + res);

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
    public boolean editar(Integer id, Funcionario funcionario) throws BancoDeDadosException {
        Connection con = null;
        try {
            con = ConexaoBancoDeDados.getConnection();

            StringBuilder sql = new StringBuilder();
            sql.append("UPDATE FUNCIONARIOS  SET \n");
            int funcionario1 = funcionario.getFuncionario();

            sql.append(" id_funcionarios = ?,");
            sql.append(" nome = ?,");
            sql.append(" salario = ?,");
            sql.deleteCharAt(sql.length() - 1); //remove o ultimo ','
            sql.append(" WHERE id_funcionario= ? ");

            PreparedStatement stmt = con.prepareStatement(sql.toString());

            int index = 1;
            if (funcionario != null) {
                stmt.setInt(index++, funcionario.getIdFuncionario());
                stmt.setInt(index++, funcionario.getNome();
                stmt.setString(index++, funcionario.getSalario();

            }

            stmt.setInt(index++, id);

            // Executa-se a consulta
            int res = stmt.executeUpdate();
            System.out.println("editarFuncionario.res=" + res);

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
    public Object adicionar(Object object) throws BancoDeDadosException {
        return null;
    }

    @Override
    public List<Funcionario> listar() throws BancoDeDadosException {
        List<Funcionario> funcionario = new ArrayList<>();
        Connection con = null;
        try {
            con = ConexaoBancoDeDados.getConnection();
            Statement stmt = con.createStatement();

            String sql = "SELECT * FROM FUNCIONARIO F";

            // Executa-se a consulta
            ResultSet res = stmt.executeQuery(sql);

            while (res.next()) {
                Funcionario funcionario1 = getFuncionarioFromResultSet(res);
                funcionario.add((Funcionario) funcionario);
            }
            return funcionario;
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
