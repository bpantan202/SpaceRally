package game;

import block.*;
import player.Player;

public class GameMap {

    private final int X_SIZE = 10;
    private final int Y_SIZE = 7;
    private Block[][] gameMap;

    public GameMap(){
        this.gameMap = new Block[Y_SIZE][X_SIZE];

        for(int i=0; i<Y_SIZE; i++){
            for(int j=0; j<X_SIZE; j++){
                gameMap[i][j] = new WalkAbleBlock(i,j);
            }
        }
    }

    public void setOneBlock(Block block, int x, int y){
        gameMap[y][x] = block;
//        printHoldMap();
    }

    public void clearBlock(int x, int y) {
        gameMap[y][x] = new WalkAbleBlock(x,y);
//        printHoldMap();
    }

    public void printHoldMap(){
        for(int i=0; i<Y_SIZE; i++){
            String gen = "";
            for(int j=0; j<X_SIZE; j++){
                gen += (gameMap[i][j]).ShowStatus() + " ";
            }
            System.out.println(gen);
        }
        System.out.println("===========================");
    }

    public boolean checkCanWalk(int x, int y, Player player) {
        return gameMap[y][x].canWalk(player);
    }

    public Block[][] getGameMap() {
        return gameMap;
    }

    public int getX_SIZE() {
        return X_SIZE;
    }

    public int getY_SIZE() {
        return Y_SIZE;
    }

}
