package org.example.entity.tile;

import org.example.core.GamePanel;
import org.example.util.ImageUtil;

import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.util.Objects;

public class TileManager {
    GamePanel gp;
    Tile[] tile;

    public TileManager(GamePanel gp) {
        this.gp = gp;
        tile = new Tile[10];
        for (int i = 0; i <= tile.length; i++) {
            this.tile[i].image = ImageUtil.getPathUri("Tile", "rose_field.png");
        }
    }




}

