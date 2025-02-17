package org.wiyu;


import org.wiyu.enums.Color;

import java.util.Scanner;

import static org.wiyu.StaticMethods.translateBoard;

public class Suchess {
    private static final int BOARD_LENGTH = 8;
    private static final int BOARD_HEIGHT = 8;

    public static void main(String[] args) {
        ChessPiece[][] board = new ChessPiece[BOARD_HEIGHT][BOARD_LENGTH];

        board[0][0] = board[0][7] = new Rook(Color.WHITE);
        board[7][0] = board[7][7] = new Rook(Color.BLACK);

        board[0][1] = board[0][6] = new Knight(Color.WHITE);
        board[7][1] = board[7][6] = new Knight(Color.BLACK);

        board[0][2] = board[0][5] = new Bishop(Color.WHITE);
        board[7][2] = board[7][5] = new Bishop(Color.BLACK);

        for (int x=0; x<board[0].length; x++) {
            board[1][x] = new Pawn(Color.BLACK);
            board[BOARD_HEIGHT-2][x] = new Pawn(Color.WHITE);
        }

        board[0][3] = new Queen(Color.BLACK); board[BOARD_HEIGHT-1][3] = new Queen(Color.WHITE);
        board[0][4] = new King(Color.BLACK); board[BOARD_HEIGHT-1][4] = new King(Color.WHITE);

        for (int y=0; y<BOARD_HEIGHT; y++) {
            for (int x=0; x<BOARD_LENGTH; x++) {
                if (board[y][x] != null) {
                    board[y][x].setX(x);
                    board[y][x].setY(y);
                }
            }
        }

        Scanner reader = new Scanner(System.in);

        board[6][3].movePiece(4,5,board);

        translateBoard(board);
    }
}