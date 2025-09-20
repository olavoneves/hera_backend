package br.com.hera.controller;

import br.com.hera.model.dto.Acompanhante;
import br.com.hera.model.dto.Administrador;
import br.com.hera.model.dto.Telefone;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class PacienteController {

    public String inserirPaciente(String nome, String email, String sexo, Telefone telefone, String status, int consultasRestantes, int faltas, boolean possuiDeficiencia, String tipoDeficiencia, boolean videoEnviado, LocalDate dataNascimento, String endereco, String preferenciaContato, LocalDateTime dataCadastro, LocalDateTime ultimaAtualizacao, Acompanhante acompanhante, Administrador administrador) {

    }

    public String alterarPaciente(int id, String nome, String email, String sexo, Telefone telefone, String status, int consultasRestantes, int faltas, boolean possuiDeficiencia, String tipoDeficiencia, boolean videoEnviado, LocalDate dataNascimento, String endereco, String preferenciaContato, LocalDateTime dataCadastro, LocalDateTime ultimaAtualizacao, Acompanhante acompanhante, Administrador administrador) {

    }

    public String excluirPaciente(int id) {

    }

    public String listarUmPaciente(int id) {

    }

    public String listarTodosPacientes() {

    }
}
