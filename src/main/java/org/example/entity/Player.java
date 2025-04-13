package org.example.entity;


import org.example.constants.GameCon;
import org.example.constants.Kgra;
import org.example.constants.KeyCon;
import org.example.core.KeyHandler;
import org.example.entity.ext.Entity;

import java.awt.*;
import java.awt.image.BufferedImage;


public class Player extends Entity {

    // sono FINAL -> piazzano il character al centro della view
    public final int screenX;
    public final int screenY;

    public Player() {

        this.screenX = Kgra.screenWidth / 2 - Kgra.tileSize / 2;  // ->  - Kgra.tileSize / 2 -> questa parte finale per centrarlo 100%
        this.screenY = Kgra.screenHeight / 2 - Kgra.tileSize / 2;


        setDeafultValues();
    }

    public void setDeafultValues() {
        worldX = Kgra.tileSize * 23;
        worldY = Kgra.tileSize * 21;
        speed = GameCon.playerSpeed;
        direction = KeyCon.DOWN;
        getImage();
    }


    public void update(KeyHandler kh) {

        if (kh.upPressed) {
            this.worldY -= GameCon.playerSpeed;
            extracted(KeyCon.UP);
        }

        if (kh.downPressed) {
            this.worldY += GameCon.playerSpeed;
            extracted(KeyCon.DOWN);
        }

        if (kh.leftPressed) {
            this.worldX -= GameCon.playerSpeed;
            extracted(KeyCon.LEFT);

        }

        if (kh.rightPressed) {
            this.worldX += GameCon.playerSpeed;
            extracted(KeyCon.RIGHT);
        }


    }

    private void extracted(String direction) {
        this.direction = direction;
        walkingAnimation();
        System.out.println("worldX=" + worldX + ", worldY = " + worldY);
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

        g2.drawImage(image, screenX, screenY, Kgra.tileSize, Kgra.tileSize, null);
    }

}

