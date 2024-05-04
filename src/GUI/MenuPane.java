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
        // Load background image
        Image backgroundImage = new Image("background/MenuBackground.png"); // Path to your background image
        ImageView backgroundImageView = new ImageView(backgroundImage);

        Text text = new Text("Space Rally");
        text.setFont(Font.font("Algerian", FontWeight.BOLD, 80));
        text.setFill(Color.WHITE);
        text.setTranslateY(400);
        text.setTranslateX(500);// Adjust Y position of the text

        Rectangle playButton = new Rectangle(200, 50);
        playButton.setTranslateX(650);
        playButton.setTranslateY(450); // Adjust Y position of the button
        playButton.setArcWidth(20); // Set arc width
        playButton.setArcHeight(20); // Set arc height
        playButton.setFill(Color.DARKSEAGREEN); // Set button color

        Text buttonText = new Text("Play");
        buttonText.setFont(Font.font("Arial", FontWeight.BOLD, 20));
        buttonText.setFill(Color.WHITE);
        buttonText.setTranslateX(725);
        buttonText.setTranslateY(480); // Adjust Y position of the button text

        // Event handler for the "Play" button
        playButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                // Handle button click event
                // For example, launch a new game scene
                // Main2.State = Main
                //MenuPane menuPane = new MenuPane();
                RootPane rootPane = RootPane.getRootPane();
                rootPane.getChildren().remove(MenuPane.this);
                //System.out.println("Play button clicked!");
            }
        });

        // Add UI elements to the MenuPane
        getChildren().addAll(backgroundImageView, text, playButton, buttonText);

        // Set background color (fallback if image fails to load or not available)
        setBackground(new Background(new BackgroundFill(Color.WHITE, null, null)));
    }
}
