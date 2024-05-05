package block;

import game.GameMap;
import player.Player;

public class WalkAbleBlock extends Block{
    public WalkAbleBlock(int posX, int posY) {
        super(posX, posY);
    }

    @Override
    public boolean canWalk(Player player) {
        return true;
    }

    @Override
    public void landOnBlock(Player player, GameMap gameMap) {
        return;
    }
}
