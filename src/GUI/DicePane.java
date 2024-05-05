package GUI;

import game.GameController;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.util.Duration;
import player.Player;

import java.util.Random;

public class DicePane extends Pane /*implements Renderable*/ {
    private static DicePane instance;
    //private GraphicsContext gc;
//    private Button rollButton;
    private static final ImageView diceImageView1 = new ImageView();
    private static final ImageView diceImageView2 = new ImageView();

    private static Timeline timeline;
    private static final String[] diceImages = {
            "dice/dice-01.png", "dice/dice-02.png", "dice/dice-03.png",
            "dice/dice-04.png", "dice/dice-05.png", "dice/dice-06.png"
    };

    private int deg = 30;
    private int dicestatus1 = 0;
    private int dicestatus2 = 0;


    public DicePane() {
        //this.drawpane(gc);
//        rollButton = new Button("Roll Dice");
//        rollButton.setLayoutX(400);
//        rollButton.setLayoutY(50);
//
//        rollButton.setOnKeyPressed(new EventHandler<KeyEvent>() {
//            @Override
//            public void handle(KeyEvent event) {
//                if (event.getCode() == KeyCode.SPACE) {
//                    rollButton.setDisable(true);
//                    rollDice();
//                    System.out.println("Spacebar pressed");
//                }
//            }
//        });

        diceImageView1.setFitWidth(100);
        diceImageView1.setFitHeight(100);
        diceImageView1.setLayoutX(75);
        diceImageView1.setLayoutY(25);
        diceImageView1.setImage(new Image(ClassLoader.getSystemResourceAsStream("dice/dice-03.png")));

        diceImageView2.setFitWidth(100);
        diceImageView2.setFitHeight(100);
        diceImageView2.setLayoutX(225);
        diceImageView2.setLayoutY(25);
        diceImageView2.setImage(new Image(ClassLoader.getSystemResourceAsStream("dice/dice-05.png")));
        getChildren().addAll(diceImageView1, diceImageView2);
//        rollButton.requestFocus();

    }

//    private void startRollDice(){
//        Thread t = new Thread(){
//            @Override
//            public void run() {
//                try {
//                    rollDice();
//                } catch (InterruptedException e) {
//                    Thread.currentThread().interrupt();
//                }
//            }
//        };
//        t.start();
//    }

    public void rollDice() /*throws InterruptedException*/ {

//        Thread.sleep(3000);
//        Platform.runLater(new Runnable() {
//            @Override
//            public void run() {
//                timeline = new Timeline(new KeyFrame(Duration.millis(100), e -> changeDiceImage()));
//                timeline.setCycleCount(Timeline.INDEFINITE);
//                timeline.play();
//
//                new Timeline(new KeyFrame(Duration.seconds(2.4), e -> {
//                    stopDice();
//                })).play();
//            }
//        });


        timeline = new Timeline(new KeyFrame(Duration.millis(100), e -> changeDiceImage()));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();

        new Timeline(new KeyFrame(Duration.seconds(2.4), e -> {
            stopDice();
        })).play();
        //PaintPane.getInstance().drawAll(RenderableHolder.getInstance().getObjects());
        return;


    }

    private void changeDiceImage() {


        Random rand1 = new Random();
        Random rand2 = new Random();
        int result1 = (rand1.nextInt(996) % 6) + 1;
        int result2 = (rand2.nextInt(996) % 6) + 1;
        int index1 = result1 - 1;
        int index2 = result2 - 1;
        //result1 = result1 % diceImages.length;
        //result2 = result2 % diceImages.length;
        dicestatus1 = result1;
        dicestatus2 = result2;
        System.out.println("dicestatus1 : " + dicestatus1);
        System.out.println("dicestatus2 : " + dicestatus2);
        //System.out.println("res : "+getDiceResult());
        Image image1 = new Image(ClassLoader.getSystemResourceAsStream(diceImages[index1]));
        Image image2 = new Image(ClassLoader.getSystemResourceAsStream(diceImages[index2]));
        Timeline rotateTimeline1 = new Timeline(
                new KeyFrame(Duration.ZERO, new KeyValue(diceImageView1.rotateProperty(), deg)),
                new KeyFrame(Duration.millis(200), new KeyValue(diceImageView1.rotateProperty(), (deg))));
        Timeline rotateTimeline2 = new Timeline(
                new KeyFrame(Duration.ZERO, new KeyValue(diceImageView2.rotateProperty(), deg)),
                new KeyFrame(Duration.millis(200), new KeyValue(diceImageView2.rotateProperty(), (deg))));
        deg = (deg + 30) % 360; // Update rotation value
        rotateTimeline1.play();
        rotateTimeline2.play();
        diceImageView1.setImage(image1);
        diceImageView2.setImage(image2);
        GameController.getInstance().getPlayers().get(GameController.getInstance().getPlayerNow()).setWalkLeft(getDiceResult());
        System.out.println(getDiceResult());
        //System.out.println(GameController.getInstance().getPlayers().get(GameController.getInstance().getPlayerNow()).getWalkLeft());

        GameController.getInstance().getPlayers().get(GameController.getInstance().getPlayerNow()).printPlayerStatus();

        //PaintPane.getInstance().drawAll(RenderableHolder.getInstance().getObjects());
        //rollButton.setGraphic(new ImageView(image));
        //stopDice(); // Stop the timeline when the result is obtained
    }


    private Runnable onDiceRolledCallback; // Callback to signal when dice rolling animation finishes

    public void setOnDiceRolledCallback(Runnable callback) {
        this.onDiceRolledCallback = callback;
    }
    private void stopDice() {
        timeline.stop();
        if (onDiceRolledCallback != null) {
            onDiceRolledCallback.run(); // Signal that dice rolling has finished
        }
    }

    public int getDiceResult() {
        return dicestatus1 + dicestatus2;
    }

    public static DicePane getInstance() {
        if (instance==null){
            instance=new DicePane();
        }
        return instance;
    }

    public static void setInstance(DicePane instance) {
        DicePane.instance = instance;
    }

    public int getDeg() {
        return deg;
    }

    public void setDeg(int deg) {
        this.deg = deg;
    }

    public int getDicestatus1() {
        return dicestatus1;
    }

    public void setDicestatus1(int dicestatus) {
        this.dicestatus1 = dicestatus;
    }

    public int getDicestatus2() {
        return dicestatus2;
    }

    public void setDicestatus2(int dicestatus) {
        this.dicestatus2 = dicestatus;
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