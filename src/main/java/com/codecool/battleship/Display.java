package com.codecool.battleship;

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

    public static final String ANSI_BLACK_BACKGROUND = "\u001B[40m;1m";
    public static final String ANSI_RED_BACKGROUND = "\u001B[41m;1m";
    public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m;1m";
    public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m;1m";
    public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m;1m";
    public static final String ANSI_PURPLE_BACKGROUND = "\u001B[45m;1m";
    public static final String ANSI_CYAN_BACKGROUND = "\u001B[46m;1m";
    public static final String ANSI_WHITE_BACKGROUND = "\u001B[47m;1m";

    public Display() {

    }

    public void displayMenu() {
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

    public void displayMessages(String message) {
        System.out.println(message);
    }

    public void displayMainMenuOptions() {
        System.out.println("press: \n" +
                "\t 0 - Play \n" +
                "\t 1 - Print game rules \n" +
                "\t 2 - Exit game \n");
    }

    public void displayExitMessage() {
        System.out.println("Have a nice day!");
    }

    public void gameRules() {
        System.out.println("blablablabl");
    }

    public void displayBoard(Board ocean) {
        char[] columns = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        StringBuilder boardBuilder = new StringBuilder("    ");
        for (int row = 0; row < ocean.getSizeX(); row++) {
            boardBuilder.append(columns[row]).append("  ");
        }
        boardBuilder.append("\n");
        for (int row = 0; row < ocean.getSizeY(); row++) {
            if (row < 9) {
                boardBuilder.append(row + 1).append("  ");
            } else {
                boardBuilder.append(row + 1).append(" ");
            }
            for (int column = 0; column < ocean.getSizeX(); column++) {
                switch (ocean.getSquare((char) row, column).getCharacter()) {
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
//            boardBuilder.append(" ").append(row + 1);
//            boardBuilder.append("\n");
        }
//        boardBuilder.append("\t");
//        for (int row = 0; row < ocean.getSize(); row++) {
//            boardBuilder.append(columns[row]).append("  ");

//        }
        System.out.println(boardBuilder);
    }

}
