package org.example.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.example.entity.ext.Entity;


public class Player extends Entity {

    public Player(Integer x, Integer y, Integer speed) {
        super(x, y, speed);
    }
}
