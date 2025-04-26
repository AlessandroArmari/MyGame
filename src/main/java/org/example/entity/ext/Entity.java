package org.example.entity.ext;

import org.example.util.DrawUtil;

import java.awt.*;
import java.awt.image.BufferedImage;

public abstract class Entity {

    public Integer worldX;
    public Integer worldY;

    public Integer speed;

    public BufferedImage up1, up2, down1, down2, left1, left2, right1, right2;
    public String direction;

    public Integer spriteCounter = 0;
    public Integer spriteNum = 1;

    public Rectangle solidArea; //serve per le collision
    public Integer solidAreaDefaultX, solidAreaDefaultY;

    public Boolean collisionOn = false;

    public Entity() {
    }

    public void getImage() {
        up1 = DrawUtil.getBuffImg("character/Man", "up1");
        up2 = DrawUtil.getBuffImg("character/Man", "up2");
        down1 = DrawUtil.getBuffImg("character/Man", "down1");
        down2 = DrawUtil.getBuffImg("character/Man", "down2");
        left1 = DrawUtil.getBuffImg("character/Man", "left1");
        left2 = DrawUtil.getBuffImg("character/Man", "left2");
        right1 = DrawUtil.getBuffImg("character/Man", "right1");
        right2 = DrawUtil.getBuffImg("character/Man", "right2");
    }
}
