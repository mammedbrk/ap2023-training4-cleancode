package com.mammedbrk.logic;

import com.mammedbrk.model.*;

import java.util.List;

public class GameController {
    private Game game;

    public GameController(Game game) {
        this.game = game;
    }

    // method

    public void makeMove(int x, int y) {
        if (game.getBoard().getPiece(x, y) != null)
            return;
        List<Piece> flip = game.flipList(x, y, game.getCurrentPlayer());
        for (Piece piece : flip)
            piece.setColor(game.getCurrentPlayer());
        if (!flip.isEmpty()) {
            game.getBoard().addPiece(new Piece(x, y, game.getCurrentPlayer()));
            game.changeTurn();
        }
    }

    // getters and setters

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }
}
