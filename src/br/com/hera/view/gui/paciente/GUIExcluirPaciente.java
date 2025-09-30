package br.com.hera.view.gui.paciente;

import br.com.hera.controller.PacienteController;

import javax.swing.*;
import java.awt.*;

public class GUIExcluirPaciente extends JPanel {
    private JLabel lbId;
    private JTextField tfId;
    private JButton btExcluir, btListarTodos;
    private JTextArea taLista;
    private PacienteController pacienteController;

    public GUIExcluirPaciente() {
        inicializarComponentes();
        definirEventos();
    }

    private void inicializarComponentes() {
        setLayout(new BorderLayout());
        setBackground(Color.RED);

        JPanel panelTop = new JPanel(new GridLayout(0, 1, 5, 5));
        lbId = new JLabel("Id do Paciente:");
        tfId = new JTextField(10);
        btExcluir = new JButton("Excluir");
        btListarTodos = new JButton("Listar Todos");

        panelTop.add(lbId);
        panelTop.add(tfId);
        panelTop.add(btExcluir);
        panelTop.add(btListarTodos);

        taLista = new JTextArea();
        taLista.setEditable(false);
        JScrollPane scroll = new JScrollPane(taLista);

        add(panelTop, BorderLayout.NORTH);
        add(scroll, BorderLayout.CENTER);

        pacienteController = new PacienteController();
    }

    private void definirEventos() {
        btExcluir.addActionListener(e -> {
            try {
                int id = Integer.parseInt(tfId.getText());
                String resposta = pacienteController.excluirPaciente(id);
                JOptionPane.showMessageDialog(null, resposta, "INFORMAÇÃO", JOptionPane.INFORMATION_MESSAGE);
                limparCampos();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        });

        btListarTodos.addActionListener(e -> {
            try {
                String lista = pacienteController.listarTodosPacientes();
                taLista.setText(lista);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        });
    }

    private void limparCampos() {
        tfId.setText("");
    }
}
