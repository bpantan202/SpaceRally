package GUI;

import block.WalkAbleBlock;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import player.Player;

import java.time.Instant;
import java.util.ArrayList;

public class PaintPane extends Canvas{
    private static PaintPane instance;
    private GraphicsContext gc;
    Player one,two,three,four;

    public PaintPane() {
        super(1600,900);
        gc = getGraphicsContext2D();
        one = new Player("yellow",40,40);
        two = new Player("red",40,40);
        three = new Player("green",40,40);
        four = new Player("gray",40,40);
        one.drawPlayer(gc,one.getPlayerName(),1000,30);
        two.drawPlayer(gc,two.getPlayerName(),1000,660);
        three.drawPlayer(gc,three.getPlayerName(),1360,650);
        four.drawPlayer(gc,four.getPlayerName(),1360,40);
    }


    public static PaintPane getInstance() {
        if (instance == null)
            instance = new PaintPane();
        return instance;
    }

    public GraphicsContext getGc() {
        return gc;
    }

    public void drawAll(ArrayList<Renderable> objects) {
//        gc.drawImage(new Image("SpaceBackground.png"),500,500,0,0);
        for(Renderable e : objects){
            e.draw(gc);
        }
    }
}
