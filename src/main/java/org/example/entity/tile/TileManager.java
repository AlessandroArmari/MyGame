package org.example.entity.tile;

import org.example.constants.GraphicCon;
import org.example.core.GamePanel;
import org.example.util.ImageUtil;

import java.awt.*;

public class TileManager {
    GamePanel gp;
    Tile[] tile;

    public TileManager(GamePanel gp) {
        this.gp = gp;
        tile = new Tile[10];

        this.tile[0] = new Tile();
        this.tile[0].image = ImageUtil.getPathUri("Tile", "rose_field");

        this.tile[1] = new Tile();
        this.tile[1].image = ImageUtil.getPathUri("Tile", "water");

    }

    public void drawImage(Graphics2D g2) {

        for (int i = 0; i <= 1; i++) {
            g2.drawImage(tile[i].image, GraphicCon.tileSize*i, 0, GraphicCon.tileSize, GraphicCon.tileSize, null);
        }


    }


}

