package com.mammedbrk.model;

public class Board {
    private final int rowCount, colCount;
    private Piece[][] pieces;

    public Board(int rowCount, int colCount) {
        this.rowCount = rowCount;
        this.colCount = colCount;
        pieces = new Piece[rowCount][colCount];
    }

    // methods

    public void addPiece(Piece piece) {
        pieces[piece.getX()][piece.getY()] = piece;
    }

    public Piece getPiece(int x, int y) {
        return pieces[x][y];
    }

    // getters and setters

    public int getRowCount() {
        return rowCount;
    }

    public int getColCount() {
        return colCount;
    }

    public Piece[][] getPieces() {
        return pieces;
    }

    public void setPieces(Piece[][] pieces) {
        this.pieces = pieces;
    }
}
