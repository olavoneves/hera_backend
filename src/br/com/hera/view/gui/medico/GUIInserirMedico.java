package br.com.hera.view.gui.medico;

import br.com.hera.controller.MedicoController;
import br.com.hera.controller.TelefoneController;
import br.com.hera.model.dto.Telefone;

import javax.swing.*;
import java.awt.*;

public class GUIInserirMedico extends JPanel {
    private JLabel lbNome, lbCrm, lbEspecialidade, lbEmail, lbDDD, lbNumero, lbTipo, lbCargaHorariaSemanal, lbStatus;
    private JTextField tfNome, tfCrm, tfEspecialidade, tfEmail, tfDDD, tfNumero, tfTipo, tfCargaHorariaSemanal, tfStatus;
    private JCheckBox cbAtivo, cbPreferencial;
    private JButton btInserir, btListarTodos;
    private JTextArea taLista;
    private MedicoController medicoController;

    public GUIInserirMedico() {
        inicializarComponentes();
        definirEventos();
    }

    private void inicializarComponentes() {
        setLayout(new BorderLayout());
        setBackground(Color.GREEN);

        JPanel panelTop = new JPanel(new GridLayout(0, 4, 10, 10));

        lbNome = new JLabel("Nome:");
        tfNome = new JTextField();
        lbCrm = new JLabel("CRM:");
        tfCrm = new JTextField();
        lbEspecialidade = new JLabel("Especialidade:");
        tfEspecialidade = new JTextField();
        lbEmail = new JLabel("Email:");
        tfEmail = new JTextField();
        lbDDD = new JLabel("DDD:");
        tfDDD = new JTextField();
        lbNumero = new JLabel("Número do Telefone:");
        tfNumero = new JTextField();
        lbTipo = new JLabel("Tipo do Telefone:");
        tfTipo = new JTextField();
        cbAtivo = new JCheckBox("Ativo");
        cbPreferencial = new JCheckBox("Preferencial");
        lbCargaHorariaSemanal = new JLabel("Carga Horária Semanal: ");
        tfCargaHorariaSemanal = new JTextField();
        lbStatus = new JLabel("Status do Médico:");
        tfStatus = new JTextField();

        panelTop.add(lbNome); panelTop.add(tfNome);
        panelTop.add(lbCrm); panelTop.add(tfCrm);
        panelTop.add(lbEspecialidade); panelTop.add(tfEspecialidade);
        panelTop.add(lbEmail); panelTop.add(tfEmail);
        panelTop.add(lbDDD); panelTop.add(tfDDD);
        panelTop.add(lbNumero); panelTop.add(tfNumero);
        panelTop.add(lbTipo); panelTop.add(tfTipo);
        panelTop.add(cbAtivo); panelTop.add(cbPreferencial);
        panelTop.add(lbCargaHorariaSemanal); panelTop.add(tfCargaHorariaSemanal);
        panelTop.add(lbStatus); panelTop.add(tfStatus);

        btInserir = new JButton("Inserir");
        btListarTodos = new JButton("Listar Todos");

        taLista = new JTextArea();
        taLista.setEditable(false);
        JScrollPane scroll = new JScrollPane(taLista);

        panelTop.add(btInserir);
        panelTop.add(btListarTodos);

        add(panelTop, BorderLayout.NORTH);
        add(scroll, BorderLayout.CENTER);

        medicoController = new MedicoController();
    }

    private void definirEventos() {
        btInserir.addActionListener(e -> {
            try {
                TelefoneController telefoneController = new TelefoneController();

                Telefone telefone = new Telefone(tfDDD.getText(), tfNumero.getText(), tfTipo.getText(), cbAtivo.isSelected(), cbPreferencial.isSelected());
                telefone.setId(telefoneController.inserirTelefone(telefone));

                String resposta = medicoController.inserirMedico(
                        tfNome.getText(), tfCrm.getText(), tfEspecialidade.getText(), tfEmail.getText(), telefone, Integer.parseInt(tfCargaHorariaSemanal.getText()), tfStatus.getText()
                );
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
        tfNome.setText(""); tfCrm.setText(""); tfEspecialidade.setText(""); tfEmail.setText(""); tfDDD.setText(""); tfNumero.setText("");
        tfTipo.setText(""); tfCargaHorariaSemanal.setText(""); tfStatus.setText("");
        cbAtivo.setSelected(false); cbPreferencial.setSelected(false);
    }
}
