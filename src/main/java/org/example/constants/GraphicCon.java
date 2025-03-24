package org.example.constants;

public class GraphicCon {

    //SCREEN SETTINGS
    public final static int originalTileSize = 16; // 16x16 px
    public final static int scale = 3;

    public final static int tileSize = originalTileSize * scale; // 48x48 px
    public final static int maxScreenColumn = 16;
    public final static int maxScreenRow = 12;

    public final static int screenWidth = maxScreenColumn * tileSize; // 768 px
    public final static int screenHeight = maxScreenRow * tileSize; // 576 px
}
