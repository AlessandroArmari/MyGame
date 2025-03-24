package org.example.entity.ext;

public abstract class Entity {

    public Integer X;
    public Integer Y;

    public Integer speed;

    public Entity(Integer x, Integer y, Integer speed) {
        X = x;
        Y = y;
        this.speed = speed;
    }
}
