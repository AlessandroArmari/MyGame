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
            extracted(KeyCon.UP);
        }

        if (kh.downPressed) {
            this.Y += GameCon.playerSpeed;
            extracted(KeyCon.DOWN);
        }

        if (kh.leftPressed) {
            this.X -= GameCon.playerSpeed;
            extracted(KeyCon.LEFT);

        }

        if (kh.rightPressed) {
            this.X += GameCon.playerSpeed;
            extracted(KeyCon.RIGHT);
        }


    }

    private void extracted(String direction) {
        this.direction = direction;
        walkingAnimation();
        System.out.println(direction + KeyCon.PRESSED);
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

        BufferedImage image = switch (direction) {

            case KeyCon.UP -> (spriteNum == 1) ? up1 : up2;

            case KeyCon.DOWN -> (spriteNum == 1) ? down1 : down2;

            case KeyCon.LEFT -> (spriteNum == 1) ? left1 : left2;

            case KeyCon.RIGHT -> (spriteNum == 1) ? right1 : right2;

            default -> throw new RuntimeException();
        };

        g2.drawImage(image, X, Y, GraphicCon.tileSize, GraphicCon.tileSize, null);
    }

}

