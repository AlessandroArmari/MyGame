package org.example.core;

import org.example.constants.Kkey;
import org.example.constants.Kgra;
import org.example.constants.Ktile;
import org.example.entity.ext.Entity;
import org.example.entity.ext.SuperObject;

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

        int tileNum1 = 0, tileNum2 = 0;

        switch (entity.direction) {

            case Kkey.UP:
                entityTopRow = (entityTopWorldY - entity.speed) / Kgra.tileSize;
                tileNum1 = gp.tileM.mapTileNum[entityLeftCol][entityTopRow];    // -> punto alto a sinistra del quadrato interno
                tileNum2 = gp.tileM.mapTileNum[entityRightCol][entityTopRow];   // -> punto alto a destra del quadrato interno
                break;

            case Kkey.DOWN:
                entityBottomRow = (entityBottomWorldY + entity.speed) / Kgra.tileSize;
                tileNum1 = gp.tileM.mapTileNum[entityLeftCol][entityBottomRow];
                tileNum2 = gp.tileM.mapTileNum[entityRightCol][entityBottomRow];
                break;

            case Kkey.LEFT:
                entityLeftCol = (entityLeftWorldX - entity.speed) / Kgra.tileSize;
                tileNum1 = gp.tileM.mapTileNum[entityLeftCol][entityTopRow];
                tileNum2 = gp.tileM.mapTileNum[entityLeftCol][entityBottomRow];
                break;

            case Kkey.RIGHT:
                entityRightCol = (entityRightWorldX + entity.speed) / Kgra.tileSize;
                tileNum1 = gp.tileM.mapTileNum[entityRightCol][entityTopRow];
                tileNum2 = gp.tileM.mapTileNum[entityRightCol][entityBottomRow];
                break;
        }

        /*
                se anche solo 1 dei 2 estremi tocca un tile esterno che ha il 'collision' a true
                esempio -> se vai verso su e uno degli estremi del quadrato interno tocca water o wall
                setto il valore di collisionOn del Char a true
        */
        if (Ktile.mapIntTile.get(tileNum1).collision || Ktile.mapIntTile.get(tileNum2).collision) {
            entity.collisionOn = true;
        }

    }

    //confronto collision tra un 'entity' (quasi sempre il player)
    // e la lista degli oggetti
    public int checkObject(Entity entity, boolean isPlayer) { // -> boolean perchè potrei usare questo metodo NON SOLAMENTE per il player

        //999999 come finto index inarrivabile
        Integer index = 9999999;

        for (int i = 0; i < gp.obj.size(); i++) {

            SuperObject obj = gp.obj.get(i);

            //ciclo tutti gli oggetti
            if (obj != null) {
                //ottengo x e y del quadrato interno
                entity.solidArea.x = entity.worldX + entity.solidArea.x;
                entity.solidArea.y = entity.worldY + entity.solidArea.y;

                //ottengo uno alla volta x e y degli oggetti
                obj.solidArea.x = obj.worldX + obj.solidArea.x;
                obj.solidArea.y = obj.worldY + obj.solidArea.y;

                // adesso simulo la posizione dell'entity col movimento (aggiungo o sottraggo la speed)
                switch (entity.direction) {
                    case Kkey.UP -> {
                        entity.solidArea.y -= entity.speed;
                        index = extracted(entity, obj, Kkey.UP, isPlayer, index, i);
                        //System.out.println(index);
                    }

                    case Kkey.DOWN -> {
                        entity.solidArea.y += entity.speed;
                        index = extracted(entity, obj, Kkey.DOWN, isPlayer, index, i);
                    }

                    case Kkey.LEFT -> {
                        entity.solidArea.x -= entity.speed;
                        index = extracted(entity, obj, Kkey.LEFT, isPlayer, index, i);
                    }

                    case Kkey.RIGHT -> {
                        entity.solidArea.x += entity.speed;
                        index = extracted(entity, obj, Kkey.RIGHT, isPlayer, index, i);
                    }
                }

                // resetto x e y del quadrato interno dell'entity (player)
                entity.solidArea.x = entity.solidAreaDefaultX;
                entity.solidArea.y = entity.solidAreaDefaultY;

                // resetto x e y dell'oggeto -> siamo in un cilo, quindi lo faccio per tutti
                obj.solidArea.x = obj.solidAreaDefaultX;
                obj.solidArea.y = obj.solidAreaDefaultY;


            }
        }

        return index;
    }

    private int extracted(Entity entity, SuperObject obj, String direction, boolean isPlayer, Integer index, Integer indexInTheList) {

        if (entity.solidArea.intersects(obj.solidArea)) {
            System.out.println(String.format("Collision with %s, Direction %s", obj.name, direction));

            entity.collisionOn = true; //come per i tile setto collisionOn a true

            if (isPlayer) {
                index = indexInTheList;
                return index;
            }

        }

        return index;
    }
}
