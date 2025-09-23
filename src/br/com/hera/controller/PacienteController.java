package br.com.hera.controller;

import br.com.hera.model.dao.ConnectionFactory;
import br.com.hera.model.dao.PacienteDAO;
import br.com.hera.model.dto.Acompanhante;
import br.com.hera.model.dto.Administrador;
import br.com.hera.model.dto.Paciente;
import br.com.hera.model.dto.Telefone;

import java.sql.Connection;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class PacienteController {

    public String inserirPaciente(String nome, String email, String sexo, Telefone telefone, String status, int consultasRestantes, int faltas, boolean possuiDeficiencia, String tipoDeficiencia, boolean videoEnviado, LocalDate dataNascimento, String endereco, String preferenciaContato, LocalDateTime dataCadastro, LocalDateTime ultimaAtualizacao, Acompanhante acompanhante, Administrador administrador) {
        String resposta;
        Connection connection = ConnectionFactory.abrirConexao();

        Paciente paciente = new Paciente();
        paciente.setNome(nome);
        paciente.setEmail(email);
        paciente.setSexo(sexo);
        paciente.setTelefone(telefone);
        paciente.setStatus(status);
        paciente.setConsultasRestantes(consultasRestantes);
        paciente.setFaltas(faltas);
        paciente.setPossuiDeficiencia(possuiDeficiencia);
        paciente.setTipoDeficiencia(tipoDeficiencia);
        paciente.setVideoEnviado(videoEnviado);
        paciente.setDataNascimento(dataNascimento);
        paciente.setEndereco(endereco);
        paciente.setPreferenciaContato(preferenciaContato);
        paciente.setDataCadastro(dataCadastro);
        paciente.setUltimaAtualizacao(ultimaAtualizacao);
        paciente.setAcompanhante(acompanhante);
        paciente.setAdministrador(administrador);

        PacienteDAO pacienteDAO = new PacienteDAO(connection);
        resposta = pacienteDAO.inserir(paciente);

        ConnectionFactory.fecharConexao(connection);
        return resposta;
    }

    public String alterarPaciente(int id, String nome, String email, String sexo, Telefone telefone, String status, int consultasRestantes, int faltas, boolean possuiDeficiencia, String tipoDeficiencia, boolean videoEnviado, LocalDate dataNascimento, String endereco, String preferenciaContato, LocalDateTime dataCadastro, LocalDateTime ultimaAtualizacao, Acompanhante acompanhante, Administrador administrador) {
        String resposta;
        Connection connection = ConnectionFactory.abrirConexao();

        Paciente paciente = new Paciente();
        paciente.setId(id);
        paciente.setNome(nome);
        paciente.setEmail(email);
        paciente.setSexo(sexo);
        paciente.setTelefone(telefone);
        paciente.setStatus(status);
        paciente.setConsultasRestantes(consultasRestantes);
        paciente.setFaltas(faltas);
        paciente.setPossuiDeficiencia(possuiDeficiencia);
        paciente.setTipoDeficiencia(tipoDeficiencia);
        paciente.setVideoEnviado(videoEnviado);
        paciente.setDataNascimento(dataNascimento);
        paciente.setEndereco(endereco);
        paciente.setPreferenciaContato(preferenciaContato);
        paciente.setDataCadastro(dataCadastro);
        paciente.setUltimaAtualizacao(ultimaAtualizacao);
        paciente.setAcompanhante(acompanhante);
        paciente.setAdministrador(administrador);

        PacienteDAO pacienteDAO = new PacienteDAO(connection);
        resposta = pacienteDAO.alterar(paciente);

        ConnectionFactory.fecharConexao(connection);
        return resposta;
    }

    public String excluirPaciente(int id) {
        String resposta;
        Connection connection = ConnectionFactory.abrirConexao();

        Paciente paciente = new Paciente();
        paciente.setId(id);

        PacienteDAO pacienteDAO = new PacienteDAO(connection);
        resposta = pacienteDAO.excluir(paciente);

        ConnectionFactory.fecharConexao(connection);
        return resposta;
    }

    public String listarUmPaciente(int id) {
        String resposta;
        Connection connection = ConnectionFactory.abrirConexao();

        Paciente paciente = new Paciente();
        paciente.setId(id);

        PacienteDAO pacienteDAO = new PacienteDAO(connection);
        resposta = pacienteDAO.listarUm(paciente);

        ConnectionFactory.fecharConexao(connection);
        return resposta;
    }

    public String listarTodosPacientes() {
        String resposta;
        Connection connection = ConnectionFactory.abrirConexao();

        PacienteDAO pacienteDAO = new PacienteDAO(connection);
        ArrayList<Object> pacientes = pacienteDAO.listarTodos();

        resposta = "Lista de Pacientes:\n";
        if (pacientes.isEmpty()) {
            return "Nenhum paciente cadastrado.\n";
        } else {
            for (Object object : pacientes) {
                Paciente paciente = (Paciente) object;
                resposta += "Id: " + paciente.getId()
                        + ", Nome: " + paciente.getNome()
                        + ", E-mail: " + paciente.getEmail()
                        + ", Sexo: " + paciente.getSexo()
                        + ", Telefone: " + paciente.getTelefone()
                        + ", Status: " + paciente.getStatus()
                        + ", Consultas Restantes: " + paciente.getConsultasRestantes()
                        + ", Faltas: " + paciente.getFaltas()
                        + ", Possui Deficiência: " + paciente.isPossuiDeficiencia()
                        + ", Tipo de Deficiência: " + paciente.getTipoDeficiencia()
                        + ", Vídeo Enviado: " + paciente.isVideoEnviado()
                        + ", Data Nascimento: " + paciente.getDataNascimento()
                        + ", Endereço: " + paciente.getEndereco()
                        + ", Preferência de Contato: " + paciente.getPreferenciaContato()
                        + ", Data de Cadastro: " + paciente.getDataCadastro()
                        + ", Ultima Atualização: " + paciente.getUltimaAtualizacao()
                        + ", Acompanhante: " + paciente.getAcompanhante()
                        + ", Administrador: " + paciente.getAdministrador()
                        + "\n";
            }
        }

        ConnectionFactory.fecharConexao(connection);
        return resposta;
    }
}
