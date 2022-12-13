package com.codecool.battleship.game;

import com.codecool.battleship.ship.Ship;
import com.codecool.battleship.view.Board;
import com.codecool.battleship.view.Display;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private List<Ship> shipsPlayer1 = new ArrayList<>();
    private List<Ship> shipsPlayer2 = new ArrayList<>();
    List<Board> boards;

    public void gameLogic() {
        Input board1 = new Input();
        boards = board1.getBoards();
        Board boardPlayer1 = boards.get(0);
        Board boardPlayer2 = boards.get(1);
        for(int i = 2; i < 2; i++) {
            Ship one = board1.createShip(0);
            while(one.isPlacementOk(one, shipsPlayer1, boardPlayer1) == false) {
                one = board1.createShip(0);
            }
            shipsPlayer1.add(one);
        }
        for(int i = 2; i < 2; i++) {
            Ship one = board1.createShip(1);
            while(one.isPlacementOk(one, shipsPlayer2, boardPlayer2) == false) {
                one = board1.createShip(1);
            }
            shipsPlayer2.add(one);
        }

        Player player1 = new Player(shipsPlayer1, boardPlayer2);
        Player player2 = new Player(shipsPlayer2, boardPlayer1);
        boolean gameOn = true;
        Display display = new Display();
        System.out.println("          <<<<<<<<Player 1 Board>>>>>>>>>>");
        display.printBoard(boardPlayer1);
        System.out.println("          --------------------------------");
        System.out.println("          <<<<<<<<Player 2 Board>>>>>>>>>>");
        display.printBoard(boardPlayer2);
        int numberOfShipPlayer1 = player1.numberOfSquaresOfShips(shipsPlayer1);
        int numberOfShipPlayer2 = player2.numberOfSquaresOfShips(shipsPlayer2);

        while (gameOn) {
            int[] ShootCoordinates;
            ShootCoordinates = board1.shoot(0);
            if (player2.handleShot((char) ShootCoordinates[0], ShootCoordinates[1])) {
                display.printBoard(player2.getBoard());
                numberOfShipPlayer2--;
            } else {
                display.printBoard(player2.getBoard());
            }
            if (numberOfShipPlayer2 == 0) {
                display.printBoard(player2.getBoard());
                System.out.println("Player 1 wins!");
                break;
            }
            ShootCoordinates = board1.shoot(1);
            if (player1.handleShot((char) ShootCoordinates[0], ShootCoordinates[1])) {
                display.printBoard(player1.getBoard());
                numberOfShipPlayer1--;
            } else {
                display.printBoard(player1.getBoard());
            }
            if (numberOfShipPlayer1 == 0) {
                display.printBoard(player1.getBoard());
                System.out.println("Player 2 wins!");
                break;
            }
        }
    }
}

