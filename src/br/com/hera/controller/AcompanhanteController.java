package br.com.hera.controller;

import br.com.hera.model.dao.AcompanhanteDAO;
import br.com.hera.model.dao.ConnectionFactory;
import br.com.hera.model.dto.Acompanhante;

import java.sql.Connection;

public class AcompanhanteController {

    public int inserirAcompanhante(Acompanhante acompanhante) {
        int resposta;
        Connection connection = ConnectionFactory.abrirConexao();

        AcompanhanteDAO acompanhanteDAO = new AcompanhanteDAO(connection);
        resposta = acompanhanteDAO.inserir(acompanhante);

        ConnectionFactory.fecharConexao(connection);
        return resposta;
    }

    public int alterarAcompanhante(Acompanhante acompanhante) {
        int resposta;
        Connection connection = ConnectionFactory.abrirConexao();

        AcompanhanteDAO acompanhanteDAO = new AcompanhanteDAO(connection);
        resposta = acompanhanteDAO.alterar(acompanhante);

        ConnectionFactory.fecharConexao(connection);
        return resposta;
    }
}
