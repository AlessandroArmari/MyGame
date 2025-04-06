package org.example.entity.tile;

import java.awt.image.BufferedImage;

public class Tile {

    public BufferedImage image;
    public Boolean collision;

    public Tile(BufferedImage image, Boolean collision) {
        this.image = image;
        this.collision = collision;
    }
}
