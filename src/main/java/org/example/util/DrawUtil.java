package org.example.util;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

public class DrawUtil {

    public static BufferedImage getBuffImg(String imgPath, String imgName) {

        String returnString = String.format("/%s/%s.png", imgPath, imgName);

        try {
            return ImageIO.read(Objects.requireNonNull(DrawUtil.class.getResourceAsStream(returnString)));
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
    }


}
