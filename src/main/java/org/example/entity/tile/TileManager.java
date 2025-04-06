package org.example.entity.tile;

import org.example.constants.GameCon;
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

        for (int i = 0; i <= GraphicCon.maxScreenColumn; i++) {
            for (int j = 0; j <= GraphicCon.maxScreenRow; j++) {
                g2.drawImage(TileCon.roseField().image,
                        GraphicCon.tileSize * i,
                        GraphicCon.tileSize * j,
                        GraphicCon.tileSize,
                        GraphicCon.tileSize,
                        null);
            }
        }
    }


}

