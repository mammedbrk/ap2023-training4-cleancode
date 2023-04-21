package com.mammedbrk.logic;

import com.mammedbrk.config.Config;
import com.mammedbrk.model.*;

public class BoardBuilder {
    public Board build() {
        int rowCount = Integer.parseInt(Config.getInstance().getProperty("rowCount"));
        int colCount = Integer.parseInt(Config.getInstance().getProperty("colCount"));

        Board board = new Board(rowCount, colCount);

        initPieces(board);

        return board;
    }

    private void initPieces(Board board) {
        for (int i = 1; Config.getInstance().getProperty("xPiece" + i) != null; i++) {
            int x = Integer.parseInt(Config.getInstance().getProperty("xPiece" + i));
            int y = Integer.parseInt(Config.getInstance().getProperty("yPiece" + i));
            int color = Integer.parseInt(Config.getInstance().getProperty("colorPiece" + i));

            Piece piece = new Piece(x, y, color);
            board.addPiece(piece);
        }
    }
}
