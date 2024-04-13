package block;

import game.GameMap;
import player.Player;
import special.RandomNum;
import usage.ConsoleShow;

public class Mission extends Item {
    public Mission(int posX, int posY) {
        super(posX, posY);
    }

    @Override
    public void landOnBlock(Player player, GameMap gameMap) {
        gameMap.spawnMission();
        randomMission(player, gameMap);
    }

    public void randomMission(Player player, GameMap gameMap) {
        if(player.getMission().size() > 2 || player.getMission().size() >= gameMap.getLandmarkArrayList().size()){
            return;
        }

        int num = RandomNum.randomNum(0, gameMap.getLandmarkArrayList().size() - 1);
        Landmark missionLandmark = gameMap.getLandmarkArrayList().get(num);
        while (!gameMap.getLandmarkArrayList().contains(missionLandmark)){
            num = RandomNum.randomNum(0, gameMap.getLandmarkArrayList().size() - 1);
            missionLandmark = gameMap.getLandmarkArrayList().get(num);
        }
        player.getMission().add(missionLandmark);
    }

    @Override
    public char ShowStatus() {
        return 'M';
    }
}
