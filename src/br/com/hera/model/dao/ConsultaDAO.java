package br.com.hera.model.dao;

import br.com.hera.model.dto.Consulta;
import br.com.hera.model.dto.Medico;
import br.com.hera.model.dto.Paciente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ConsultaDAO implements IDAO {
    private Connection connection;
    private Consulta consulta;

    public ConsultaDAO(Connection connection) {
        this.connection = connection;
    }

    public Connection getConnection() {
        return connection;
    }

    @Override
    public String inserir(Object object) {
        consulta = (Consulta) object;
        String sql = "INSERT INTO T_HERA_CONSULTAS(paciente_id, medico_id, dataconsulta, horarioconsulta, status, tipoconsulta, observacoes, linkteleconsulta, duracaoestimada) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement preparedStatement = getConnection().prepareStatement(sql);) {
            preparedStatement.setInt(1, consulta.getPaciente().getId());
            preparedStatement.setInt(2, consulta.getMedico().getId());
            preparedStatement.setDate(3, java.sql.Date.valueOf(consulta.getDataConsulta()));
            preparedStatement.setTime(4, java.sql.Time.valueOf(consulta.getHorarioConsulta()));
            preparedStatement.setString(5, consulta.getStatus());
            preparedStatement.setString(6, consulta.getTipoConsulta());
            preparedStatement.setString(7, consulta.getObservacoes());
            preparedStatement.setString(8, consulta.getLinkTeleconsulta());
            preparedStatement.setInt(9, consulta.getDuracaoEstimada());
            if (preparedStatement.executeUpdate() > 0) {
                return "Consulta agendada com sucesso";
            } else {
                return "Erro ao inserir consulta";
            }
        } catch (SQLException exception) {
            return "Erro de SQL! \n" + exception.getMessage();
        }
    }

    @Override
    public String alterar(Object object) {
        consulta = (Consulta) object;
        String sql = "UPDATE T_HERA_CONSULTAS SET paciente_id = ?, medico_id = ?, dataconsulta = ?, horarioconsulta = ?, status = ?, tipoconsulta = ?, observacoes = ?, linkteleconsulta = ?, duracaoestimada = ? WHERE id = ?";
        try (PreparedStatement preparedStatement = getConnection().prepareStatement(sql);) {
            preparedStatement.setInt(1, consulta.getPaciente().getId());
            preparedStatement.setInt(2, consulta.getMedico().getId());
            preparedStatement.setDate(3, java.sql.Date.valueOf(consulta.getDataConsulta()));
            preparedStatement.setTime(4, java.sql.Time.valueOf(consulta.getHorarioConsulta()));
            preparedStatement.setString(5, consulta.getStatus());
            preparedStatement.setString(6, consulta.getTipoConsulta());
            preparedStatement.setString(7, consulta.getObservacoes());
            preparedStatement.setString(8, consulta.getLinkTeleconsulta());
            preparedStatement.setInt(9, consulta.getDuracaoEstimada());
            preparedStatement.setInt(10, consulta.getId());
            if (preparedStatement.executeUpdate() > 0) {
                return "Consulta alterada com sucesso";
            } else {
                return "Erro ao alterar consulta";
            }
        } catch (SQLException exception) {
            return "Erro de SQL! \n" + exception.getMessage();
        }
    }

    @Override
    public String excluir(Object object) {
        consulta = (Consulta) object;
        String sql = "DELETE FROM T_HERA_CONSULTAS WHERE id = ?";
        try (PreparedStatement preparedStatement = getConnection().prepareStatement(sql);) {
            preparedStatement.setInt(1, consulta.getId());
            if (preparedStatement.executeUpdate() > 0) {
                return "Consulta excluida com sucesso";
            } else {
                return "Erro ao excluir consulta";
            }
        } catch (SQLException exception) {
            return "Erro de SQL! \n" + exception.getMessage();
        }
    }

    @Override
    public String listarUm(Object object) {
        consulta = (Consulta) object;
        String sql = "SELECT * FROM T_HERA_CONSULTAS WHERE id = ?";
        try (PreparedStatement preparedStatement = getConnection().prepareStatement(sql);) {
            preparedStatement.setInt(1, consulta.getId());
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                consulta.setId(resultSet.getInt("id"));
                consulta.setDataConsulta(resultSet.getDate("dataconsulta").toLocalDate());
                consulta.setHorarioConsulta(resultSet.getTime("horarioconsulta").toLocalTime());
                consulta.setStatus(resultSet.getString("status"));
                consulta.setTipoConsulta(resultSet.getString("tipoconsulta"));
                consulta.setObservacoes(resultSet.getString("observacoes"));
                consulta.setLinkTeleconsulta(resultSet.getString("linkteleconsulta"));
                consulta.setDuracaoEstimada(resultSet.getInt("duracaoestimada"));

                PacienteDAO pacienteDAO = new PacienteDAO(getConnection());
                consulta.setPaciente(pacienteDAO.buscarPorId(resultSet.getInt("paciente_id")));

                MedicoDAO medicoDAO = new MedicoDAO(getConnection());
                consulta.setMedico(medicoDAO.buscarPorId(resultSet.getInt("medico_id")));

                return String.format(
                  "Id: %d\nPaciente: %s\nMédico: %s\nData Consulta: %s\nHorário Consulta: %s\nStatus: %s\nTipo de Consulta: %s\nObservações: %s\nLink Teleconsulta: %s\nDuração Estimada: %d",
                        consulta.getId(),
                        consulta.getPaciente().getNome(),
                        consulta.getMedico().getNome(),
                        consulta.getDataConsulta(),
                        consulta.getHorarioConsulta(),
                        consulta.getStatus(),
                        consulta.getTipoConsulta(),
                        consulta.getObservacoes(),
                        consulta.getLinkTeleconsulta(),
                        consulta.getDuracaoEstimada()
                );
            } else {
                return "Erro ao listar consulta";
            }

        } catch (SQLException exception) {
            return "Erro de SQL! \n" + exception.getMessage();
        }
    }

    @Override
    public ArrayList<Object> listarTodos() {
        String sql = "SELECT * FROM T_HERA_CONSULTAS ORDER BY id";
        ArrayList<Object> listaConsultas = new ArrayList<>();

        try (PreparedStatement preparedStatement = getConnection().prepareStatement(sql);
             ResultSet resultSet = preparedStatement.executeQuery();) {

            if (resultSet != null) {
                while (resultSet.next()) {
                    consulta = new Consulta();
                    consulta.setId(resultSet.getInt("id"));

                    Paciente paciente = new Paciente();
                    paciente.setId(resultSet.getInt("paciente_id"));
                    consulta.setPaciente(paciente);

                    Medico medico = new Medico();
                    medico.setId(resultSet.getInt("medico_id"));
                    consulta.setMedico(medico);

                    consulta.setDataConsulta(resultSet.getDate("dataconsulta").toLocalDate());
                    consulta.setHorarioConsulta(resultSet.getTime("horarioconsulta").toLocalTime());
                    consulta.setStatus(resultSet.getString("status"));
                    consulta.setTipoConsulta(resultSet.getString("tipoconsulta"));
                    consulta.setObservacoes(resultSet.getString("observacoes"));
                    consulta.setLinkTeleconsulta(resultSet.getString("linkteleconsulta"));
                    consulta.setDuracaoEstimada(resultSet.getInt("duracaoestimada"));

                    listaConsultas.add(consulta);
                }
            } else {
                return null;
            }

        } catch (SQLException e) {
            System.out.println("Erro: SQL\n" + e.getMessage());
            return null;
        }
        return listaConsultas;
    }

    @Override
    public Consulta buscarPorId(int id) {
        String sql = "SELECT * FROM T_HERA_CONSULTAS WHERE id = ?";
        try (PreparedStatement preparedStatement = getConnection().prepareStatement(sql);) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                consulta = new Consulta();
                consulta.setId(resultSet.getInt("id"));
                consulta.setDataConsulta(resultSet.getDate("dataconsulta").toLocalDate());
                consulta.setHorarioConsulta(resultSet.getTime("horarioconsulta").toLocalTime());
                consulta.setStatus(resultSet.getString("status"));
                consulta.setTipoConsulta(resultSet.getString("tipoconsulta"));
                consulta.setObservacoes(resultSet.getString("observacoes"));
                consulta.setLinkTeleconsulta(resultSet.getString("linkteleconsulta"));
                consulta.setDuracaoEstimada(resultSet.getInt("duracaoestimada"));

                PacienteDAO pacienteDAO = new PacienteDAO(getConnection());
                consulta.setPaciente(pacienteDAO.buscarPorId(resultSet.getInt("paciente_id")));

                MedicoDAO medicoDAO = new MedicoDAO(getConnection());
                consulta.setMedico(medicoDAO.buscarPorId(resultSet.getInt("medico_id")));

                return consulta;

            } else {
                return null;
            }

        } catch (SQLException exception) {
            System.out.println("Erro de SQL! \n" + exception.getMessage());
            return null;
        }
    }
}
