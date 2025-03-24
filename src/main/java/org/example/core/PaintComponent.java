package org.example.core;

import org.example.character.CharacterPosition;
import org.example.constants.GraphicCon;

import javax.swing.*;
import java.awt.*;

public class PaintComponent extends JComponent {

    public void paintComponent(Graphics g, CharacterPosition charPosition) {

        super.paintComponent(g);

        //creo nuova cosa
        Graphics2D g2 = (Graphics2D) g;

        g2.setColor(Color.RED);

        g2.fillRect(charPosition.X, charPosition.Y, GraphicCon.tileSize, GraphicCon.tileSize);

        g2.dispose();
    }
}
