package br.com.hera.view.gui;

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

public class GUIPaciente extends JPanel {
    private JLabel lbId, lbNome, lbEmail, lbSexo, lbDDD, lbNumero, lbTipo, lbAtivo, lbPreferencial, lbStatus, lbConsultasRestantes, lbFaltas, lbPossuiDeficiencia,lbTipoDeficiencia, lbVideoEnviado, lbDataNascimento, lbEndereco, lbPreferenciaContato, lbDataCadastro, lbUltimaAtualizacao, lbAcompanhante, lbParentesco, lbDDD_Acomp, lbNumero_Acomp, lbTipo_Acomp, lbAtivo_Acomp, lbPreferencial_Acomp;
    private JTextField tfId, tfNome, tfEmail, tfSexo, tfDDD, tfNumero, tfTipo, tfStatus, tfConsultasRestantes, tfFaltas, tfTipoDeficiencia, tfEndereco,tfPreferenciaContato, tfAcompanhante, tfParentesco, tfDDD_Acomp, tfNumero_Acomp, tfTipo_Acomp;
    private JCheckBox cbPossuiDeficiencia, cbVideoEnviado, cbAtivo, cbPreferencial, cbAtivo_Acomp, cbPreferencial_Acomp;
    private JTextField tfDataNascimento, tfDataCadastro, tfUltimaAtualizacao;
    private JButton btPesquisar, btNovo, btAtualizar, btApagar, btCancelar, btListarTodos;
    private JTextArea taListagem = new JTextArea();
    private JScrollPane scrollPane = new JScrollPane(taListagem);

    public GUIPaciente() {
        inicializarComponentes();
        definirEventos();
    }

