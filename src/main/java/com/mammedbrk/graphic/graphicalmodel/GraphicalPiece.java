package com.mammedbrk.graphic.graphicalmodel;

import com.mammedbrk.config.Config;

import java.awt.*;

public class GraphicalPiece implements GraphicalModel {
    private static int pieceSize;
    private static int cellWidth, cellHeight;
    private Color color;
    private final int x, y;

    public GraphicalPiece(int x, int y, int color) {
        this.x = x * cellWidth + cellWidth / 2 - pieceSize / 2;
        this.y = y * cellHeight + cellHeight / 2 - pieceSize / 2;;
        this.color = Color.decode(Config.getInstance().getProperty("colorPlayer" + color));
    }

    @Override
    public void paint(Graphics2D g) {
        g.setColor(color);
        g.drawOval(x, y, pieceSize, pieceSize);
        g.fillOval(x, y, pieceSize, pieceSize);
    }

    // getters and setters

    public static int getPieceSize() {
        return pieceSize;
    }

    public static void setPieceSize(int pieceSize) {
        GraphicalPiece.pieceSize = pieceSize;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public static int getCellWidth() {
        return cellWidth;
    }

    public static void setCellWidth(int cellWidth) {
        GraphicalPiece.cellWidth = cellWidth;
    }

    public static int getCellHeight() {
        return cellHeight;
    }

    public static void setCellHeight(int cellHeight) {
        GraphicalPiece.cellHeight = cellHeight;
    }
}
