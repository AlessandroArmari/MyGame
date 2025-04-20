package org.example.core;

import org.example.constants.Kkey;
import org.example.constants.Kgra;
import org.example.constants.Ktile;
import org.example.entity.ext.Entity;

public class CollisionChecker {

    GamePanel gp;

    public CollisionChecker(GamePanel gp) {
        this.gp = gp;
    }

    public void checkTile(Entity entity) {

        //check i 4 estremi del quadrato interno del character
        int entityLeftWorldX = entity.worldX + entity.solidArea.x; //sarebbe la X del Char + il pezzettino di differenza dal quadrato interno
        int entityRightWorldX = entity.worldX + entity.solidArea.x + entity.solidArea.width;
        int entityTopWorldY = entity.worldY + entity.solidArea.y;
        int entityBottomWorldY = entity.worldY + entity.solidArea.y + entity.solidArea.height;

        int entityLeftCol = entityLeftWorldX / Kgra.tileSize;
        int entityRightCol = entityRightWorldX / Kgra.tileSize;
        int entityTopRow = entityTopWorldY / Kgra.tileSize;
        int entityBottomRow = entityBottomWorldY / Kgra.tileSize;

        int tileNum1, tileNum2;

        switch (entity.direction) {
            case Kkey.UP:
                entityTopRow = (entityTopWorldY - entity.speed) / Kgra.tileSize;
                tileNum1 = gp.tileM.mapTileNum[entityLeftCol][entityTopRow];    // -> punto alto a sinistra del quadrato interno
                tileNum2 = gp.tileM.mapTileNum[entityRightCol][entityTopRow];   // -> punto alto a destra del quadrato interno

                // se anche solo 1 dei 2 estremi tocca un tile esterno che ha il 'collision' a true
                // esempio -> se vai verso su e uno degli estremi del quadrato interno tocca water o wall
                // setto il valore di collisionOn del Char a true
                if (Ktile.mapIntTile.get(tileNum1).collision ||
                        Ktile.mapIntTile.get(tileNum2).collision) {
                    entity.collisionOn = true;
                }
                break;
        }

    }

}