    private void inicializarComponentes() {
        setLayout(null);
        setBackground(Color.LIGHT_GRAY);

        // Labels
        lbId = new JLabel("Id:", JLabel.RIGHT);
        lbNome = new JLabel("Nome:", JLabel.RIGHT);
        lbEmail = new JLabel("Email:", JLabel.RIGHT);
        lbSexo = new JLabel("Sexo:", JLabel.RIGHT);
        lbDDD = new JLabel("DDD:", JLabel.RIGHT);
        lbNumero = new JLabel("Número:", JLabel.RIGHT);
        lbTipo = new JLabel("Tipo de Telefone:", JLabel.RIGHT);
        lbAtivo = new JLabel("Está Ativo:", JLabel.RIGHT);
        lbPreferencial = new JLabel("Preferencial:", JLabel.RIGHT);
        lbStatus = new JLabel("Status:", JLabel.RIGHT);
        lbConsultasRestantes = new JLabel("Consultas Restantes:", JLabel.RIGHT);
        lbFaltas = new JLabel("Faltas:", JLabel.RIGHT);
        lbPossuiDeficiencia = new JLabel("Possui Deficiência:", JLabel.RIGHT);
        lbTipoDeficiencia = new JLabel("Tipo Deficiência:", JLabel.RIGHT);
        lbVideoEnviado = new JLabel("Vídeo Enviado:", JLabel.RIGHT);
        lbDataNascimento = new JLabel("Data Nascimento:", JLabel.RIGHT);
        lbEndereco = new JLabel("Endereço:", JLabel.RIGHT);
        lbPreferenciaContato = new JLabel("Preferência Contato:", JLabel.RIGHT);
        lbDataCadastro = new JLabel("Data Cadastro:", JLabel.RIGHT);
        lbUltimaAtualizacao = new JLabel("Última Atualização:", JLabel.RIGHT);
        lbAcompanhante = new JLabel("Acompanhante:", JLabel.RIGHT);
        lbParentesco = new JLabel("Parentesco:", JLabel.RIGHT);
        lbDDD_Acomp = new JLabel("DDD Acomp.:", JLabel.RIGHT);
        lbNumero_Acomp = new JLabel("Número Acomp.:", JLabel.RIGHT);
        lbTipo_Acomp = new JLabel("Tipo Acomp.:", JLabel.RIGHT);
        lbAtivo_Acomp = new JLabel("Ativo Acomp.:", JLabel.RIGHT);
        lbPreferencial_Acomp = new JLabel("Preferencial Acomp.:", JLabel.RIGHT);

        // TextFields
        tfId = new JTextField();
        tfNome = new JTextField();
        tfEmail = new JTextField();
        tfSexo = new JTextField();
        tfDDD = new JTextField();
        tfNumero = new JTextField();
        tfTipo = new JTextField();
        tfStatus = new JTextField();
        tfConsultasRestantes = new JTextField();
        tfFaltas = new JTextField();
        tfTipoDeficiencia = new JTextField();
        tfEndereco = new JTextField();
        tfPreferenciaContato = new JTextField();
        tfDataNascimento = new JTextField();
        tfDataCadastro = new JTextField();
        tfUltimaAtualizacao = new JTextField();
        tfAcompanhante = new JTextField();
        tfParentesco = new JTextField();
        tfDDD_Acomp = new JTextField();
        tfNumero_Acomp = new JTextField();
        tfTipo_Acomp = new JTextField();

        // Checkboxes
        cbPossuiDeficiencia = new JCheckBox();
        cbVideoEnviado = new JCheckBox();
        cbAtivo = new JCheckBox();
        cbPreferencial = new JCheckBox();
        cbAtivo_Acomp = new JCheckBox();
        cbPreferencial_Acomp = new JCheckBox();

        // Botões
        btPesquisar = new JButton(new ImageIcon(getClass().getResource("images/search_icon.png")));
        btNovo = new JButton(new ImageIcon(getClass().getResource("images/new_icon.png")));
        btAtualizar = new JButton(new ImageIcon(getClass().getResource("images/update_icon.png")));
        btApagar = new JButton(new ImageIcon(getClass().getResource("images/delete_icon.png")));
        btCancelar = new JButton(new ImageIcon(getClass().getResource("images/exit_icon.png")));
        btListarTodos = new JButton("Listar Todos");

        taListagem = new JTextArea();
        scrollPane = new JScrollPane(taListagem);

        // Medidas
        int labelWidth = 140, fieldWidth = 180, height = 25, gapY = 40;
        int[] xLabels = {20, 420, 820};
        int[] xFields = {170, 570, 970};

        // Organização em 3 colunas
        int y = 20;
        int coluna = 0;

        addCampo(lbId, tfId, xLabels[coluna], xFields[coluna], y, labelWidth, fieldWidth, height); coluna++;
        addCampo(lbNome, tfNome, xLabels[coluna], xFields[coluna], y, labelWidth, fieldWidth, height); coluna++;
        addCampo(lbEmail, tfEmail, xLabels[coluna], xFields[coluna], y, labelWidth, fieldWidth, height);

        y += gapY; coluna = 0;
        addCampo(lbSexo, tfSexo, xLabels[coluna], xFields[coluna], y, labelWidth, fieldWidth, height); coluna++;
        addCampo(lbDDD, tfDDD, xLabels[coluna], xFields[coluna], y, labelWidth, fieldWidth, height); coluna++;
        addCampo(lbNumero, tfNumero, xLabels[coluna], xFields[coluna], y, labelWidth, fieldWidth, height);

        y += gapY; coluna = 0;
        addCampo(lbTipo, tfTipo, xLabels[coluna], xFields[coluna], y, labelWidth, fieldWidth, height); coluna++;
        addCheck(lbAtivo, cbAtivo, xLabels[coluna], xFields[coluna], y, labelWidth, height); coluna++;
        addCheck(lbPreferencial, cbPreferencial, xLabels[coluna], xFields[coluna], y, labelWidth, height);

        y += gapY; coluna = 0;
        addCampo(lbStatus, tfStatus, xLabels[coluna], xFields[coluna], y, labelWidth, fieldWidth, height); coluna++;
        addCampo(lbConsultasRestantes, tfConsultasRestantes, xLabels[coluna], xFields[coluna], y, labelWidth, fieldWidth, height); coluna++;
        addCampo(lbFaltas, tfFaltas, xLabels[coluna], xFields[coluna], y, labelWidth, fieldWidth, height);

        y += gapY; coluna = 0;
        addCheck(lbPossuiDeficiencia, cbPossuiDeficiencia, xLabels[coluna], xFields[coluna], y, labelWidth, height); coluna++;
        addCampo(lbTipoDeficiencia, tfTipoDeficiencia, xLabels[coluna], xFields[coluna], y, labelWidth, fieldWidth, height); coluna++;
        addCheck(lbVideoEnviado, cbVideoEnviado, xLabels[coluna], xFields[coluna], y, labelWidth, height);

        y += gapY; coluna = 0;
        addCampo(lbDataNascimento, tfDataNascimento, xLabels[coluna], xFields[coluna], y, labelWidth, fieldWidth, height); coluna++;
        addCampo(lbEndereco, tfEndereco, xLabels[coluna], xFields[coluna], y, labelWidth, fieldWidth, height); coluna++;
        addCampo(lbPreferenciaContato, tfPreferenciaContato, xLabels[coluna], xFields[coluna], y, labelWidth, fieldWidth, height);

        y += gapY; coluna = 0;
        addCampo(lbDataCadastro, tfDataCadastro, xLabels[coluna], xFields[coluna], y, labelWidth, fieldWidth, height); coluna++;
        addCampo(lbUltimaAtualizacao, tfUltimaAtualizacao, xLabels[coluna], xFields[coluna], y, labelWidth, fieldWidth, height); coluna++;
        addCampo(lbAcompanhante, tfAcompanhante, xLabels[coluna], xFields[coluna], y, labelWidth, fieldWidth, height);

        y += gapY; coluna = 0;
        addCampo(lbParentesco, tfParentesco, xLabels[coluna], xFields[coluna], y, labelWidth, fieldWidth, height); coluna++;
        addCampo(lbDDD_Acomp, tfDDD_Acomp, xLabels[coluna], xFields[coluna], y, labelWidth, fieldWidth, height); coluna++;
        addCampo(lbNumero_Acomp, tfNumero_Acomp, xLabels[coluna], xFields[coluna], y, labelWidth, fieldWidth, height);

        y += gapY; coluna = 0;
        addCampo(lbTipo_Acomp, tfTipo_Acomp, xLabels[coluna], xFields[coluna], y, labelWidth, fieldWidth, height); coluna++;
        addCheck(lbAtivo_Acomp, cbAtivo_Acomp, xLabels[coluna], xFields[coluna], y, labelWidth, height); coluna++;
        addCheck(lbPreferencial_Acomp, cbPreferencial_Acomp, xLabels[coluna], xFields[coluna], y, labelWidth, height);

        // Área de listagem
        scrollPane.setBounds(20, y + 60, 1200, 250);
        add(scrollPane);

        // Botões alinhados
        int btnY = y + 330;
        btNovo.setBounds(20, btnY, 120, 40);
        btAtualizar.setBounds(160, btnY, 120, 40);
        btApagar.setBounds(300, btnY, 120, 40);
        btPesquisar.setBounds(440, btnY, 120, 40);
        btCancelar.setBounds(580, btnY, 120, 40);
        btListarTodos.setBounds(720, btnY, 140, 40);

        add(btNovo); add(btAtualizar); add(btApagar);
        add(btPesquisar); add(btCancelar); add(btListarTodos);
    }

