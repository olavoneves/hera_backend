package br.com.hera.view.gui.paciente;

import br.com.hera.controller.AcompanhanteController;
import br.com.hera.controller.PacienteController;
import br.com.hera.controller.TelefoneController;
import br.com.hera.model.dto.Acompanhante;
import br.com.hera.model.dto.Telefone;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class GUIAtualizarPaciente extends JPanel {
    private JLabel lbIdPaciente, lbIdTelefone, lbIdAcompanhante, lbIdTelefoneAcomp;
    private JTextField tfIdPaciente, tfIdTelefone, tfIdAcompanhante, tfIdTelefoneAcomp;
    private JLabel lbNome, lbEmail, lbSexo, lbDDD, lbNumero, lbTipo, lbStatus, lbConsultasRestantes, lbFaltas,
            lbTipoDeficiencia, lbDataNascimento, lbEndereco, lbPreferenciaContato,
            lbDataCadastro, lbUltimaAtualizacao, lbAcompanhante, lbParentesco, lbDDD_Acomp, lbNumero_Acomp, lbTipo_Acomp;
    private JTextField tfNome, tfEmail, tfSexo, tfDDD, tfNumero, tfTipo, tfStatus, tfConsultasRestantes, tfFaltas,
            tfTipoDeficiencia, tfDataNascimento, tfEndereco, tfPreferenciaContato, tfDataCadastro, tfUltimaAtualizacao,
            tfAcompanhante, tfParentesco, tfDDD_Acomp, tfNumero_Acomp, tfTipo_Acomp;
    private JCheckBox cbPossuiDeficiencia, cbVideoEnviado, cbAtivo, cbPreferencial, cbAtivo_Acomp, cbPreferencial_Acomp;
    private JButton btAtualizar, btListarTodos;
    private JTextArea taLista;
    private PacienteController pacienteController;

    public GUIAtualizarPaciente() {
        inicializarComponentes();
        definirEventos();
    }

    private void inicializarComponentes() {
        setLayout(new BorderLayout());
        setBackground(Color.YELLOW);

        JPanel panelTop = new JPanel(new GridLayout(0, 4, 10, 10));

        lbIdPaciente = new JLabel("ID Paciente:");
        tfIdPaciente = new JTextField();
        lbIdTelefone = new JLabel("ID Telefone:");
        tfIdTelefone = new JTextField();
        lbIdAcompanhante = new JLabel("ID Acompanhante:");
        tfIdAcompanhante = new JTextField();
        lbIdTelefoneAcomp = new JLabel("ID Telefone Acomp.:");
        tfIdTelefoneAcomp = new JTextField();

        lbNome = new JLabel("Nome:");
        tfNome = new JTextField();
        lbEmail = new JLabel("Email:");
        tfEmail = new JTextField();
        lbSexo = new JLabel("Sexo:");
        tfSexo = new JTextField();
        lbDDD = new JLabel("DDD:");
        tfDDD = new JTextField();
        lbNumero = new JLabel("Número do Telefone:");
        tfNumero = new JTextField();
        lbTipo = new JLabel("Tipo do Telefone:");
        tfTipo = new JTextField();
        cbAtivo = new JCheckBox("Ativo");
        cbPreferencial = new JCheckBox("Preferencial");

        lbStatus = new JLabel("Status do Paciente:");
        tfStatus = new JTextField();
        lbConsultasRestantes = new JLabel("Consultas Restantes:");
        tfConsultasRestantes = new JTextField();
        lbFaltas = new JLabel("Faltas:");
        tfFaltas = new JTextField();
        cbPossuiDeficiencia = new JCheckBox("Possui Deficiência");
        lbTipoDeficiencia = new JLabel("Tipo de Deficiência:");
        tfTipoDeficiencia = new JTextField();
        cbVideoEnviado = new JCheckBox("Vídeo Enviado");
        lbDataNascimento = new JLabel("Data de Nascimento (dd/MM/yyyy):");
        tfDataNascimento = new JTextField();
        lbEndereco = new JLabel("Endereço:");
        tfEndereco = new JTextField();
        lbPreferenciaContato = new JLabel("Preferência Contato:");
        tfPreferenciaContato = new JTextField();
        lbDataCadastro = new JLabel("Data de Cadastro (dd/MM/yyyy HH:mm):");
        tfDataCadastro = new JTextField();
        lbUltimaAtualizacao = new JLabel("Última Atualização (dd/MM/yyyy HH:mm):");
        tfUltimaAtualizacao = new JTextField();
        lbAcompanhante = new JLabel("Nome do Acompanhante:");
        tfAcompanhante = new JTextField();
        lbParentesco = new JLabel("Parentesco:");
        tfParentesco = new JTextField();
        lbDDD_Acomp = new JLabel("DDD Tel. Acomp.:");
        tfDDD_Acomp = new JTextField();
        lbNumero_Acomp = new JLabel("Número Tel. Acomp.:");
        tfNumero_Acomp = new JTextField();
        lbTipo_Acomp = new JLabel("Tipo Tel. Acomp.:");
        tfTipo_Acomp = new JTextField();
        cbAtivo_Acomp = new JCheckBox("Tel. Acomp. Está Ativo");
        cbPreferencial_Acomp = new JCheckBox("Tel. Acomp. é Preferencial.");

        panelTop.add(lbIdPaciente); panelTop.add(tfIdPaciente);
        panelTop.add(lbIdTelefone); panelTop.add(tfIdTelefone);
        panelTop.add(lbIdAcompanhante); panelTop.add(tfIdAcompanhante);
        panelTop.add(lbIdTelefoneAcomp); panelTop.add(tfIdTelefoneAcomp);
        panelTop.add(lbNome); panelTop.add(tfNome);
        panelTop.add(lbEmail); panelTop.add(tfEmail);
        panelTop.add(lbSexo); panelTop.add(tfSexo);
        panelTop.add(lbDDD); panelTop.add(tfDDD);
        panelTop.add(lbNumero); panelTop.add(tfNumero);
        panelTop.add(lbTipo); panelTop.add(tfTipo);
        panelTop.add(cbAtivo); panelTop.add(cbPreferencial);
        panelTop.add(lbStatus); panelTop.add(tfStatus);
        panelTop.add(lbConsultasRestantes); panelTop.add(tfConsultasRestantes);
        panelTop.add(lbFaltas); panelTop.add(tfFaltas);
        panelTop.add(cbPossuiDeficiencia); panelTop.add(lbTipoDeficiencia); panelTop.add(tfTipoDeficiencia); panelTop.add(cbVideoEnviado);
        panelTop.add(lbDataNascimento); panelTop.add(tfDataNascimento);
        panelTop.add(lbEndereco); panelTop.add(tfEndereco);
        panelTop.add(lbPreferenciaContato); panelTop.add(tfPreferenciaContato);
        panelTop.add(lbDataCadastro); panelTop.add(tfDataCadastro);
        panelTop.add(lbUltimaAtualizacao); panelTop.add(tfUltimaAtualizacao);
        panelTop.add(lbAcompanhante); panelTop.add(tfAcompanhante);
        panelTop.add(lbParentesco); panelTop.add(tfParentesco);
        panelTop.add(lbDDD_Acomp); panelTop.add(tfDDD_Acomp);
        panelTop.add(lbNumero_Acomp); panelTop.add(tfNumero_Acomp);
        panelTop.add(lbTipo_Acomp); panelTop.add(tfTipo_Acomp);
        panelTop.add(cbAtivo_Acomp); panelTop.add(cbPreferencial_Acomp);

        btAtualizar = new JButton("Atualizar");
        btListarTodos = new JButton("Listar Todos");

        taLista = new JTextArea();
        taLista.setEditable(false);
        JScrollPane scroll = new JScrollPane(taLista);

        panelTop.add(btAtualizar);
        panelTop.add(btListarTodos);

        add(panelTop, BorderLayout.NORTH);
        add(scroll, BorderLayout.CENTER);

        pacienteController = new PacienteController();
    }

    private void definirEventos() {
        btAtualizar.addActionListener(e -> {
            try {
                TelefoneController telefoneController = new TelefoneController();
                AcompanhanteController acompanhanteController = new AcompanhanteController();

                Telefone telefone = new Telefone(tfDDD.getText(), tfNumero.getText(), tfTipo.getText(), cbAtivo.isSelected(), cbPreferencial.isSelected());
                telefone.setId(Integer.parseInt(tfIdTelefone.getText()));
                telefoneController.alterarTelefone(telefone);

                Telefone telefoneAcomp = new Telefone(tfDDD_Acomp.getText(), tfNumero_Acomp.getText(), tfTipo_Acomp.getText(), cbAtivo_Acomp.isSelected(), cbPreferencial_Acomp.isSelected());
                telefoneAcomp.setId(Integer.parseInt(tfIdTelefoneAcomp.getText()));
                telefoneController.alterarTelefone(telefoneAcomp);

                Acompanhante acompanhante = new Acompanhante(tfAcompanhante.getText(), telefoneAcomp, tfParentesco.getText(), tfEmail.getText(), LocalDateTime.now());
                acompanhante.setId(Integer.parseInt(tfIdAcompanhante.getText()));
                acompanhanteController.alterarAcompanhante(acompanhante);

                String resposta = pacienteController.alterarPaciente(
                        Integer.parseInt(tfIdPaciente.getText()),
                        tfNome.getText(), tfEmail.getText(), tfSexo.getText(),
                        telefone, tfStatus.getText(), Integer.parseInt(tfConsultasRestantes.getText()),
                        Integer.parseInt(tfFaltas.getText()), cbPossuiDeficiencia.isSelected(),
                        tfTipoDeficiencia.getText(), cbVideoEnviado.isSelected(),
                        LocalDate.parse(tfDataNascimento.getText(), DateTimeFormatter.ofPattern("dd/MM/yyyy")),
                        tfEndereco.getText(), tfPreferenciaContato.getText(),
                        LocalDateTime.parse(tfDataCadastro.getText(), DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm")),
                        LocalDateTime.parse(tfUltimaAtualizacao.getText(), DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm")),
                        acompanhante
                );
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
        tfIdPaciente.setText(""); tfIdTelefone.setText(""); tfIdAcompanhante.setText(""); tfIdTelefoneAcomp.setText("");
        tfNome.setText(""); tfEmail.setText(""); tfSexo.setText(""); tfDDD.setText(""); tfNumero.setText(""); tfTipo.setText("");
        cbAtivo.setSelected(false); cbPreferencial.setSelected(false);
        tfStatus.setText(""); tfConsultasRestantes.setText(""); tfFaltas.setText("");
        cbPossuiDeficiencia.setSelected(false); tfTipoDeficiencia.setText(""); cbVideoEnviado.setSelected(false);
        tfDataNascimento.setText(""); tfEndereco.setText(""); tfPreferenciaContato.setText("");
        tfDataCadastro.setText(""); tfUltimaAtualizacao.setText("");
        tfAcompanhante.setText(""); tfParentesco.setText(""); tfDDD_Acomp.setText(""); tfNumero_Acomp.setText(""); tfTipo_Acomp.setText("");
        cbAtivo_Acomp.setSelected(false); cbPreferencial_Acomp.setSelected(false);
    }
}
