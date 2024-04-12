package block;

import player.Player;
import usage.ConsoleShow;

public class Mission extends Item {
    public Mission(int posX, int posY) {
        super(posX, posY);
    }

    @Override
    public void landOnBlock(Player player) {
        player.getMission().add(this);
    }

    @Override
    public char ShowStatus() {
        return 'M';
    }
}
