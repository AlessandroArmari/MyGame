package org.example.util;

import org.example.constants.Kgra;
import org.example.core.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

public class DrawUtil {

    public static BufferedImage getBuffImg(String imgPath, String imgName) {

        String returnString = String.format("/%s/%s.png", imgPath, imgName);

        try {
            return ImageIO.read(Objects.requireNonNull(DrawUtil.class.getResourceAsStream(returnString)));
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
    }


    public static void DrawTileOrObject (Integer worldX, Integer worldY, GamePanel gp, Graphics2D g2, BufferedImage image) {

        // screenX e screenY sono le coordinate che passo nel drawImage() per ogni tile O OGGETTO
        int screenX = worldX - gp.player.worldX + gp.player.screenX;
        int screenY = worldY - gp.player.worldY + gp.player.screenY;

        // -> la screenX dell'oggetto-tile è uguale a posizione dell'oggetto-tile MENO la X real-time del player
        //QUINDI l'oggetto-tile può trovarsi anche

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
