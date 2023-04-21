package com.mammedbrk.graphic.view;

import com.mammedbrk.config.Config;
import com.mammedbrk.graphic.graphicalmodel.GraphicalGame;

import javax.swing.*;
import java.awt.*;

public class MyPanel extends JPanel {
    private GraphicalGame graphicalGame;
    private final String color;

    public MyPanel() {
        color = Config.getInstance().getProperty("panelColor");
        setLayout(null);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.setBackground(Color.decode(color));

        int windowHeight = graphicalGame.getBoard().getHeight();
        g.drawString("Player turn: " + (Config.getInstance().getProperty("colorPlayer" + graphicalGame.getCurrentPlayer() + "Name")), 0, windowHeight + 15);

        graphicalGame.getBoard().paint((Graphics2D) g);
    }

    // getters and setters

    public GraphicalGame getGraphicalGame() {
        return graphicalGame;
    }

    public void setGraphicalGame(GraphicalGame graphicalGame) {
        this.graphicalGame = graphicalGame;
    }
}
