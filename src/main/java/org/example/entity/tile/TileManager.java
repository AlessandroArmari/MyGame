package org.example.entity.tile;

import org.example.constants.Kgra;
import org.example.constants.Ktile;
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

            while (rowCounter < Kgra.maxWorldRow && colCounter < Kgra.maxWorldCol) {

                String line = br.readLine();

                while (colCounter < Kgra.maxWorldCol) {
                    String[] numbers = line.split(" ");
                    mapTileNum[colCounter][rowCounter] = Integer.parseInt(numbers[colCounter]);
                    colCounter++;
                }

                if (colCounter == Kgra.maxWorldCol) {
                    colCounter = 0;
                    rowCounter++;
                }
            }
            br.close();

        } catch (Exception e) {
            throw new RuntimeException(ExMsg.loadMap(e.getMessage()));
        }
    }

    public void drawImage(Graphics g2) {

        int worldCol = 0;
        int worldRow = 0;


        while (worldCol < Kgra.maxWorldCol && worldRow < Kgra.maxWorldRow) {

            int tileNum = mapTileNum[worldCol][worldRow];

            int worldX = worldCol * Kgra.tileSize;
            int worldY = worldRow * Kgra.tileSize;

            // screenX e screenY sono le coordinate che passo nel drawImage() per ogni tile
            int screenX = worldX - gp.player.worldX + gp.player.screenX;
            int screenY = worldY - gp.player.worldY + gp.player.screenY;
            // GamePanel -> get Player -> get worldX e worldY
            // -> queste 2 info sarebbero le INFO real-time della posizione del char. nel mondo

            // in base a queste decido DOVE disegnare i tile della mappa -> PERCHè il char. è SEMPRE al centro

            if // -> questo if avvia il metodo SOLAMENTE per i tile "a vista" del char.
            (
                    (worldX + Kgra.tileSize) > gp.player.worldX - gp.player.screenX &&
                            (worldX - Kgra.tileSize) < gp.player.worldX + gp.player.screenX &&
                            (worldY + Kgra.tileSize) > gp.player.worldY - gp.player.screenY &&
                            (worldY - Kgra.tileSize) < gp.player.worldY + gp.player.screenY
            ) {
                g2.drawImage(Ktile.mapIntTile.get(tileNum).image, screenX, screenY, Kgra.tileSize, Kgra.tileSize, null);
            }

            worldCol++;

            if (worldCol == Kgra.maxWorldCol) {

                worldCol = 0;

                worldRow++;
            }
        }
    }
}

