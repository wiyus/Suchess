package org.wiyu;

public class StaticMethods {
    public static boolean outOfBounds(int x, int y) {
        if ((x<0 || x>7) || (y<0 || y>7)) {
            return true;
        }
        return false;
    }

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
}
