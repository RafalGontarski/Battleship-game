package com.codecool.battleship.game;

import com.codecool.battleship.view.Display;

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
            System.out.println("Enter a choice: ");
            System.out.println();
            choice = input.getIntegerMenuOption();
            switch (choice) {
                case 0:
                    display.printMessages("You've choosed to play the game.");
                    game.gameLogic();
                    break;
                case 1:
                    display.printMessages("You've choosed to exit");
                    exitGame();
                    break;
            }
        }
    }
}
