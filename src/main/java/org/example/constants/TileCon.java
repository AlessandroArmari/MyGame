package org.example.constants;

import org.example.entity.tile.Tile;
import org.example.util.ImageUtil;

import java.util.Map;

public class TileCon {


    public static Tile roseField0() {
        return new Tile(ImageUtil.getPathUri("Tile", "rose_field"), false);
    }

    public static Tile water1() {
        return new Tile(ImageUtil.getPathUri("Tile", "water"), false);
    }

    public static Tile wall2() {
        return new Tile(ImageUtil.getPathUri("Tile", "wall"), false);
    }

    public static Tile sand3() {
        return new Tile(ImageUtil.getPathUri("Tile", "sand"), false);
    }


    public static Map<Integer, Tile> mapIntTile = Map.of(
            0, roseField0(),
            1, water1(),
            2, wall2(),
            3, sand3()
    );


}
