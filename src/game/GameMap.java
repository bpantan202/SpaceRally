package game;

import GUI.Img;
import GUI.RenderableHolder;
import block.*;
import function.Pair;
import player.Player;
import special.RandomNum;

import java.util.ArrayList;

public class GameMap {

    private final int X_SIZE = 10;
    private final int Y_SIZE = 7;
    private Block[][] gameMap;
    private Block[][] defaultMap;
    private ArrayList<Landmark> landmarkArrayList;

    public GameMap(){
        resetHoldMap();
    }

    public void resetHoldMap() {
        this.gameMap = new Block[Y_SIZE][X_SIZE];
        this.defaultMap = new Block[Y_SIZE][X_SIZE];
        this.landmarkArrayList = new ArrayList<>();

        for(int i=0; i<Y_SIZE; i++){
            for(int j=0; j<X_SIZE; j++){
                gameMap[i][j] = new WalkAbleBlock(j,i);
//                RenderableHolder.getInstance().add(gameMap[i][j]);
            }
        }

        this.setToMapA();
//        RenderableHolder.getInstance().setObjects(new ArrayList<>());

        RenderableHolder.getInstance().add(new Img());
    }

    public void setOneBlock(Block block, int x, int y){
        gameMap[y][x] = block;
//        printHoldMap();
    }

    public void clearBlock(int x, int y) {
        if(defaultMap[y][x] != null){
            gameMap[y][x] = defaultMap[y][x];
        }
        else {
            gameMap[y][x] = new WalkAbleBlock(x,y);
        }
    }

    public void printHoldMap(){
//        for(int i=0; i<Y_SIZE; i++){
//            String gen = "";
//            for(int j=0; j<X_SIZE; j++){
//                gen += (gameMap[i][j]).ShowStatus() + " ";
//            }
//            System.out.println(gen);
//        }
//        System.out.println("===========================");
    }

    public boolean checkCanWalk(int x, int y, Player player) {
        return gameMap[y][x].canWalk(player);
    }

    public boolean checkAvailable(Pair<Integer,Integer> position) {
        Block block = gameMap[position.getSecond()][position.getFirst()];
        if(block instanceof Item || block instanceof Landmark){return false;}
        return block instanceof WalkAbleBlock;
    }

    public void spawnKey() {
        Pair<Integer,Integer> position = RandomNum.randomPosition(X_SIZE,Y_SIZE,this);
        gameMap[position.getSecond()][position.getFirst()] = new Key(position.getFirst(), position.getSecond());
    }

    public void spawnMission() {
        Pair<Integer,Integer> position = RandomNum.randomPosition(X_SIZE,Y_SIZE,this);
        gameMap[position.getSecond()][position.getFirst()] = new Mission(position.getFirst(), position.getSecond());
    }

    public Block[][] getGameMap() {
        return gameMap;
    }

    public Block[][] getDefaultMap() {
        return defaultMap;
    }

    public int getX_SIZE() {
        return X_SIZE;
    }

    public int getY_SIZE() {
        return Y_SIZE;
    }

    public ArrayList<Landmark> getLandmarkArrayList() {
        return landmarkArrayList;
    }

    public void addLandmark(String name, int point, int posX, int posY) {
        Landmark landmark = new Landmark(name,"landmark/"+name+".png",point,posX,posY);
        defaultMap[posY][posX] = landmark;
        landmarkArrayList.add(landmark);
    }

    public void setToMapA() {
//        resetHoldMap();
//        defaultMap[1][0] = new Key(0,1);
//        defaultMap[2][1] = new Mission(1,2);
        addLandmark("Earth",5,7,3);
        addLandmark("Mercury",4,4,0);
        addLandmark("Moon",3,9,6);
        addLandmark("Redmoon",6,0,5);
        addLandmark("Sun",10,0,3);
        defaultMap[3][1] = new ExtraDoor(6,1,3);
        defaultMap[1][6] = new SolidBlock(6,1);
        defaultMap[1][7] = new SolidBlock(7,1);
        defaultMap[1][8] = new SolidBlock(8,1);

//        defaultMap[2][0] = new SolidBlock(0,2);
//        defaultMap[3][0] = new SolidBlock(0,3);
//        defaultMap[4][0] = new SolidBlock(0,4);
        defaultMap[2][0] = new SolidBlock(0,2);
        defaultMap[4][0] = new SolidBlock(0,4);
        defaultMap[2][1] = new SolidBlock(1,2);
        defaultMap[4][1] = new SolidBlock(1,4);

        defaultMap[4][5] = new SolidBlock(5,4);
        defaultMap[4][4] = new SolidBlock(4,4);
        defaultMap[5][5] = new SolidBlock(5,5);

        for(int i=0; i<Y_SIZE; i++){
            for(int j=0; j< X_SIZE; j++){
                if(defaultMap[i][j] != null){
                    gameMap[i][j] = defaultMap[i][j];
                }
            }
        }
        addShow();

        spawnKey();
        spawnKey();

        spawnMission();




    }

    public void addShow() {
        for(int i=0; i<Y_SIZE; i++){
            for(int j=0; j<X_SIZE; j++){
                RenderableHolder.getInstance().add(gameMap[i][j]);
            }
        }
    }
}
