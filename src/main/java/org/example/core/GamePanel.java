package org.example.core;

import org.example.character.CharacterPosition;
import org.example.constants.GameCon;
import org.example.constants.Update;

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

    CharacterPosition charPosition = CharacterPosition.builder()
            .X(200)
            .Y(200)
            .build();

    Thread gameThread;

    Update update = new Update();
    GameLoop gameLoop = new GameLoop();


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

        //prossimo TIME di aggiornamento
        Double nextDrawTime = System.nanoTime() + GameCon.drawInterval;

        while (gameThread.isAlive()) {

            // 1: UPDATE nuove informazioni
            update.update(kh, charPosition);

            // 2: DRAW ridisegna lo screen
            repaint();

            nextDrawTime = gameLoop.gameLoop(nextDrawTime);

        }

    }


    public void paintComponent(Graphics g) {

        super.paintComponent(g);

        //creo nuova cosa
        Graphics2D g2 = (Graphics2D) g;

        g2.setColor(Color.RED);

        g2.fillRect(charPosition.X, charPosition.Y, tileSize, tileSize);

        g2.dispose();
    }
}

