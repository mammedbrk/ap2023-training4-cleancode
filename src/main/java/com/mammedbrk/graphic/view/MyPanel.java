package com.mammedbrk.graphic.view;

import config.Config;
import view.graphicalmodel.GraphicalGame;

import javax.swing.*;
import java.awt.*;

public final class MyPanel extends JPanel {
    private static MyPanel instance;
    private GraphicalGame graphicalGame;
    private final String color;

    public static MyPanel getInstance() {
        if (instance == null)
            instance = new MyPanel();
        return instance;
    }

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
