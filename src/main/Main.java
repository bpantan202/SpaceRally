package main;

import game.GameController;

public class Main {

    public static void main(String[] args) {
        GameController gameInstance = GameController.getInstance();
        gameInstance.getGameMap().printHoldMap();
    }

}
