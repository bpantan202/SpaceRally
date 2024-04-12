package block;

import player.Player;

public class Landmark extends ConditionsBlock{

    private String name;

    private Integer point;

    public Landmark(String name, int point, int posX, int posY) {
        super(posX, posY);
        this.name = name;
        this.point = point;
    }

    @Override
    public void landOnBlock(Player player) {
        if(!player.getPlanetVisit().contains(this)) {
            player.getPlanetVisit().add(this);
            player.setScore(player.getScore() + this.point);
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
