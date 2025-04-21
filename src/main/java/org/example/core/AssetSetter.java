package org.example.core;

import org.example.entity.object.Key;

public class AssetSetter {

    public GamePanel gp;

    public AssetSetter(GamePanel gp) {
        this.gp = gp;
    }

    public void setObject() {

        gp.obj.add(new Key(12,12));
        gp.obj.add(new Key(24,24));
    }
}
