package com.codecool.battleship.game;

import com.codecool.battleship.view.Display;
import com.codecool.battleship.view.Input;

import java.util.InputMismatchException;

public class Battleship {
    private final Display display;
    private final Input input;
    private final Game game = new Game();

    public Battleship() {
        display = new Display();
        input = new Input();
    }

    public static void main(String[] args) {
        Battleship battleship = new Battleship();
        battleship.start();
    }

    public void start() {
        display.printMenu();
        mainMenu();
        mainMenu();
    }

    public void exitGame() {
        display.printExitMessage();
        System.exit(0);
    }

    public void mainMenu() {
        boolean input = false;

        while (!input) {
            display.printMainMenuOptions();
            System.out.println("                             Your choice: ");
            try {
                int choice = this.input.getIntegerMenuOption();
                    if (choice >= 1 && choice <= 2) {
                        input = true;
                        switch (choice) {
                            case 1 -> {
                                display.printMessages(
                                        """
                                                \t                                                            __\s
                                                \t   _____ _____ _____ _____ _____    _____ _____ _____ _____|  |
                                                \t  |   __|_   _|  _  | __  |_   _|  |   __|  _  |     |   __|  |
                                                \t  |__   | | | |     |    -| | |    |  |  |     | | | |   __|__|
                                                \t  |_____| |_| |__|__|__|__| |_|    |_____|__|__|_|_|_|_____|__|
                                                                                                            \s""");
                                game.gameLogic();
                            }
                            case 2 -> {
                                display.printMessages(
                                        """
                                                                            _____   _____ _\s
                                                                           | _ ) \\ / / __| |
                                                                           | _ \\\\ V /| _||_|
                                                                           |___/ |_| |___(_)
                                                """);
                                exitGame();
                            }
                        }
                    } else {
                        System.out.println("                    Number out of range! Try again !");
                    }
            } catch (InputMismatchException number) {
                System.out.println("                    Wrong input try again!");
            }
        }
    }
}

