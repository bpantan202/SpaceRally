package game;

import GUI.RenderableHolder;
import GUI.*;
import Sound.Sound;
import block.*;
import display.Arrow;
import function.Pair;
import javafx.scene.canvas.GraphicsContext;
import player.Player;
import special.RandomDice;
import special.RandomNum;

import java.util.*;

public class GameController {
    private static GameController instance;
    private GameMap gameMap;
    private ArrayList<Player> players;
    private Integer turnLeft;
    private Integer playerNow;
    private Integer amountPlayer;
    private ArrayList<Arrow> arrowDisplay;

    private Sound backgroundMusic;


    public GameController(){
        this.gameMap = new GameMap();
        this.players = new ArrayList<>();
        this.arrowDisplay = new ArrayList<>();
        this.turnLeft = 10;
        this.playerNow = 0;

        setUpGame();
    }

    public void setUpGame() {
        this.amountPlayer = 4; ////

        newPlayer("Gray");
        newPlayer("Green");
        newPlayer("Red");
        newPlayer("Yellow");

        playTurn();
    }

    public void playTurn() {
        DicePane.getInstance().setOnDiceRolledCallback(() -> {
            Player player = players.get(playerNow);
            player.printPlayerStatus();

            int roleDice = DicePane.getInstance().getDiceResult();
            System.out.println("roleDice: " + roleDice);
            player.setWalkLeft(roleDice);
            PaintPane.getInstance().drawAll(RenderableHolder.getInstance().getObjects());
        });
        DicePane.getInstance().rollDice();
    }

    public void playTurnEach(int walk) {
        Player player = players.get(playerNow);
        System.out.println(player.getWalkLeft());
        if(player.getWalkLeft() > 0){
            Pair<Integer, Integer> walkTo = generateNextBlock(player,walk);
            if (walkTo.getFirst() == -1) {
                player.setWalkLeft(0);
                player.setPosBefore(new Pair<>(-99,-99));
                System.out.println("No walk way !!!");
                return;
            }
            System.out.println("walkTo: " + walkTo);
            Block blockBefore = gameMap.getGameMap()[walkTo.getSecond()][walkTo.getFirst()];
            System.out.println(blockBefore);
            blockBefore.landOnBlock(player, gameMap);
            if (player.getWalkLeft() == 1) {
                player.setPosition(walkTo, gameMap, true);
            } else {
                player.setPosition(walkTo, gameMap, false);
            }
            System.out.println(walkTo);
            player.setWalkLeft(player.getWalkLeft() - 1);
            player.printPlayerStatus();

            if(player.getWalkLeft() <= 0){
                nextPlayer();
            }
        }
    }



    public Pair<Integer,Integer> generateNextBlock(Player player, int walk){
        int posX = player.getPosX();
        int posY = player.getPosY();

        System.out.println("walk:" + walk);
        if(walk == 1) {return new Pair<>(posX-1,posY);}
        else if(walk == 2) {return new Pair<>(posX+1,posY);}
        else if(walk == 3) {return new Pair<>(posX,posY-1);}
        else if(walk == 4) {return new Pair<>(posX,posY+1);}
        return new Pair<>(posX,posY);
    }

    public ArrayList<Boolean> askValid() {
        Player player = players.get(playerNow);
        boolean left = false;
        boolean right = false;
        boolean up = false;
        boolean down = false;
        int posX = player.getPosX();
        int posY = player.getPosY();
        int posXBefore = player.getPosXBefore();
        int posYBefore = player.getPosYBefore();

        removeArrow();

        if(posX-1 >= 0 && posXBefore != posX-1){
            if(gameMap.checkCanWalk(posX-1,posY,player)) {
                genArrow( new Arrow("arrow/left.png",posX-1,posY) );
                left = true;
            }
        }
        if(posX+1 < gameMap.getX_SIZE() && posXBefore != posX+1){
            if(gameMap.checkCanWalk(posX+1,posY,player)) {
                genArrow( new Arrow("arrow/right.png",posX+1,posY) );
                right = true;
            }
        }
        if(posY-1 >= 0 && posYBefore != posY-1){
            if(gameMap.checkCanWalk(posX,posY-1,player)) {
                genArrow( new Arrow("arrow/up.png",posX,posY-1) );
                up = true;
            }
        }
        if(posY+1 < gameMap.getY_SIZE() && posYBefore != posY+1){
            if(gameMap.checkCanWalk(posX,posY+1,player)) {
                genArrow( new Arrow("arrow/down.png",posX,posY+1) );
                down = true;
            }
        }
        ArrayList<Boolean> res = new ArrayList<>(Arrays.asList(left, right, up, down));
        return res;
    }

    public void genArrow(Arrow arrow) {
        RenderableHolder.getInstance().add(arrow);
        arrowDisplay.add(arrow);
    }

    public void removeArrow() {
        for(Arrow x : arrowDisplay) {
            RenderableHolder.getInstance().removeThis(x);
        }
        arrowDisplay = new ArrayList<>();
    }


    public void newPlayer(String name) {
        Pair<Integer,Integer> position = RandomNum.randomPosition(gameMap.getX_SIZE(),gameMap.getY_SIZE(), gameMap);

        Player player = new Player(name, position.getFirst(), position.getSecond());
        Block[][] dataGM = gameMap.getGameMap();
        dataGM[player.getPosY()][player.getPosX()] = new PlayerBlock(player);
        players.add(player);
        System.out.println(name + " spawn at " + position);
    }


    public static GameController getInstance() {
        if(instance == null)
            instance = new GameController();
        return instance;
    }


    public void nextPlayer(){
        players.get(playerNow).setPosBefore(new Pair<>(-99,-99));
        if(playerNow >= amountPlayer-1){
            nextTurn();
            this.playerNow = 0;
            playTurn();
        }
        else {
            this.playerNow = this.playerNow + 1;
            backgroundMusic = new Sound("changePlayer.mp3");
            backgroundMusic.jump();
            playTurn();
        }
    }

    public void nextTurn() {
        if(this.turnLeft == 0){
            System.out.println("end");
        }
        else {
            this.turnLeft = this.turnLeft - 1;
        }
    }

    public String getPlayerDisplay() {
        Player player =players.get(playerNow);
        return player.getPlayerName() + " : " + player.getWalkLeft();
    }

    public GameMap getGameMap() {
        return gameMap;
    }

    public Integer getTurnLeft() {
        return turnLeft;
    }

    public Integer getPlayerNow() {
        return playerNow;
    }

    public ArrayList<Player> getPlayers(){
        return this.players;
    }
}