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

    public void movePiece(int x, int y, ChessPiece[][] board) {
        if (isLegal(x,y,board)) {
            board[y][x] = this;
            board[this.y][this.x] = null;
            board[y][x].y = y;
            board[y][x].x = x;
        }
    }

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
        if (this.color==Color.WHITE) {
            if (board[y][x] == null) {
                if (x==this.x && y==this.y-1) {
                    return true;
                } else if (this.y==6 && y==this.y-2) {
                    return true;
                }
            } else if ((x==this.x-1 || x==this.x+1) && y==this.y-1) {
                return true;
            }
        } else if (this.color==Color.BLACK) {
            if (board[y][x] == null) {
                if (this.y==1 && y==this.y+2) {
                    return true;
                } else if (x==this.x && y==this.y+1) {
                    return true;
                }
            } else {
                if ((x==this.x-1 || x==this.x+1) && y==this.y+1) {
                    return true;
                }
            }
        }



        return false;
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
}
