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

    public GamePanel() {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.BLACK);
        this.setDoubleBuffered(true);
    }

    public void startGameThread() {
        Thread thread = new Thread(this);
        thread.start();
    }


    @Override
    public void run() {

    }
}
