package com.codecool.battleship.game;

import com.codecool.battleship.ship.Ship;
import com.codecool.battleship.board.square.Square;
import com.codecool.battleship.board.square.SquareStatus;
import com.codecool.battleship.board.Board;

import java.util.List;

public class Player {

    private final List<Ship> ships;
    private final Board board;

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

        for (Ship ship : this.ships) {
            for (Square square : ship.getFields()) {
                if (square.getY() == y && square.getX() == x &&
                        square.getSquareStatus().equals(SquareStatus.SHIP)) {
                    square.setSquareStatus(SquareStatus.HIT);
                    this.board.getSquare(x, y).setSquareStatus(SquareStatus.HIT);
                    System.out.println("""

                            \t\t\t                _  _ ___ _____ _\s
                            \t\t\t               | || |_ _|_   _| |
                            \t\t\t               | __ || |  | | |_|
                            \t\t\t               |_||_|___| |_| (_)
                            \t""");
                    return true;
                } else if (square.getY() == y && square.getX() == x &&
                        square.getSquareStatus().equals(SquareStatus.HIT)) {
                    square.setSquareStatus(SquareStatus.HIT);
                    this.board.getSquare(x, y).setSquareStatus(SquareStatus.HIT);
                    System.out.println("""

                                        _   _    ___ ___   _   _____   __  _  _ ___ _____ _\s
                                       /_\\ | |  | _ \\ __| /_\\ |   \\ \\ / / | || |_ _|_   _| |
                                      / _ \\| |__|   / _| / _ \\| |) \\ V /  | __ || |  | | |_|
                                     /_/ \\_\\____|_|_\\___/_/ \\_\\___/ |_|   |_||_|___| |_| (_)
                            \t""");
                    return false;
                }
            }
        }
        board.getSquare(x,y).setSquareStatus(SquareStatus.MISSED);
        System.out.println("""

                \t\t\t               __  __ ___ ___ ___ _\s
                \t\t\t              |  \\/  |_ _/ __/ __| |
                \t\t\t              | |\\/| || |\\__ \\__ \\_|
                \t\t\t              |_|  |_|___|___/___(_)
                \t""");
        return false;
    }
}
