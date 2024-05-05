package main;

import GUI.*;
import Sound.Sound;
import game.GameController;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.GraphicsContext;
import javafx.stage.Stage;

import java.util.ArrayList;


public class Main extends Application {
    private Sound backgroundMusic;
    @Override
    public void start(Stage primaryStage) throws Exception {
        RootPane rootPane = RootPane.getRootPane();
        Scene scene = new Scene(rootPane,1600,900);

        PaintPane paintPane = PaintPane.getInstance();

        GraphicsContext gc = paintPane.getGraphicsContext2D();
        RenderableHolder renderableHolder = RenderableHolder.getInstance();


        DicePane dicePane = DicePane.getInstance();
        rootPane.getChildren().add(dicePane);
        Thread.sleep(4000);


        primaryStage.setScene(scene);
        primaryStage.setTitle("SpaceRally");
        primaryStage.show();


        backgroundMusic = new Sound("backgroundMusic.mp3");
        backgroundMusic.loop();

        GameController gameController = GameController.getInstance();

        PlayerStatusPane playerStatusPane = new PlayerStatusPane(gameController.getPlayers(),gc);
        rootPane.getChildren().add(playerStatusPane);

        TurnPane turnPane = new TurnPane(gc);
        rootPane.getChildren().add(turnPane);

        ControlPane controlPane = new ControlPane();
        rootPane.getChildren().add(controlPane);


        ArrayList<Boolean> valid =  GameController.getInstance().askValid();
        controlPane.setValidButton(valid.get(0), valid.get(1), valid.get(2), valid.get(3));
        paintPane.drawAll(renderableHolder.getObjects());
        controlPane.updateGameText(GameController.getInstance().getPlayerDisplay());

        MenuPane menuPane = new MenuPane();
        rootPane.getChildren().add(menuPane);

        AnimationTimer animationTimer = new AnimationTimer() {

            private void setButton() {
                ArrayList<Boolean> valid = GameController.getInstance().askValid();
                while (!(valid.get(0) || valid.get(1) || valid.get(2) || valid.get(3))){
                    GameController.getInstance().nextPlayer();
                    valid = GameController.getInstance().askValid();
                }
                controlPane.setValidButton(valid.get(0), valid.get(1), valid.get(2), valid.get(3));
                controlPane.updateGameText(GameController.getInstance().getPlayerDisplay());
            }


            @Override
            public void handle(long l) {
                if(controlPane.getGameText() == "Left"){
                    gameController.playTurnEach(1);
                    setButton();

                    paintPane.drawAll(renderableHolder.getObjects());

                }
                else if(controlPane.getGameText() == "Right"){
                    gameController.playTurnEach(2);
                    setButton();

                    paintPane.drawAll(renderableHolder.getObjects());

                }
                if(controlPane.getGameText() == "Up"){
                    gameController.playTurnEach(3);
                    setButton();

                    paintPane.drawAll(renderableHolder.getObjects());

                } else if (controlPane.getGameText() == "Down") {
                    gameController.playTurnEach(4);
                    setButton();

                    paintPane.drawAll(renderableHolder.getObjects());
                }

            }
        };
        animationTimer.start();



    }


    public static void main(String[] args) {
        launch(args);
    }
}
