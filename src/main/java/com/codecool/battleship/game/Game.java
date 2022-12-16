package com.codecool.battleship.game;

import com.codecool.battleship.ship.Ship;
import com.codecool.battleship.board.Board;
import com.codecool.battleship.view.Display;
import com.codecool.battleship.view.Input;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private final List<Ship> shipsPlayer1 = new ArrayList<>();
    private final List<Ship> shipsPlayer2 = new ArrayList<>();
    List<Board> boards;

    public void gameLogic() {

        Input input = new Input();
        boards = input.getBoards();
        Board boardPlayer1 = boards.get(0);
        Board boardPlayer2 = boards.get(1);

        for(int i = 0; i < 2; i++) {
            Ship one = input.createShip(0);
            while(one.isPlacementOk(one, shipsPlayer1, boardPlayer1) == false) {
                System.out.println("\n           You can't place ship right here. Try another place.");
                one = input.createShip(0);
            }
            shipsPlayer1.add(one);
            System.out.println("\n                        " + (i + 1) + " Ship has been created.");
        }
        for(int i = 0; i < 2; i++) {
            Ship one = input.createShip(1);
            while(one.isPlacementOk(one, shipsPlayer2, boardPlayer2) == false) {
                System.out.println("\nYou can't place ship right here. Try another place.");
                one = input.createShip(1);
            }
            shipsPlayer2.add(one);
            System.out.println("\n                         " + (i + 1) + " Ship has been created.");
        }

        Player player1 = new Player(shipsPlayer1, boardPlayer2);
        Player player2 = new Player(shipsPlayer2, boardPlayer1);

        boolean gameOn = true;

        Display display = new Display();

        System.out.println("\n                    <<<<<<<<<Player 1 Board>>>>>>>>>>");
        display.printBoard(boardPlayer1);
        System.out.println(" ");
        display.printBoard(boardPlayer2);
        System.out.println("                    <<<<<<<<<Player 2 Board>>>>>>>>>>");

        int numberOfShipPlayer1 = player1.numberOfSquaresOfShips(shipsPlayer1);
        int numberOfShipPlayer2 = player2.numberOfSquaresOfShips(shipsPlayer2);

        while (gameOn) {
            int[] shootCoordinates;
            shootCoordinates = input.shoot(0);
            if (player2.handleShot(shootCoordinates[0], shootCoordinates[1])) {
                System.out.println("                    <<<<<<<<<Player 2 Board>>>>>>>>>>");
                display.printBoard(player2.getBoard());
                display.printBoard(player1.getBoard());
                System.out.println("                    <<<<<<<<<Player 1 Board>>>>>>>>>>");
                numberOfShipPlayer2--;
            } else {
                System.out.println("                    <<<<<<<<<Player 2 Board>>>>>>>>>>");
                display.printBoard(player2.getBoard());
                display.printBoard(player1.getBoard());
                System.out.println("                    <<<<<<<<<Player 1 Board>>>>>>>>>>");
            }
            if (numberOfShipPlayer2 == 0) {
                System.out.println("\n" +
                        "           ___ ___ _  _   _   _      ___ ___ ___ _   _ _  _____ \n" +
                        "          | __|_ _| \\| | /_\\ | |    | _ \\ __/ __| | | | ||_   _|\n" +
                        "          | _| | || .` |/ _ \\| |__  |   / _|\\__ \\ |_| | |__| |  \n" +
                        "          |_| |___|_|\\_/_/ \\_\\____| |_|_\\___|___/\\___/|____|_|  \n" +
                        "                                                       ");
                System.out.println("                   <<<<<<<<<Player 1 Board>>>>>>>>>>");
                display.printBoard(player1.getBoard());
                System.out.println(" ");
                display.printBoard(player2.getBoard());
                System.out.println("                   <<<<<<<<<Player 2 Board>>>>>>>>>>");
                System.out.println("\n" +
                        "                                                                      __ \n" +
                        "      _____ __    _____ __ __ _____ _____    ___      _ _ _ _        |  |\n" +
                        "     |  _  |  |  |  _  |  |  |   __| __  |  |_  |    | | | |_|___ ___|  |\n" +
                        "     |   __|  |__|     |_   _|   __|    -|   _| |_   | | | | |   |_ -|__|\n" +
                        "     |__|  |_____|__|__| |_| |_____|__|__|  |_____|  |_____|_|_|_|___|__|\n" +
                        "                                                                    ");
                break;
            }
            shootCoordinates = input.shoot(1);
            if (player1.handleShot(shootCoordinates[0], shootCoordinates[1])) {
                System.out.println("                    <<<<<<<<<Player 1 Board>>>>>>>>>>");
                display.printBoard(player1.getBoard());
                display.printBoard(player2.getBoard());
                System.out.println("                    <<<<<<<<<Player 2 Board>>>>>>>>>>");
                numberOfShipPlayer1--;
            } else {
                System.out.println("                    <<<<<<<<<Player 1 Board>>>>>>>>>>");
                display.printBoard(player1.getBoard());
                display.printBoard(player2.getBoard());
                System.out.println("                    <<<<<<<<<Player 2 Board>>>>>>>>>>");
            }
            if (numberOfShipPlayer1 == 0) {
                System.out.println("\n" +
                        "           ___ ___ _  _   _   _      ___ ___ ___ _   _ _  _____ \n" +
                        "          | __|_ _| \\| | /_\\ | |    | _ \\ __/ __| | | | ||_   _|\n" +
                        "          | _| | || .` |/ _ \\| |__  |   / _|\\__ \\ |_| | |__| |  \n" +
                        "          |_| |___|_|\\_/_/ \\_\\____| |_|_\\___|___/\\___/|____|_|  \n" +
                        "                                                          ");
                System.out.println("                    <<<<<<<<<Player 1 Board>>>>>>>>>>");
                display.printBoard(player1.getBoard());
                System.out.println(" ");
                display.printBoard(player2.getBoard());
                System.out.println("                    <<<<<<<<<Player 2 Board>>>>>>>>>>");
                System.out.println("\n" +
                        "                                                                    __ \n" +
                        "      _____ __    _____ __ __ _____ _____    ___    _ _ _ _        |  |\n" +
                        "     |  _  |  |  |  _  |  |  |   __| __  |  |_  |  | | | |_|___ ___|  |\n" +
                        "     |   __|  |__|     |_   _|   __|    -|  |  _|  | | | | |   |_ -|__|\n" +
                        "     |__|  |_____|__|__| |_| |_____|__|__|  |___|  |_____|_|_|_|___|__|\n" +
                        "                                                                  ");
                break;
            }
        }
    }
}

