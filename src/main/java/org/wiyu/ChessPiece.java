package org.wiyu;

import org.wiyu.enums.*;

import static org.wiyu.StaticMethods.outOfBounds;

public abstract class ChessPiece {
    protected Piece type;
    protected Color color;

    public ChessPiece(Piece t, Color c) {
        this.type = t;
        this.color = c;
    }

    abstract void movePiece(int x, int y);
    abstract boolean isLegal(int x, int y);
}

class Pawn extends ChessPiece {
    public Pawn(Color c) {
        super(Piece.PAWN, c);
    }

    @Override
    boolean isLegal(int x, int y) {
        if (outOfBounds(x,y)) {
            return false;
        }
        return true;
    }

    @Override
    void movePiece(int x, int y) {
        if (isLegal(x,y)) {

        }

    }

}

class Rook extends ChessPiece {
    public Rook(Color c) {
        super(Piece.ROOK, c);
    }

    @Override
    boolean isLegal(int x, int y) {
        if (outOfBounds(x,y)) {
            return false;
        }
        return true;
    }

    @Override
    void movePiece(int x, int y) {
        if (isLegal(x,y)) {

        }
    }
}

class Knight extends ChessPiece {
    public Knight(Color c) {
        super(Piece.KNIGHT, c);
    }

    @Override
    boolean isLegal(int x, int y) {
        if (outOfBounds(x,y)) {
            return false;
        }
        return true;
    }

    @Override
    void movePiece(int x, int y) {
        if (isLegal(x,y)) {

        }
    }
}

class Bishop extends ChessPiece {
    public Bishop(Color c) {
        super(Piece.BISHOP, c);
    }

    @Override
    boolean isLegal(int x, int y) {
        if (outOfBounds(x,y)) {
            return false;
        }
        return true;
    }

    @Override
    void movePiece(int x, int y) {
        if (isLegal(x,y)) {

        }
    }
}

class King extends ChessPiece {
    public King(Color c) {
        super(Piece.KING, c);
    }

    @Override
    boolean isLegal(int x, int y) {
        if (outOfBounds(x,y)) {
            return false;
        }
        return true;
    }

    @Override
    void movePiece(int x, int y) {
        if (isLegal(x,y)) {

        }
    }
}

class Queen extends ChessPiece {
    public Queen(Color c) {
        super(Piece.QUEEN, c);
    }

    @Override
    boolean isLegal(int x, int y) {
        if (outOfBounds(x,y)) {
            return false;
        }
        return true;
    }

    @Override
    void movePiece(int x, int y) {
        if (isLegal(x,y)) {

        }
    }
}
