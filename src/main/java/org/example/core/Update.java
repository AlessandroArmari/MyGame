package org.example.core;

import org.example.constants.GameCon;
import org.example.constants.KeyCon;
import org.example.entity.Player;

public class Update {

    public void update(KeyHandler kh, Player player) {

        if (kh.upPressed) {
            player.Y -= GameCon.playerSpeed;
            System.out.println(KeyCon.UP + KeyCon.PRESSED);
        }

        if (kh.downPressed) {
            player.Y += GameCon.playerSpeed;
            System.out.println(KeyCon.UP + KeyCon.DOWN);
        }

        if (kh.leftPressed) {
            player.X -= GameCon.playerSpeed;
            System.out.println(KeyCon.UP + KeyCon.LEFT);
        }

        if (kh.rightPressed) {
            player.X += GameCon.playerSpeed;
            System.out.println(KeyCon.UP + KeyCon.RIGHT);
        }

    }
}
