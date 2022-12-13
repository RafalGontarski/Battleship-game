package com.codecool.battleship;

import com.codecool.battleship.view.Game;

public class Battleship {
    public static void main(String[] args){
        Game game = new Game();
        game.startNewGame();
        game.displayHighscores();
        game.exitGame();
    }
}
