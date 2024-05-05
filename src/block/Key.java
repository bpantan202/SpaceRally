package block;

import GUI.RenderableHolder;
import Sound.Sound;
import game.GameController;
import game.GameMap;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import player.Player;

public class Key extends Item{
    public Key(int posX, int posY) {
        super(posX, posY);
    }
    private Sound backgroundMusic;

    @Override
    public void landOnBlock(Player player, GameMap gameMap) {
        RenderableHolder.getInstance().removeThis(this);
        player.setKeyAmount(player.getKeyAmount() + 1);
        gameMap.spawnKey();
        backgroundMusic = new Sound("getItemsound.wav");
        backgroundMusic.jump();
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
