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
            this.y = y;
            this.x = x;
        }
    } // piece moving logic is the same for all pieces

    protected abstract boolean isLegal(int x, int y, ChessPiece[][] board);
}

//Pawn definition
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
            if (board[y][x] == null && x==this.x) {
                if (y==this.y-1) {
                    return true;
                } else if (this.y==6 && y==this.y-2) {
                    return true;
                }
            } else if ((x==this.x-1 || x==this.x+1) && y==this.y-1) {
                return true;
            }
        } else if (this.color==Color.BLACK) {
            if (board[y][x] == null && x==this.x) {
                if (this.y==1 && y==this.y+2) {
                    return true;
                } else if (y==this.y+1) {
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

//Rook definition
class Rook extends ChessPiece {
    public Rook(Color c) {
        super(Piece.ROOK, c);
    }

    @Override
    protected boolean isLegal(int x, int y, ChessPiece[][] board) {
        if (outOfBounds(x,y)) {
            return false;
        }
        return this.checkLines(x,y,board);
    }

    private boolean checkLines(int x, int y, ChessPiece[][] board) {
        if (x!=this.x && y!=this.y) {
            System.out.println("Case 1");
            return false;
        }

        if (x==this.x) {
            if (y<this.y) {
                for (int i=this.y-1; i!=y; i--) {
                    if (board[i][this.x] != null) {
                        System.out.println("Case 2");
                        System.out.println(board[i][this.x].y);
                        return false;
                    }
                }
            } else {
                for (int i=this.y+1; i!=y; i++) {
                    if (board[i][this.x] != null) {
                        System.out.println("Case 3");
                        return false;
                    }
                }
            }
        } else if (y==this.y) {
            if (x<this.x) {
                for (int i=this.x-1; i!=x; i--) {
                    if (board[this.y][i] != null) {
                        System.out.println("Case 4");
                        return false;
                    }
                }
            } else {
                for (int i=this.x+1; i!=x; i++) {
                    if (board[this.y][i] != null) {
                        System.out.println("Case 5");
                        return false;
                    }
                }
            }
        }

        if ((board[y][x] == null) || (board[y][x].color != this.color)) {
            return true;
        }

        return false;
    }
}

//Knight definition
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

//Bishop definition
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

//King definition
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

//Queen definition
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
