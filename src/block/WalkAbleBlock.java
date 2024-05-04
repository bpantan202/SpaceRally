package block;

import GUI.Renderable;
import game.GameMap;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
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
    public void landOnBlock(Player player, GameMap gameMap) {
        return;
    }

    @Override
    public char ShowStatus() {
        return '-';
    }

//    @Override
//    public int getZ() {
//        return 0;
//    }
//    @Override
//    public void draw(GraphicsContext gc) {
//        gc.drawImage(new Image("block-plain.png"),getDisplayPosX() ,getDisplayPosY(),80,80);
//    }
}
