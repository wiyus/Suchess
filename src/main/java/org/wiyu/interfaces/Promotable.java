package org.wiyu.interfaces;

import org.wiyu.ChessPiece;

public interface Promotable {
    public void promote(int x, int y, ChessPiece[][] board);
}
