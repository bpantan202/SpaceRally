package block;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import player.Player;

public class PlayerBlock extends ConditionsBlock{

    private Player player;

    public PlayerBlock(Player player) {
        super(player.getPosX(), player.getPosY());
        this.player = player;
    }

    @Override
    public boolean canWalk(Player player) {
        return false;
    }

    @Override
    public int getZ() {
        return 100;
    }
    @Override
    public void draw(GraphicsContext gc) {
        gc.drawImage(new Image("players/" + player.getPlayerName() + ".png"),getDisplayPosX() ,getDisplayPosY(),80,80);
    }
}
