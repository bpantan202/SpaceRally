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
    private static PlayerStatusPane instance;
    private GraphicsContext gc;
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
             gc.setFont(Font.font("Courier New", FontWeight.EXTRA_BOLD, 40));
             gc.fillText(""+players.get(i).getScore(), x + 360, y + 40);


             gc.setFont(Font.font("Courier New", FontWeight.BOLD, 14));
             gc.fillText("Keys: " + players.get(i).getKeyAmount(), x + 150, y + 30);

             gc.fillText("PlanetVisited: " + players.get(i).getPlanetVisit(), x + 150, y + 50);

             gc.fillText("Mission: " + players.get(i).getMission(), x + 150, y + 90);
             gc.fillText("ExtraDoor: " + players.get(i).getExtraDoor(), x + 150, y + 110);

//             //debug
//             System.out.println("==================");
//             System.out.println(i);
//             System.out.println("Score: " + players.get(i).getScore());
//             System.out.println("Keys: " + players.get(i).getKeyAmount());
//             System.out.println("==================");
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

//    public static PlayerStatusPane getInstance() {
//        GameController gameController = GameController.getInstance();
//        if (instance == null)
//            instance = new PlayerStatusPane(gameController.getPlayers());
//        return instance;
//    }

}
