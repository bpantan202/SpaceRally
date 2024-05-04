package block;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import player.Player;

import java.util.Scanner;
import java.util.Set;

public class ExtraDoor extends ConditionsBlock{

    private Integer keyAmount;

    public ExtraDoor(int keyAmount, int posX, int posY) {
        super(posX, posY);
        this.keyAmount = keyAmount;
    }

    public char ShowStatus(){
        return 'D';
    }

    @Override
    public boolean canWalk(Player player) {

        if(player.getKeyAmount() >= keyAmount){
            if(askToOpenDoor()){
                player.getExtraDoor().add(this);
                player.setKeyAmount(player.getKeyAmount() - keyAmount);
//                return true;
            }
        }
        if(player.getExtraDoor().contains(this)){
            return true;
        }
        return false;
    }

    public boolean askToOpenDoor() {
        System.out.println("Would you like to open the door with " + keyAmount + " key?");
        System.out.println("1:Open 2:No Thanks");

        int choice = new Scanner(System.in).nextInt();
        while (choice != 1 && choice != 2) {
            System.out.println("Invalid input");
            choice = new Scanner(System.in).nextInt();
        }
        if(choice == 1) {
            return true;
        }
        return false;
    }

    @Override
    public void draw(GraphicsContext gc) {
        gc.drawImage(new Image("ExtraDoor.png"),getDisplayPosX() ,getDisplayPosY(),80,80);
    }

}
