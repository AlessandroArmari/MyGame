package org.example.core;

import org.example.constants.Kgra;
import org.example.entity.object.Key;

public class AssetSetter {

    public GamePanel gp;

    public AssetSetter(GamePanel gp) {
        this.gp = gp;
    }

    public void setObject() {

        gp.obj.add(new Key(12 * Kgra.tileSize,12 * Kgra.tileSize));
        gp.obj.add(new Key(24 * Kgra.tileSize,24 * Kgra.tileSize));
    }
}
