package block;

import GUI.Renderable;
import GUI.RenderableHolder;
import function.Pair;
import game.GameMap;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import player.Player;
import usage.ConsoleShow;

public abstract class Block implements ConsoleShow, Renderable {

    private Pair<Integer,Integer> position;

    public abstract boolean canWalk(Player player);
    public abstract void landOnBlock(Player player, GameMap gameMap);

    public Block(int posX, int posY){
        position = new Pair<>(posX,posY);

        RenderableHolder.getInstance().add(this);

    }

    public void setPosition(int posX, int posY) {
        position = new Pair<>(posX,posY);
    }

    public Pair<Integer,Integer> getPosition(){
        return position;
    }

    public char ShowStatus(){
        return '_';
    }

    public int getDisplayPosX() {
        return position.getFirst() * 100;
    }

    public int getDisplayPosY() {
        return position.getSecond() * 100;
    }

    @Override
    public int getZ() {
        return 0;
    }
    @Override
    public void draw(GraphicsContext gc) {
//        gc.drawImage(new Image("Block.png"),getDisplayPosX() ,getDisplayPosY(),80,80);
//        gc.fillText(getPosition().getFirst() +","+ getPosition().getSecond(),getDisplayPosX(),getDisplayPosY());
    }

}
