package com.mammedbrk.graphic.graphicalmodel;

public class GraphicalGame {
    private final GraphicalBoard board;
    private int currentPlayer;

    public GraphicalGame() {
        this.board = new GraphicalBoard();
        currentPlayer = 1;
    }

    // getters and setters

    public GraphicalBoard getBoard() {
        return board;
    }

    public int getCurrentPlayer() {
        return currentPlayer;
    }

    public void setCurrentPlayer(int currentPlayer) {
        this.currentPlayer = currentPlayer;
    }
}
