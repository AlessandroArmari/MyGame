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

    public void update(KeyHandler kh) {
        if (kh.upPressed) {
            this.Y -= GameCon.playerSpeed;
            this.direction = KeyCon.UP;
            System.out.println(KeyCon.UP + KeyCon.PRESSED);
        }

        if (kh.downPressed) {
            this.Y += GameCon.playerSpeed;
            this.direction = KeyCon.DOWN;
            System.out.println(KeyCon.DOWN + KeyCon.PRESSED);
        }

        if (kh.leftPressed) {
            this.X -= GameCon.playerSpeed;
            this.direction = KeyCon.LEFT;
            System.out.println(KeyCon.LEFT + KeyCon.PRESSED);
        }

        if (kh.rightPressed) {
            this.X += GameCon.playerSpeed;
            this.direction = KeyCon.RIGHT;
            System.out.println(KeyCon.RIGHT + KeyCon.PRESSED);
        }
    }

    ;

    public void draw(Graphics2D g2) {

        //g2.setColor(Color.RED);
        //g2.fillRect(this.X, this.Y, GraphicCon.tileSize, GraphicCon.tileSize);

        BufferedImage image = null;

        switch (direction) {
            case KeyCon.UP -> image = up1;
            case KeyCon.DOWN -> image = down1;
            case KeyCon.LEFT -> image = left1;
            case KeyCon.RIGHT -> image = right1;
            default -> {}
        }

        g2.drawImage(image, X, Y, GraphicCon.tileSize, GraphicCon.tileSize, null);
    }

}
