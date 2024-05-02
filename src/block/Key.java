package block;

import GUI.RenderableHolder;
import game.GameController;
import game.GameMap;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import player.Player;

public class Key extends Item{
    public Key(int posX, int posY) {
        super(posX, posY);
    }

    @Override
    public void landOnBlock(Player player, GameMap gameMap) {
        RenderableHolder.getInstance().removeThis(this);
        player.setKeyAmount(player.getKeyAmount() + 1);
        gameMap.spawnKey();
    }


    @Override
    public char ShowStatus() {
        return 'K';
    }

    @Override
    public int getZ() {
        return 20;
    }
    @Override
    public void draw(GraphicsContext gc) {
        gc.drawImage(new Image("Key.png"),getDisplayPosX() ,getDisplayPosY(),80,80);
    }
}
