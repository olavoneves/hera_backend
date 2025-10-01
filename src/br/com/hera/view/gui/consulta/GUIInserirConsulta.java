package br.com.hera.view.gui.consulta;

import br.com.hera.controller.ConsultaController;
import br.com.hera.model.dto.Medico;
import br.com.hera.model.dto.Paciente;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class GUIInserirConsulta extends JPanel {
    private JLabel lbIdPaciente, lbIdMedico, lbDataConsulta, lbHorarioConsulta, lbStatus, lbTipoConsulta, lbObservacoes, lbLinkTeleconsulta, lbDuracaoEstimada;
    private JTextField tfIdPaciente, tfIdMedico, tfDataConsulta, tfHorarioConsulta, tfStatus, tfTipoConsulta, tfObservacoes, tfLinkTeleconsulta, tfDuracaoEstimada;
    private JButton btInserir, btListarTodos;
    private JTextArea taLista;
    private ConsultaController consultaController;

    public GUIInserirConsulta() {
        inicializarComponentes();
        definirEventos();
    }

    private void inicializarComponentes() {
        setLayout(new BorderLayout());
        setBackground(Color.GREEN);

        JPanel panelTop = new JPanel(new GridLayout(0, 4, 10, 10));

        lbIdPaciente = new JLabel("ID Paciente:");
        tfIdPaciente = new JTextField();
        lbIdMedico = new JLabel("ID Médico:");
        tfIdMedico = new JTextField();
        lbDataConsulta = new JLabel("Data Consulta (dd/MM/yyyy):");
        tfDataConsulta = new JTextField();
        lbHorarioConsulta = new JLabel("Horário Consulta (HH:mm):");
        tfHorarioConsulta = new JTextField();
        lbStatus = new JLabel("Status:");
        tfStatus = new JTextField();
        lbTipoConsulta = new JLabel("Tipo Consulta:");
        tfTipoConsulta = new JTextField();
        lbObservacoes = new JLabel("Observações:");
        tfObservacoes = new JTextField();
        lbLinkTeleconsulta = new JLabel("Link Teleconsulta:");
        tfLinkTeleconsulta = new JTextField();
        lbDuracaoEstimada = new JLabel("Duração Estimada:");
        tfDuracaoEstimada = new JTextField();

        panelTop.add(lbIdPaciente); panelTop.add(tfIdPaciente);
        panelTop.add(lbIdMedico); panelTop.add(tfIdMedico);
        panelTop.add(lbDataConsulta); panelTop.add(tfDataConsulta);
        panelTop.add(lbHorarioConsulta); panelTop.add(tfHorarioConsulta);
        panelTop.add(lbStatus); panelTop.add(tfStatus);
        panelTop.add(lbTipoConsulta); panelTop.add(tfTipoConsulta);
        panelTop.add(lbObservacoes); panelTop.add(tfObservacoes);
        panelTop.add(lbLinkTeleconsulta); panelTop.add(tfLinkTeleconsulta);
        panelTop.add(lbDuracaoEstimada); panelTop.add(tfDuracaoEstimada);

        btInserir = new JButton("Inserir");
        btListarTodos = new JButton("Listar Todos");

        taLista = new JTextArea();
        taLista.setEditable(false);
        JScrollPane scroll = new JScrollPane(taLista);

        panelTop.add(btInserir);
        panelTop.add(btListarTodos);

        add(panelTop, BorderLayout.NORTH);
        add(scroll, BorderLayout.CENTER);

        consultaController = new ConsultaController();
    }

    private void definirEventos() {
        btInserir.addActionListener(e -> {
            try {
                Paciente paciente = new Paciente();
                paciente.setId(Integer.parseInt(tfIdPaciente.getText()));

                Medico medico = new Medico();
                medico.setId(Integer.parseInt(tfIdMedico.getText()));

                String resposta = consultaController.inserirConsulta(
                        paciente, medico, LocalDate.parse(tfDataConsulta.getText(), DateTimeFormatter.ofPattern("dd/MM/yyyy")), LocalTime.parse(tfHorarioConsulta.getText(), DateTimeFormatter.ofPattern("HH:mm")), tfStatus.getText(), tfTipoConsulta.getText(), tfObservacoes.getText(), tfLinkTeleconsulta.getText(), Integer.parseInt(tfDuracaoEstimada.getText())
                );
                JOptionPane.showMessageDialog(null, resposta, "INFORMAÇÃO", JOptionPane.INFORMATION_MESSAGE);
                limparCampos();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        });

        btListarTodos.addActionListener(e -> {
            try {
                String lista = consultaController.listarTodasConsultas();
                taLista.setText(lista);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        });
    }

    private void limparCampos() {
        tfIdPaciente.setText(""); tfIdMedico.setText(""); tfDataConsulta.setText("");
        tfHorarioConsulta.setText(""); tfStatus.setText(""); tfTipoConsulta.setText("");
        tfObservacoes.setText(""); tfLinkTeleconsulta.setText(""); tfDuracaoEstimada.setText("");
    }
}
