package org.example.constants;

import org.example.entity.tile.Tile;
import org.example.util.ImageUtil;

import java.util.Map;

public class Ktile {


    public static Tile field0() {
        return new Tile(ImageUtil.getPathUri("tile", "field0"), false);
    }

    public static Tile water1() {
        return new Tile(ImageUtil.getPathUri("tile", "water1"), true);
    }

    public static Tile wall2() {return new Tile(ImageUtil.getPathUri("tile", "wall2"), true);}

    public static Tile sand3() {return new Tile(ImageUtil.getPathUri("tile", "sand3"), false);}

    public static Tile stone4() {return new Tile(ImageUtil.getPathUri("tile", "stone4"), false);}


    public static Map<Integer, Tile> mapIntTile = Map.of(
            0, field0(),
            1, water1(),
            2, wall2(),
            3, sand3(),
            4, stone4()
    );


}
