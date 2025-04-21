package org.example.entity.object;

import org.example.entity.ext.SuperObject;
import org.example.util.DrawUtil;

public class Key extends SuperObject {


    public Key(Integer worldX, Integer worldY) {
        name = "key";
        image = DrawUtil.getBuffImg("object","key");
        this.worldX = worldX;
        this.worldY = worldY;
    }

}
