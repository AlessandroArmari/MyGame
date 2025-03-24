package org.example.entity.ext;

import org.example.core.KeyHandler;

import java.awt.*;

public abstract class Entity {

    public Integer X;
    public Integer Y;

    public Integer speed;

    public Entity(Integer x, Integer y, Integer speed) {
        X = x;
        Y = y;
        this.speed = speed;
    }

    public void update() {
    }

    public abstract void update(KeyHandler kh);

    public abstract void draw(Graphics2D g2);
}