    private void definirEventos() {
        btCancelar.addActionListener(e -> System.exit(0));

        btNovo.addActionListener(e -> {
            PacienteController pacienteController = new PacienteController();
            TelefoneController telefoneController = new TelefoneController();
            AcompanhanteController acompanhanteController = new AcompanhanteController();

            try {
                // Inserir telefone do paciente
                Telefone telefone = new Telefone(tfDDD.getText(), tfNumero.getText(), tfTipo.getText(), cbAtivo.isSelected(), cbPreferencial.isSelected());
                int telefoneId = telefoneController.inserirTelefone(telefone);
                telefone.setId(telefoneId);

                // Inserir telefone do acompanhante
                Telefone telefoneAcomp = new Telefone(tfDDD_Acomp.getText(), tfNumero_Acomp.getText(), tfTipo_Acomp.getText(), cbAtivo_Acomp.isSelected(), cbPreferencial_Acomp.isSelected());
                int telefoneAcompId = telefoneController.inserirTelefone(telefoneAcomp);
                telefoneAcomp.setId(telefoneAcompId);

                // Inserir acompanhante
                Acompanhante acompanhante = new Acompanhante(tfAcompanhante.getText(), telefoneAcomp, tfParentesco.getText(), tfEmail.getText(), LocalDateTime.now()) ;
                int acompanhanteId = acompanhanteController.inserirAcompanhante(acompanhante);
                acompanhante.setId(acompanhanteId);

                // Inserir paciente
                String resposta = pacienteController.inserirPaciente(
                        tfNome.getText(),
                        tfEmail.getText(),
                        tfSexo.getText(),
                        telefone,
                        tfStatus.getText(),
                        Integer.parseInt(tfConsultasRestantes.getText()),
                        Integer.parseInt(tfFaltas.getText()),
                        cbPossuiDeficiencia.isSelected(),
                        tfTipoDeficiencia.getText(),
                        cbVideoEnviado.isSelected(),
                        LocalDate.parse(tfDataNascimento.getText(), DateTimeFormatter.ofPattern("dd/MM/yyyy")),
                        tfEndereco.getText(),
                        tfPreferenciaContato.getText(),
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

        btAtualizar.addActionListener(e -> {
            PacienteController pacienteController = new PacienteController();
            TelefoneController telefoneController = new TelefoneController();
            AcompanhanteController acompanhanteController = new AcompanhanteController();

            try {
                // Inserir telefone do paciente
                Telefone telefone = new Telefone(tfDDD.getText(), tfNumero.getText(), tfTipo.getText(), cbAtivo.isSelected(), cbPreferencial.isSelected());
                int telefoneId = telefoneController.alterarTelefone(telefone);
                telefone.setId(telefoneId);

                // Inserir telefone do acompanhante
                Telefone telefoneAcomp = new Telefone(tfDDD_Acomp.getText(), tfNumero_Acomp.getText(), tfTipo_Acomp.getText(), cbAtivo_Acomp.isSelected(), cbPreferencial_Acomp.isSelected());
                int telefoneAcompId = telefoneController.alterarTelefone(telefoneAcomp);
                telefoneAcomp.setId(telefoneAcompId);

                // Inserir acompanhante
                Acompanhante acompanhante = new Acompanhante(tfAcompanhante.getText(), telefoneAcomp, tfParentesco.getText(), tfEmail.getText(), LocalDateTime.now()) ;
                int acompanhanteId = acompanhanteController.alterarAcompanhante(acompanhante);
                acompanhante.setId(acompanhanteId);

                // Inserir paciente
                String resposta = pacienteController.alterarPaciente(
                        Integer.parseInt(tfId.getText()),
                        tfNome.getText(),
                        tfEmail.getText(),
                        tfSexo.getText(),
                        telefone,
                        tfStatus.getText(),
                        Integer.parseInt(tfConsultasRestantes.getText()),
                        Integer.parseInt(tfFaltas.getText()),
                        cbPossuiDeficiencia.isSelected(),
                        tfTipoDeficiencia.getText(),
                        cbVideoEnviado.isSelected(),
                        LocalDate.parse(tfDataNascimento.getText(), DateTimeFormatter.ofPattern("dd/MM/yyyy")),
                        tfEndereco.getText(),
                        tfPreferenciaContato.getText(),
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

        btApagar.addActionListener(e -> {
            PacienteController pacienteController = new PacienteController();
            try {
                int id = Integer.parseInt(tfId.getText());
                String resposta = pacienteController.excluirPaciente(id);
                JOptionPane.showMessageDialog(null, resposta, "INFORMAÇÃO", JOptionPane.INFORMATION_MESSAGE);
                limparCampos();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        });

        btPesquisar.addActionListener(e -> {
            PacienteController pacienteController = new PacienteController();
            try {
                int id = Integer.parseInt(tfId.getText());
                String resposta = pacienteController.listarUmPaciente(id);
                JOptionPane.showMessageDialog(null, resposta, "INFORMAÇÃO", JOptionPane.INFORMATION_MESSAGE);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        });

        btListarTodos.addActionListener(e -> {
            PacienteController pacienteController = new PacienteController();
            try {
                String lista = pacienteController.listarTodosPacientes();
                taListagem.setText(lista);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        });
    }

    private void limparCampos() {
        tfId.setText("");
        tfNome.setText("");
        tfEmail.setText("");
        tfSexo.setText("");
        tfDDD.setText("");
        tfNumero.setText("");
        tfTipo.setText("");
        cbAtivo.setSelected(false);
        cbPreferencial.setSelected(false);
        tfStatus.setText("");
        tfConsultasRestantes.setText("");
        tfFaltas.setText("");
        cbPossuiDeficiencia.setSelected(false);
        tfTipoDeficiencia.setText("");
        cbVideoEnviado.setSelected(false);
        tfDataNascimento.setText("");
        tfEndereco.setText("");
        tfPreferenciaContato.setText("");
        tfDataCadastro.setText("");
        tfUltimaAtualizacao.setText("");
        tfAcompanhante.setText("");
        tfParentesco.setText("");
        tfDDD_Acomp.setText("");
        tfNumero_Acomp.setText("");
        tfTipo_Acomp.setText("");
        cbAtivo_Acomp.setSelected(false);
        cbPreferencial_Acomp.setSelected(false);
    }

    private void addCampo(JLabel label, JTextField field, int xLabel, int xField, int y, int labelWidth, int fieldWidth, int height) {
        label.setBounds(xLabel, y, labelWidth, height);
        field.setBounds(xField, y, fieldWidth, height);
        add(label); add(field);
    }

    private void addCheck(JLabel label, JCheckBox check, int xLabel, int xField, int y, int labelWidth, int height) {
        label.setBounds(xLabel, y, labelWidth, height);
        check.setBounds(xField, y, 20, height);
        add(label); add(check);
    }
}
