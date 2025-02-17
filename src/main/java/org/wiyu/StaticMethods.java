package org.wiyu;

import org.wiyu.enums.Color;

public class StaticMethods {
    public static boolean outOfBounds(int x, int y) {
        if ((x<0 || x>7) || (y<0 || y>7)) {
            return true;
        }
        return false;
    } // Prevents the isLegal method from firing off if the parameters are invalid

    public static int[] posToCoords(String coordinates) {
        char x = coordinates.toLowerCase().charAt(0);
        char y = coordinates.charAt(1);

        if (coordinates.length() != 2) {
            throw new RuntimeException("Invalid format.");
        } else if (x<'a' || x>'h' || y<'1' || y>'8') {
            throw new RuntimeException("Invalid format.");
        }


        return new int[]{Math.abs(x-'a'-7), y-'1'};
    }

    public static void translateBoard(ChessPiece[][] board) {
        for (int y=0; y<board.length; y++) {
            for (int x=0; x<board[y].length; x++) {
                if (board[y][x] != null) {
                    if (board[y][x].color == Color.BLACK) {
                        System.out.print("B");
                    } else {
                        System.out.print("W");
                    }
                    System.out.print("X ");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
    }
}
