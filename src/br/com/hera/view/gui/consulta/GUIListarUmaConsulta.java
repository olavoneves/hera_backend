package br.com.hera.view.gui.consulta;

import br.com.hera.controller.ConsultaController;

import javax.swing.*;
import java.awt.*;

public class GUIListarUmaConsulta extends JPanel {
    private JLabel lbId;
    private JTextField tfId;
    private JButton btBuscar, btListarTodos;
    private JTextArea taResultado;
    private ConsultaController consultaController;

    public GUIListarUmaConsulta() {
        inicializarComponentes();
        definirEventos();
    }

    private void inicializarComponentes() {
        setLayout(new BorderLayout());
        setBackground(Color.RED);

        JPanel panelTop = new JPanel(new GridLayout(0, 1, 5, 5));
        lbId = new JLabel("Id da Consulta:");
        tfId = new JTextField(10);
        btBuscar = new JButton("Buscar");
        btListarTodos = new JButton("Listar Todos");

        panelTop.add(lbId);
        panelTop.add(tfId);
        panelTop.add(btBuscar);
        panelTop.add(btListarTodos);

        taResultado = new JTextArea();
        taResultado.setEditable(false);
        JScrollPane scroll = new JScrollPane(taResultado);

        add(panelTop, BorderLayout.NORTH);
        add(scroll, BorderLayout.CENTER);

        consultaController = new ConsultaController();
    }

    private void definirEventos() {
        btBuscar.addActionListener(e -> {
            try {
                int id = Integer.parseInt(tfId.getText());
                String resposta = consultaController.listarUmConsulta(id);
                taResultado.setText(resposta);
                limparCampos();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        });

        btListarTodos.addActionListener(e -> {
            try {
                String lista = consultaController.listarTodasConsultas();
                taResultado.setText(lista);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        });
    }

    private void limparCampos() {
        tfId.setText("");
    }
}
