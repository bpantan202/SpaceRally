package block;

import player.Player;

public class Key extends Item{
    public Key(int posX, int posY) {
        super(posX, posY);
    }

    @Override
    public void landOnBlock(Player player) {
        player.setKeyAmount(player.getKeyAmount() + 1);
    }

    @Override
    public char ShowStatus() {
        return 'K';
    }
}
