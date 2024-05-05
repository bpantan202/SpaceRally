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

    private void setUpGame() {

//        Block[][] defaultMap = gameMap.getDefaultMap();
//        defaultMap[1][0] = new Key(0,1);
//        defaultMap[2][1] = new Mission(1,2);
//        defaultMap[3][7] = new Landmark("Earth",3,7,3);
//        defaultMap[3][2] = new ExtraDoor(2,2,3);
//        defaultMap[1][6] = new SolidBlock(6,1);
//
//        Block[][] dataGM = gameMap.getGameMap();
//        for(int i=0; i<gameMap.getY_SIZE(); i++){
//            for(int j=0; j< gameMap.getX_SIZE(); j++){
//                if(defaultMap[i][j] != null){
//                    dataGM[i][j] = defaultMap[i][j];
//                }
//            }
//        }
//        gameMap.setToMapA();
//
//        System.out.println("Select amount player (2-4) : ");
//        Set<Integer> am = new HashSet<>();
//        am.add(2);
//        am.add(3);
//        am.add(4);
//        int amPlayer = inputCheck(am);
//        this.amountPlayer = amPlayer;
        this.amountPlayer = 4; ////


        newPlayer("Gray");
        newPlayer("Green");
        newPlayer("Red");
        newPlayer("Yellow");


//        if(amountPlayer >= 3){
//            newPlayer("Red");
//        }
//        if(amountPlayer >= 4){
//            newPlayer("Yellow");
//        }

        gameMap.printHoldMap();

        playTurn();


//        for (int round = 1; round<=10; round++){
//            System.out.println("* * * * *  round " + round + "  * * * * *");
//            for (Player player : players) {
////                playTurn(player);
//            }
//        }


    }

    public void playTurn() {
        Player player = players.get(playerNow);
        gameMap.printHoldMap();
        player.printPlayerStatus();
        int roleDice = RandomDice.roleDice();
        System.out.println("roleDice: " + roleDice);
        player.setWalkLeft(roleDice);
//        while (player.getWalkLeft() > 0){
//            Pair<Integer, Integer> walkTo = choseWalkBlock(player);
//            if(walkTo.getFirst() == -1){
//                player.setWalkLeft(0);
//                player.setPosBefore(new Pair<>(-1,-1));
//                System.out.println("No walk way !!!");
//                return;
//            }
//            System.out.println("walkTo: " + walkTo);
//            Block blockBefore = gameMap.getGameMap()[walkTo.getSecond()][walkTo.getFirst()];
//            System.out.println(blockBefore);
//            blockBefore.landOnBlock(player,gameMap);
//            if(player.getWalkLeft() == 1){
//                player.setPosition(walkTo, gameMap, true);
//            } else {
//                player.setPosition(walkTo, gameMap, false);
//            }
//            System.out.println(walkTo);
//            player.setWalkLeft(player.getWalkLeft() - 1);
//            gameMap.printHoldMap();
//            player.printPlayerStatus();
//
//            nextTurn();
//        }
    }

