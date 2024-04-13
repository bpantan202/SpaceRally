package block;

import function.Pair;
import game.GameMap;
import player.Player;
import usage.ConsoleShow;

public abstract class Block implements ConsoleShow {

    private Pair<Integer,Integer> position;

    public abstract boolean canWalk(Player player);
    public abstract void landOnBlock(Player player, GameMap gameMap);

    public Block(int posX, int posY){
        position = new Pair<>(posX,posY);
    }

    public void setPosition(int posX, int posY) {
        position = new Pair<>(posX,posY);
    }

    public Pair<Integer,Integer> getPosition(){
        return position;
    }

    public char ShowStatus(){
        return '_';
    }

}
