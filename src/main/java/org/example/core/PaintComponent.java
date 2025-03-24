package org.example.core;

import org.example.constants.GraphicCon;
import org.example.entity.Player;

import javax.swing.*;
import java.awt.*;

public class PaintComponent extends JComponent {

    public void paintComponent(Graphics g, Player player) {

        super.paintComponent(g);

        //creo nuova cosa
        Graphics2D g2 = (Graphics2D) g;

        g2.setColor(Color.RED);

        g2.fillRect(player.X, player.Y, GraphicCon.tileSize, GraphicCon.tileSize);

        g2.dispose();
    }
}
