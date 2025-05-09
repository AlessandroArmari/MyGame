package org.example.entity;


import org.example.constants.Kgame;
import org.example.constants.Kgra;
import org.example.constants.Kkey;
import org.example.core.GamePanel;
import org.example.core.KeyHandler;
import org.example.entity.ext.Entity;

import java.awt.*;
import java.awt.image.BufferedImage;


public class Player extends Entity {

    // sono FINAL -> piazzano il character al centro della view
    public final int screenX;
    public final int screenY;

    public int rectangleWidth;
    public int rectangleHeight;

    public GamePanel gp;

    public int hasKey;

    public Player(GamePanel gp) {

        this.gp = gp;

        this.screenX = Kgra.screenWidth / 2 - Kgra.tileSize / 2;  // ->  - Kgra.tileSize / 2 -> questa parte finale per centrarlo 100%
        this.screenY = Kgra.screenHeight / 2 - Kgra.tileSize / 2;

        solidArea = rectangleCreator();

        //salvo le coordinate della solidArea
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;

        setDeafultValues();

        getImage();

    }

    //genero il rattangolo interno
    private Rectangle rectangleCreator() {

        /*
                         48
                |------------------|
                |                  |
                |                  |
           48   |     |------|     |    48
                |     |      |32   |
                |     |      |     |
                |-----|------|-----|
                         24
         */

        this.rectangleWidth = Kgra.tileSize - (Kgra.tileSize / 2);   //24
        this.rectangleHeight = Kgra.tileSize - (Kgra.tileSize / 3);  //32

        return new Rectangle( // il rettangolo comodo per la visualizzazione
                12,16,
                rectangleWidth,
                rectangleHeight
        );
    }

    public void setDeafultValues() {
        worldX = Kgra.tileSize * 23;
        worldY = Kgra.tileSize * 21;
        speed = Kgame.playerSpeed;
        direction = Kkey.DOWN;
    }


    public void update(KeyHandler kh) {

        if (kh.upPressed) {
            extracted(Kkey.UP);
        }

        if (kh.downPressed) {
            extracted(Kkey.DOWN);
        }

        if (kh.leftPressed) {
            extracted(Kkey.LEFT);
        }

        if (kh.rightPressed) {
            extracted(Kkey.RIGHT);
        }
    }

    private void extracted(String direction) {

        this.direction = direction;

        //controllare Collision del quadrato interno
        collisionOn = false;

        //CHECK TYLE
        gp.cChecker.checkTile(this); // --> questo può cambiare collisionOn a true

        //CHECK OBJECT
        int index = gp.cChecker.checkObject(this, true); // --> anche questo come sopra

        pickUpObject(index);




        //SE collisionOn è FALSE dopo checkTile(this) -> il char può moversi
        //ALTRIMENTI --> niente

        if (!collisionOn) {
            switch (direction) {
                case Kkey.UP -> this.worldY -= Kgame.playerSpeed;

                case Kkey.DOWN -> this.worldY += Kgame.playerSpeed;

                case Kkey.LEFT -> this.worldX -= Kgame.playerSpeed;

                case Kkey.RIGHT -> this.worldX += Kgame.playerSpeed;
            }
        }

        walkingAnimation();
        //wdSystem.out.println("worldX=" + worldX + ", worldY = " + worldY);
    }

    private void pickUpObject(int index) {

        ///9999999 è la situazione di default
        if (index != 9999999) {

            switch (gp.obj.get(index).name) {

                case "key" -> {
                    hasKey++;
                    System.out.println("add 1 key, now you have= " + hasKey);
                    gp.obj.remove(index); // -> la key la elimino dalla lista
                }

                case "door" -> {
                    if (hasKey > 0) {
                        System.out.println("hasKey= " + hasKey + ", so open the door");
                        gp.obj.remove(index);
                        hasKey--;
                    }
                }

            }
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

        BufferedImage image = switch (direction) {

            case Kkey.UP -> (spriteNum == 1) ? up1 : up2;

            case Kkey.DOWN -> (spriteNum == 1) ? down1 : down2;

            case Kkey.LEFT -> (spriteNum == 1) ? left1 : left2;

            case Kkey.RIGHT -> (spriteNum == 1) ? right1 : right2;

            default -> throw new RuntimeException();
        };

        g2.drawImage(image, screenX, screenY, Kgra.tileSize, Kgra.tileSize, null);
        //g2.drawRect(screenX + (rectangleWidth/2), screenY + (rectangleHeight/2), rectangleWidth, rectangleHeight);
        g2.drawRect(screenX , screenY , Kgra.tileSize, Kgra.tileSize);

    }

}

