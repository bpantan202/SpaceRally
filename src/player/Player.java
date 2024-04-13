package player;

import block.ExtraDoor;
import block.Landmark;
import block.Mission;
import block.PlayerBlock;
import function.Pair;
import game.GameMap;

import java.util.ArrayList;

import static java.lang.Math.max;
import static java.lang.Math.min;

public class Player {

    private String playerName;
    private Integer score;
    private Integer keyAmount;
    private Integer walkLeft;
    private ArrayList<Landmark> planetVisit;
    private ArrayList<Landmark> mission;
    private ArrayList<ExtraDoor> extraDoor;
    private Pair<Integer,Integer> position;
    private Pair<Integer,Integer> posBefore;

    public Player(String name, int x, int y){
        this.playerName = name;
        this.score = 0;
        this.keyAmount = 0;
        this.planetVisit = new ArrayList<>();
        this.mission = new ArrayList<>();
        this.extraDoor = new ArrayList<>();
        this.position = new Pair<>(x,y);
        this.posBefore = new Pair<>(-1,-1);
    }

    public void printPlayerStatus() {
        System.out.println(playerName + " score:" + score + " key:" + keyAmount + " walkLeft:" + walkLeft);
        System.out.println("PlanetVisit: " + planetVisit);
        System.out.println("Mission: " + mission);
        System.out.println("extraDoor: " + extraDoor);
    }

    public void setPosition(Pair<Integer,Integer> pos, GameMap gameMap, boolean lastWalk) {
        if(lastWalk){
            this.posBefore = new Pair<>(-1,-1);
        } else {
            this.posBefore = this.position;
        }
        gameMap.clearBlock(position.getFirst(),position.getSecond());
        this.position = pos;
        gameMap.setOneBlock(new PlayerBlock(this),pos.getFirst(),pos.getSecond());
//        System.out.println("+++");
    }

    public Integer getKeyAmount() {
        return keyAmount;
    }

    public void setKeyAmount(int x) {
        this.keyAmount = min(max(0,x),5);
    }


    public Integer getPosX() {
        return position.getFirst();
    }

    public Integer getPosY() {
        return position.getSecond();
    }

    public Integer getPosXBefore() {
        return posBefore.getFirst();
    }

    public Integer getPosYBefore() {
        return posBefore.getSecond();
    }

    public Pair<Integer,Integer> getPosition() {
        return position;
    }

    public ArrayList<Landmark> getMission() {
        return mission;
    }

    public ArrayList<Landmark> getPlanetVisit() {
        return planetVisit;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = max(0,score);
    }

    public Integer getWalkLeft(){
        return walkLeft;
    }

    public void setWalkLeft(int x) {
        this.walkLeft = max(0,x);
    }

    public ArrayList<ExtraDoor> getExtraDoor() {
        return extraDoor;
    }

    public void setPosBefore(Pair<Integer, Integer> posBefore) {
        this.posBefore = posBefore;
    }
}
