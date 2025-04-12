package org.example.entity.tile;

import org.example.constants.Kgra;
import org.example.constants.TileCon;
import org.example.core.GamePanel;
import org.example.util.exception.ExMsg;

import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class TileManager {
    GamePanel gp;
    int[][] mapTileNum;

    public TileManager(GamePanel gp) {
        this.gp = gp;
        mapTileNum = new int[Kgra.maxWorldCol][Kgra.maxWorldRow];
        loadMap();
    }


    //questo valorizza -> int[][] mapTileNum -> a partire dal file .txt
    public void loadMap() {
        try {

            InputStream is = getClass().getResourceAsStream("/Map/world01.txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            int rowCounter = 0;
            int colCounter = 0;

            while (rowCounter < Kgra.maxScreenRow && colCounter < Kgra.maxScreenColumn) {

                String line = br.readLine();

                while (colCounter < Kgra.maxScreenColumn) {
                    String[] numbers = line.split(" ");
                    mapTileNum[colCounter][rowCounter] = Integer.parseInt(numbers[colCounter]);
                    colCounter++;
                }

                if (colCounter == Kgra.maxScreenColumn) {
                    colCounter = 0;
                    rowCounter++;
                }
            }
            br.close();

        } catch (Exception e) {
            throw new RuntimeException(ExMsg.loadMap());
        }
    }

    public void drawImage(Graphics g2) {

        int worldCol = 0;
        int worldRow = 0;


        while (worldCol < Kgra.maxWorldCol && worldRow < Kgra.maxWorldRow) {

            int tileNum = mapTileNum[worldCol][worldRow];

            int worldX = worldCol * Kgra.tileSize;
            int worldY = worldRow * Kgra.tileSize;
            int screenX = worldX - gp.player.worldX + gp.player.screenX;
            int screenY = worldY - gp.player.worldY + gp.player.screenY;

            g2.drawImage(TileCon.mapIntTile.get(tileNum).image, screenX, screenY, Kgra.tileSize, Kgra.tileSize, null);
            worldCol++;

            if (worldCol == Kgra.maxWorldCol) {

                worldCol = 0;

                worldRow++;
            }
        }
    }

    /*
    public void drawImage(Graphics2D g2) {

        for (int i = 0; i <= GraphicCon.maxScreenColumn; i++) {
            for (int j = 0; j <= GraphicCon.maxScreenRow; j++) {
                g2.drawImage(TileCon.roseField().image,
                        GraphicCon.tileSize * i,
                        GraphicCon.tileSize * j,
                        GraphicCon.tileSize,
                        GraphicCon.tileSize,
                        null);
            }
        }
    }

     */


}

