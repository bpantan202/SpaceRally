package block;

import GUI.RenderableHolder;
import game.GameMap;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import player.Player;
import special.RandomNum;

public class Mission extends Item {
    public Mission(int posX, int posY) {
        super(posX, posY);
    }

    public void randomMission(Player player, GameMap gameMap) {
        if(player.getMission().size() >= 2  || (player.getMission().size() + player.getPlanetVisit().size()) >= gameMap.getLandmarkArrayList().size() ){
            return;
        }

        int num = RandomNum.randomNum(0, gameMap.getLandmarkArrayList().size() - 1);
        Landmark missionLandmark = gameMap.getLandmarkArrayList().get(num);

        while (player.getMission().contains(missionLandmark) || player.getPlanetVisit().contains(missionLandmark)){
            num = RandomNum.randomNum(0, gameMap.getLandmarkArrayList().size() - 1);
            missionLandmark = gameMap.getLandmarkArrayList().get(num);
        }

        player.getMission().add(missionLandmark);
    }
    @Override
    public void landOnBlock(Player player, GameMap gameMap) {
        RenderableHolder.getInstance().removeThis(this);
        gameMap.spawnMission();
        randomMission(player, gameMap);
    }

    @Override
    public int getZ() {
        return 19;
    }

    @Override
    public void draw(GraphicsContext gc) {
        gc.drawImage(new Image("Mission.png"),getDisplayPosX() ,getDisplayPosY(),80,80);
    }
}
