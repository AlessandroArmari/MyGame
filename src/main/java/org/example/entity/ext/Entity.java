package org.example.entity.ext;

import org.example.util.ImageUtil;

import java.awt.image.BufferedImage;

public abstract class Entity {

    public Integer worldX;
    public Integer worldY;

    public Integer speed;

    public BufferedImage up1, up2, down1, down2, left1, left2, right1, right2;
    public String direction;

    public Integer spriteCounter = 0;
    public Integer spriteNum = 1;

    public Entity() {
    }

    public void getImage() {
        up1 = ImageUtil.getPathUri("Character/Man", "up1");
        up2 = ImageUtil.getPathUri("Character/Man", "up2");
        down1 = ImageUtil.getPathUri("Character/Man", "down1");
        down2 = ImageUtil.getPathUri("Character/Man", "down2");
        left1 = ImageUtil.getPathUri("Character/Man", "left1");
        left2 = ImageUtil.getPathUri("Character/Man", "left2");
        right1 = ImageUtil.getPathUri("Character/Man", "right1");
        right2 = ImageUtil.getPathUri("Character/Man", "right2");
    }
}
