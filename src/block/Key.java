package block;

import game.GameController;
import game.GameMap;
import player.Player;

public class Key extends Item{
    public Key(int posX, int posY) {
        super(posX, posY);
    }

    @Override
    public void landOnBlock(Player player, GameMap gameMap) {
        player.setKeyAmount(player.getKeyAmount() + 1);
        gameMap.spawnKey();
    }


    @Override
    public char ShowStatus() {
        return 'K';
    }
}
