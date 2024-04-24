package function;

import javafx.scene.image.Image;

public class Load {
    public static Image yellowPlayer,redPlayer,grayPlayer,greenPlayer;
    public static void loadPlayer() {
        yellowPlayer = new Image(ClassLoader.getSystemResourceAsStream("players/yellow.png"));
        redPlayer = new Image(ClassLoader.getSystemResourceAsStream("players/red.png"));
        greenPlayer = new Image(ClassLoader.getSystemResourceAsStream("players/green.png"));
        grayPlayer = new Image(ClassLoader.getSystemResourceAsStream("players/gray.png"));
    }
}
