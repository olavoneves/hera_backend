package br.com.hera.model.dao;

import br.com.hera.model.dto.Paciente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PacienteDAO implements IDAO {
    private Connection connection;
    private Paciente paciente;

    public PacienteDAO(Connection connection) {
        this.connection = connection;
    }

    public Connection getConnection() {
        return connection;
    }

    @Override
    public String inserir(Object object) {
        paciente = (Paciente) object;
        String sql = "INSERT INTO T_HERA_PACIENTES(nome, email, sexo, telefone, status, consultasRestantes, faltas, possuiDeficiencia, tipoDeficiencia, videoEnviado, dataNascimento, endereco, preferenciaContato, dataCadastro, ultimaAtualizacao, acompanhante, administrador) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement preparedStatement = getConnection().prepareStatement(sql);) {
            preparedStatement.setString(1, paciente.getNome());
            preparedStatement.setString(2, paciente.getEmail());
            preparedStatement.setString(3, paciente.getSexo());
            preparedStatement.setObject(4, paciente.getTelefone());
            preparedStatement.setString(5, paciente.getStatus());
            preparedStatement.setInt(6, paciente.getConsultasRestantes());
            preparedStatement.setInt(7, paciente.getFaltas());
            preparedStatement.setBoolean(8, paciente.isPossuiDeficiencia());
            preparedStatement.setString(9, paciente.getTipoDeficiencia());
            preparedStatement.setBoolean(10, paciente.isVideoEnviado());
            preparedStatement.setDate(11, paciente.getDataNascimento());
            preparedStatement.setString(12, paciente.getEndereco());
            preparedStatement.setString(13, paciente.getPreferenciaContato());
            preparedStatement.setTimestamp(14, paciente.getDataCadastro());
            preparedStatement.setTimestamp(15, paciente.getUltimaAtualizacao());
            preparedStatement.setObject(16, paciente.getAcompanhante());
            preparedStatement.setObject(17, paciente.getAdministrador());
            if (preparedStatement.executeUpdate() > 0) {
                return "Paciente inserido com sucesso";
            } else {
                return "Erro ao inserir paciente";
            }
        } catch (SQLException exception) {
            return "Erro de SQL! \n" + exception.getMessage();
        }
    }

    @Override
    public String alterar(Object object) {
        paciente = (Paciente) object;
        String sql = "UPDATE T_HERA_PACIENTES SET nome = ?, email, sexo = ?, telefone = ?, status = ?, consultasRestantes = ?, faltas = ?, possuiDeficiencia = ?, tipoDeficiencia = ?, videoEnviado = ?, dataNascimento = ?, endereco = ?, preferenciaContato = ?, dataCadastro = ?, ultimaAtualizacao = ?, acompanhante = ?, administrador = ? WHERE id = ?)";
        try (PreparedStatement preparedStatement = getConnection().prepareStatement(sql);) {
            preparedStatement.setString(1, paciente.getNome());
            preparedStatement.setString(2, paciente.getEmail());
            preparedStatement.setString(3, paciente.getSexo());
            preparedStatement.setObject(4, paciente.getTelefone());
            preparedStatement.setString(5, paciente.getStatus());
            preparedStatement.setInt(6, paciente.getConsultasRestantes());
            preparedStatement.setInt(7, paciente.getFaltas());
            preparedStatement.setBoolean(8, paciente.isPossuiDeficiencia());
            preparedStatement.setString(9, paciente.getTipoDeficiencia());
            preparedStatement.setBoolean(10, paciente.isVideoEnviado());
            preparedStatement.setDate(11, paciente.getDataNascimento());
            preparedStatement.setString(12, paciente.getEndereco());
            preparedStatement.setString(13, paciente.getPreferenciaContato());
            preparedStatement.setTimestamp(14, paciente.getDataCadastro());
            preparedStatement.setTimestamp(15, paciente.getUltimaAtualizacao());
            preparedStatement.setObject(16, paciente.getAcompanhante());
            preparedStatement.setObject(17, paciente.getAdministrador());
            preparedStatement.setInt(18, paciente.getId());
            if (preparedStatement.executeUpdate() > 0) {
                return "Paciente alterado com sucesso";
            } else {
                return "Erro ao alterar paciente";
            }
        } catch (SQLException exception) {
            return "Erro de SQL! \n" + exception.getMessage();
        }
    }

    @Override
    public String excluir(Object object) {
        paciente = (Paciente) object;
        String sql = "DELETE FROM T_HERA_PACIENTES WHERE id = ?)";
        try (PreparedStatement preparedStatement = getConnection().prepareStatement(sql);) {
            preparedStatement.setInt(1, paciente.getId());
            if (preparedStatement.executeUpdate() > 0) {
                return "Paciente excluido com sucesso";
            } else {
                return "Erro ao excluir paciente";
            }
        } catch (SQLException exception) {
            return "Erro de SQL! \n" + exception.getMessage();
        }
    }

    @Override
    public String listarUm(Object object) {
        paciente = (Paciente) object;
        String sql = "SELECT * FROM T_HERA_PACIENTES WHERE id = ?)";
        try (PreparedStatement preparedStatement = getConnection().prepareStatement(sql);) {
            ResultSet resultSet = preparedStatement.executeQuery();
            preparedStatement.setInt(1, paciente.getId());
            if (resultSet.next()) {
                return "Paciente listado com sucesso";
            } else {
                return "Erro ao listar paciente";
            }
        } catch (SQLException exception) {
            return "Erro de SQL! \n" + exception.getMessage();
        }
    }

    @Override
    public ArrayList<Object> listarTodos() {

    }
}
