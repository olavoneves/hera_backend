package br.com.hera.view.gui.medico;

import br.com.hera.controller.MedicoController;

import javax.swing.*;
import java.awt.*;

public class GUIListarUmMedico extends JPanel {
    private JLabel lbId;
    private JTextField tfId;
    private JButton btBuscar, btListarTodos;
    private JTextArea taResultado;
    private MedicoController medicoController;

    public GUIListarUmMedico() {
        inicializarComponentes();
        definirEventos();
    }

    private void inicializarComponentes() {
        setLayout(new BorderLayout());
        setBackground(Color.GRAY);

        JPanel panelTop = new JPanel(new GridLayout(0, 1, 5, 5));
        lbId = new JLabel("Id do Médico:");
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

        medicoController = new MedicoController();
    }

    private void definirEventos() {
        btBuscar.addActionListener(e -> {
            try {
                int id = Integer.parseInt(tfId.getText());
                String resposta = medicoController.listarUmMedico(id);
                taResultado.setText(resposta);
                limparCampos();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Digite um ID válido!");
            }
        });

        btListarTodos.addActionListener(e -> {
            try {
                String lista = medicoController.listarTodosMedicos();
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
