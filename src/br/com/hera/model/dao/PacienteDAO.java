package br.com.hera.model.dao;

import br.com.hera.model.dto.Acompanhante;
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
        String sql = "INSERT INTO T_HERA_PACIENTES(nome, email, sexo, telefone_id, status, consultasRestantes, faltas, possuiDeficiencia, tipoDeficiencia, videoEnviado, dataNascimento, endereco, preferenciaContato, dataCadastro, ultimaAtualizacao, acompanhante_id) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement preparedStatement = getConnection().prepareStatement(sql);) {
            preparedStatement.setString(1, paciente.getNome());
            preparedStatement.setString(2, paciente.getEmail());
            preparedStatement.setString(3, paciente.getSexo());
            preparedStatement.setInt(4, paciente.getTelefone().getId());
            preparedStatement.setString(5, paciente.getStatus());
            preparedStatement.setInt(6, paciente.getConsultasRestantes());
            preparedStatement.setInt(7, paciente.getFaltas());
            preparedStatement.setString(8, paciente.isPossuiDeficiencia() ? "1" : "0");
            preparedStatement.setString(9, paciente.getTipoDeficiencia());
            preparedStatement.setString(10, paciente.isVideoEnviado() ? "1" : "0");
            preparedStatement.setDate(11,  java.sql.Date.valueOf(paciente.getDataNascimento()));
            preparedStatement.setString(12, paciente.getEndereco());
            preparedStatement.setString(13, paciente.getPreferenciaContato());
            preparedStatement.setTimestamp(14, java.sql.Timestamp.valueOf(paciente.getDataCadastro()));
            preparedStatement.setTimestamp(15, java.sql.Timestamp.valueOf(paciente.getUltimaAtualizacao()));
            preparedStatement.setInt(16, paciente.getAcompanhante().getId());
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
        String sql = "UPDATE T_HERA_PACIENTES SET nome = ?, email = ?, sexo = ?, telefone_id = ?, status = ?, consultasRestantes = ?, faltas = ?, possuiDeficiencia = ?, tipoDeficiencia = ?, videoEnviado = ?, dataNascimento = ?, endereco = ?, preferenciaContato = ?, dataCadastro = ?, ultimaAtualizacao = ?, acompanhante_id = ? WHERE id = ?";
        try (PreparedStatement preparedStatement = getConnection().prepareStatement(sql);) {
            preparedStatement.setString(1, paciente.getNome());
            preparedStatement.setString(2, paciente.getEmail());
            preparedStatement.setString(3, paciente.getSexo());
            preparedStatement.setInt(4, paciente.getTelefone().getId());
            preparedStatement.setString(5, paciente.getStatus());
            preparedStatement.setInt(6, paciente.getConsultasRestantes());
            preparedStatement.setInt(7, paciente.getFaltas());
            preparedStatement.setString(8, paciente.isPossuiDeficiencia() ? "1" : "0");
            preparedStatement.setString(9, paciente.getTipoDeficiencia());
            preparedStatement.setString(10, paciente.isVideoEnviado() ? "1" : "0");
            preparedStatement.setDate(11, java.sql.Date.valueOf(paciente.getDataNascimento()));
            preparedStatement.setString(12, paciente.getEndereco());
            preparedStatement.setString(13, paciente.getPreferenciaContato());
            preparedStatement.setTimestamp(14, java.sql.Timestamp.valueOf(paciente.getDataCadastro()));
            preparedStatement.setTimestamp(15, java.sql.Timestamp.valueOf(paciente.getUltimaAtualizacao()));
            preparedStatement.setInt(16, paciente.getAcompanhante().getId());
            preparedStatement.setInt(17, paciente.getId());
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
        String sql = "DELETE FROM T_HERA_PACIENTES WHERE id = ?";
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
        String sql = "SELECT * FROM T_HERA_PACIENTES WHERE id = ?";
        try (PreparedStatement preparedStatement = getConnection().prepareStatement(sql);) {
            preparedStatement.setInt(1, paciente.getId());
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                paciente.setId(resultSet.getInt("id"));
                paciente.setNome(resultSet.getString("nome"));
                paciente.setEmail(resultSet.getString("email"));
                paciente.setSexo(resultSet.getString("sexo"));
                paciente.setStatus(resultSet.getString("status"));
                paciente.setConsultasRestantes(resultSet.getInt("consultasRestantes"));
                paciente.setFaltas(resultSet.getInt("faltas"));
                paciente.setPossuiDeficiencia("1".equals(resultSet.getString("possuiDeficiencia")));
                paciente.setTipoDeficiencia(resultSet.getString("tipoDeficiencia"));
                paciente.setVideoEnviado("1".equals(resultSet.getString("videoEnviado")));
                paciente.setDataNascimento(resultSet.getDate("dataNascimento").toLocalDate());
                paciente.setEndereco(resultSet.getString("endereco"));
                paciente.setPreferenciaContato(resultSet.getString("preferenciaContato"));
                paciente.setDataCadastro(resultSet.getTimestamp("dataCadastro").toLocalDateTime());
                paciente.setUltimaAtualizacao(resultSet.getTimestamp("ultimaAtualizacao").toLocalDateTime());

                TelefoneDAO telefoneDAO = new TelefoneDAO(getConnection());
                paciente.setTelefone(telefoneDAO.listarUm(resultSet.getInt("telefone_id")));

                AcompanhanteDAO acompanhanteDAO = new AcompanhanteDAO(getConnection());
                paciente.setAcompanhante(acompanhanteDAO.listarUm(resultSet.getInt("acompanhante_id")));

                return String.format(
                        "Id: %d\nNome: %s\nEmail: %s\nSexo: %s\nTelefone: %s\nStatus: %s\nConsultas Restantes: %d\nFaltas: %d\nPossui Deficiência: %b\nTipo de Deficiencia: %s\nVideo Enviado: %b\nData Nascimento: %s\nEndereço: %s\nPreferência de Contato: %s\nData Cadastro: %s\nÚltima Atualização: %s\nAcompanhante: %s\nTelefone Acompanhante: %s\n",
                        paciente.getId(),
                        paciente.getNome(),
                        paciente.getEmail(),
                        paciente.getSexo(),
                        paciente.getTelefone() != null ? paciente.getTelefone().getNumero() : "N/A",
                        paciente.getStatus(),
                        paciente.getConsultasRestantes(),
                        paciente.getFaltas(),
                        paciente.isPossuiDeficiencia(),
                        paciente.getTipoDeficiencia(),
                        paciente.isVideoEnviado(),
                        paciente.getDataNascimento(),
                        paciente.getEndereco(),
                        paciente.getPreferenciaContato(),
                        paciente.getDataCadastro(),
                        paciente.getUltimaAtualizacao(),
                        paciente.getAcompanhante() != null ? paciente.getAcompanhante().getNome() : "N/A",
                        paciente.getAcompanhante() != null && paciente.getAcompanhante().getTelefone() != null ? paciente.getAcompanhante().getTelefone().getNumero() : "N/A"
                );
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
        TelefoneDAO telefoneDAO = new TelefoneDAO(getConnection());

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
                    tel.setId(resultSet.getInt("telefone_id"));
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
                    acompanhante.setId(resultSet.getInt("acompanhante_id"));
                    Telefone telAcomp = telefoneDAO.buscarPorAcompanhante(resultSet.getInt("acompanhante_id"));
                    acompanhante.setTelefone(telAcomp);
                    paciente.setAcompanhante(acompanhante);
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

    public Paciente buscarPorId(int id) {
        String sql = "SELECT * FROM T_HERA_PACIENTES WHERE id = ?";
        try (PreparedStatement preparedStatement = getConnection().prepareStatement(sql);) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                paciente = new Paciente();
                paciente.setId(resultSet.getInt("id"));
                paciente.setNome(resultSet.getString("nome"));
                paciente.setEmail(resultSet.getString("email"));
                paciente.setSexo(resultSet.getString("sexo"));
                paciente.setStatus(resultSet.getString("status"));
                paciente.setConsultasRestantes(resultSet.getInt("consultasRestantes"));
                paciente.setFaltas(resultSet.getInt("faltas"));
                paciente.setPossuiDeficiencia("1".equals(resultSet.getString("possuiDeficiencia")));
                paciente.setTipoDeficiencia(resultSet.getString("tipoDeficiencia"));
                paciente.setVideoEnviado("1".equals(resultSet.getString("videoEnviado")));
                paciente.setDataNascimento(resultSet.getDate("dataNascimento").toLocalDate());
                paciente.setEndereco(resultSet.getString("endereco"));
                paciente.setPreferenciaContato(resultSet.getString("preferenciaContato"));
                paciente.setDataCadastro(resultSet.getTimestamp("dataCadastro").toLocalDateTime());
                paciente.setUltimaAtualizacao(resultSet.getTimestamp("ultimaAtualizacao").toLocalDateTime());

                TelefoneDAO telefoneDAO = new TelefoneDAO(getConnection());
                paciente.setTelefone(telefoneDAO.listarUm(resultSet.getInt("telefone_id")));

                AcompanhanteDAO acompanhanteDAO = new AcompanhanteDAO(getConnection());
                paciente.setAcompanhante(acompanhanteDAO.listarUm(resultSet.getInt("acompanhante_id")));

                return paciente;
            } else {
                return null;
            }
        } catch (SQLException exception) {
            System.out.println("Erro de SQL! \n" + exception.getMessage());
            return null;
        }
    }
}
