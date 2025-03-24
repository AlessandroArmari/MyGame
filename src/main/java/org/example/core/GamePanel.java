package org.example.core;

import org.example.constants.GameCon;
import org.example.constants.GraphicCon;
import org.example.entity.Player;

import javax.swing.*;
import java.awt.*;


public class GamePanel extends JPanel implements Runnable {

    Player player = new Player();
    Thread gameThread;
    GameLoop gameLoop = new GameLoop();
    KeyHandler kh = new KeyHandler();

    public GamePanel() {
        this.setPreferredSize(new Dimension(GraphicCon.screenWidth, GraphicCon.screenHeight));
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
            player.update(kh);

            // 2: DRAW ridisegna lo screen
            repaint();

            nextDrawTime = gameLoop.gameLoop(nextDrawTime);

        }
    }

    public void paintComponent(Graphics g) {

        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;

        player.draw(g2);

        g2.dispose();

    }
}





