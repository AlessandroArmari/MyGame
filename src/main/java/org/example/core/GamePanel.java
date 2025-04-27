package org.example.core;

import org.example.constants.Kgame;
import org.example.constants.Kgra;
import org.example.entity.Player;
import org.example.entity.ext.SuperObject;
import org.example.entity.tile.TileManager;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;


public class GamePanel extends JPanel implements Runnable {

    GameLoop gameLoop = new GameLoop();
    TileManager tileM = new TileManager(this);
    KeyHandler kh = new KeyHandler();
    Thread gameThread;

    public CollisionChecker cChecker = new CollisionChecker(this);
    public AssetSetter aSetter = new AssetSetter(this);
    public Player player = new Player(this);
    public List<SuperObject> obj = new ArrayList<>(); //potresti sotituirlo con List<>



    public GamePanel() {
        this.setPreferredSize(new Dimension(Kgra.screenWidth, Kgra.screenHeight));
        this.setBackground(Color.CYAN);
        this.setDoubleBuffered(true);
        this.addKeyListener(kh);
        this.setFocusable(true);
    }

    public void setUpGame() {
        aSetter.setObject();
    }

    public void startGameThread() {
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {

        //prossimo TIME di aggiornamento
        Double nextDrawTime = System.nanoTime() + Kgame.drawInterval;

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

        //TILE
        tileM.drawImage(g2);

        //OBJECT
        for (SuperObject superObject : obj) {
            superObject.draw(g2, this);
        }

        //PLAYER
        player.draw(g2);

        g2.dispose();

    }
}





