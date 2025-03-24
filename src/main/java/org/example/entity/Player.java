package org.example.entity;


import org.example.constants.GameCon;
import org.example.constants.KeyCon;
import org.example.entity.ext.Entity;

import java.awt.*;


public class Player extends Entity {

    public Player() {
        setDeafultValues();
    }

    public void setDeafultValues() {
        X = GameCon.defaultX;
        Y = GameCon.defaultY;
        speed = GameCon.playerSpeed;
        direction = KeyCon.DOWN;
        getImage();

    }



}
