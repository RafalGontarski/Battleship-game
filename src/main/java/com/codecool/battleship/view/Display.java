package com.codecool.battleship.view;

public class Display {

    public static final String ANSI_RESET = "\u001B[0m";

    public static final String ANSI_RED_BACKGROUND = "\u001B[41m  ";
    public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m  ";
    public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m  ";
    public static final String ANSI_WHITE_BACKGROUND = "\u001B[47m  ";
    public static final String ANSI_CYAN_BACKGROUND = "\u001B[46m  ";

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
                "\t 0 - Play \n" +
                "\t 1 - Exit game \n");
    }

    public void printExitMessage() {
        System.out.println("Have a nice day!");
    }

    public void printBoard(Board ocean) {

        char[] row = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();

        StringBuilder boardBuilder = new StringBuilder("    ");

        for (int columns = 0; columns < ocean.getSizeX(); columns++) {
            boardBuilder.append(row[columns]).append("  ");
        }
        boardBuilder.append("\n");
        for (int columns = 0; columns < ocean.getSizeY(); columns++) {
            if (columns < 9) {
                boardBuilder.append(columns + 1).append("  ");
            } else {
                boardBuilder.append(columns + 1).append(" ");
            }
            for (int column = 0; column < ocean.getSizeX(); column++) {

                switch (ocean.getSquare(columns, column).getCharacter()) {
                    case 'O':
                        boardBuilder.append(ANSI_BLUE_BACKGROUND).append(" ").append(ANSI_RESET);
                        break;
                    case 'H':
                        boardBuilder.append(ANSI_RED_BACKGROUND).append(" ").append(ANSI_RESET);
                        break;
                    case 'S':
                        boardBuilder.append(ANSI_YELLOW_BACKGROUND).append(" ").append(ANSI_RESET);
                        break;
                    case 'M':
                        boardBuilder.append(ANSI_WHITE_BACKGROUND).append(" ").append(ANSI_RESET);
                        break;
                    case 'E':
                        boardBuilder.append(ANSI_CYAN_BACKGROUND).append(" ").append(ANSI_RESET);
                        break;
                }
            }

            boardBuilder.append(" ").append(columns + 1);
            boardBuilder.append("\n");
        }
        boardBuilder.append("\t");
        for (int columns = 0; columns < ocean.getSizeX(); columns++) {
            boardBuilder.append(row[columns]).append("  ");

        }
        System.out.println(boardBuilder);
    }

}
