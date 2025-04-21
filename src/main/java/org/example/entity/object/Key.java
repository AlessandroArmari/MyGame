package org.example.entity.object;

import org.example.entity.ext.SuperObject;
import org.example.util.ImageUtil;

public class Key extends SuperObject {


    public Key(Integer worldX, Integer worldY) {
        name = "key";
        image = ImageUtil.getBuffImg("object","key");
        this.worldX = worldX;
        this.worldY = worldY;
    }

}
