package org.example.entity.ext;

import org.example.constants.Kgra;
import org.example.constants.Ktile;
import org.example.core.GamePanel;
import org.example.util.DrawUtil;

import java.awt.*;
import java.awt.image.BufferedImage;

public class SuperObject {

    public BufferedImage image;
    public String name;
    public Boolean collision = false;
    public Integer worldX, worldY;
    public Rectangle solidArea = new Rectangle(0,0, Kgra.tileSize, Kgra.tileSize);

    public void draw(Graphics2D g2, GamePanel gp) {
        DrawUtil.DrawTileOrObject(worldX, worldY, gp, g2, image);
    }
}
