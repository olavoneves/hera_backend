package br.com.hera.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    public static Connection abrirConexao() {
        Connection connection = null;
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            String url = "jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL";
            final String USER = "RM563558";
            final String PASSWORD = "230707";
            connection = DriverManager.getConnection(url, USER, PASSWORD);
        } catch (ClassNotFoundException exception) {
            System.out.println("Erro: A classe de conexão não foi encontrada! \n" + exception.getMessage());
        } catch (SQLException exception) {
            System.out.println("Erro de SQL! \n" + exception.getMessage());
        } catch (Exception exception) {
            System.out.println("Erro: " + exception.getMessage());
        }
        return connection;
    }

    public static void fecharConexao(Connection connection) {
        try {
            connection.close();
        } catch (SQLException exception) {
            System.out.println("Erro de SQL! \n" + exception.getMessage());
        } catch (Exception exception) {
            System.out.println("Erro: " + exception.getMessage());
        }
    }
}
