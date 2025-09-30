package br.com.hera.view;

import br.com.hera.view.gui.GUIPrincipal;

import javax.swing.*;
import java.awt.*;

public class RunApplication {
    public static void main(String[] args) {
        GUIPrincipal frame = new GUIPrincipal();

        // Garantir que o X funcione
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Pegar as dimensões da janela
        Dimension tela = Toolkit.getDefaultToolkit().getScreenSize();

        // Deixar a janela no meio da tela
        frame.setLocation((tela.width - frame.getSize().width) / 2,(tela.height - frame.getSize().height) / 2);
        frame.setVisible(true);
    }
}
