package org.example.entity;


import org.example.constants.GameCon;
import org.example.constants.GraphicCon;
import org.example.constants.KeyCon;
import org.example.core.KeyHandler;
import org.example.entity.ext.Entity;

import java.awt.*;


public class Player extends Entity {

    public Player(Integer x, Integer y, Integer speed) {
        super(x, y, speed);
    }

    @Override
    public void update(KeyHandler kh) {

        if (kh.upPressed) {
            this.Y -= GameCon.playerSpeed;
            System.out.println(KeyCon.UP + KeyCon.PRESSED);
        }

        if (kh.downPressed) {
            this.Y += GameCon.playerSpeed;
            System.out.println(KeyCon.DOWN + KeyCon.PRESSED);
        }

        if (kh.leftPressed) {
            this.X -= GameCon.playerSpeed;
            System.out.println(KeyCon.LEFT + KeyCon.PRESSED);
        }

        if (kh.rightPressed) {
            this.X += GameCon.playerSpeed;
            System.out.println(KeyCon.RIGHT + KeyCon.PRESSED);
        }
    }

    @Override
    public void draw(Graphics2D g2) {
        g2.setColor(Color.RED);

        g2.fillRect(this.X, this.Y, GraphicCon.tileSize, GraphicCon.tileSize);
    }
}
