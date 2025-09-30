package br.com.hera.model.dao;

import br.com.hera.model.dto.Acompanhante;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AcompanhanteDAO{
    private Connection connection;

    public AcompanhanteDAO(Connection connection) {
        this.connection = connection;
    }

    public Connection getConnection() {
        return connection;
    }

    public int inserir(Acompanhante acompanhante) {
        String sql = "INSERT INTO T_HERA_ACOMPANHANTES(nome, telefone_id, parentesco, email, datacadastro) VALUES(?, ?, ?, ?, ?)";
        try (PreparedStatement preparedStatement = getConnection().prepareStatement(sql, new String[]{"id"});) {
            preparedStatement.setString(1, acompanhante.getNome());
            preparedStatement.setInt(2, acompanhante.getTelefone().getId());
            preparedStatement.setString(3, acompanhante.getParentesco());
            preparedStatement.setString(4, acompanhante.getEmail());
            preparedStatement.setTimestamp(5, java.sql.Timestamp.valueOf(acompanhante.getDataCadastro()));
            if (preparedStatement.executeUpdate() > 0) {
                try (ResultSet resultSet = preparedStatement.getGeneratedKeys()) {
                    if (resultSet.next()) {
                        int idGerado = resultSet.getInt(1);
                        acompanhante.setId(idGerado);
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

    public int alterar(Acompanhante acompanhante) {
        String sql = "UPDATE T_HERA_PACIENTES SET nome = ?, telefone_id = ?, parentesco = ?, email = ?, datacadastro = ? WHERE id = ?";
        try (PreparedStatement preparedStatement = getConnection().prepareStatement(sql, new String[]{"id"});) {
            preparedStatement.setString(1, acompanhante.getNome());
            preparedStatement.setInt(2, acompanhante.getTelefone().getId());
            preparedStatement.setString(3, acompanhante.getParentesco());
            preparedStatement.setString(4, acompanhante.getEmail());
            preparedStatement.setTimestamp(5, java.sql.Timestamp.valueOf(acompanhante.getDataCadastro()));
            preparedStatement.setInt(6, acompanhante.getId());
            if (preparedStatement.executeUpdate() > 0) {
                try (ResultSet resultSet = preparedStatement.getGeneratedKeys()) {
                    if (resultSet.next()) {
                        int idGerado = resultSet.getInt(1);
                        acompanhante.setId(idGerado);
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

    public String excluir(Acompanhante acompanhante) {
        String sql = "DELETE FROM T_HERA_PACIENTES WHERE id = ?";
        try (PreparedStatement preparedStatement = getConnection().prepareStatement(sql);) {
            preparedStatement.setInt(1, acompanhante.getId());
            if (preparedStatement.executeUpdate() > 0) {
                return "Acompanhante excluido com sucesso";
            } else {
                return "Erro ao excluir acompanhante";
            }
        } catch (SQLException exception) {
            return "Erro de SQL! \n" + exception.getMessage();
        }
    }

    public Acompanhante listarUm(int acompanhanteId) {
        String sql = "SELECT * FROM T_HERA_ACOMPANHANTES WHERE id = ?";
        try (PreparedStatement preparedStatement = getConnection().prepareStatement(sql);) {
            preparedStatement.setInt(1, acompanhanteId);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                Acompanhante acompanhante = new Acompanhante();
                acompanhante.setId(resultSet.getInt("id"));
                acompanhante.setNome(resultSet.getString("nome"));
                TelefoneDAO telefoneDAO = new TelefoneDAO(getConnection());
                acompanhante.setTelefone(telefoneDAO.listarUm(resultSet.getInt("telefone_id")));
                acompanhante.setParentesco(resultSet.getString("parentesco"));
                acompanhante.setEmail(resultSet.getString("email"));
                acompanhante.setDataCadastro(resultSet.getTimestamp("datacadastro").toLocalDateTime());
                return acompanhante;
            } else {
                return null;
            }
        } catch (SQLException e) {
            System.out.println("Erro de SQL! \n" + e.getMessage());
            return null;
        }
    }
}
