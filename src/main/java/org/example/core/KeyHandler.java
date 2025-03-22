package org.example.core;

import org.example.constants.KeyCon;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {

    private boolean upPressed;
    private boolean downPressed;
    private boolean leftPressed;
    private boolean rightPressed;

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

        int code = e.getKeyCode();

        if (e.getKeyCode() == KeyEvent.VK_W) {
            upPressed = true;
        }

        if (e.getKeyCode() == KeyEvent.VK_S) {
            downPressed = true;
        }

        if (e.getKeyCode() == KeyEvent.VK_A) {
            leftPressed = true;
        }

        if (e.getKeyCode() == KeyEvent.VK_D) {
            rightPressed = true;
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {

        int code = e.getKeyCode();

        if (e.getKeyCode() == KeyEvent.VK_W) {
            logBtnPressed(KeyCon.UP);
            upPressed = false;
        }

        if (e.getKeyCode() == KeyEvent.VK_S) {
            logBtnPressed(KeyCon.DOWN);
            downPressed = false;
        }

        if (e.getKeyCode() == KeyEvent.VK_A) {
            logBtnPressed(KeyCon.LEFT);
            leftPressed = false;
        }

        if (e.getKeyCode() == KeyEvent.VK_D) {
            logBtnPressed(KeyCon.RIGHT);
            rightPressed = false;
        }
    }

    private void logBtnPressed(String button) {
        System.out.println(button + KeyCon.PRESSED);
    }
}
