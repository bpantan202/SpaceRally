package pane;

import GUI.spacePane;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
//import utils.Goto;

public class RootPane extends StackPane {
    private static RootPane instance;
    public PaintPane paintPane;

    private RootPane() {
        paintPane = new PaintPane();
        Image image = new Image("background.png");
        BackgroundImage backgroundImage = new BackgroundImage(image, null, null, null, null);
        Background background = new Background(backgroundImage);
        this.setBackground(background);
        this.setAlignment(Pos.TOP_CENTER);
        this.getChildren().add(paintPane);
        paintPane.drawTurn();

        spacePane spacePane = new spacePane();
        this.getChildren().add(spacePane);
    }

    public static RootPane getRootPane() {
        if (instance == null)
            instance = new RootPane();
        return instance;
    }
}
