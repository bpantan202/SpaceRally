package block;

import game.GameMap;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import player.Player;

public class SolidBlock extends Block{
    public SolidBlock(int posX, int posY) {
        super(posX, posY);
    }

    @Override
    public void landOnBlock(Player player, GameMap gameMap) {
        return;
    }

    @Override
    public boolean canWalk(Player player) {
        return false;
    }

    @Override
    public void draw(GraphicsContext gc) {
        return;
    }
}
