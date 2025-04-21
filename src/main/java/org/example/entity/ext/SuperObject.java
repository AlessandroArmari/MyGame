package org.example.entity.ext;

import org.example.constants.Kgra;
import org.example.constants.Ktile;
import org.example.core.GamePanel;

import java.awt.*;
import java.awt.image.BufferedImage;

public class SuperObject {

    public BufferedImage image;
    public String name;
    public Boolean collision = false;
    public Integer worldX, worldY;

    public void draw(Graphics2D g2, GamePanel gp) {

        // screenX e screenY sono le coordinate che passo nel drawImage() per ogni tile
        int screenX = worldX - gp.player.worldX + gp.player.screenX;
        int screenY = worldY - gp.player.worldY + gp.player.screenY;
        // GamePanel -> get Player -> get worldX e worldY
        // -> queste 2 info sarebbero le INFO real-time della posizione del char. nel mondo

        // in base a queste decido DOVE disegnare i tile della mappa -> PERCHè il char. è SEMPRE al centro

        if // -> questo if avvia il metodo SOLAMENTE per i tile "a vista" del char.
        (
                (worldX + Kgra.tileSize) > gp.player.worldX - gp.player.screenX &&
                        (worldX - Kgra.tileSize) < gp.player.worldX + gp.player.screenX &&
                        (worldY + Kgra.tileSize) > gp.player.worldY - gp.player.screenY &&
                        (worldY - Kgra.tileSize) < gp.player.worldY + gp.player.screenY
        ) {
            g2.drawImage(image, screenX, screenY, Kgra.tileSize, Kgra.tileSize, null);
        }

    }
}
