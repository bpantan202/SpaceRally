package GUI;

import game.GameController;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import player.Player;

public class TurnPane extends Pane implements Renderable{
    private GraphicsContext gc;

    public TurnPane(GraphicsContext gc){
        this.drawTurn(gc);
        RenderableHolder.getInstance().add(this);
    }

    public void drawTurn(GraphicsContext gc) {
        GameController gameController = GameController.getInstance();
        if (gameController != null) {
            Player player = gameController.getPlayers().get(gameController.getPlayerNow());
            System.out.println("PlayerNow"+gameController.getPlayerNow());
            if (player != null) {
                int turnLeft = gameController.getTurnLeft();
                System.out.println("turnleft" + turnLeft);
                int turn = -(turnLeft - 11);
                String playerName = player.getPlayerName();
                System.out.println("turn" + turn);
                String turnText = "TURN: " + turn + "/" + playerName;
//
                gc.setFill(Color.LIGHTGRAY);
                gc.setFont(Font.font("Courier New", FontWeight.BOLD, 40));

                double textWidth = gc.getFont().getSize() * turnText.length();
                double textHeight = gc.getFont().getSize();

                double x = (gc.getCanvas().getWidth() - textWidth) / 2 + 100;
                double y = textHeight + 20;
//
//                // Draw the text
                gc.fillText(turnText, x, y);
            }else {
                System.out.println("player is null");
            }
        }else{
            System.out.println("GameController is null");
        }
    }

    @Override
    public int getZ() {
        return 101;
    }

    @Override
    public void draw(GraphicsContext gc) {
        drawTurn(gc);
    }
}
