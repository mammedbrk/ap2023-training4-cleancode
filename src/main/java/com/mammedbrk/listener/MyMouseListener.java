package com.mammedbrk.listener;

import com.mammedbrk.config.Config;
import com.mammedbrk.logic.Agent;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MyMouseListener implements MouseListener {
    private final Agent agent;

    public MyMouseListener(Agent agent) {
        this.agent = agent;
    }


    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
        int boardWidth = Integer.parseInt(Config.getInstance().getProperty("boardWidth"));
        int boardHeight = Integer.parseInt(Config.getInstance().getProperty("boardHeight"));
        int rowCount = Integer.parseInt(Config.getInstance().getProperty("rowCount"));
        int colCount = Integer.parseInt(Config.getInstance().getProperty("colCount"));

        int x = e.getX() / (boardWidth / rowCount);
        int y = e.getY() / (boardHeight / colCount);
        if (x >= rowCount || y >= rowCount) {
            return;
        }

        agent.makeMove(x, y);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
}
