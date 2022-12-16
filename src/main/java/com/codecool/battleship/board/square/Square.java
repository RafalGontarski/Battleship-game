package com.codecool.battleship.board.square;

public class Square {
    private final int x;
    private final int y;
    private SquareStatus squareStatus;

    public Square(int x, int y, SquareStatus squareStatus) {
        this.x = x;
        this.y = y;
        this.squareStatus = squareStatus;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setSquareStatus(SquareStatus squareStatus) {
        this.squareStatus = squareStatus;
    }

    public SquareStatus getSquareStatus() {
        return squareStatus;
    }

    public char getCharacter() {
        char result = ' ';
        switch (squareStatus) {
            case HIT:
                result = 'H';
                break;
            case SHIP:
                result = 'S';
                break;
            case OCEAN:
                result = 'O';
                break;
            case MISSED:
                result = 'M';
        }
        return result;
    }
}
