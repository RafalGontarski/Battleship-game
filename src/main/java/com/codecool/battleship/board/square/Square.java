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

    public SquareStatus getSquareStatus() {
        return squareStatus;
    }

    public void setSquareStatus(SquareStatus squareStatus) {
        this.squareStatus = squareStatus;
    }

    public char getCharacter() {
        return switch (squareStatus) {
            case HIT -> 'H';
            case SHIP -> 'S';
            case OCEAN -> 'O';
            case MISSED -> 'M';
        };
    }
}
