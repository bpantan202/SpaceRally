package GUI;

import function.Load;
import game.GameController;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
//import utils.Goto;

public class RootPane extends StackPane {
    private static RootPane instance;
    public PaintPane paintPane;

//    private RootPane() {
//        paintPane = new PaintPane();
//        Image image = new Image("gif.gif");
//
//        BackgroundImage backgroundImage = new BackgroundImage(image, null, null, null, null);
//        Background background = new Background(backgroundImage);
//        this.setBackground(background);
//        this.setAlignment(Pos.TOP_CENTER);
//        this.getChildren().add(paintPane);
//        paintPane.drawTurn();
//
//        spacePane spacePane = new spacePane();
//        this.getChildren().add(spacePane);
//    }
private RootPane() {
    Load.loadPlayer();
    paintPane = PaintPane.getInstance();
//    Image image = new Image("background/gif2.gif");

    // Create a BackgroundSize object that will fill the area
    BackgroundSize backgroundSize = new BackgroundSize(
            100, // Width is 100% of area
            100, // Height is 100% of area
            true, // Width as percentage
            true, // Height as percentage
            false, // Do not preserve image's width/height ratio
            true  // Cover the available area
    );

    // Configure the BackgroundImage
//    BackgroundImage backgroundImage = new BackgroundImage(
//            image,
//            BackgroundRepeat.NO_REPEAT, // Image will not repeat
//            BackgroundRepeat.NO_REPEAT,
//            BackgroundPosition.CENTER, // Image centered in the background
//            backgroundSize              // Use the custom BackgroundSize
//    );

//    Background background = new Background(backgroundImage);
//    this.setBackground(background);
    this.setAlignment(Pos.TOP_CENTER);
    this.getChildren().add(paintPane);
//    paintPane.drawTurn();
//    paintPane.drawPlayerStatus();

//    SpacePane spacePane = new SpacePane();
//    this.getChildren().add(spacePane);
}


    public static RootPane getRootPane() {
        if (instance == null)
            instance = new RootPane();
        return instance;
    }

}
