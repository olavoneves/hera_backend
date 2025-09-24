package br.com.hera.view.gui;

import br.com.hera.controller.PacienteController;
import br.com.hera.model.dto.Acompanhante;
import br.com.hera.model.dto.Telefone;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class GUIPaciente extends JPanel{
    private JLabel lbNome, lbEmail, lbSexo, lbTelefone, lbStatus, lbConsultasRestantes, lbFaltas, lbPossuiDeficiencia, lbTipoDeficiencia, lbVideoEnviado, lbDataNascimento, lbEndereco, lbPreferenciaContato, lbDataCadastro, lbUltimaAtualizacao, lbAcompanhante;
    private JTextField tfNome, tfEmail, tfSexo, tfDDD, tfNumero, tfTipo, tfStatus, tfConsultasRestantes, tfFaltas, tfTipoDeficiencia, tfEndereco, tfPreferenciaContato,tfAcompanhante;
    private JCheckBox cbPossuiDeficiencia, cbVideoEnviado, cbAtivo, cbPreferencial;
    private JTextField tfDataNascimento, tfDataCadastro, tfUltimaAtualizacao;
    private JButton btPesquisar, btNovo, btAtualizar, btApagar, btCancelar, btListarTodos;
    private JTextArea taListagem = new JTextArea();
    private JScrollPane scrollPane = new JScrollPane(taListagem);

    public GUIPaciente() {
        inicializarComponentes();
        definirEventos();
        setVisible(true);
    }

    private void inicializarComponentes() {
        setLayout(null);
        setBackground(Color.LIGHT_GRAY);

        // Labels
        lbNome = new JLabel("Nome:", JLabel.RIGHT);
        lbEmail = new JLabel("Email:", JLabel.RIGHT);
        lbSexo = new JLabel("Sexo:", JLabel.RIGHT);
        lbTelefone = new JLabel("Telefone:", JLabel.RIGHT);
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

        // TextFields
        tfNome = new JTextField();
        tfEmail = new JTextField();
        tfSexo = new JTextField();
        tfTelefone = new JTextField();
        tfStatus = new JTextField();
        tfConsultasRestantes = new JTextField();
        tfFaltas = new JTextField();
        tfTipoDeficiencia = new JTextField();
        tfEndereco = new JTextField();
        tfPreferenciaContato = new JTextField();
        tfAcompanhante = new JTextField();
        tfDataNascimento = new JTextField();
        tfDataCadastro = new JTextField();
        tfUltimaAtualizacao = new JTextField();

        // Checkboxes
        cbPossuiDeficiencia = new JCheckBox();
        cbVideoEnviado = new JCheckBox();

        // Botões
        btPesquisar = new JButton("Pesquisar");
        btNovo = new JButton("Novo");
        btAtualizar = new JButton("Atualizar");
        btApagar = new JButton("Apagar");
        btCancelar = new JButton("Cancelar");
        btListarTodos = new JButton("Listar Todos");

        // Definindo posições e tamanhos
        int labelWidth = 140, fieldWidth = 180, height = 25;
        int xLabel = 20, xField = 170;
        int y = 20, gap = 35;

        lbNome.setBounds(xLabel, y, labelWidth, height); tfNome.setBounds(xField, y, fieldWidth, height); y += gap;
        lbEmail.setBounds(xLabel, y, labelWidth, height); tfEmail.setBounds(xField, y, fieldWidth, height); y += gap;
        lbSexo.setBounds(xLabel, y, labelWidth, height); tfSexo.setBounds(xField, y, fieldWidth, height); y += gap;
        lbTelefone.setBounds(xLabel, y, labelWidth, height); tfTelefone.setBounds(xField, y, fieldWidth, height); y += gap;
        lbStatus.setBounds(xLabel, y, labelWidth, height); tfStatus.setBounds(xField, y, fieldWidth, height); y += gap;
        lbConsultasRestantes.setBounds(xLabel, y, labelWidth, height); tfConsultasRestantes.setBounds(xField, y, fieldWidth, height); y += gap;
        lbFaltas.setBounds(xLabel, y, labelWidth, height); tfFaltas.setBounds(xField, y, fieldWidth, height); y += gap;
        lbPossuiDeficiencia.setBounds(xLabel, y, labelWidth, height); cbPossuiDeficiencia.setBounds(xField, y, 20, height); y += gap;
        lbTipoDeficiencia.setBounds(xLabel, y, labelWidth, height); tfTipoDeficiencia.setBounds(xField, y, fieldWidth, height); y += gap;
        lbVideoEnviado.setBounds(xLabel, y, labelWidth, height); cbVideoEnviado.setBounds(xField, y, 20, height); y += gap;
        lbDataNascimento.setBounds(xLabel, y, labelWidth, height); tfDataNascimento.setBounds(xField, y, fieldWidth, height); y += gap;
        lbEndereco.setBounds(xLabel, y, labelWidth, height); tfEndereco.setBounds(xField, y, fieldWidth, height); y += gap;
        lbPreferenciaContato.setBounds(xLabel, y, labelWidth, height); tfPreferenciaContato.setBounds(xField, y, fieldWidth, height); y += gap;
        lbDataCadastro.setBounds(xLabel, y, labelWidth, height); tfDataCadastro.setBounds(xField, y, fieldWidth, height); y += gap;
        lbUltimaAtualizacao.setBounds(xLabel, y, labelWidth, height); tfUltimaAtualizacao.setBounds(xField, y, fieldWidth, height); y += gap;
        lbAcompanhante.setBounds(xLabel, y, labelWidth, height); tfAcompanhante.setBounds(xField, y, fieldWidth, height); y += gap;
        scrollPane.setBounds(20, 300, 600, 200);

        // Botões
        btNovo.setBounds(400, 50, 120, 40);
        btAtualizar.setBounds(400, 110, 120, 40);
        btApagar.setBounds(400, 170, 120, 40);
        btPesquisar.setBounds(400, 230, 120, 40);
        btCancelar.setBounds(400, 290, 120, 40);
        btListarTodos.setBounds(400, 350, 120, 40);

        // Adicionando componentes
        add(lbNome); add(tfNome);
        add(lbEmail); add(tfEmail);
        add(lbSexo); add(tfSexo);
        add(lbTelefone); add(tfTelefone);
        add(lbStatus); add(tfStatus);
        add(lbConsultasRestantes); add(tfConsultasRestantes);
        add(lbFaltas); add(tfFaltas);
        add(lbPossuiDeficiencia); add(cbPossuiDeficiencia);
        add(lbTipoDeficiencia); add(tfTipoDeficiencia);
        add(lbVideoEnviado); add(cbVideoEnviado);
        add(lbDataNascimento); add(tfDataNascimento);
        add(lbEndereco); add(tfEndereco);
        add(lbPreferenciaContato); add(tfPreferenciaContato);
        add(lbDataCadastro); add(tfDataCadastro);
        add(lbUltimaAtualizacao); add(tfUltimaAtualizacao);
        add(lbAcompanhante); add(tfAcompanhante);
        add(scrollPane);

        add(btNovo); add(btAtualizar); add(btApagar); add(btPesquisar); add(btCancelar); add(btListarTodos);
    }

    private void definirEventos() {
        btCancelar.addActionListener(e -> System.exit(0));

        btNovo.addActionListener(e -> {
            PacienteController controller = new PacienteController();
            try {
                String resposta = controller.inserirPaciente(
                        tfNome.getText(),
                        tfEmail.getText(),
                        tfSexo.getText(),
                        new Telefone(tfDDD.getText(), tfNumero.getText(), tfTipo.getText(), cbAtivo.isSelected(), cbPreferencial.isSelected()),
                        tfStatus.getText(),
                        Integer.parseInt(tfConsultasRestantes.getText()),
                        Integer.parseInt(tfFaltas.getText()),
                        cbPossuiDeficiencia.isSelected(),
                        tfTipoDeficiencia.getText(),
                        cbVideoEnviado.isSelected(),
                        LocalDate.parse(tfDataNascimento.getText()),
                        tfEndereco.getText(),
                        tfPreferenciaContato.getText(),
                        LocalDateTime.now(), // dataCadastro
                        LocalDateTime.now(), // ultimaAtualizacao
                        new Acompanhante(tfAcompanhante.getText()) // adaptando
                );
                JOptionPane.showMessageDialog(null, resposta);
                limparCampos();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
        });

        btAtualizar.addActionListener(e -> {
            PacienteController controller = new PacienteController();
            try {
                String resposta = controller.alterarPaciente(
                        Integer.parseInt(tfNome.getText()), // id precisa ser obtido em campo ou selecionado
                        tfNome.getText(),
                        tfEmail.getText(),
                        tfSexo.getText(),
                        new Telefone(tfTelefone.getText()),
                        tfStatus.getText(),
                        Integer.parseInt(tfConsultasRestantes.getText()),
                        Integer.parseInt(tfFaltas.getText()),
                        cbPossuiDeficiencia.isSelected(),
                        tfTipoDeficiencia.getText(),
                        cbVideoEnviado.isSelected(),
                        LocalDate.parse(tfDataNascimento.getText()),
                        tfEndereco.getText(),
                        tfPreferenciaContato.getText(),
                        LocalDateTime.parse(tfDataCadastro.getText()),
                        LocalDateTime.parse(tfUltimaAtualizacao.getText()),
                        new Acompanhante(tfAcompanhante.getText())
                );
                JOptionPane.showMessageDialog(null, resposta);
                limparCampos();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
        });

        btApagar.addActionListener(e -> {
            PacienteController controller = new PacienteController();
            try {
                int id = Integer.parseInt(tfNome.getText()); // id precisa ser obtido em campo ou selecionado
                String resposta = controller.excluirPaciente(id);
                JOptionPane.showMessageDialog(null, resposta);
                limparCampos();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
        });

        btPesquisar.addActionListener(e -> {
            PacienteController controller = new PacienteController();
            try {
                int id = Integer.parseInt(tfNome.getText());
                String resposta = controller.listarUmPaciente(id);
                JOptionPane.showMessageDialog(null, resposta);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
        });

        btListarTodos.addActionListener(e -> {
            PacienteController pacienteController = new PacienteController();
            try {
                String lista = pacienteController.listarTodosPacientes();
                taListagem.setText(lista);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
        });
    }

    private void limparCampos() {
        tfNome.setText("");
        tfEmail.setText("");
        tfSexo.setText("");
        tfTelefone.setText("");
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
    }
}