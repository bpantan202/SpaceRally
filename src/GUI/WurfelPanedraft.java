package GUI;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

import java.util.Random;

public class WurfelPanedraft extends Pane {
    private static WurfelPanedraft instance;
    private GraphicsContext gc;
    private Button rollButton;
    private static final ImageView diceImageView = new ImageView();

    private static Timeline timeline;
    private static final String[] diceImages = {
            "players/gray.png", "players/gray.png", "players/green.png",
            "players/green.png", "players/red.png", "players/yellow.png"
    };

    private int deg = 30;



    public WurfelPanedraft(GraphicsContext gc){
        //this.drawpane(gc);
        rollButton = new Button("Roll Dice");
        rollButton.setLayoutX(250);
        rollButton.setLayoutY(50);

        rollButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                rollDice();
                System.out.println("button");
            }
        });

        //Image image = new Image(ClassLoader.getSystemResourceAsStream(diceImages[index]));
        diceImageView.setLayoutX(75);
        diceImageView.setLayoutY(25);
        diceImageView.setImage(new Image(ClassLoader.getSystemResourceAsStream("players/red.png")));
        getChildren().addAll(diceImageView,rollButton);

        //RenderableHolder.getInstance().add(this);
    }

    private void rollDice() {
        timeline = new Timeline(new KeyFrame(Duration.millis(100), e ->changeDiceImage()));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();

        new Timeline(new KeyFrame(Duration.seconds(2.4), e -> stopDice())).play();


    }

//    private void changeDiceImage() {
//        Random rand = new Random();
//        int result = (rand.nextInt(996) % 6) + 1; // Subtract 1 to match array index
//        int index = (result - 1) % diceImages.length;
//        System.out.println("role : " + result);
//
//        Image image = new Image(ClassLoader.getSystemResourceAsStream(diceImages[index]));
//        // Update the button's graphic instead of diceImageView
//        rollButton.setGraphic(new ImageView(image));
//    }


//    public void startChangeDiceImage(){
//        Thread t = new Thread(){
//            @Override
//            public void run() {
//                try {
//                    changeDiceImage();
//                } catch (InterruptedException e) {
//                    Thread.currentThread().interrupt();
//                }
//            }
//        };
//        t.start();
//    }

    private void changeDiceImage()  /*throws InterruptedException*/  {

//        Random rand = new Random();
//        int result = (rand.nextInt(996) % 6) + 1; // Subtract 1 to match array index
//        int index =  (result - 1)% diceImages.length;
//        System.out.println("role : " + result);
//
//        Image image = new Image(ClassLoader.getSystemResourceAsStream(diceImages[index]));
//
//        Platform.runLater(() -> {
//            diceImageView.setImage(image);
//        });

//        Thread.sleep(2000);
//        Platform.runLater(new Runnable() {
//            @Override
//            public void run() {
//                Image image = new Image(ClassLoader.getSystemResourceAsStream(diceImages[index]));
//                diceImageView.setImage(image);
//            }
//        });

        Random rand = new Random();
        int result = (rand.nextInt(996) % 6) + 1; // Subtract 1 to match array index
        int index =  (result - 1)% diceImages.length;
//      result = result % diceImages.length;
        System.out.println("role : " + result);
        Image image = new Image(ClassLoader.getSystemResourceAsStream(diceImages[index]));
        diceImageView.setImage(image);
        //rollButton.setGraphic(new ImageView(image));
        //stopDice(); // Stop the timeline when the result is obtained
    }

    private void stopDice() {
        timeline.stop();
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


//    @Override
//    public int getZ() {
//        return 100;
//    }

//    @Override
//    public void draw(GraphicsContext gc) {
//        drawpane(gc);
//    }



//    public static PlayerStatusPane getInstance() {
//        GameController gameController = GameController.getInstance();
//        if (instance == null)
//            instance = new PlayerStatusPane(gameController.getPlayers());
//        return instance;
//    }

}



