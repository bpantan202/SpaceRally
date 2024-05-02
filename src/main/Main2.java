package main;

import GUI.*;
import game.GameController;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.util.ArrayList;


public class Main2 extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        RootPane rootPane = RootPane.getRootPane();
        Scene scene = new Scene(rootPane,1600,900);

        PaintPane paintPane = PaintPane.getInstance();

        GraphicsContext gc = paintPane.getGraphicsContext2D();
        RenderableHolder renderableHolder = RenderableHolder.getInstance();

        ControlPane controlPane = new ControlPane();
        rootPane.getChildren().add(controlPane);


//        gc.drawImage(new Image("Key.png"),100,100,100,100);
//        GameController.getInstance();
//        Img i = new Img();
//        i.draw(gc);
//        RenderableHolder.getInstance().add(i);
//        GameController.getInstance();


        primaryStage.setScene(scene);
        primaryStage.setTitle("SpaceRally");
        primaryStage.setFullScreen(true);
        primaryStage.show();
//        primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
//            @Override
//            public void handle(WindowEvent e) {
//                Platform.exit();
//                System.exit(0);
//            }
//        });
        GameController gameController = GameController.getInstance();
        paintPane.drawAll(renderableHolder.getObjects());
        ArrayList<Boolean> valid =  GameController.getInstance().askValid();
        controlPane.setValidButton(valid.get(0), valid.get(1), valid.get(2), valid.get(3));

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

//                if(gameController.getTurnLeft() > 0){
//                    gameController.playTurnEach();
//                }
            }
        };
        animationTimer.start();



    }


    public static void main(String[] args) {
        launch(args);
    }
}
