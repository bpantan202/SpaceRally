package GUI;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.EventHandler;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

import java.util.Random;

public class WurfelPane extends Pane /*implements Renderable*/{
    private static WurfelPane instance;
    private GraphicsContext gc;
    private Button rollButton;
    private static final ImageView diceImageView = new ImageView();

    private static Timeline timeline;
    private static final String[] diceImages = {
            "dice/dice-01.png", "dice/dice-02.png", "dice/dice-03.png",
            "dice/dice-04.png", "dice/dice-05.png", "dice/dice-06.png"
    };

    private int deg = 30;



    public WurfelPane(GraphicsContext gc){
        //this.drawpane(gc);
        rollButton = new Button("Roll Dice");
        rollButton.setLayoutX(250);
        rollButton.setLayoutY(50);

        rollButton.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if (event.getCode() == KeyCode.SPACE) {
                    rollDice();
                    System.out.println("Spacebar pressed");
                }
            }
        });

        diceImageView.setFitWidth(100);
        diceImageView.setFitHeight(100);
        diceImageView.setLayoutX(75);
        diceImageView.setLayoutY(25);
        diceImageView.setImage(new Image(ClassLoader.getSystemResourceAsStream("players/Red.png")));
        getChildren().addAll(diceImageView,rollButton);

    }

    private void rollDice() {
        timeline = new Timeline(new KeyFrame(Duration.millis(100), e ->changeDiceImage()));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();

        new Timeline(new KeyFrame(Duration.seconds(2.4), e -> stopDice())).play();


    }

    private void changeDiceImage(){

        Random rand = new Random();
        int result = (rand.nextInt(996) % 6) + 1; // Subtract 1 to match array index
        int index =  (result - 1)% diceImages.length;
//      result = result % diceImages.length;
        System.out.println("role : " + result);
        Image image = new Image(ClassLoader.getSystemResourceAsStream(diceImages[index]));
        Timeline rotateTimeline = new Timeline(
                new KeyFrame(Duration.ZERO, new KeyValue(diceImageView.rotateProperty(), deg)),
                new KeyFrame(Duration.millis(200), new KeyValue(diceImageView.rotateProperty(), (deg))));
        deg = (deg + 30) % 360; // Update rotation value
        rotateTimeline.play();

        diceImageView.setImage(image);
        //rollButton.setGraphic(new ImageView(image));
        //stopDice(); // Stop the timeline when the result is obtained
    }

    private void stopDice() {
        timeline.stop();
    }

//    public void drawpane(GraphicsContext gc){
//        int x = 50;
//        int y = 25;
//        int width = 400;
//        int height = 150;
//
//        gc.setGlobalAlpha(0.7);
//
//        gc.setFill(Color.BLACK);
//        gc.fillRoundRect(x,y,width,height,35,35);
//
//        gc.setStroke(Color.WHITE);
//        gc.setLineWidth(3);
//        gc.strokeRoundRect(x, y, width, height, 35, 35);
//
//        gc.setGlobalAlpha(1.0);
//
//    }
//
//    @Override
//    public int getZ() {
//        return 100;
//    }
//
//    @Override
//    public void draw(GraphicsContext gc) {
//        drawpane(gc);
//    }


}



