package com.codecool.battleship.game;

import com.codecool.battleship.ship.Ship;
import com.codecool.battleship.ship.ShipType;
import com.codecool.battleship.square.Square;
import com.codecool.battleship.square.SquareStatus;
import com.codecool.battleship.view.Board;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Input {

    private Scanner scanner = new Scanner(System.in);
    private List<Board> boards = new ArrayList<>();
    int choice;
    List<Integer> CoordinatesAndShipType = new ArrayList<>();

    public List<Board> getBoards() {
        getBoardSize();
        return boards;
    }

    public void getBoardSize() {

        int n = 0;
        boolean input = false;

        while (!input) {
            Scanner boardSize = new Scanner(System.in);
            System.out.println("Enter board size. Choose between 15 and 26: ");
            try {
                int userInput = boardSize.nextInt();
                if (userInput >= 15 && userInput <= 26) {
                    n = userInput;
                    input = true;

                } else {
                    System.out.println("Number out of range! Try again !");
                }
            } catch (InputMismatchException number) {
                System.out.println("Wrong input try again!");
            }
        }
        Board board1 = new Board(n, n);
        Board board2 = new Board(n, n);
        boards.add(board1);
        boards.add(board2);
    }

    public Input() {

    }

    public int getIntegerMenuOption() {
        choice = scanner.nextInt();
        scanner.nextLine();
        return choice;
    }

    private List<Integer> AskCoordForShipAndTypes() {
        Scanner sc = new Scanner(System.in);
        this.CoordinatesAndShipType = new ArrayList<>();
        System.out.print("Enter position for ship: ");
        String position = sc.nextLine().toUpperCase();
        String[] coordinates = position.split("", 2);
        int row = Integer.parseInt(coordinates[1]) - 1;
        int col = position.charAt(0) - 65;
        System.out.println("\nSelect ship: \n\n\t" + "1 - CARRIER \n\t" + "2 - CRUISER \n\t" + "3 - BATTLESHIP \n\t" + "4 - DESTROYER \n\t"
                + "5 - SUBMARINE \n");
        int shipType = sc.nextInt();
        CoordinatesAndShipType.add(row);
        CoordinatesAndShipType.add(col);
        CoordinatesAndShipType.add(shipType);
        return CoordinatesAndShipType;
    }

    public Ship createShip(int player) {
        int GamePlayer = player + 1;
        Square shipPart;
        Ship ship;
        System.out.println("\n\t>>>>Player" + GamePlayer + " place ship<<<< \n");
        CoordinatesAndShipType = AskCoordForShipAndTypes();
        int row = CoordinatesAndShipType.get(0);
        int col = CoordinatesAndShipType.get(1);
        int shipType = CoordinatesAndShipType.get(2);
        shipPart = new Square(row, col, SquareStatus.SHIP);
        ship = new Ship(new ArrayList<>(), ShipType.values()[shipType-1]);
        boards.get(player).placeShip(shipPart, ship);
        return ship;
    }

    public int[] shoot(int player) {

        int GamePlayer = player + 1;
        System.out.println("\n\t>>>Player" + GamePlayer + " shoot<<< \n");

        System.out.print("Enter position of shoot: ");
        String position = scanner.nextLine().toUpperCase();
        String[] coordinates = position.split("", 2);
        int row = Integer.parseInt(coordinates[1]) - 1;
        int col = position.charAt(0) - 65;

        return new int[]{row, col};
    }
}
