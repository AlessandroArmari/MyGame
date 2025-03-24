package org.example.entity;


import org.example.constants.GameCon;
import org.example.constants.GraphicCon;
import org.example.constants.KeyCon;
import org.example.core.KeyHandler;
import org.example.entity.ext.Entity;

import java.awt.*;
import java.awt.image.BufferedImage;


public class Player extends Entity {

    public Player() {
        setDeafultValues();
    }

    public void setDeafultValues() {
        X = GameCon.defaultX;
        Y = GameCon.defaultY;
        speed = GameCon.playerSpeed;
        direction = KeyCon.DOWN;
        getImage();
    }


    public void update(KeyHandler kh) {
        if (kh.upPressed) {
            this.Y -= GameCon.playerSpeed;
            this.direction = KeyCon.UP;
            walkingAnimation();
            System.out.println(KeyCon.UP + KeyCon.PRESSED);
        }

        if (kh.downPressed) {
            this.Y += GameCon.playerSpeed;
            this.direction = KeyCon.DOWN;
            walkingAnimation();
            System.out.println(KeyCon.DOWN + KeyCon.PRESSED);
        }

        if (kh.leftPressed) {
            this.X -= GameCon.playerSpeed;
            this.direction = KeyCon.LEFT;
            walkingAnimation();
            System.out.println(KeyCon.LEFT + KeyCon.PRESSED);
        }

        if (kh.rightPressed) {
            this.X += GameCon.playerSpeed;
            this.direction = KeyCon.RIGHT;
            walkingAnimation();
            System.out.println(KeyCon.RIGHT + KeyCon.PRESSED);
        }


    }

    private void walkingAnimation() {

        spriteCounter++;

        if (spriteCounter == 22) { // --> ogni 22 Frame aggiorna aniomazione camminata

            if (spriteNum == 1) {

                spriteNum = 2;
            } else {

                spriteNum = 1;
            }

            spriteCounter = 0; // IN OGNI CASO -> resetta SpriteCounter a 0

        }
    }


    public void draw(Graphics2D g2) {

        //g2.setColor(Color.RED);
        //g2.fillRect(this.X, this.Y, GraphicCon.tileSize, GraphicCon.tileSize);

        BufferedImage image = null;

        switch (direction) {
            case KeyCon.UP -> {
                if (spriteNum == 1) {
                    image = up1;
                } else {
                    image = up2;
                }
            }

            case KeyCon.DOWN -> {
                if (spriteNum == 1) {
                    image = down1;
                } else {
                    image = down2;
                }
            }

            case KeyCon.LEFT -> {
                if (spriteNum == 1) {
                    image = left1;
                } else {
                    image = left2;
                }
            }

            case KeyCon.RIGHT -> {
                if (spriteNum == 1) {
                    image = right1;
                } else {
                    image = right2;
                }
            }
            default -> {
            }
        }

        g2.drawImage(image, X, Y, GraphicCon.tileSize, GraphicCon.tileSize, null);
    }


}
