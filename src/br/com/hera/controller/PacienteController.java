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



        ConnectionFactory.fecharConexao(connection);
    }
}
