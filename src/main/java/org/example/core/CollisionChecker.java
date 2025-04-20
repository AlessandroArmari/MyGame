package org.example.core;

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
        int entityBottomWorldY = entity.worldY + entity.solidArea.height;

    }

}
