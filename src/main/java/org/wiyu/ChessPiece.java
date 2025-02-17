package org.wiyu;

import org.wiyu.enums.*;
import org.wiyu.interfaces.Promotable;

import static org.wiyu.StaticMethods.outOfBounds;

public abstract class ChessPiece {
    protected Piece type;
    protected Color color;
    protected int x;
    protected int y;

    public ChessPiece(Piece t, Color c) {
        this.type = t;
        this.color = c;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public abstract void movePiece(int x, int y, ChessPiece[][] board);
    protected abstract boolean isLegal(int x, int y, ChessPiece[][] board);
}

class Pawn extends ChessPiece implements Promotable {
    public Pawn(Color c) {
        super(Piece.PAWN, c);
    }

    @Override
    protected boolean isLegal(int x, int y, ChessPiece[][] board) {
        if (outOfBounds(x,y)) {
            return false;
        }
        return true;
    }

    @Override
    public void movePiece(int x, int y, ChessPiece[][] board) {
        if (isLegal(x,y,board)) {
            board[this.y][this.x] = null;
            board[y][x] = new Pawn(this.color);
            board[y][x].y = y;
            board[y][x].x = x;
        }
    }

    @Override
    public void promote(int x, int y, ChessPiece[][] board) {
        if (this.color == Color.BLACK) {
            if (y == 0) {
                board[y][x] = new Queen(this.color);
            }
        } else if (this.color == Color.WHITE) {
            if (y==7) {
                board[y][x] = new Queen(this.color);
            }
        }
    }
}

class Rook extends ChessPiece {
    public Rook(Color c) {
        super(Piece.ROOK, c);
    }

    @Override
    protected boolean isLegal(int x, int y, ChessPiece[][] board) {
        if (outOfBounds(x,y)) {
            return false;
        }
        return true;
    }

    @Override
    public void movePiece(int x, int y, ChessPiece[][] board) {
        if (isLegal(x,y,board)) {
            board[this.y][this.x] = null;
            board[y][x] = new Rook(this.color);
            board[y][x].y = y;
            board[y][x].x = x;
        }
    }
}

class Knight extends ChessPiece {
    public Knight(Color c) {
        super(Piece.KNIGHT, c);
    }

    @Override
    protected boolean isLegal(int x, int y, ChessPiece[][] board) {
        if (outOfBounds(x,y)) {
            return false;
        }
        return true;
    }

    @Override
    public void movePiece(int x, int y, ChessPiece[][] board) {
        if (isLegal(x,y,board)) {
            board[this.y][this.x] = null;
            board[y][x] = new Knight(this.color);
            board[y][x].y = y;
            board[y][x].x = x;
        }
    }
}

class Bishop extends ChessPiece {
    public Bishop(Color c) {
        super(Piece.BISHOP, c);
    }

    @Override
    protected boolean isLegal(int x, int y, ChessPiece[][] board) {
        if (outOfBounds(x,y)) {
            return false;
        }
        return true;
    }

    @Override
    public void movePiece(int x, int y, ChessPiece[][] board) {
        if (isLegal(x,y,board)) {
            board[this.y][this.x] = null;
            board[y][x] = new Bishop(this.color);
            board[y][x].y = y;
            board[y][x].x = x;
        }
    }
}

class King extends ChessPiece {
    public King(Color c) {
        super(Piece.KING, c);
    }

    @Override
    protected boolean isLegal(int x, int y, ChessPiece[][] board) {
        if (outOfBounds(x,y)) {
            return false;
        }
        return true;
    }

    @Override
    public void movePiece(int x, int y, ChessPiece[][] board) {
        if (isLegal(x,y,board)) {
            board[this.y][this.x] = null;
            board[y][x] = new King(this.color);
            board[y][x].y = y;
            board[y][x].x = x;
        }
    }
}

class Queen extends ChessPiece {
    public Queen(Color c) {
        super(Piece.QUEEN, c);
    }

    @Override
    protected boolean isLegal(int x, int y, ChessPiece[][] board) {
        if (outOfBounds(x,y)) {
            return false;
        }
        return true;
    }

    @Override
    public void movePiece(int x, int y, ChessPiece[][] board) {
        if (isLegal(x,y,board)) {
            board[this.y][this.x] = null;
            board[y][x] = new Queen(this.color);
            board[y][x].y = y;
            board[y][x].x = x;
        }
    }
}
