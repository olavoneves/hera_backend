package br.com.hera.view.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class GUIPrincipal extends JFrame {
    private JPanel painelPrincipal; // Área principal para trocar as telas
    private JMenuBar menuBar;
    private JMenu menuPaciente, menuMedico, menuConsulta;
    private JMenuItem itemPaciente, itemMedico, itemConsulta;

    public GUIPrincipal() {
        inicializarComponentes();
        definirEventos();
        configurarJanela();
    }

    private void inicializarComponentes() {
        // Painel central que será trocado dinamicamente
        painelPrincipal = new JPanel(new BorderLayout());
        add(painelPrincipal, BorderLayout.CENTER);

        // Barra de menus
        menuBar = new JMenuBar();

        menuPaciente = new JMenu("Pacientes");
        menuMedico = new JMenu("Médicos");
        menuConsulta = new JMenu("Consultas");

        itemPaciente = new JMenuItem("Paciente");
        itemMedico = new JMenuItem("Médico");
        itemConsulta = new JMenuItem("Consulta");

        menuPaciente.add(itemPaciente);
        menuMedico.add(itemMedico);
        menuConsulta.add(itemConsulta);

        menuBar.add(menuPaciente);
        menuBar.add(menuMedico);
        menuBar.add(menuConsulta);

        setJMenuBar(menuBar);
    }

    private void definirEventos() {
        // Paciente
        itemPaciente.addActionListener((ActionEvent e) -> {
            GUIPaciente guiPaciente = new GUIPaciente();
            setPainelPrincipal(guiPaciente);
        });

        // Médico
        itemMedico.addActionListener((ActionEvent e) -> {
            JPanel painelMedico = new JPanel();
            painelMedico.add(new JLabel("GUI Médico ainda não implementada"));
            setPainelPrincipal(painelMedico);
        });

        // Consulta
        itemConsulta.addActionListener((ActionEvent e) -> {
            JPanel painelConsulta = new JPanel();
            painelConsulta.add(new JLabel("GUI Consulta ainda não implementada"));
            setPainelPrincipal(painelConsulta);
        });
    }

    private void setPainelPrincipal(JPanel painel) {
        painelPrincipal.removeAll();
        painelPrincipal.add(painel, BorderLayout.CENTER);
        painelPrincipal.revalidate();
        painelPrincipal.repaint();
    }

    private void configurarJanela() {
        setTitle("Sistema Hera");
        setSize(1400, 1000);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
