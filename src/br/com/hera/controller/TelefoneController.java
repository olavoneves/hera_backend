package br.com.hera.controller;

import br.com.hera.model.dao.ConnectionFactory;
import br.com.hera.model.dao.TelefoneDAO;
import br.com.hera.model.dto.Telefone;

import java.sql.Connection;

public class TelefoneController {

    public int inserirTelefone(Telefone telefone) {
        int resposta;
        Connection connection = ConnectionFactory.abrirConexao();

        TelefoneDAO telefoneDAO = new TelefoneDAO(connection);
        resposta = telefoneDAO.inserir(telefone);

        ConnectionFactory.fecharConexao(connection);
        return resposta;
    }

    public int alterarTelefone(Telefone telefone) {
        int resposta;
        Connection connection = ConnectionFactory.abrirConexao();

        TelefoneDAO telefoneDAO = new TelefoneDAO(connection);
        resposta = telefoneDAO.alterar(telefone);

        ConnectionFactory.fecharConexao(connection);
        return resposta;
    }
}
