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
        for (int i = 0; i <= tile.length-1; i++) {
            this.tile[i] = new Tile();
            this.tile[i].image = ImageUtil.getPathUri("Tile", "rose_field");
        }
    }

    public void drawImage(Graphics2D g2) {
        g2.drawImage(tile[0].image, 0, 0, GraphicCon.tileSize,  GraphicCon.tileSize, null);
    }




}

