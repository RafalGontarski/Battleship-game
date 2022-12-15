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

        for(int i = 0; i < 2; i++) {
            Ship one = board1.createShip(0);
            while(one.isPlacementOk(one, shipsPlayer1, boardPlayer1) == false) {
                System.out.println("You can't place ship here. Try another place.");
                one = board1.createShip(0);
            }
            shipsPlayer1.add(one);
            System.out.println("\n" + (i + 1) + " Ship created ");
        }
        for(int i = 0; i < 2; i++) {
            Ship one = board1.createShip(1);
            while(one.isPlacementOk(one, shipsPlayer2, boardPlayer2) == false) {
                System.out.println("You can't place ship here. Try another place.");
                one = board1.createShip(1);
            }
            shipsPlayer2.add(one);
            System.out.println("\n" + (i + 1) + " Ship created ");
        }

        Player player1 = new Player(shipsPlayer1, boardPlayer2);
        Player player2 = new Player(shipsPlayer2, boardPlayer1);

        boolean gameOn = true;

        Display display = new Display();

        System.out.println("\n          <<<<<<<<<Player 1 Board>>>>>>>>>>");
        display.printBoard(boardPlayer1);
        System.out.println(" ");
        display.printBoard(boardPlayer2);
        System.out.println("          <<<<<<<<<Player 2 Board>>>>>>>>>>");

        int numberOfShipPlayer1 = player1.numberOfSquaresOfShips(shipsPlayer1);
        int numberOfShipPlayer2 = player2.numberOfSquaresOfShips(shipsPlayer2);

        while (gameOn) {
            int[] shootCoordinates;
            shootCoordinates = board1.shoot(0);
            if (player2.handleShot(shootCoordinates[0], shootCoordinates[1])) {
                System.out.println("          <<<<<<<<<Player 2 Board>>>>>>>>>>");
                display.printBoard(player2.getBoard());
                numberOfShipPlayer2--;
            } else {
                System.out.println("          <<<<<<<<<Player 2 Board>>>>>>>>>>");
                display.printBoard(player2.getBoard());
            }
            if (numberOfShipPlayer2 == 0) {
                System.out.println("          <<<<<<<<<Player 1 Board>>>>>>>>>>");
                display.printBoard(player1.getBoard());
                System.out.println(" ");
                display.printBoard(player2.getBoard());
                System.out.println("          <<<<<<<<<Player 2 Board>>>>>>>>>>");
                System.out.println("Player 1 wins!");
                break;
            }
            shootCoordinates = board1.shoot(1);
            if (player1.handleShot(shootCoordinates[0], shootCoordinates[1])) {
                System.out.println("          <<<<<<<<<Player 1 Board>>>>>>>>>>");
                display.printBoard(player1.getBoard());
                numberOfShipPlayer1--;
            } else {
                System.out.println("          <<<<<<<<<Player 1 Board>>>>>>>>>>");
                display.printBoard(player1.getBoard());
            }
            if (numberOfShipPlayer1 == 0) {
                System.out.println("          <<<<<<<<<Player 1 Board>>>>>>>>>>");
                display.printBoard(player1.getBoard());
                System.out.println(" ");
                display.printBoard(player2.getBoard());
                System.out.println("          <<<<<<<<<Player 2 Board>>>>>>>>>>");
                System.out.println("Player 2 wins!");
                break;
            }
        }
    }
}

