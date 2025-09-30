package br.com.hera.model.dao;

import br.com.hera.model.dto.Medico;
import br.com.hera.model.dto.Telefone;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MedicoDAO implements IDAO {
    private Connection connection;
    private Medico medico;

    public MedicoDAO(Connection connection) {
        this.connection = connection;
    }

    public Connection getConnection() {
        return connection;
    }

    @Override
    public String inserir(Object object) {
        medico = (Medico) object;
        String sql = "INSERT INTO T_HERA_MEDICOS(nome, crm, especialidade, email, telefone_id, cargahorariasemanal, status) VALUES(?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement preparedStatement = getConnection().prepareStatement(sql);) {
            preparedStatement.setString(1, medico.getNome());
            preparedStatement.setString(2, medico.getCrm());
            preparedStatement.setString(3, medico.getEspecialidade());
            preparedStatement.setString(4, medico.getEmail());
            preparedStatement.setInt(5, medico.getTelefone().getId());
            preparedStatement.setInt(6, medico.getCargaHorariaSemanal());
            preparedStatement.setString(7, medico.getStatus());
            if (preparedStatement.executeUpdate() > 0) {
                return "Médico inserido com sucesso";
            } else {
                return "Erro ao inserir médico";
            }
        } catch (SQLException exception) {
            return "Erro de SQL! \n" + exception.getMessage();
        }
    }

    @Override
    public String alterar(Object object) {
        medico = (Medico) object;
        String sql = "UPDATE T_HERA_MEDICOS SET nome = ?, crm = ?, especialidade = ?, email = ?, telefone_id = ?, cargahorariasemanal = ?, status = ? WHERE id = ?";
        try (PreparedStatement preparedStatement = getConnection().prepareStatement(sql);) {
            preparedStatement.setString(1, medico.getNome());
            preparedStatement.setString(2, medico.getCrm());
            preparedStatement.setString(3, medico.getEspecialidade());
            preparedStatement.setString(4, medico.getEmail());
            preparedStatement.setInt(5, medico.getTelefone().getId());
            preparedStatement.setInt(6, medico.getCargaHorariaSemanal());
            preparedStatement.setString(7, medico.getStatus());
            preparedStatement.setInt(8, medico.getId());
            if (preparedStatement.executeUpdate() > 0) {
                return "Médico alterado com sucesso";
            } else {
                return "Erro ao alterar médico";
            }
        } catch (SQLException exception) {
            return "Erro de SQL! \n" + exception.getMessage();
        }
    }

    @Override
    public String excluir(Object object) {
        medico = (Medico) object;
        String sql = "DELETE FROM T_HERA_MEDICOS WHERE id = ?";
        try (PreparedStatement preparedStatement = getConnection().prepareStatement(sql);) {
            preparedStatement.setInt(1, medico.getId());
            if (preparedStatement.executeUpdate() > 0) {
                return "Médico excluido com sucesso";
            } else {
                return "Erro ao excluir médico";
            }
        } catch (SQLException exception) {
            return "Erro de SQL! \n" + exception.getMessage();
        }
    }

    @Override
    public String listarUm(Object object) {
        medico = (Medico) object;
        String sql = "SELECT * FROM T_HERA_MEDICOS WHERE id = ?";
        try (PreparedStatement preparedStatement = getConnection().prepareStatement(sql);) {
            preparedStatement.setInt(1, medico.getId());
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                medico.setId(resultSet.getInt("id"));
                medico.setNome(resultSet.getString("nome"));
                medico.setCrm(resultSet.getString("crm"));
                medico.setEspecialidade(resultSet.getString("especialidade"));
                medico.setEmail(resultSet.getString("email"));

                TelefoneDAO telefoneDAO = new TelefoneDAO(getConnection());
                medico.setTelefone(telefoneDAO.listarUm(resultSet.getInt("telefone_id")));

                medico.setCargaHorariaSemanal(resultSet.getInt("cargahorariasemanal"));
                medico.setStatus(resultSet.getString("status"));

                return String.format(
                        "Id: %d\nNome: %s\nCRM: %s\nEspecialidade: %s\nE-mail: %s\nTelefone: %s\nCarga Horária Semanal: %d\nStatus: %s\n",
                        medico.getId(),
                        medico.getNome(),
                        medico.getCrm(),
                        medico.getEspecialidade(),
                        medico.getEmail(),
                        medico.getTelefone() != null ? medico.getTelefone().getNumero() : "N/A",
                        medico.getCargaHorariaSemanal(),
                        medico.getStatus()
                );
            } else {
                return "Erro ao listar médico";
            }
        } catch (SQLException exception) {
            return "Erro de SQL! \n" + exception.getMessage();
        }
    }

    @Override
    public ArrayList<Object> listarTodos() {
        String sql = "SELECT * FROM T_HERA_MEDICOS ORDER BY id";
        ArrayList<Object> listaMedicos = new ArrayList<>();

        try (PreparedStatement preparedStatement = getConnection().prepareStatement(sql);
             ResultSet resultSet = preparedStatement.executeQuery();) {

            if (resultSet != null) {
                while (resultSet.next()) {
                    medico = new Medico();
                    medico.setId(resultSet.getInt("id"));
                    medico.setNome(resultSet.getString("nome"));
                    medico.setCrm(resultSet.getString("crm"));
                    medico.setEspecialidade(resultSet.getString("especialidade"));
                    medico.setEmail(resultSet.getString("email"));

                    Telefone tel = new Telefone();
                    tel.setId(resultSet.getInt("telefone_id"));
                    medico.setTelefone(tel);

                    medico.setCargaHorariaSemanal(resultSet.getInt("cargahorariasemanal"));
                    medico.setStatus(resultSet.getString("status"));
                    listaMedicos.add(medico);
                }
            } else {
                return null;
            }
        } catch (SQLException e) {
            System.out.println("Erro: SQL\n" + e.getMessage());
            return null;
        }
        return listaMedicos;
    }

    public Medico buscarPorId(int id) {
        String sql = "SELECT * FROM T_HERA_MEDICOS WHERE id = ?";
        try (PreparedStatement preparedStatement = getConnection().prepareStatement(sql);) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                medico = new Medico();
                medico.setId(resultSet.getInt("id"));
                medico.setNome(resultSet.getString("nome"));
                medico.setCrm(resultSet.getString("crm"));
                medico.setEspecialidade(resultSet.getString("especialidade"));
                medico.setEmail(resultSet.getString("email"));
                medico.setCargaHorariaSemanal(resultSet.getInt("cargahorariasemanal"));
                medico.setStatus(resultSet.getString("status"));

                TelefoneDAO telefoneDAO = new TelefoneDAO(getConnection());
                medico.setTelefone(telefoneDAO.listarUm(resultSet.getInt("telefone_id")));

                return medico;
            } else {
                return null;
            }
        } catch (SQLException exception) {
            System.out.println("Erro de SQL! \n" + exception.getMessage());
            return null;
        }
    }
}
