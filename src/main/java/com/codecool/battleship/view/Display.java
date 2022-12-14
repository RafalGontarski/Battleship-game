package com.codecool.battleship.view;

public class Display {

    public static final String ANSI_RESET = "\u001B[0m";

    public static final String ANSI_RED_BACKGROUND = "\u001B[41m  ";
    public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m  ";
    public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m  ";
    public static final String ANSI_BLACK_BACKGROUND = "\u001B[47m  ";
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
                        boardBuilder.append(" x").append(" ").append(ANSI_RESET);
                        break;
                    case 'S':
                        boardBuilder.append(ANSI_YELLOW_BACKGROUND).append(" ").append(ANSI_RESET);
                        break;
                    case 'E':
                        boardBuilder.append(ANSI_CYAN_BACKGROUND).append(" ").append(ANSI_RESET);
                        break;
                    case 'M':
                        boardBuilder.append(ANSI_BLACK_BACKGROUND).append(" ").append(ANSI_RESET);
                        break;
                }
            }

            boardBuilder.append(" ").append(row + 1);
            boardBuilder.append("\n");
        }
        boardBuilder.append("\t");
        for (int columns = 0; columns < ocean.getSizeX(); columns++) {
            boardBuilder.append(charRow[columns]).append("  ");

        }
        System.out.println(boardBuilder);

//        System.out.print("    ");
//
//        int row;
//        for(row = 0; row < ocean.getSizeX(); ++row) {
//            System.out.print("" + row + "  ");
//        }
//
//        System.out.println();
//
//        for(row = 0; row < ocean.getSizeX(); ++row) {
//            if (row < 10) {
//                System.out.print("" + row + "   ");
//            } else {
//                System.out.print(row);
//            }
//
//            for(int col = 0; col < ocean.getSizeY(); ++col) {
//                switch (ocean.getSquare(row, col).getCharacter()) {
//                    case 'E':
//                        System.out.print(ANSI_CYAN_BACKGROUND + " " + ANSI_RESET);
//                    case 'F':
//                    case 'G':
//                    case 'I':
//                    case 'J':
//                    case 'K':
//                    case 'L':
//                    case 'N':
//                    case 'P':
//                    case 'Q':
//                    case 'R':
//                    default:
//                        break;
//                    case 'H':
//                        System.out.print(ANSI_RED_BACKGROUND + " " + ANSI_RESET);
//                        break;
//                    case 'M':
//                        System.out.print(ANSI_BLACK_BACKGROUND + " " + ANSI_RESET);
//                        break;
//                    case 'O':
//                        System.out.print(ANSI_BLUE_BACKGROUND + " " + ANSI_RESET);
//                        break;
//                    case 'S':
//                        System.out.print(ANSI_YELLOW_BACKGROUND + " " + ANSI_RESET);
//                }
//            }
//
//            System.out.println();
//        }
    }
}
