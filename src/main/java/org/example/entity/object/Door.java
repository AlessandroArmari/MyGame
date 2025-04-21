package org.example.entity.object;

import org.example.entity.ext.SuperObject;
import org.example.util.DrawUtil;

public class Door extends SuperObject {

    public Door(Integer worldX, Integer worldY) {
        name = "door";
        image = DrawUtil.getBuffImg("object","door");
        this.worldX = worldX;
        this.worldY = worldY;
    }
}
