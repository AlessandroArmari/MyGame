package org.example.core;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Map;
import java.util.function.Consumer;


@Getter
@Setter
@NoArgsConstructor
public class KeyHandler implements KeyListener {

    public Boolean upPressed = false;
    public Boolean downPressed = false;
    public Boolean leftPressed = false;
    public Boolean rightPressed = false;

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
        mapKeyAction.getOrDefault(e.getKeyCode(), (no) -> {} ).accept(true);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        mapKeyAction.getOrDefault(e.getKeyCode(), (no) -> {}).accept(false);}


}
