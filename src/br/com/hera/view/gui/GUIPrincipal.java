package br.com.hera.view.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class GUIPrincipal extends JFrame {
    private Container container;
    private JMenuBar menuBar;
    private JMenu menuPaciente, menuMedico, menuConsulta;
    private JMenuItem itemCadastroPaciente, itemCadastroMedico, itemCadastroConsulta;

    public GUIPrincipal() {
        inicializarComponentes();
        definirEventos();
        configurarJanela();
    }

    private void inicializarComponentes() {
        container = getContentPane();

        menuBar = new JMenuBar();

        menuPaciente = new JMenu("Pacientes");
        menuMedico = new JMenu("Médicos");
        menuConsulta = new JMenu("Consultas");

        itemCadastroPaciente = new JMenuItem("Cadastro de Pacientes");
        itemCadastroMedico = new JMenuItem("Cadastro de Médicos");
        itemCadastroConsulta = new JMenuItem("Agendar Consulta");

        menuPaciente.add(itemCadastroPaciente);
        menuMedico.add(itemCadastroMedico);
        menuConsulta.add(itemCadastroConsulta);

        menuBar.add(menuPaciente);
        menuBar.add(menuMedico);
        menuBar.add(menuConsulta);

        setJMenuBar(menuBar);
    }

    private void definirEventos() {
        // Paciente
        itemCadastroPaciente.addActionListener((ActionEvent e) -> {
            GUIPaciente guiPaciente = new GUIPaciente();
            container.removeAll();
            container.add(guiPaciente);
            container.validate();
        });

        // Médico
        itemCadastroMedico.addActionListener((ActionEvent e) -> {
            JOptionPane.showMessageDialog(this, "GUI Médico ainda não implementada");
        });

        // Consulta
        itemCadastroConsulta.addActionListener((ActionEvent e) -> {
            JOptionPane.showMessageDialog(this, "GUI Consulta ainda não implementada");
        });
    }

    private void configurarJanela() {
        setTitle("Sistema Hera");
        setSize(900, 700);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
