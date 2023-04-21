package com.mammedbrk.logic;

import com.mammedbrk.listener.MyMouseListener;
import com.mammedbrk.model.*;
import com.mammedbrk.graphic.view.*;
import com.mammedbrk.graphic.graphicalmodel.*;

import javax.swing.*;

public class Agent {
    private MyFrame frame;
    private MyPanel panel;
    private GameController controller;
    private Game game;
    private GraphicalGame graphicalGame;

    public Agent() {
        frame = new MyFrame();
        panel = new MyPanel();

        panel.addMouseListener(new MyMouseListener(this));


        resetGame();

        frame.setContentPane(panel);
        frame.setVisible(true);
    }

    private void resetGame() {
        Board board = new BoardBuilder().build();
        game = new Game(board);
        controller = new GameController(game);

        graphicalGame = new GraphicalGame();
        panel.setGraphicalGame(graphicalGame);

        updateGraphics();
    }

    public void makeMove(int x, int y) {
        controller.makeMove(x, y);

        updateGraphics();

        if (game.gameIsFinished()) {
            int winner = game.getWinner();
            String message = (winner > 0)? "Player" + winner + " win the game!": "Tie";
            JOptionPane.showMessageDialog(frame, message);

            resetGame();
        }
    }

    private void updateGraphics() {
        graphicalGame.getBoard().clearPieces();
        for (int i = 0; i < game.getBoard().getRowCount(); i++) {
            for (int j = 0; j < game.getBoard().getColCount(); j++) {
                if (game.getBoard().getPiece(i, j) != null) {
                    Piece piece = game.getBoard().getPiece(i, j);
                    GraphicalPiece gPiece = new GraphicalPiece(piece.getX(), piece.getY(), piece.getColor());
                    graphicalGame.getBoard().addPiece(gPiece);
                }
            }
        }

        graphicalGame.setCurrentPlayer(game.getCurrentPlayer());

        frame.repaint();
        frame.revalidate();
    }
}
