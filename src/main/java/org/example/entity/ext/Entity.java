package org.example.entity.ext;

import org.example.constants.GameCon;
import org.example.constants.GraphicCon;
import org.example.constants.KeyCon;
import org.example.core.KeyHandler;

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
        up1 = getPathUri("up1");
        up2 = getPathUri("up2");
        down1 = getPathUri("down1");
        down2 = getPathUri("down2");
        left1 = getPathUri("left1");
        left2 = getPathUri("left2");
        right1 = getPathUri("right1");
        right2 = getPathUri("right2");
    }

    private BufferedImage getPathUri(String imgName) {
        String returnString = String.format("/%s/%s.png", this.getClass().getSimpleName(), imgName);

        try {
            return ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream(returnString)));
        } catch (IOException e) {

            e.printStackTrace();
            throw new RuntimeException();
        }
    }




}
