package com.codecool.battleship.view;

import com.codecool.battleship.board.Board;

public class Display {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED_BACKGROUND = "\u001B[41m  ";
    public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m  ";
    public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m  ";


    public Display() {

    }

    public void printMenu() {
        System.out.println("\n\n                        Battleship is starting...");
        System.out.println("""

                                                     # #  ( )
                                                  ___#_#___|__
                                              _  |____________|  _
                                       _=====| | |            | | |==== _
                                 =====| |.---------------------------. | |====
                   <--------------------'   .  .  .  .  .  .  .  .   '--------------/
                     \\                                                             /
                      \\_______________________________________________WWS_________/\s
                """
        );
    }

    public void printMessages(String message) {
        System.out.println(message);
    }

    public void printMainMenuOptions() {
        System.out.println(
                """
                        \t\t\t  __  __   _   ___ _  _   __  __ ___ _  _ _   _\s
                        \t\t\t |  \\/  | /_\\ |_ _| \\| | |  \\/  | __| \\| | | | |
                        \t\t\t | |\\/| |/ _ \\ | || .` | | |\\/| | _|| .` | |_| |
                        \t\t\t |_|  |_/_/ \\_\\___|_|\\_| |_|  |_|___|_|\\_|\\___/\s
                                                                       \s
                        \t                         1 - Play\s
                        \t                         2 - Exit game\s
                        """);
    }

    public void printExitMessage() {
        System.out.println(" ");
    }

    public void printBoard(Board ocean) {

        char[] charRow = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();

        StringBuilder boardBuilder = new StringBuilder("                      ");

        for (int i = 0; i < ocean.getSizeX(); i++) {
            boardBuilder.append(charRow[i]).append("  ");
        }
        boardBuilder.append("\n");

        for (int row = 0; row < ocean.getSizeX(); row++) {
            if (row < 9) {
                boardBuilder.append("                   ").append(row + 1).append(" ");
            } else {
                boardBuilder.append("                  ").append(row + 1).append(" ");
            }
            for (int column = 0; column < ocean.getSizeY(); column++) {
                switch (ocean.getSquare(row, column).getCharacter()) {
                    case 'O' -> boardBuilder.append(ANSI_BLUE_BACKGROUND).append(" ").append(ANSI_RESET);
                    case 'H' -> boardBuilder.append(ANSI_RED_BACKGROUND).append(" ").append(ANSI_RESET);
                    case 'M' -> boardBuilder.append(ANSI_YELLOW_BACKGROUND).append(" ").append(ANSI_RESET);
                }
            }
            if (row == 0) {
                boardBuilder.append(" ").append(1).append("   ").append(ANSI_BLUE_BACKGROUND).append(" ")
                        .append(ANSI_RESET)
                        .append(" - OCEAN \n");
            }
            else if (row == 2) {
                boardBuilder.append(" ").append(3).append("   ").append(ANSI_YELLOW_BACKGROUND).append(" ")
                        .append(ANSI_RESET)
                        .append(" - MISS \n");
            }
            else if (row == 4) {
                boardBuilder.append(" ").append(5).append("   ").append(ANSI_RED_BACKGROUND).append(" ")
                        .append(ANSI_RESET)
                        .append(" - HIT \n");
            } else {
                boardBuilder.append(" ").append(row + 1);
                boardBuilder.append("\n");
            }
        }
        boardBuilder.append("\t                  ");
        for (int columns = 0; columns < ocean.getSizeX(); columns++) {
            boardBuilder.append(charRow[columns]).append("  ");
        }
        System.out.println(boardBuilder);
    }
}
