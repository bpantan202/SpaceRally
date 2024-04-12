package block;

import player.Player;
import usage.ConsoleShow;

public class WalkAbleBlock extends Block{

    @Override
    public boolean canWalk(Player player) {
        return true;
    }

    public WalkAbleBlock(int posX, int posY) {
        super(posX, posY);
    }

    @Override
    public void landOnBlock(Player player) {
        return;
    }

    @Override
    public char ShowStatus() {
        return '-';
    }
}
