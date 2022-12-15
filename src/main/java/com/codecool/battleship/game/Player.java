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
                    System.out.println("\n" +
                            "\t\t\t               _  _ ___ _____ _ \n" +
                            "\t\t\t              | || |_ _|_   _| |\n" +
                            "\t\t\t              | __ || |  | | |_|\n" +
                            "\t\t\t              |_||_|___| |_| (_)\n" +
                            "\t");
                    return true;
                } else if (square.getY() == y && square.getX() == x &&
                        square.getSquareStatus().equals(SquareStatus.HIT)){
                    square.setSquareStatus(SquareStatus.HIT);
                    this.board.getSquare(x,y).setSquareStatus(SquareStatus.HIT);
                    System.out.println("\n" +
                            "            _   _    ___ ___   _   _____   __  _  _ ___ _____ _ \n" +
                            "           /_\\ | |  | _ \\ __| /_\\ |   \\ \\ / / | || |_ _|_   _| |\n" +
                            "          / _ \\| |__|   / _| / _ \\| |) \\ V /  | __ || |  | | |_|\n" +
                            "         /_/ \\_\\____|_|_\\___/_/ \\_\\___/ |_|   |_||_|___| |_| (_)\n" +
                            "\t");
                    return false;
                }
            }
        }

        board.getSquare(x,y).setSquareStatus(SquareStatus.MISSED);
        System.out.println("\n" +
                "\t\t\t              __  __ ___ ___ ___ _ \n" +
                "\t\t\t             |  \\/  |_ _/ __/ __| |\n" +
                "\t\t\t             | |\\/| || |\\__ \\__ \\_|\n" +
                "\t\t\t             |_|  |_|___|___/___(_)\n" +
                "\t");
        return false;
    }
}
