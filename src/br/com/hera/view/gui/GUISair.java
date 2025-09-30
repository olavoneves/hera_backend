package br.com.hera.view.gui;

import javax.swing.*;
import java.awt.*;

public class GUISair extends JPanel {
    private JButton btCancelar;

    public GUISair() {
        inicializarComponentes();
        definirEventos();
    }

    private void inicializarComponentes() {
        JPanel panelTop = new JPanel(new GridLayout(0, 1, 5, 5));

        btCancelar = new JButton(new ImageIcon(getClass().getResource("images/exit_icon.png")));

        panelTop.add(btCancelar);

        add(panelTop, BorderLayout.NORTH);

    }

    private void definirEventos() {
        btCancelar.addActionListener(e -> System.exit(0));
    }
}
