package main;

import GUI.SpaceCell;
import GUI.SpacePane;
import game.GameController;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import GUI.RootPane;

//public class Main {
//    public static void main(String[] args)  {
//        GameController gameInstance = GameController.getInstance();
//        gameInstance.getGameMap().printHoldMap();
//    }


    public class Main extends Application {

        @Override
        public void start(Stage primaryStage) throws Exception {
//             TODO Auto-generated method stub
//            HBox root = new HBox();
//            root.setPadding(new Insets(10));
//            root.setSpacing(10);
//            root.setPrefHeight(900);
//
//            root.setPrefWidth(1600);
//            //GameLogic.getInstance();
//            spacePane spacePane = new spacePane();
//            //ControlPane controlPane = new ControlPane(ticTacToePane);
//
//            //GameLogic.getInstance().setControlPane(controlPane);
//
//
//            root.getChildren().add(spacePane);
//            //root.getChildren().add(controlPane);


            RootPane rootPane = RootPane.getRootPane();
            Scene scene = new Scene(rootPane,1600,900);

            GameController.getInstance();
//            rootPane.setGameController() = GameController.getInstance();
//            SpacePane spacePane = new SpacePane();
//            ControlPane controlPane = new ControlPane(ticTacToePane);

//            GameController.getInstance().setControlPane(controlPane);

            primaryStage.setScene(scene);
            primaryStage.setTitle("SpaceRally");
            primaryStage.setFullScreen(true);
            primaryStage.show();
            primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
                @Override
                public void handle(WindowEvent e) {
                    Platform.exit();
                    System.exit(0);
                }
            });
//            GameController gameInstance = GameController.getInstance();
//            gameInstance.getGameMap().printHoldMap();
        }


        public static void main(String[] args) {
            launch(args);
        }
    }

//}
