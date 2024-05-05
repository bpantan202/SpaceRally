package GUI;

import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class MenuPane extends Pane {

    public MenuPane() {
        Image backgroundImage = new Image("background/MenuBackground.png");
        ImageView backgroundImageView = new ImageView(backgroundImage);

        Text text = new Text("Space Rally");
        text.setFont(Font.font("Algerian", FontWeight.BOLD, 80));
        text.setFill(Color.WHITE);
        text.setTranslateY(400);
        text.setTranslateX(500);

        Rectangle playButton = new Rectangle(200, 50);
        playButton.setTranslateX(650);
        playButton.setTranslateY(450);
        playButton.setArcWidth(20);
        playButton.setArcHeight(20);
        playButton.setFill(Color.DARKSEAGREEN);

        Text buttonText = new Text("Play");
        buttonText.setFont(Font.font("Arial", FontWeight.BOLD, 20));
        buttonText.setFill(Color.WHITE);
        buttonText.setTranslateX(725);
        buttonText.setTranslateY(480);

        playButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                RootPane rootPane = RootPane.getRootPane();
                rootPane.getChildren().remove(MenuPane.this);
                //System.out.println("Play button clicked!");
            }
        });

        getChildren().addAll(backgroundImageView, text, playButton, buttonText);

        setBackground(new Background(new BackgroundFill(Color.WHITE, null, null)));
    }
}
