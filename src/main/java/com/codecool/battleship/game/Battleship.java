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
            System.out.println("Enter your choice: ");
            try {
                choice = input.getIntegerMenuOption();

                    if (choice >= 1 && choice <= 2) {



                        switch (choice) {
                            case 1 -> {
                                display.printMessages("You've choosed to play the game.");
                                game.gameLogic();
                            }
                            case 2 -> {
                                display.printMessages("You've choosed to exit");
                                exitGame();
                            }
                        }
                    } else {
                        System.out.println("Number out of range! Try again !");
                    }

            } catch (InputMismatchException number) {
                System.out.println("Wrong input try again!");
            }
        }
    }
}

