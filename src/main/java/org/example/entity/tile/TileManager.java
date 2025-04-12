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
        mapTileNum = new int[Kgra.maxScreenColumn][Kgra.maxScreenRow];
        loadMap();
    }


    //questo valorizza -> int[][] mapTileNum -> a partire dal file .txt
    public void loadMap() {
        try {

            InputStream is = getClass().getResourceAsStream("/Map/map01.txt");
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

        int colCounter = 0;
        int rowCounter = 0;
        int x = 0;
        int y = 0;

        while (colCounter < Kgra.maxScreenColumn && rowCounter < Kgra.maxScreenRow) {

            int tileNum = mapTileNum[colCounter][rowCounter];

            g2.drawImage(TileCon.mapIntTile.get(tileNum).image, x, y, Kgra.tileSize, Kgra.tileSize, null);
            colCounter++;
            x += Kgra.tileSize;

            if (colCounter == Kgra.maxScreenColumn) {

                colCounter = 0;
                x = 0;
                rowCounter++;
                y += Kgra.tileSize;
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

