package org.example.entity.ext;

import org.example.constants.GameCon;
import org.example.constants.GraphicCon;
import org.example.constants.KeyCon;
import org.example.core.KeyHandler;
import org.example.util.ImageUtil;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

public abstract class Entity {

    public Integer X;
    public Integer Y;

    public Integer speed;

    public BufferedImage up1, up2, down1, down2, left1, left2, right1, right2;
    public String direction;

    public Integer spriteCounter = 0;
    public Integer spriteNum = 1;

    public Entity() {
    }

    public void getImage() {
        up1 = ImageUtil.getPathUri("Characters/Man", "up1");
        up2 = ImageUtil.getPathUri("Characters/Man", "up2");
        down1 = ImageUtil.getPathUri("Characters/Man", "down1");
        down2 = ImageUtil.getPathUri("Characters/Man", "down2");
        left1 = ImageUtil.getPathUri("Characters/Man", "left1");
        left2 = ImageUtil.getPathUri("Characters/Man", "left2");
        right1 = ImageUtil.getPathUri("Characters/Man", "right1");
        right2 = ImageUtil.getPathUri("Characters/Man", "right2");
    }
}
