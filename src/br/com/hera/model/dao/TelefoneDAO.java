package br.com.hera.model.dao;

import br.com.hera.model.dto.Telefone;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TelefoneDAO {
    private Connection connection;

    public TelefoneDAO(Connection connection) {
        this.connection = connection;
    }

    public Connection getConnection() {
        return connection;
    }

    public int inserir(Telefone telefone) {
        String sql = "INSERT INTO T_HERA_TELEFONES(ddd, numero, tipo, ativo, preferencial) VALUES(?, ?, ?, ?, ?)";
        try (PreparedStatement preparedStatement = getConnection().prepareStatement(sql, new String[]{"id"});) {
            preparedStatement.setString(1, telefone.getDdd());
            preparedStatement.setString(2, telefone.getNumero());
            preparedStatement.setString(3, telefone.getTipo());
            preparedStatement.setString(4, telefone.isAtivo() ? "1" : "0");
            preparedStatement.setString(5, telefone.isPreferencial() ? "1" : "0");
            if (preparedStatement.executeUpdate() > 0) {
                try (ResultSet resultSet = preparedStatement.getGeneratedKeys()) {
                    if (resultSet.next()) {
                        int idGerado = resultSet.getInt(1);
                        telefone.setId(idGerado);
                        return idGerado;
                    }
                }
            }
            return 0;
        } catch (SQLException e) {
            System.out.println("Erro de SQL:" + e.getMessage());
            return 0;
        }
    }

    public int alterar(Telefone telefone) {
        String sql = "UPDATE T_HERA_TELEFONES SET ddd = ?, numero = ?, tipo = ?, ativo = ?, preferencial = ? WHERE id = ?";
        try (PreparedStatement preparedStatement = getConnection().prepareStatement(sql, new String[]{"id"});) {
            preparedStatement.setString(1, telefone.getDdd());
            preparedStatement.setString(2, telefone.getNumero());
            preparedStatement.setString(3, telefone.getTipo());
            preparedStatement.setString(4, telefone.isAtivo() ? "1" : "0");
            preparedStatement.setString(5, telefone.isPreferencial() ? "1" : "0");
            preparedStatement.setInt(6, telefone.getId());
            if (preparedStatement.executeUpdate() > 0) {
                try (ResultSet resultSet = preparedStatement.getGeneratedKeys()) {
                    if (resultSet.next()) {
                        int idGerado = resultSet.getInt(1);
                        telefone.setId(idGerado);
                        return idGerado;
                    }
                }
            }
            return 0;
        } catch (SQLException e) {
            System.out.println("Erro de SQL:" + e.getMessage());
            return 0;
        }
    }

    public String excluir(Telefone telefone) {
        String sql = "DELETE FROM T_HERA_PACIENTES WHERE id = ?";
        try (PreparedStatement preparedStatement = getConnection().prepareStatement(sql);) {
            preparedStatement.setInt(1, telefone.getId());
            if (preparedStatement.executeUpdate() > 0) {
                return "Telefone excluido com sucesso";
            } else {
                return "Erro ao excluir telefone";
            }
        } catch (SQLException exception) {
            return "Erro de SQL! \n" + exception.getMessage();
        }
    }

    public Telefone listarUm(int telefoneId) {
        String sql = "SELECT * FROM T_HERA_TELEFONES WHERE id = ?";
        try (PreparedStatement preparedStatement = getConnection().prepareStatement(sql);) {
            preparedStatement.setInt(1, telefoneId);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                Telefone telefone = new Telefone();
                telefone.setId(resultSet.getInt("id"));
                telefone.setDdd(resultSet.getString("ddd"));
                telefone.setNumero(resultSet.getString("numero"));
                telefone.setTipo(resultSet.getString("tipo"));
                telefone.setAtivo("1".equals(resultSet.getString("ativo")));
                telefone.setPreferencial("1".equals(resultSet.getString("preferencial")));
                return telefone;
            } else {
                return null;
            }
        } catch (SQLException e) {
            System.out.println("Erro de SQL! \n" + e.getMessage());
            return null;
        }
    }
}
