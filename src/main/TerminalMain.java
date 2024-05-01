package main;

import game.GameController;

public class TerminalMain {
    public static void main(String[] args) {
        GameController gameInstance = GameController.getInstance();
        gameInstance.getGameMap().printHoldMap();
    }
}