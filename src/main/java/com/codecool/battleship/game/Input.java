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

        this.CoordinatesAndShipType = new ArrayList<>();
//        System.out.println("Select row: ");
//        int charRow = scanner.next().charAt(0) - 65;

        System.out.print("Enter position for ship: ");
        String position = scanner.nextLine().toUpperCase();
        String[] coordinates = position.split("", 2);
        int row = position.charAt(0) - 65;
        int col = Integer.parseInt(coordinates[1]) - 1;
        System.out.println(row);
        System.out.println(col);

//        scanner.nextLine();
//        System.out.println("Select column: ");
//        int col = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Select ship: \n" + "1. CARRIER \n" + "2. CRUISER \n" + "3. BATTLESHIP \n" + "4. DESTROYER \n"
                + "5. SUBMARINE \n");
        int shipType = scanner.nextInt();
        CoordinatesAndShipType.add(row);
        CoordinatesAndShipType.add(col);
        CoordinatesAndShipType.add(shipType);
        return CoordinatesAndShipType;
    }

    public Ship createShip(int player) {
        int GamePlayer = player + 1;
        Square shipPart;
        Ship ship;
        System.out.println("Player" + GamePlayer + " place ship");
        CoordinatesAndShipType = AskCoordForShipAndTypes();
        int row = CoordinatesAndShipType.get(0);
        int col = CoordinatesAndShipType.get(1);
        int shipType = CoordinatesAndShipType.get(2);
        shipPart = new Square(row, col, SquareStatus.SHIP);
        ship = new Ship(new ArrayList<>(), ShipType.values()[shipType-1]);
        boards.get(player).buildShip(shipPart,ship);
        return ship;
    }

    public int[] shoot(int player) {

        int GamePlayer = player + 1;
        System.out.println("Player" + GamePlayer + " shoot");

        System.out.print("Enter position of shoot: ");
        String position = scanner.nextLine().toUpperCase();
        String[] coordinates = position.split("", 2);
        int row = position.charAt(0) - 65;
        int col = Integer.parseInt(coordinates[1]) - 1;

        return new int[]{row, col};
    }
}
