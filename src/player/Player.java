package player;

import block.*;
import function.Load;
import function.Pair;
import game.GameController;
import game.GameMap;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;


import java.util.ArrayList;
import java.util.Objects;

import static java.lang.Math.max;
import static java.lang.Math.min;

public class Player {

    private Image playerImg;
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
            this.posBefore = new Pair<>(-99,-99);
        } else {
            this.posBefore = this.position;
        }


        Block[][] gameMap1 = GameController.getInstance().getGameMap().getGameMap();
        Block playerBlock = gameMap1[position.getSecond()][position.getFirst()];
        gameMap.setOneBlock(playerBlock,pos.getFirst(),pos.getSecond());
        playerBlock.setPosition(pos.getFirst(),pos.getSecond());
        gameMap.clearBlock(position.getFirst(),position.getSecond());
        this.position = pos;
//        System.out.println("+++");
    }


    //this one is the corner player pic
    public void drawPlayer(GraphicsContext gc, String color, int posX, int posY) {
        if (Objects.equals(color, "Yellow")) {
            playerImg = Load.yellowPlayer;
        } else if (Objects.equals(color, "Red")) {
            playerImg = Load.redPlayer;
        } else if (Objects.equals(color, "Green")) {
            playerImg = Load.greenPlayer;
        } else {
            playerImg = Load.grayPlayer;
        }
//        int diameter = 150;
//        gc.setFill(Color.WHITE);
//        gc.fillOval(posX,posY,diameter,diameter);
        int diameter = 150;
        Color transparentColor = Color.rgb(0, 0, 0, 0);

        gc.setFill(transparentColor);
        gc.fillOval(posX,posY,diameter,diameter);

        double imageWidth = 100; // Adjust the width of the player image
        double imageHeight = 100; // Adjust the height of the player image
        gc.drawImage(playerImg, posX + (diameter - imageWidth) / 2, posY + (diameter - imageHeight) / 2, imageWidth, imageHeight);


//        gc.setFill(Color.WHITE);
//        gc.setFont(new Font(20));
//        gc.fillText("Score : "+ getScore(),posX+35,posY+175 );
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

    public int getScore() {
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

    public String getPlayerName() {
        return playerName;
    }

}
