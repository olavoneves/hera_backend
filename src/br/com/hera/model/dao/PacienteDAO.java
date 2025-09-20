package br.com.hera.model.dao;

import br.com.hera.model.dto.Paciente;

import java.sql.Connection;

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

    }

    @Override
    public String alterar(Object object) {

    }

    @Override
    public String excluir(Object object) {

    }

    @Override
    public String listarUm(Object object) {

    }

    @Override
    public String listarTodos() {

    }
}
