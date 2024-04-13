package block;

import game.GameMap;
import player.Player;
import special.RandomNum;

public class Landmark extends ConditionsBlock{

    private String name;

    private Integer point;

    public Landmark(String name, int point, int posX, int posY) {
        super(posX, posY);
        this.name = name;
        this.point = point;
    }

    @Override
    public void landOnBlock(Player player, GameMap gameMap) {
        if(!player.getPlanetVisit().contains(this)) {
            player.getPlanetVisit().add(this);
            player.setScore(player.getScore() + this.point);
        }
        if(player.getMission().contains(this)) {
            player.getMission().remove(this);
            int extraScore = RandomNum.randomNum(2,6);
            player.setScore(player.getScore() + extraScore);
            System.out.println("You got " + extraScore + " point from # Mission #");
        }
    }

    public char ShowStatus(){
        return '^';
    }

    @Override
    public boolean canWalk(Player player) {
        if(player.getWalkLeft() == 1){
            return true;
        }
        return false;
    }
}
