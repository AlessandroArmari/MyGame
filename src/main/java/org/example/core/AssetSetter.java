package org.example.core;

import org.example.constants.Kgra;
import org.example.entity.object.Door;
import org.example.entity.object.Key;

public class AssetSetter {

    public GamePanel gp;

    public AssetSetter(GamePanel gp) {
        this.gp = gp;
    }

    // metodo per settare oggetti prima del cricamento
    // N.B -> andrà legato alla mappa primao poi
    public void setObject() {

        gp.obj.add(new Key(12 * Kgra.tileSize,12 * Kgra.tileSize));
        gp.obj.add(new Key(24 * Kgra.tileSize,23 * Kgra.tileSize));
        gp.obj.add(new Key(25 * Kgra.tileSize,22 * Kgra.tileSize));
        gp.obj.add(new Key(19 * Kgra.tileSize,21 * Kgra.tileSize));


        gp.obj.add(new Door(33 * Kgra.tileSize,3 * Kgra.tileSize));
        gp.obj.add(new Door(33 * Kgra.tileSize,4 * Kgra.tileSize));
        gp.obj.add(new Door(33 * Kgra.tileSize,5 * Kgra.tileSize));
        gp.obj.add(new Door(44 * Kgra.tileSize,2 * Kgra.tileSize));
        gp.obj.add(new Door(38 * Kgra.tileSize,45 * Kgra.tileSize));

    }
}
