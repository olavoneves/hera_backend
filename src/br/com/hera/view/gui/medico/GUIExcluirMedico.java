package br.com.hera.view.gui.medico;

import br.com.hera.controller.MedicoController;

import javax.swing.*;
import java.awt.*;

public class GUIExcluirMedico extends JPanel {
    private JLabel lbId;
    private JTextField tfId;
    private JButton btExcluir, btListarTodos;
    private JTextArea taLista;
    private MedicoController medicoController;

    public GUIExcluirMedico() {
        inicializarComponentes();
        definirEventos();
    }

    private void inicializarComponentes() {
        setLayout(new BorderLayout());
        setBackground(Color.RED);

        JPanel panelTop = new JPanel(new GridLayout(0, 1, 5, 5));
        lbId = new JLabel("Id do Médico:");
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

        medicoController = new MedicoController();
    }

    private void definirEventos() {
        btExcluir.addActionListener(e -> {
            try {
                int id = Integer.parseInt(tfId.getText());
                String resposta = medicoController.excluirMedico(id);
                JOptionPane.showMessageDialog(null, resposta, "INFORMAÇÃO", JOptionPane.INFORMATION_MESSAGE);
                limparCampos();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        });

        btListarTodos.addActionListener(e -> {
            try {
                String lista = medicoController.listarTodosMedicos();
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
