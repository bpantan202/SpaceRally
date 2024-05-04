package GUI;
import javafx.application.Platform;
import player.*;
import special.*;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.Random;

public class Wurfel extends Application {

    private static final int DICE_SIZE = 100;
    private static final Random random = new Random();
    private static final String[] diceImages = {
            "players/gray.png", "players/gray.png", "players/green.png",
            "players/green.png", "players/red.png", "players/yellow.png"
    };
    private static final ImageView diceImageView = new ImageView();
    private static Timeline timeline;
    private Button rolldice;
    private int deg = 30;

    public static void main(String[] args) {
        launch(args);
    }

    private void rollDice() {
        timeline = new Timeline(new KeyFrame(Duration.millis(100), e -> changeDiceImage()));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();

        new Timeline(new KeyFrame(Duration.seconds(2.4), e -> stopDice())).play();

//        int result = RandomDice.roleDice() - 1; // Subtract 1 to match array index
//        result = result % diceImages.length;
//        Image image = new Image(ClassLoader.getSystemResourceAsStream(diceImages[result]));
//        diceImageView.setImage(image);
    }

    private void changeDiceImage() {

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

        //stopDice(); // Stop the timeline when the result is obtained
    }

    private void stopDice() {
        timeline.stop();
    }

//    public void startCountDownTimer(int pl) {
//			/*
//		 * FIX CODES
//		 * The following code will make the winning cells change to green background,but it will freeze
//		  the program while it's working.
//		 * Implement it in a thread so it's will work properly,Don't forget to start the thread.
//		 * If implement correctly,the block will change one at a time with correct animation. */
//        Thread t = new Thread(){
//            @Override
//            public void run() {
//                try {
//                    runCountDownTimer(pl);
//                } catch (InterruptedException e) {
//                    Thread.currentThread().interrupt();
//                }
//            }
//        };
//        t.start();
//    }
//    public void runCountDownTimer(int pl) throws InterruptedException {
//        Timer plTimer = playerTimer[pl];
//        plTimer.setStop(false);
//        if(pl==0) {
//            while (gameStart&&isOTurn && !plTimer.isTimerEmpty()) {
//                Thread.sleep(20);
//
//                Platform.runLater(new Runnable() {
//                    @Override
//                    public void run() {
//                        timerPane[pl].setTimer(plTimer);
//                        plTimer.decrementTimer(2);
//                    }
//                });
//					/*
//			 * FIX CODE: There is JavaFX commands inside the code below
//				Add something to the code below to make JavaFX commands can
//				function in the thread
//			 */
////				timerPane[pl].setTimer(plTimer);
////
////				plTimer.decrementTimer(2);
//            }
//        }
//        else {
//            while (gameStart&&!isOTurn&&!plTimer.isTimerEmpty()) {
//                Thread.sleep(20);
//
//                Platform.runLater(new Runnable() {
//                    @Override
//                    public void run() {
//                        timerPane[pl].setTimer(plTimer);
//                        plTimer.decrementTimer(2);
//                    }
//                });
//				/*
//				 *	/*
//			 * FIX CODE: There is JavaFX commands inside the code below
//				Add something to the code below to make JavaFX commands can
//				function in the thread
//				 */
////				timerPane[pl].setTimer(plTimer);
////
////				plTimer.decrementTimer(2);
//            }
//        }
//        plTimer.setStop(true);
//
//        if(plTimer.isTimerEmpty()) {
//            if(isOTurn)controlPane.updateGameText("X wins!");
//            else controlPane.updateGameText("O wins!");
//            return;
//        }
//    }

    @Override
    public void start(Stage primaryStage) {
        Pane root = new Pane();

        diceImageView.setLayoutX(100);
        diceImageView.setLayoutY(100);


        root.getChildren().add(diceImageView);

        Button rollButton = new Button("Roll Dice");
        rollButton.setLayoutX(10);
        rollButton.setLayoutY(10);
        root.getChildren().add(rollButton);

        rollButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                rollDice();
            }
        });

        Scene scene = new Scene(root, 300, 300);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Dice Roll Game");
        primaryStage.show();
    }
}
