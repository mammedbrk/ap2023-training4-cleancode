package com.mammedbrk.graphic.graphicalmodel;

import com.mammedbrk.config.Config;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class GraphicalBoard implements GraphicalModel {
    private final int width, height;
    private final int rowCount, colCount;
    private List<GraphicalPiece> pieces;
    private final Color color;

    public GraphicalBoard() {
        this.width = Integer.parseInt(Config.getInstance().getProperty("boardWidth"));
        this.height = Integer.parseInt(Config.getInstance().getProperty("boardHeight"));
        this.rowCount = Integer.parseInt(Config.getInstance().getProperty("rowCount"));
        this.colCount = Integer.parseInt(Config.getInstance().getProperty("colCount"));
        this.color = Color.decode(Config.getInstance().getProperty("boardColor"));

        this.pieces = new ArrayList<>();
        GraphicalPiece.setPieceSize(Math.min(width / colCount, height / rowCount) / 2);
        GraphicalPiece.setCellHeight(height / rowCount);
        GraphicalPiece.setCellWidth(width / colCount);
    }

    // methods

    public void addPiece(GraphicalPiece piece) {
        pieces.add(piece);
    }

    public void clearPieces() {
        pieces.clear();
    }

    @Override
    public void paint(Graphics2D g) {
        g.setColor(color);
        for (int i = 0; i <= rowCount; i++) {
            g.drawLine(0, i * height / rowCount, width, i * height / rowCount);
            g.drawLine(i * width / colCount, 0, i * width / rowCount, height);
        }
        for (GraphicalPiece piece: pieces) {
            piece.paint(g);
        }
    }

    // getters and setters

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getRowCount() {
        return rowCount;
    }

    public int getColCount() {
        return colCount;
    }

    public void setPieces(List<GraphicalPiece> pieces) {
        this.pieces = pieces;
    }

    public List<GraphicalPiece> getPieces() {
        return pieces;
    }
}
