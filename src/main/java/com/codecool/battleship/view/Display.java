package com.codecool.battleship.view;

public class Display {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    public static final String ANSI_BLACK_BACKGROUND = "\u001B[40m";
    public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
    public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
    public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
    public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m   ";
    public static final String ANSI_PURPLE_BACKGROUND = "\u001B[45m";
    public static final String ANSI_CYAN_BACKGROUND = "\u001B[46m";
    public static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";

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
        System.out.println("press: \n" +
                "\t 0 - Play \n" +
                "\t 1 - Exit game \n");
    }

    public void printExitMessage() {
        System.out.println("Have a nice day!");
    }

    public void printBoard(Board ocean) {
//        char[] row = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        StringBuilder boardBuilder = new StringBuilder("    ");
        for (int columns = 0; columns < ocean.getSizeX(); columns++) {
            boardBuilder.append(columns + 1).append("  ");
        }
        boardBuilder.append("\n");
        for (int columns = 0; columns < ocean.getSizeY(); columns++) {
            char[] row = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
            if (columns < 9) {
                boardBuilder.append(row[columns]).append("  ");
            } else {
                boardBuilder.append(row[columns]).append("  ");
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
                    default:

                }
            }

            boardBuilder.append(" ").append(row[columns]);
            boardBuilder.append("\n");
        }
        boardBuilder.append("\t");
        for (int columns = 0; columns < ocean.getSizeX(); columns++) {
            boardBuilder.append(columns + 1).append("  ");

        }
        System.out.println(boardBuilder);
    }

}
