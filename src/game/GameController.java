package game;

import block.*;
import function.Pair;
import player.Player;
import special.RandomDice;
import special.RandomNum;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class GameController {
    private static GameController instance;
    private GameMap gameMap;
    private ArrayList<Player> players;

    public GameController(){
        this.gameMap = new GameMap();
        this.players = new ArrayList<>();

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
        gameMap.setToMapA();

        System.out.println("Select amount player (2-4) : ");
        Set<Integer> am = new HashSet<>();
        am.add(2);
        am.add(3);
        am.add(4);
        int amountPlayer = inputCheck(am);
        for(int i=1; i<=amountPlayer; i++){
            System.out.println("Player " + i + " name : ");
            String name = new Scanner(System.in).nextLine();
            newPlayer(name);
        }


        gameMap.printHoldMap();


        for (int round = 1; round<=10; round++){
            System.out.println("* * * * *  round " + round + "  * * * * *");
            for (Player player : players) {
                playTurn(player);
            }
        }


    }

    public void playTurn(Player player) {
        gameMap.printHoldMap();
        player.printPlayerStatus();
        int roleDice = RandomDice.roleDice();
        System.out.println("roleDice: " + roleDice);
        player.setWalkLeft(roleDice);
        while (player.getWalkLeft() > 0){
            Pair<Integer, Integer> walkTo = choseWalkBlock(player);
            if(walkTo.getFirst() == -1){
                player.setWalkLeft(0);
                player.setPosBefore(new Pair<>(-1,-1));
                System.out.println("No walk way !!!");
                return;
            }
            System.out.println("walkTo: " + walkTo);
            Block blockBefore = gameMap.getGameMap()[walkTo.getSecond()][walkTo.getFirst()];
            System.out.println(blockBefore);
            blockBefore.landOnBlock(player,gameMap);
            if(player.getWalkLeft() == 1){
                player.setPosition(walkTo, gameMap, true);
            } else {
                player.setPosition(walkTo, gameMap, false);
            }
            System.out.println(walkTo);
            player.setWalkLeft(player.getWalkLeft() - 1);
            gameMap.printHoldMap();
            player.printPlayerStatus();
        }
    }

    public Pair<Integer,Integer> choseWalkBlock(Player player) {
        int posX = player.getPosX();
        int posY = player.getPosY();
        int posXBefore = player.getPosXBefore();
        int posYBefore = player.getPosYBefore();
        Set<Integer> set = new HashSet<>();
        if(posX-1 >= 0 && posXBefore != posX-1){
            if(gameMap.checkCanWalk(posX-1,posY,player)) {
                System.out.println("1: Left");
                set.add(1);
            }
        }
        if(posX+1 < gameMap.getX_SIZE() && posXBefore != posX+1){
            if(gameMap.checkCanWalk(posX+1,posY,player)) {
                System.out.println("2: Right");
                set.add(2);
            }
        }
        if(posY-1 >= 0 && posYBefore != posY-1){
            if(gameMap.checkCanWalk(posX,posY-1,player)) {
                System.out.println("3: Up");
                set.add(3);
            }
        }
        if(posY+1 < gameMap.getY_SIZE() && posYBefore != posY+1){
            if(gameMap.checkCanWalk(posX,posY+1,player)) {
                System.out.println("4: Down");
                set.add(4);
            }
        }
        if(set.isEmpty()){
            return new Pair<>(-1,-1);
        }

        int walk = inputCheck(set);
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
//        return player;
    }

    public int inputCheck(Set<Integer> available) {
//        System.out.println(available);
        int choice = new Scanner(System.in).nextInt();
        while (!available.contains(choice)) {
            System.out.println("Invalid input");
            choice = new Scanner(System.in).nextInt();
        }
        return choice;
    }

    public static GameController getInstance() {
        if(instance == null)
            instance = new GameController();
        return instance;
    }

    public GameMap getGameMap() {
        return gameMap;
    }
}
