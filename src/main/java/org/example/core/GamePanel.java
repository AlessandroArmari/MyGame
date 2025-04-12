package org.example.core;

import org.example.constants.GameCon;
import org.example.constants.Kgra;
import org.example.entity.Player;
import org.example.entity.tile.TileManager;

import javax.swing.*;
import java.awt.*;


public class GamePanel extends JPanel implements Runnable {

    Player player = new Player();
    Thread gameThread;
    GameLoop gameLoop = new GameLoop();
    KeyHandler kh = new KeyHandler();
    TileManager tileM = new TileManager(this);

    public GamePanel() {
        this.setPreferredSize(new Dimension(Kgra.screenWidth, Kgra.screenHeight));
        this.setBackground(Color.CYAN);
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

        tileM.drawImage(g2);

        player.draw(g2);

        g2.dispose();

    }
}





