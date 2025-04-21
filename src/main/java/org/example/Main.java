package org.example;

import org.example.core.GamePanel;

import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {


        JFrame window = new JFrame();

        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        window.setTitle("MyGame");
        window.setResizable(false);

        GamePanel gamePanel = new GamePanel();
        window.add(gamePanel);

        window.pack();

        window.setLocationRelativeTo(null);
        window.setVisible(true);

        gamePanel.setUpGame();
        gamePanel.startGameThread();

    }
}
