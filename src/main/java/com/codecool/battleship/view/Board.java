package com.codecool.battleship.view;

import com.codecool.battleship.ship.Ship;
import com.codecool.battleship.square.Square;
import com.codecool.battleship.square.SquareStatus;

public class Board {

    private int sizeX;
    private int sizeY;
    Square[][] ocean;

    public Board(int sizeX, int sizeY) {
        this.sizeX = sizeX;
        this.sizeY = sizeY;
        fillBoard(sizeX, sizeY);
    }
    // Nie wiem co to jest... xD
//    public Square[][] getBoard() {
//        return ocean;
//    }


    public int getSizeX() {
        return this.sizeX;
    }

    public int getSizeY() {
        return this.sizeY;
    }

    /** Method checks square on the board.
     * Parameters
     * @param row - row number (from index 0 to (board size - 1))
     * @param column - column number (from index 0 to (board size - 1)) */
    public Square getSquare(int row, int column) {
        return this.ocean[row][column];
    }

    public Square[][] fillBoard(int x, int y) {
        this.ocean = new Square[sizeX][sizeY];
        for (int row = 0; row < x; row++) {
            for (int col = 0; col < y; col++) {
                ocean[row][col] = new Square(row, col, SquareStatus.OCEAN);
            }
        }
        return this.ocean;
    }

    public void placeShip(Square square, Ship ship) {
        int x;
        int y;
        switch (ship.getShipType().uniqueLength) {
            case 1:
                square.setSquareStatus(SquareStatus.SHIP);
                ship.add(square);
                break;
            case 2:
                square.setSquareStatus(SquareStatus.SHIP);
                ship.add(square);
                x = square.getX();
                y = square.getY();
                ship.add(new Square(x, y+1, SquareStatus.SHIP));
            case 3:
                square.setSquareStatus(SquareStatus.SHIP);
                ship.add(square);
                x = square.getX();
                y = square.getY();
                ship.add(new Square(x, y+1, SquareStatus.SHIP));
                ship.add(new Square(x, y+2, SquareStatus.SHIP));
            case 4:
                square.setSquareStatus(SquareStatus.SHIP);
                ship.add(square);
                x = square.getX();
                y = square.getY();
                ship.add(new Square(x, y+1, SquareStatus.SHIP));
                ship.add(new Square(x, y+2, SquareStatus.SHIP));
                ship.add(new Square(x, y+3, SquareStatus.SHIP));
        }
    }
}
