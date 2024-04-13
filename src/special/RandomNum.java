package special;

import function.Pair;
import game.GameMap;

import java.util.Random;

public class RandomNum {

    public static int randomNum(int min, int max) {
        Random rand = new Random();
        return (rand.nextInt(max-min+1) + min);
    }

    public static Pair<Integer,Integer> randomPosition(int x, int y, GameMap gameMap) {
        Pair<Integer, Integer> position = new Pair<>(randomNum(0,x-1), randomNum(0,y-1));
        while (!gameMap.checkAvailable(position)) {
            position = new Pair<>(randomNum(0,x-1), randomNum(0,y-1));
        }

        return position;
    }
}
