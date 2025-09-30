package br.com.hera.view.gui;

import br.com.hera.view.gui.paciente.GUIAtualizarPaciente;
import br.com.hera.view.gui.paciente.GUIExcluirPaciente;
import br.com.hera.view.gui.paciente.GUIInserirPaciente;
import br.com.hera.view.gui.paciente.GUIListarUmPaciente;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class GUIPrincipal extends JFrame {
    private JPanel painelPrincipal; // Área principal para trocar as telas
    private JMenuBar menuBar;
    private JMenu menuPaciente, menuMedico, menuConsulta, menuSair;
    private JMenuItem itemCadastrarPaciente, itemAtualizarPaciente, itemExcluirPaciente, itemListarPaciente, itemCadastrarMedico, itemAtualizarMedico, itemExcluirMedico, itemListarMedico, itemAgendarConsulta, itemExcluirConsulta, itemListarConsulta, itemSair;

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
        menuSair = new JMenu("Sair");

        itemCadastrarPaciente = new JMenuItem("Cadastrar Paciente");
        itemAtualizarPaciente = new JMenuItem("Atualizar Paciente");
        itemExcluirPaciente = new JMenuItem("Excluir Paciente");
        itemListarPaciente = new JMenuItem("Listar Paciente");
        itemCadastrarMedico = new JMenuItem("Cadastrar Médico");
        itemAtualizarMedico = new JMenuItem("Atualizar Médico");
        itemExcluirMedico = new JMenuItem("Excluir Médico");
        itemListarMedico = new JMenuItem("Listar Médico");
        itemAgendarConsulta = new JMenuItem("Agendar Consulta");
        itemExcluirConsulta = new JMenuItem("Excluir Consulta");
        itemListarConsulta = new JMenuItem("Listar Consulta");
        itemSair = new JMenuItem("Sair");

        menuPaciente.add(itemCadastrarPaciente);
        menuPaciente.add(itemAtualizarPaciente);
        menuPaciente.add(itemExcluirPaciente);
        menuPaciente.add(itemListarPaciente);
        menuMedico.add(itemCadastrarMedico);
        menuMedico.add(itemAtualizarMedico);
        menuMedico.add(itemExcluirMedico);
        menuMedico.add(itemListarMedico);
        menuConsulta.add(itemAgendarConsulta);
        menuConsulta.add(itemExcluirConsulta);
        menuConsulta.add(itemListarConsulta);
        menuSair.add(itemSair);

        menuBar.add(menuPaciente);
        menuBar.add(menuMedico);
        menuBar.add(menuConsulta);
        menuBar.add(menuSair);

        setJMenuBar(menuBar);
    }

    private void definirEventos() {
        // Paciente
        itemCadastrarPaciente.addActionListener((ActionEvent e) -> {
            GUIInserirPaciente guiInserirPaciente = new GUIInserirPaciente();
            setPainelPrincipal(guiInserirPaciente);
        });

        itemAtualizarPaciente.addActionListener((ActionEvent e) -> {
            GUIAtualizarPaciente guiAtualizarPaciente = new GUIAtualizarPaciente();
            setPainelPrincipal(guiAtualizarPaciente);
        });

        itemExcluirPaciente.addActionListener((ActionEvent e) -> {
            GUIExcluirPaciente guiExcluirPaciente = new GUIExcluirPaciente();
            setPainelPrincipal(guiExcluirPaciente);
        });

        itemListarPaciente.addActionListener((ActionEvent e) -> {
            GUIListarUmPaciente guiListarUmPaciente = new GUIListarUmPaciente();
            setPainelPrincipal(guiListarUmPaciente);
        });

        // Médico
        itemCadastrarMedico.addActionListener((ActionEvent e) -> {
            JPanel painelMedico = new JPanel();
            painelMedico.add(new JLabel("GUI Médico ainda não implementada"));
            setPainelPrincipal(painelMedico);
        });

        itemAtualizarMedico.addActionListener((ActionEvent e) -> {
            JPanel painelMedico = new JPanel();
            painelMedico.add(new JLabel("GUI Médico ainda não implementada"));
            setPainelPrincipal(painelMedico);
        });

        itemExcluirMedico.addActionListener((ActionEvent e) -> {
            JPanel painelMedico = new JPanel();
            painelMedico.add(new JLabel("GUI Médico ainda não implementada"));
            setPainelPrincipal(painelMedico);
        });

        itemListarMedico.addActionListener((ActionEvent e) -> {
            JPanel painelMedico = new JPanel();
            painelMedico.add(new JLabel("GUI Médico ainda não implementada"));
            setPainelPrincipal(painelMedico);
        });

        // Consulta
        itemAgendarConsulta.addActionListener((ActionEvent e) -> {
            JPanel painelConsulta = new JPanel();
            painelConsulta.add(new JLabel("GUI Consulta ainda não implementada"));
            setPainelPrincipal(painelConsulta);
        });

        itemExcluirConsulta.addActionListener((ActionEvent e) -> {
            JPanel painelConsulta = new JPanel();
            painelConsulta.add(new JLabel("GUI Consulta ainda não implementada"));
            setPainelPrincipal(painelConsulta);
        });

        itemListarConsulta.addActionListener((ActionEvent e) -> {
            JPanel painelConsulta = new JPanel();
            painelConsulta.add(new JLabel("GUI Consulta ainda não implementada"));
            setPainelPrincipal(painelConsulta);
        });

        // Sair
        itemSair.addActionListener((ActionEvent e) -> {
            GUISair guiSair = new GUISair();
            setPainelPrincipal(guiSair);
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