//    public void playTurnEach() {
//        Player player = players.get(playerNow);
//        System.out.println(player.getWalkLeft());
//        if(player.getWalkLeft() > 0){
//            Pair<Integer, Integer> walkTo = choseWalkBlock(player);
//            if (walkTo.getFirst() == -1) {
//                player.setWalkLeft(0);
//                player.setPosBefore(new Pair<>(-99, -99));
//                System.out.println("No walk way !!!");
//                return;
//            }
//            System.out.println("walkTo: " + walkTo);
//            Block blockBefore = gameMap.getGameMap()[walkTo.getSecond()][walkTo.getFirst()];
//            System.out.println(blockBefore);
//            blockBefore.landOnBlock(player, gameMap);
//            if (player.getWalkLeft() == 1) {
//                player.setPosition(walkTo, gameMap, true);
//            } else {
//                player.setPosition(walkTo, gameMap, false);
//            }
//            System.out.println(walkTo);
//            player.setWalkLeft(player.getWalkLeft() - 1);
//            gameMap.printHoldMap();
//            player.printPlayerStatus();
//
//            if(player.getWalkLeft() <= 0){
//                nextPlayer();
//            }
//        }
//    }

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
            gameMap.printHoldMap();
            player.printPlayerStatus();

            if(player.getWalkLeft() <= 0){
                nextPlayer();
            }
        }
    }



    public Pair<Integer,Integer> generateNextBlock(Player player, int walk){
        int posX = player.getPosX();
        int posY = player.getPosY();
//        int posXBefore = player.getPosXBefore();
//        int posYBefore = player.getPosYBefore();
        Set<Integer> set = new HashSet<>();

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
//        System.out.println(res + "_"+ posXBefore );
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

    public Pair<Integer,Integer> choseWalkBlock(Player player) {
        int posX = player.getPosX();
        int posY = player.getPosY();
        int posXBefore = player.getPosXBefore();
        int posYBefore = player.getPosYBefore();
        Set<Integer> set = new HashSet<>();
        
        int walk = 0;
        
        if(posX-1 >= 0 && posXBefore != posX-1){
            if(gameMap.checkCanWalk(posX-1,posY,player)) {
                System.out.println("1: Left");
                set.add(1);
                walk = 1;
            }
        }
        if(posX+1 < gameMap.getX_SIZE() && posXBefore != posX+1){
            if(gameMap.checkCanWalk(posX+1,posY,player)) {
                System.out.println("2: Right");
                set.add(2);
                walk = 2;
            }
        }
        if(posY-1 >= 0 && posYBefore != posY-1){
            if(gameMap.checkCanWalk(posX,posY-1,player)) {
                System.out.println("3: Up");
                set.add(3);
                walk = 3;
            }
        }
        if(posY+1 < gameMap.getY_SIZE() && posYBefore != posY+1){
            if(gameMap.checkCanWalk(posX,posY+1,player)) {
                System.out.println("4: Down");
                set.add(4);
                walk = 4;
            }
        }
        if(set.isEmpty()){
            return new Pair<>(-1,-1);
        }

//        int walk = inputCheck(set);
        
        System.out.println("walk:" + walk);
        if(walk == 1) {return new Pair<>(posX-1,posY);}
        else if(walk == 2) {return new Pair<>(posX+1,posY);}
        else if(walk == 3) {return new Pair<>(posX,posY-1);}
        else if(walk == 4) {return new Pair<>(posX,posY+1);}
        return new Pair<>(posX,posY); //not do
    }

    public void newPlayer(String name) {
        Pair<Integer,Integer> position = RandomNum.randomPosition(gameMap.getX_SIZE(),gameMap.getY_SIZE(), gameMap);

        Player player = new Player(name, position.getFirst(), position.getSecond());
        Block[][] dataGM = gameMap.getGameMap();
        dataGM[player.getPosY()][player.getPosX()] = new PlayerBlock(player);
        players.add(player);
        System.out.println(name + " spawn at " + position);
//      return player;
    }

//    public int inputCheck(Set<Integer> available) {
////        System.out.println(available);
//        int choice = new Scanner(System.in).nextInt();
//        while (!available.contains(choice)) {
//            System.out.println("Invalid input");
//            choice = new Scanner(System.in).nextInt();
//        }
//        return choice;
//    }

    public static GameController getInstance() {
        if(instance == null)
            instance = new GameController();
        return instance;
    }

    public GameMap getGameMap() {
        return gameMap;
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

    public Integer getTurnLeft() {
        return turnLeft;
    }

    public Integer getPlayerNow() {
        return playerNow;
    }

    public String getPlayerDisplay() {
        Player player =players.get(playerNow);
        return player.getPlayerName() + " : " + player.getWalkLeft();
    }

    public ArrayList<Player> getPlayers(){
        return this.players;
    }
}
