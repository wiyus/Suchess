package org.wiyu;

public class StaticMethods {
    public static boolean outOfBounds(int x, int y) {
        if ((x<0 || x>7) || (y<0 || y>7)) {
            return true;
        }
        return false;
    }

    public static int[] posToCoords(String coordinates) {
        int[] newCoords = new int[2];

        if (coordinates.length() != 2) {

        }
        return newCoords;
    }
}
