package main;

import game.GameController;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import pane.PaintPane;
import pane.RootPane;

public class Main extends Application {

//    public static void main(String[] args) {
//        GameController gameInstance = GameController.getInstance();
//        gameInstance.getGameMap().printHoldMap();
//    }
    public static void main(String[] args) {
    launch();
}

    @Override
    public void start(Stage stage) {
        RootPane rootPane = RootPane.getRootPane();
        Scene scene = new Scene(rootPane,1600,900);
        stage.setScene(scene);
        stage.setFullScreen(true);
        stage.show();
    }

}
