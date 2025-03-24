package org.example.core;

import org.example.character.CharacterPosition;
import org.example.constants.GameCon;
import org.example.constants.KeyCon;

public class Update {

    public void update(KeyHandler kh, CharacterPosition charPosition) {

        if (kh.upPressed) {
            charPosition.Y -= GameCon.playerSpeed;
            System.out.println(KeyCon.UP + KeyCon.PRESSED);
        }

        if (kh.downPressed) {
            charPosition.Y += GameCon.playerSpeed;
            System.out.println(KeyCon.UP + KeyCon.DOWN);
        }

        if (kh.leftPressed) {
            charPosition.X -= GameCon.playerSpeed;
            System.out.println(KeyCon.UP + KeyCon.LEFT);
        }

        if (kh.rightPressed) {
            charPosition.X += GameCon.playerSpeed;
            System.out.println(KeyCon.UP + KeyCon.RIGHT);
        }

    }
}
