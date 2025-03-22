package org.example.core;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable {

    //SCREEN SETTINGS
    final int originalTileSize = 16; // 16x15 px
    final int scale = 3;

    final int tileSize = originalTileSize * scale; // 48x48 px
    final int maxScreenColumn = 16;
    final int maxScreenRow = 12;

    final int screenWidth = maxScreenColumn * tileSize; // 768 px
    final int screenHeight = maxScreenRow * tileSize; // 576 px

    Thread gameThread;

    public GamePanel() {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.BLACK);
        this.setDoubleBuffered(true);
    }

    public void startGameThread() {
        gameThread = new Thread(this);
        gameThread.start();
    }


    @Override
    public void run() {

        System.out.println("ciao");
        while (gameThread.isAlive()) {

            // 1: UPDATE nuove informazioni
            update();

            // 2: DRAW ridisegna lo screen
            repaint();


            System.out.println("gameThread is running");
        }

    }

    private void update() {
     }

    public void paintComponent(Graphics g) {

        super.paintComponent(g);

        //creo nuova cosa
        Graphics2D g2 = (Graphics2D) g;

        g2.setColor(Color.WHITE);

        g2.fillRect(200, 200, tileSize, tileSize);

        g2.dispose();
    }
}
