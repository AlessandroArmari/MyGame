package org.example.constants;

import org.example.entity.tile.Tile;
import org.example.util.ImageUtil;

public class TileCon {


    public static Tile roseField() {
        return new Tile(ImageUtil.getPathUri("Tile", "rose_field"), false);
    }

    public static Tile water() {
        return new Tile(ImageUtil.getPathUri("Tile", "water"), false);
    }

    public static Tile wall() {
        return new Tile(ImageUtil.getPathUri("Tile", "wall"), false);
    }


}
