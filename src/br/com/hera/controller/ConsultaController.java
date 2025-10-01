package br.com.hera.controller;

import br.com.hera.model.dao.*;
import br.com.hera.model.dto.Consulta;
import br.com.hera.model.dto.Medico;
import br.com.hera.model.dto.Paciente;

import java.sql.Connection;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class ConsultaController {

    public String inserirConsulta(Paciente paciente, Medico medico, LocalDate dataConsulta, LocalTime horarioConsulta, String status, String tipoConsulta, String observacoes, String linkTeleconsulta, int duracaoEstimada) {
        String resposta;
        Connection connection = ConnectionFactory.abrirConexao();

        Consulta consulta = new Consulta();
        consulta.setPaciente(paciente);
        consulta.setMedico(medico);
        consulta.setDataConsulta(dataConsulta);
        consulta.setHorarioConsulta(horarioConsulta);
        consulta.setStatus(status);
        consulta.setTipoConsulta(tipoConsulta);
        consulta.setObservacoes(observacoes);
        consulta.setLinkTeleconsulta(linkTeleconsulta);
        consulta.setDuracaoEstimada(duracaoEstimada);

        ConsultaDAO consultaDAO = new ConsultaDAO(connection);
        resposta = consultaDAO.inserir(consulta);

        ConnectionFactory.fecharConexao(connection);
        return resposta;
    }

    public String alterarConsulta(int id, Paciente paciente, Medico medico, LocalDate dataConsulta, LocalTime horarioConsulta, String status, String tipoConsulta, String observacoes, String linkTeleconsulta, int duracaoEstimada) {
        String resposta;
        Connection connection = ConnectionFactory.abrirConexao();

        Consulta consulta = new Consulta();
        consulta.setId(id);
        consulta.setPaciente(paciente);
        consulta.setMedico(medico);
        consulta.setDataConsulta(dataConsulta);
        consulta.setHorarioConsulta(horarioConsulta);
        consulta.setStatus(status);
        consulta.setTipoConsulta(tipoConsulta);
        consulta.setObservacoes(observacoes);
        consulta.setLinkTeleconsulta(linkTeleconsulta);
        consulta.setDuracaoEstimada(duracaoEstimada);

        ConsultaDAO consultaDAO = new ConsultaDAO(connection);
        resposta = consultaDAO.alterar(consulta);

        ConnectionFactory.fecharConexao(connection);
        return resposta;
    }

    public String excluirConsulta(int id) {
        String resposta;
        Connection connection = ConnectionFactory.abrirConexao();

        Consulta consulta = new Consulta();
        consulta.setId(id);

        ConsultaDAO consultaDAO = new ConsultaDAO(connection);
        PacienteDAO pacienteDAO = new PacienteDAO(connection);
        MedicoDAO medicoDAO = new MedicoDAO(connection);

        consulta = consultaDAO.buscarPorId(id);

        if (consulta != null) {
            if (consulta.getPaciente() != null) {
                pacienteDAO.excluir(consulta.getPaciente());
            }

            if (consulta.getMedico() != null) {
                medicoDAO.excluir(consulta.getMedico());
            }
        }

        resposta = consultaDAO.excluir(consulta);

        ConnectionFactory.fecharConexao(connection);
        return resposta;
    }

    public String listarUmConsulta(int id) {
        String resposta;
        Connection connection = ConnectionFactory.abrirConexao();

        Consulta consulta = new Consulta();
        consulta.setId(id);

        ConsultaDAO consultaDAO = new ConsultaDAO(connection);
        resposta = consultaDAO.listarUm(consulta);

        ConnectionFactory.fecharConexao(connection);
        return resposta;
    }

    public String listarTodasConsultas() {
        String resposta;
        Connection connection = ConnectionFactory.abrirConexao();

        ConsultaDAO consultaDAO = new ConsultaDAO(connection);
        ArrayList<Object> consultas = consultaDAO.listarTodos();

        resposta = "Lista de Consultas:\n";
        if (consultas.isEmpty()) {
            return "Nenhuma consulta cadastrada.\n";
        } else {
            for (Object object : consultas) {
                Consulta consulta = (Consulta) object;
                resposta += "Id: " + consulta.getId()
                        + " | Paciente ID: " + consulta.getPaciente().getId()
                        + " | Paciente Nome: " + consulta.getPaciente().getNome()
                        + " | Médico ID: " + consulta.getMedico().getId()
                        + " | Médico Nome: " + consulta.getMedico().getNome()
                        + " | Data: " + consulta.getDataConsulta()
                        + " | Horário: " + consulta.getHorarioConsulta()
                        + " | Status: " + consulta.getStatus()
                        + " | Tipo de Consulta: " + consulta.getTipoConsulta()
                        + " | Observações: " + consulta.getObservacoes()
                        + " | Link Teleconsulta: " + consulta.getLinkTeleconsulta()
                        + " | Duração Estimada: " + consulta.getDuracaoEstimada()
                        + "\n";
            }
        }

        ConnectionFactory.fecharConexao(connection);
        return resposta;
    }
}
