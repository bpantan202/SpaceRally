package game;

import block.*;
import function.Pair;
import player.Player;
import special.RandomDice;

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
        this.players = new ArrayList<Player>();

        setUpGame();
    }

    private void setUpGame() {
        Block[][] dataGM = gameMap.getGameMap();
        dataGM[1][0] = new Key(0,1);
        dataGM[2][1] = new Mission(1,2);
        dataGM[3][7] = new Landmark("Earth",3,7,3);
        dataGM[3][2] = new ExtraDoor(2,2,3);
        dataGM[1][6] = new SolidBlock(6,1);
        Player pA = new Player("A",4,3);
        pA.setKeyAmount(10);

        dataGM[pA.getPosY()][pA.getPosX()] = new PlayerBlock(pA);
//        int roleDice = RandomDice.roleDice();
        int roleDice = 5;
        System.out.println("roleDice: " + roleDice);
        pA.setWalkLeft(roleDice);
        while (pA.getWalkLeft() > 0){
            Pair<Integer, Integer> walkTo = choseWalkBlock(pA);
            System.out.println("walkTo: " + walkTo);
            Block blockBefore = gameMap.getGameMap()[walkTo.getSecond()][walkTo.getFirst()];
            System.out.println(blockBefore);
            blockBefore.landOnBlock(pA);
            pA.setPosition(walkTo, gameMap);
            System.out.println(walkTo);
            pA.setWalkLeft(pA.getWalkLeft() - 1);
            gameMap.printHoldMap();
            pA.printPlayerStatus();
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

        int walk = inputCheck(set);
        System.out.println("walk:" + walk);
        if(walk == 1) {return new Pair<>(posX-1,posY);}
        else if(walk == 2) {return new Pair<>(posX+1,posY);}
        else if(walk == 3) {return new Pair<>(posX,posY-1);}
        else if(walk == 4) {return new Pair<>(posX,posY+1);}
        return new Pair<>(posX,posY); //not do
    }

    public static int inputCheck(Set<Integer> available) {
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
