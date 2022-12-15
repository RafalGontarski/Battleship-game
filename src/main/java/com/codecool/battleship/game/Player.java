package com.codecool.battleship.game;

import com.codecool.battleship.ship.Ship;
import com.codecool.battleship.square.Square;
import com.codecool.battleship.square.SquareStatus;
import com.codecool.battleship.view.Board;

import java.util.Iterator;
import java.util.List;

public class Player {

    private List<Ship> ships;
    private Board board;

//    private int remainingShips = 0;

    public Player(List<Ship> ships, Board board) {
        this.ships = ships;
        this.board = board;
    }

    public Board getBoard() {
        return board;
    }

    public int numberOfSquaresOfShips(List<Ship> ships) {
        int sumOfAllSquares = 0;
        for (Ship ship : ships) {
            sumOfAllSquares += ship.getShipType().uniqueLength;
        }
        return sumOfAllSquares;
    }

    public boolean handleShot(int x, int y) {
        Iterator var3 = this.ships.iterator();

        while(var3.hasNext()) {
            Ship ship = (Ship) var3.next();
            Iterator var5 = ship.getFields().iterator();

            while(var5.hasNext()) {
                Square square = (Square)var5.next();
                if (square.getY() == y && square.getX() == x &&
                        square.getSquareStatus().equals(SquareStatus.SHIP)) {
                    square.setSquareStatus(SquareStatus.HIT);
                    this.board.getSquare(x,y).setSquareStatus(SquareStatus.HIT);
                    System.out.println("You hit a ship!");
                    return true;
                } else if (square.getY() == y && square.getX() == x &&
                        square.getSquareStatus().equals(SquareStatus.HIT)){
                    square.setSquareStatus(SquareStatus.HIT);
                    this.board.getSquare(x,y).setSquareStatus(SquareStatus.HIT);
                    System.out.println("Already Hit!");
                    return false;
                }
            }
        }

        board.getSquare(x,y).setSquareStatus(SquareStatus.MISSED);
        System.out.println("Miss!");
        return false;
    }
}
