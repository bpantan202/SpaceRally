package block;

import player.Player;

public class PlayerBlock extends ConditionsBlock{

    private Player player;

    public PlayerBlock(Player player) {
        super(player.getPosX(), player.getPosY());
        this.player = player;
    }
    @Override
    public char ShowStatus(){
        return '@';
    }

    @Override
    public boolean canWalk(Player player) {
        return false;
    }
}
