package com.codecool.battleship.board;

import com.codecool.battleship.ship.Ship;
import com.codecool.battleship.board.square.Square;
import com.codecool.battleship.board.square.SquareStatus;

public class Board {

    private final int sizeX;
    private final int sizeY;
    Square[][] ocean;

    public Board(int sizeX, int sizeY) {
        this.sizeX = sizeX;
        this.sizeY = sizeY;
        fillBoard(sizeX, sizeY);
    }

    public int getSizeX() {
        return sizeX;
    }

    public int getSizeY() {
        return sizeY;
    }

    /** Method checks square on the board.
     * @param row row number (from index 0 to (board size - 1))
     * @param column column number (from index 0 to (board size - 1))
     * */
    public Square getSquare(int row, int column) {
        return ocean[row][column];
    }

    public void fillBoard(int x, int y) {
        ocean = new Square[sizeX][sizeY];
        for (int row = 0; row < x; row++) {
            for (int col = 0; col < y; col++) {
                ocean[row][col] = new Square(row, col, SquareStatus.OCEAN);
            }
        }
    }

    public void placeShip(Square square, Ship ship) {
        int x;
        int y;

        square.setSquareStatus(SquareStatus.SHIP);
        ship.add(square);
        switch (ship.getShipType().uniqueLength) {
            case 2 -> {
                x = square.getX();
                y = square.getY();
                ship.add(new Square(x, y + 1, SquareStatus.SHIP));
            }
            case 3 -> {
                x = square.getX();
                y = square.getY();
                ship.add(new Square(x, y + 1, SquareStatus.SHIP));
                ship.add(new Square(x, y + 2, SquareStatus.SHIP));
            }
            case 4 -> {
                x = square.getX();
                y = square.getY();
                ship.add(new Square(x, y + 1, SquareStatus.SHIP));
                ship.add(new Square(x, y + 2, SquareStatus.SHIP));
                ship.add(new Square(x, y + 3, SquareStatus.SHIP));
            }
            case 5 -> {
                x = square.getX();
                y = square.getY();
                ship.add(new Square(x, y + 1, SquareStatus.SHIP));
                ship.add(new Square(x, y + 2, SquareStatus.SHIP));
                ship.add(new Square(x, y + 3, SquareStatus.SHIP));
                ship.add(new Square(x, y + 4, SquareStatus.SHIP));
            }
        }
    }
}
