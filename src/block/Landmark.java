package block;

import Sound.Sound;
import game.GameMap;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import player.Player;
import special.RandomNum;

public class Landmark extends ConditionsBlock{

    private String name;
    private String picture;
    private Integer point;

    private Sound backgroundMusic;

    public Landmark(String name,String picture, int point, int posX, int posY) {
        super(posX, posY);
        this.name = name;
        this.point = point;
        this.picture = picture;
    }

    @Override
    public void landOnBlock(Player player, GameMap gameMap) {
        if(!player.getPlanetVisit().contains(this)) {
            player.getPlanetVisit().add(this);
            player.setScore(player.getScore() + this.point);
            backgroundMusic = new Sound("getLandmark.mp3");
            backgroundMusic.jump();
            if(player.getMission().contains(this)) {
                player.getMission().remove(this);
                int extraScore = RandomNum.randomNum(2,6);
                player.setScore(player.getScore() + extraScore);
                System.out.println("You got " + extraScore + " point from # Mission #");
            }
        }

    }

    public String getName(){
        return this.name;
    }

    @Override
    public boolean canWalk(Player player) {
        if(player.getWalkLeft() == 1){
            return true;
        }
        return false;
    }

    @Override
    public void draw(GraphicsContext gc) {
        gc.drawImage(new Image(this.picture),getDisplayPosX() ,getDisplayPosY(),80,80);
    }
}
