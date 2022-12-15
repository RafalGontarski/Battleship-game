package com.codecool.battleship.view;

public class Display {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED_BACKGROUND = "\u001B[41m  ";
    public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m  ";
    public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m  ";


    public Display() {

    }

    public void printMenu() {
        System.out.println("Battleship is starting...");
        System.out.println("\n" + "                                     # #  ( )\n" +
                "                                  ___#_#___|__\n" +
                "                              _  |____________|  _\n" +
                "                       _=====| | |            | | |==== _\n" +
                "                 =====| |.---------------------------. | |====\n" +
                "   <--------------------'   .  .  .  .  .  .  .  .   '--------------/\n" +
                "     \\                                                             /\n" +
                "      \\_______________________________________________WWS_________/\n" +
                "  wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww\n" +
                "wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww\n" +
                "   wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww \n"
        );
    }

    public void printMessages(String message) {
        System.out.println(message);
    }

    public void printMainMenuOptions() {
        System.out.println("press: \n\n" +
                "\t 1 - Play \n" +
                "\t 2 - Exit game \n");
    }

    public void printExitMessage() {
        System.out.println("Have a nice day!");
    }

    public void printBoard(Board ocean) {

        char[] charRow = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();

        StringBuilder boardBuilder = new StringBuilder("    ");

        for (int i = 0; i < ocean.getSizeX(); i++) {
            boardBuilder.append(charRow[i]).append("  ");
        }
        boardBuilder.append("\n");

        for (int row = 0; row < ocean.getSizeX(); row++) {
            if (row < 9) {
                boardBuilder.append(row + 1).append("  ");
            } else {
                boardBuilder.append(row + 1).append(" ");
            }
            for (int column = 0; column < ocean.getSizeY(); column++) {

                switch (ocean.getSquare(row, column).getCharacter()) {
                    case 'O':
                        boardBuilder.append(ANSI_BLUE_BACKGROUND).append(" ").append(ANSI_RESET);
                        break;
                    case 'H':
                        boardBuilder.append(ANSI_RED_BACKGROUND).append(" ").append(ANSI_RESET);
                        break;
                    case 'M':
                        boardBuilder.append(ANSI_YELLOW_BACKGROUND).append(" ").append(ANSI_RESET);
                        break;
                }
            }
            if (row == 0) {
                boardBuilder.append(" ").append(1).append("   ").append(ANSI_RED_BACKGROUND).append(" ").append(ANSI_RESET).append(" - HIT \n");
            }

            else if (row == 2) {
                boardBuilder.append(" ").append(2).append("   ").append(ANSI_YELLOW_BACKGROUND).append(" ").append(ANSI_RESET).append(" - MISS \n");
            }

            else {
                boardBuilder.append(" ").append(row + 1);
                boardBuilder.append("\n");
            }

        }
        boardBuilder.append("\t");
        for (int columns = 0; columns < ocean.getSizeX(); columns++) {
            boardBuilder.append(charRow[columns]).append("  ");

        }
        System.out.println(boardBuilder);
    }
}
