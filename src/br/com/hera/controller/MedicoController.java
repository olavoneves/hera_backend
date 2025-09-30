package br.com.hera.controller;

import br.com.hera.model.dao.*;
import br.com.hera.model.dto.Medico;
import br.com.hera.model.dto.Telefone;
import java.sql.Connection;
import java.util.ArrayList;

public class MedicoController {

    public String inserirMedico(String nome, String crm, String especialidade, String email, Telefone telefone, int cargaHorariaSemanal, String status) {
        String resposta;
        Connection connection = ConnectionFactory.abrirConexao();

        Medico medico = new Medico();
        medico.setNome(nome);
        medico.setCrm(crm);
        medico.setEspecialidade(especialidade);
        medico.setEmail(email);
        medico.setTelefone(telefone);
        medico.setCargaHorariaSemanal(cargaHorariaSemanal);
        medico.setStatus(status);

        MedicoDAO medicoDAO = new MedicoDAO(connection);
        resposta = medicoDAO.inserir(medico);

        ConnectionFactory.fecharConexao(connection);
        return resposta;
    }

    public String alterarMedico(int id, String nome, String crm, String especialidade, String email, Telefone telefone, int cargaHorariaSemanal, String status) {
        String resposta;
        Connection connection = ConnectionFactory.abrirConexao();

        Medico medico = new Medico();
        medico.setId(id);
        medico.setNome(nome);
        medico.setCrm(crm);
        medico.setEspecialidade(especialidade);
        medico.setEmail(email);
        medico.setTelefone(telefone);
        medico.setCargaHorariaSemanal(cargaHorariaSemanal);
        medico.setStatus(status);

        MedicoDAO medicoDAO = new MedicoDAO(connection);
        TelefoneDAO telefoneDAO = new TelefoneDAO(connection);

        if (medico.getTelefone() != null) {
            telefoneDAO.alterar(medico.getTelefone());
        }

        resposta = medicoDAO.alterar(medico);

        ConnectionFactory.fecharConexao(connection);
        return resposta;
    }

    public String excluirMedico(int id) {
        String resposta;
        Connection connection = ConnectionFactory.abrirConexao();

        Medico medico = new Medico();
        medico.setId(id);

        MedicoDAO medicoDAO = new MedicoDAO(connection);
        TelefoneDAO telefoneDAO = new TelefoneDAO(connection);

        medico = medicoDAO.buscarPorId(id);

        if (medico != null) {
            if (medico.getTelefone() != null) {
                telefoneDAO.excluir(medico.getTelefone());
            }
        }

        resposta = medicoDAO.excluir(medico);

        ConnectionFactory.fecharConexao(connection);
        return resposta;
    }

    public String listarUmMedico(int id) {
        String resposta;
        Connection connection = ConnectionFactory.abrirConexao();

        Medico medico = new Medico();
        medico.setId(id);

        MedicoDAO medicoDAO = new MedicoDAO(connection);
        resposta = medicoDAO.listarUm(medico);

        ConnectionFactory.fecharConexao(connection);
        return resposta;
    }

    public String listarTodosMedicos() {
        String resposta;
        Connection connection = ConnectionFactory.abrirConexao();

        MedicoDAO medicoDAO = new MedicoDAO(connection);
        ArrayList<Object> medicos = medicoDAO.listarTodos();

        resposta = "Lista de Médicos:\n";
        if (medicos.isEmpty()) {
            return "Nenhum medico cadastrado.\n";
        } else {
            for (Object object : medicos) {
                Medico medico = (Medico) object;
                resposta += "Id: " + medico.getId()
                        + " | Nome: " + medico.getNome()
                        + " | CRM: " + medico.getCrm()
                        + " | Especialidade: " + medico.getEspecialidade()
                        + " | E-mail: " + medico.getEmail()
                        + " | Telefone ID: " + medico.getTelefone().getId()
                        + " | Carga Horária Semanal: " + medico.getCargaHorariaSemanal()
                        + " | Status: " + medico.getStatus()
                        + "\n";
            }
        }

        ConnectionFactory.fecharConexao(connection);
        return resposta;
    }
}
