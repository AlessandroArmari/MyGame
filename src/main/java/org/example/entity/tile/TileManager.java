package org.example.entity.tile;

import org.example.constants.GraphicCon;
import org.example.constants.TileCon;
import org.example.core.GamePanel;
import org.example.util.ImageUtil;

import java.awt.*;

public class TileManager {
    GamePanel gp;
    Tile[] tile;

    public TileManager(GamePanel gp) {
        this.gp = gp;


    }

    public void drawImage(Graphics2D g2) {

        for (int i = 0; i <= 1; i++) {
            g2.drawImage(TileCon.roseField().image, GraphicCon.tileSize*i, 0, GraphicCon.tileSize, GraphicCon.tileSize, null);
        }


    }


}

