package block;

import game.GameMap;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import player.Player;

import java.util.Scanner;
import java.util.Set;

public class ExtraDoor extends ConditionsBlock{

    private Integer keyAmount;

    public ExtraDoor(int keyAmount, int posX, int posY) {
        super(posX, posY);
        this.keyAmount = keyAmount;
    }


    @Override
    public boolean canWalk(Player player) {
        if(player.getExtraDoor().contains(this)){
            return true;
        }
        else if(player.getKeyAmount() >= keyAmount){
            return true;
        }
        return false;
    }

    @Override
    public void landOnBlock(Player player, GameMap gameMap) {
        if(!player.getExtraDoor().contains(this)){
            player.setKeyAmount(player.getKeyAmount() - keyAmount);
            player.getExtraDoor().add(this);
        }
    }

    @Override
    public void draw(GraphicsContext gc) {
        gc.drawImage(new Image("ExtraDoor.png"),getDisplayPosX() ,getDisplayPosY(),80,80);
    }

}
