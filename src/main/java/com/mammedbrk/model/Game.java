package com.mammedbrk.model;

import com.mammedbrk.config.Config;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private final int numOfPlayers;
    private final Board board;
    private int currentPlayer;

    public Game(Board board) {
        this.board = board;
        numOfPlayers = Integer.parseInt(Config.getInstance().getProperty("numOfPlayers"));
        currentPlayer = 1;
    }

    // methods

    public List<Piece> flipList(int i, int j, int player) {
        int[] dx = {1, 1, -1, -1, 0, 0, 1, -1};
        int[] dy = {-1, 1, 1, -1, 1, -1, 0, 0};
        ArrayList<Piece> ret = new ArrayList<>();
        mainLoop:
        for (int k = 0; k < dx.length; k++) {
            ArrayList<Piece> tmp = new ArrayList<>();
            for (int l = 1; l <= Math.max(board.getRowCount(), board.getColCount()); l++) {
                int nx = i + l * dx[k], ny = j + l * dy[k];
                if (nx >= board.getColCount() || nx < 0 || ny >= board.getRowCount() || ny < 0 || board.getPiece(nx, ny) == null)
                    continue mainLoop;
                if (board.getPiece(nx, ny).getColor() == player)
                    break;
                tmp.add(board.getPiece(nx, ny));
            }
            ret.addAll(tmp);
        }
        return ret;
    }

    private boolean playerHasMove(int player) {
        for (int i = 0; i < board.getRowCount(); i++)
            for (int j = 0; j < board.getColCount(); j++) {
                if (board.getPiece(i, j) != null)
                    continue;
                if (!flipList(i, j, player).isEmpty())
                    return true;
            }
        return false;
    }

    public void changeTurn() {
        currentPlayer = (currentPlayer % numOfPlayers) + 1;
        if (!playerHasMove(currentPlayer))
            currentPlayer = (currentPlayer % numOfPlayers) + 1;
    }

    public boolean gameIsFinished() {
        for (int i = 1; i <= numOfPlayers; i++) {
            if (playerHasMove(i))
                return false;
        }
        return true;
    }

    public int getWinner() {
        int[] playerScore = new int[numOfPlayers + 1];
        for (int i = 0; i < board.getRowCount(); i++) {
            for (int j = 0; j < board.getColCount(); j++) {
                if (board.getPiece(i, j) == null) continue;
                playerScore[board.getPiece(i, j).getColor()]++;
            }
        }

        if (playerScore[1] > playerScore[2])
            return 1;
        if (playerScore[1] < playerScore[2])
            return 2;
        return 0;
    }


    // getters and setters

    public int getNumOfPlayers() {
        return numOfPlayers;
    }

    public Board getBoard() {
        return board;
    }

    public int getCurrentPlayer() {
        return currentPlayer;
    }

    public void setCurrentPlayer(int currentPlayer) {
        this.currentPlayer = currentPlayer;
    }
}
