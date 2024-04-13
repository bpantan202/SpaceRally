package block;

import game.GameMap;
import player.Player;

public class SolidBlock extends Block{
    public SolidBlock(int posX, int posY) {
        super(posX, posY);
    }

    @Override
    public char ShowStatus() {
        return '#';
    }

    @Override
    public void landOnBlock(Player player, GameMap gameMap) {
        return;
    }

    @Override
    public boolean canWalk(Player player) {
        return false;
    }
}
