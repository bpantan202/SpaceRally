package GUI;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import player.Player;

public class PaintPane extends Canvas{
    GraphicsContext gc;
    Player one,two,three,four;
    public PaintPane() {
        super(1600,900);
        gc = getGraphicsContext2D();
        one = new Player("yellow",40,40);
        two = new Player("red",40,40);
        three = new Player("green",40,40);
        four = new Player("gray",40,40);
        one.drawPlayer(gc,one.getPlayerName(),45,30);
        two.drawPlayer(gc,two.getPlayerName(),45,660);
        three.drawPlayer(gc,three.getPlayerName(),1360,650);
        four.drawPlayer(gc,four.getPlayerName(),1360,40);
    }

    public void drawTurn() {
        double canvasWidth = getWidth();
        double rectangleWidth = 100;
        double x = (canvasWidth - rectangleWidth) / 2;

        double canvasHeight = getHeight();
        double rectangleHeight = 100;
        double y = 0;

        String text = "4";
        gc.setFill(Color.WHITE);
        gc.setFont(Font.font("Arial", FontWeight.BOLD, 60));

        double textWidth = gc.getFont().getSize() * text.length();
        double textX = x + (rectangleWidth - textWidth) / 2;
        double textY = y + (rectangleHeight + gc.getFont().getSize()) / 2;

        gc.fillText(text, textX, textY);
    }
}
