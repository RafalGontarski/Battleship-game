package com.codecool.battleship.game;

import com.codecool.battleship.view.Display;
import java.util.InputMismatchException;

public class Battleship {


    private Display display;
    private Game game = new Game();
    private Input input;

    public Battleship() {
        display = new Display();
    }

    public void start() {
        display.printMenu();
        mainMenu();
    }

    public void exitGame() {
        display.printExitMessage();
        System.exit(0);
    }

    public void mainMenu() {
        int choice;
        boolean exit = false;
        input = new Input();


        while (!exit) {
            display.printMainMenuOptions();
            System.out.println("                             Your choice: ");
            try {
                choice = input.getIntegerMenuOption();

                    if (choice >= 1 && choice <= 2) {
                        switch (choice) {
                            case 1 -> {
                                display.printMessages(
                                        "\t                                                            __ \n" +
                                        "\t   _____ _____ _____ _____ _____    _____ _____ _____ _____|  |\n" +
                                        "\t  |   __|_   _|  _  | __  |_   _|  |   __|  _  |     |   __|  |\n" +
                                        "\t  |__   | | | |     |    -| | |    |  |  |     | | | |   __|__|\n" +
                                        "\t  |_____| |_| |__|__|__|__| |_|    |_____|__|__|_|_|_|_____|__|\n" +
                                        "                                                             ");
                                game.gameLogic();
                            }
                            case 2 -> {
                                display.printMessages("\n" +
                                        "                            _____   _____ _ \n" +
                                        "                           | _ ) \\ / / __| |\n" +
                                        "                           | _ \\\\ V /| _||_|\n" +
                                        "                           |___/ |_| |___(_)\n" +
                                        "                  ");
                                exitGame();
                            }
                        }
                    } else {
                        System.out.println("                    Number out of range! Try again !");
                    }

            } catch (InputMismatchException number) {
                System.out.println("                    Wrong input try again!");
                display.printMainMenuOptions();
                break;
            }
        }
    }
}

