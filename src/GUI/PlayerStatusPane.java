package GUI;

import game.GameController;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import player.Player;

import java.util.ArrayList;

public class PlayerStatusPane extends Pane implements Renderable{
    private ArrayList<Player> players;

    public PlayerStatusPane(ArrayList<Player> players, GraphicsContext gc){
        this.players = players;
        this.drawPlayerStatus(gc,this.players);
        RenderableHolder.getInstance().add(this);
    }

    public void drawPlayerStatus(GraphicsContext gc, ArrayList<Player> players){
         int size = players.size();
         for(int i = 0 ; i < size ; i++){
             int x = 1175;
             int y = 25 + (175*i);
             int width = 400;
             int height = 150;

             gc.setGlobalAlpha(0.7);

             gc.setFill(Color.BLACK);
             gc.fillRoundRect(x,y,width,height,35,35);

             gc.setStroke(Color.WHITE);
             gc.setLineWidth(3);
             gc.strokeRoundRect(x, y, width, height, 35, 35);

             gc.setGlobalAlpha(1.0);

             players.get(i).drawPlayer(gc,players.get(i).getPlayerName() ,x , y );

             gc.setFill(Color.LIGHTGRAY);
             gc.setFont(Font.font("Courier New", FontWeight.EXTRA_BOLD, 35));
             gc.fillText(String.format("%02d", players.get(i).getScore()), x + 350, y + 30);

             gc.setFont(Font.font("Courier New", FontWeight.BOLD, 14));
             gc.fillText("Keys" , x + 150, y + 30);
             Image keyImage = new Image("Key.png");
             for(int j = 0 ; j < players.get(i).getKeyAmount() ; j ++){
                 gc.drawImage(keyImage, x + 195 + (j*20), y + 15, 20, 20);
             }

             ArrayList<String> planetVisit = new ArrayList<>();
             for(int j = 0 ; j < players.get(i).getPlanetVisit().size() ; j++){
                 planetVisit.add(players.get(i).getPlanetVisit().get(j).getName());
             }
//             gc.fillText("PlanetVisited:" + planetVisit , x + 150, y + 50);
             String planetVisitString = "PlanetVisited:";
             for(int k = 0; k < planetVisit.size(); k++) {
                 if (k == 2)
                     planetVisitString += "\n";
                 planetVisitString += " " + planetVisit.get(k);
             }
             gc.fillText(planetVisitString, x + 150, y + 50);

             ArrayList<String> mission = new ArrayList<>();
             for(int j = 0 ; j < players.get(i).getMission().size() ; j++){
                 mission.add(players.get(i).getMission().get(j).getName());
             }
             gc.fillText("Mission:" + mission, x + 150, y + 90);
             gc.fillText("ExtraDoor", x + 150, y + 120);
             Image checkImage = new Image("Check/check.png");
             Image notCheckImage = new Image("Check/notcheck.png");
             if(players.get(i).getExtraDoor().isEmpty()) gc.drawImage(notCheckImage, x + 235 , y + 107, 20, 20);
             else gc.drawImage(checkImage, x + 235 , y + 106, 25, 20);

         }

    }

    @Override
    public int getZ() {
        return 100;
    }

    @Override
    public void draw(GraphicsContext gc) {
        drawPlayerStatus(gc,players);
    }



}
