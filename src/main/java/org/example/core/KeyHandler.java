package org.example.core;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.constants.KeyCon;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Map;
import java.util.function.Consumer;


@NoArgsConstructor
public class KeyHandler implements KeyListener {

    private final Map<Integer, Consumer<Boolean>> mapKeyAction = Map.of(
            KeyEvent.VK_W, this::setUpPressed,
            KeyEvent.VK_S, this::setDownPressed,
            KeyEvent.VK_A, this::setLeftPressed,
            KeyEvent.VK_D, this::setRightPressed
    );


    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        mapKeyAction.get(e.getKeyCode()).accept(true);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        mapKeyAction.get(e.getKeyCode()).accept(false);
    }


    public void setUpPressed(boolean bool) {
        System.out.println(KeyCon.UP + ((bool) ? KeyCon.PRESSED : KeyCon.RELEASED));
    }

    public void setDownPressed(boolean bool) {
        System.out.println(KeyCon.DOWN + ((bool) ? KeyCon.PRESSED : KeyCon.RELEASED));
    }

    public void setLeftPressed(boolean bool) {
        System.out.println(KeyCon.LEFT + ((bool) ? KeyCon.PRESSED : KeyCon.RELEASED));
    }

    public void setRightPressed(boolean bool) {
        System.out.println(KeyCon.RIGHT + ((bool) ? KeyCon.PRESSED : KeyCon.RELEASED));
    }
}
