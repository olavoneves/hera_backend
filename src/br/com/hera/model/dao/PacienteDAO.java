package br.com.hera.model.dao;

import br.com.hera.model.dto.Acompanhante;
import br.com.hera.model.dto.Administrador;
import br.com.hera.model.dto.Paciente;
import br.com.hera.model.dto.Telefone;

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
            preparedStatement.setInt(4, paciente.getTelefone().getId());
            preparedStatement.setString(5, paciente.getStatus());
            preparedStatement.setInt(6, paciente.getConsultasRestantes());
            preparedStatement.setInt(7, paciente.getFaltas());
            preparedStatement.setBoolean(8, paciente.isPossuiDeficiencia());
            preparedStatement.setString(9, paciente.getTipoDeficiencia());
            preparedStatement.setBoolean(10, paciente.isVideoEnviado());
            preparedStatement.setDate(11,  java.sql.Date.valueOf(paciente.getDataNascimento()));
            preparedStatement.setString(12, paciente.getEndereco());
            preparedStatement.setString(13, paciente.getPreferenciaContato());
            preparedStatement.setTimestamp(14, java.sql.Timestamp.valueOf(paciente.getDataCadastro()));
            preparedStatement.setTimestamp(15, java.sql.Timestamp.valueOf(paciente.getUltimaAtualizacao()));
            preparedStatement.setInt(16, paciente.getAcompanhante().getId());
            preparedStatement.setInt(17, paciente.getAdministrador().getId());
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
        String sql = "UPDATE T_HERA_PACIENTES SET nome = ?, email = ?, sexo = ?, telefone = ?, status = ?, consultasRestantes = ?, faltas = ?, possuiDeficiencia = ?, tipoDeficiencia = ?, videoEnviado = ?, dataNascimento = ?, endereco = ?, preferenciaContato = ?, dataCadastro = ?, ultimaAtualizacao = ?, acompanhante = ?, administrador = ? WHERE id = ?)";
        try (PreparedStatement preparedStatement = getConnection().prepareStatement(sql);) {
            preparedStatement.setString(1, paciente.getNome());
            preparedStatement.setString(2, paciente.getEmail());
            preparedStatement.setString(3, paciente.getSexo());
            preparedStatement.setInt(4, paciente.getTelefone().getId());
            preparedStatement.setString(5, paciente.getStatus());
            preparedStatement.setInt(6, paciente.getConsultasRestantes());
            preparedStatement.setInt(7, paciente.getFaltas());
            preparedStatement.setBoolean(8, paciente.isPossuiDeficiencia());
            preparedStatement.setString(9, paciente.getTipoDeficiencia());
            preparedStatement.setBoolean(10, paciente.isVideoEnviado());
            preparedStatement.setDate(11, java.sql.Date.valueOf(paciente.getDataNascimento()));
            preparedStatement.setString(12, paciente.getEndereco());
            preparedStatement.setString(13, paciente.getPreferenciaContato());
            preparedStatement.setTimestamp(14, java.sql.Timestamp.valueOf(paciente.getDataCadastro()));
            preparedStatement.setTimestamp(15, java.sql.Timestamp.valueOf(paciente.getUltimaAtualizacao()));
            preparedStatement.setInt(16, paciente.getAcompanhante().getId());
            preparedStatement.setInt(17, paciente.getAdministrador().getId());
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
                return String.format("\nId: %d \nNome: %s \nE-mail: %s \nSexo: %s \nTelefone: %s \nStatus: %b \nConsultas Restantes: %d \nFaltas: %d \nPossui Deficiência: %b \nTipo de Deficiencia: %s \nVideo Enviado: %b \nData de Nascimento: %s \nEndereço: %s \nPreferência de Contato: %s \nData de Cadastro: %s \nUltima Atualizacao: %d \nAcompanhante: %s \nAdministrador: %s \n\n", paciente.getId(), resultSet.getString("nome"), resultSet.getString("email"), resultSet.getString("sexo"), resultSet.getObject("telefone"), resultSet.getString("status"), resultSet.getInt("consultasRestantes"), resultSet.getInt("faltas"), resultSet.getString("possuiDeficiencia"), resultSet.getString("tipoDeficiencia"), resultSet.getString("videoEnviado"), resultSet.getDate("dataNascimento").toLocalDate(), resultSet.getString("endereco"), resultSet.getString("preferenciaContato"), resultSet.getTimestamp("dataCadastro").toLocalDateTime(), resultSet.getTimestamp("ultimaAtualizacao").toLocalDateTime(), resultSet.getObject("acompanhante"), resultSet.getObject("administrador"));
            } else {
                return "Erro ao listar paciente";
            }
        } catch (SQLException exception) {
            return "Erro de SQL! \n" + exception.getMessage();
        }
    }

    @Override
    public ArrayList<Object> listarTodos() {
        String sql = "SELECT * FROM T_HERA_PACIENTES ORDER BY id";
        ArrayList<Object> listaPacientes = new ArrayList<>();

        try (PreparedStatement preparedStatement = getConnection().prepareStatement(sql);
             ResultSet resultSet = preparedStatement.executeQuery();) {

            if (resultSet != null) {
                while (resultSet.next()) {
                    paciente = new Paciente();
                    paciente.setId(resultSet.getInt("id"));
                    paciente.setNome(resultSet.getString("nome"));
                    paciente.setEmail(resultSet.getString("email"));
                    paciente.setSexo(resultSet.getString("sexo"));
                    Telefone tel = new Telefone();
                    tel.setNumero(resultSet.getString("telefone"));
                    paciente.setTelefone(tel);
                    paciente.setStatus(resultSet.getString("status"));
                    paciente.setConsultasRestantes(resultSet.getInt("consultasRestantes"));
                    paciente.setFaltas(resultSet.getInt("faltas"));
                    paciente.setPossuiDeficiencia(resultSet.getBoolean("possuiDeficiencia"));
                    paciente.setTipoDeficiencia(resultSet.getString("tipoDeficiencia"));
                    paciente.setVideoEnviado(resultSet.getBoolean("videoEnviado"));
                    paciente.setDataNascimento(resultSet.getDate("dataNascimento").toLocalDate());
                    paciente.setEndereco(resultSet.getString("endereco"));
                    paciente.setPreferenciaContato(resultSet.getString("preferenciaContato"));
                    paciente.setDataCadastro(resultSet.getTimestamp("dataCadastro").toLocalDateTime());
                    paciente.setUltimaAtualizacao(resultSet.getTimestamp("ultimaAtualizacao").toLocalDateTime());
                    Acompanhante acompanhante = new Acompanhante();
                    acompanhante.setId(resultSet.getInt("acompanhante"));
                    paciente.setAcompanhante(acompanhante);
                    Administrador administrador = new Administrador();
                    administrador.setId(resultSet.getInt("administrador"));
                    paciente.setAdministrador(administrador);
                    listaPacientes.add(paciente);
                }
            } else {
                return null;
            }
        } catch (SQLException e) {
            System.out.println("Erro: SQL\n" + e.getMessage());
            return null;
        }
        return listaPacientes;
    }
}
