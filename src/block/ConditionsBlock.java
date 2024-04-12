package block;

import player.Player;

public abstract class ConditionsBlock extends Block{

    public ConditionsBlock(int posX, int posY) {
        super(posX, posY);
    }

    @Override
    public void landOnBlock(Player player) {
        return;
    }
}
