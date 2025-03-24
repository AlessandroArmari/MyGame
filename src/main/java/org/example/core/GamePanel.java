package org.example.core;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable {

    //SCREEN SETTINGS
    final int originalTileSize = 16; // 16x16 px
    final int scale = 3;

    final int tileSize = originalTileSize * scale; // 48x48 px
    final int maxScreenColumn = 16;
    final int maxScreenRow = 12;

    final int screenWidth = maxScreenColumn * tileSize; // 768 px
    final int screenHeight = maxScreenRow * tileSize; // 576 px

    int playerX = 200;
    int playerY = 200;
    int playerSpeed = 4;

    int FPS = 60;


    Thread gameThread;

    KeyHandler kh = new KeyHandler();

    public GamePanel() {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.BLACK);
        this.setDoubleBuffered(true);
        this.addKeyListener(kh);
        this.setFocusable(true);
    }

    public void startGameThread() {
        gameThread = new Thread(this);
        gameThread.start();
    }


    @Override
    public void run() {

        double drawInterval = 1000000000 / FPS;  // -> 16.666.666,66666667 NANOSECONDI -> oppure -> 0.016666666666666666667 SECONDI
        double nextDrawTime = System.nanoTime() + drawInterval;

        while (gameThread.isAlive()) {


            // 1: UPDATE nuove informazioni
            update();

            // 2: DRAW ridisegna lo screen
            repaint();

            try {

                double remainingTime = nextDrawTime - System.nanoTime();
                remainingTime = remainingTime/1000000; // ->  //converto in millisSecond

                if (remainingTime < 0) {
                    remainingTime = 0;
                }

                Thread.sleep((long) remainingTime);

                nextDrawTime += drawInterval;

            } catch (InterruptedException e) {

                throw new RuntimeException(e);
            }


            /*
            long currentTime = System.currentTimeMillis();

            //per il numero di giri compitui dal while a ogni secondo
            if (currentTime - lastCurrentTime > 1000) {
                System.out.println(counter);
                lastCurrentTime = currentTime;
                counter = 0;
            }
            counter++;

             */



        }

    }


    private void update() {

        if (kh.upPressed) {
            playerY -= playerSpeed;
        }

        if (kh.downPressed) {
            playerY += playerSpeed;
        }

        if (kh.leftPressed) {
            playerX -= playerSpeed;
        }

        if (kh.rightPressed) {
            playerX += playerSpeed;
        }

    }

    public void paintComponent(Graphics g) {

        super.paintComponent(g);

        //creo nuova cosa
        Graphics2D g2 = (Graphics2D) g;

        g2.setColor(Color.WHITE);

        g2.fillRect(playerX, playerY, tileSize, tileSize);

        g2.dispose();
    }
}
