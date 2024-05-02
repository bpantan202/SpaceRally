package function;

import javafx.scene.image.Image;

public class Load {
    public static Image yellowPlayer,redPlayer,grayPlayer,greenPlayer;
    public static void loadPlayer() {
        yellowPlayer = new Image(ClassLoader.getSystemResourceAsStream("players/Yellow.png"));
        redPlayer = new Image(ClassLoader.getSystemResourceAsStream("players/Red.png"));
        greenPlayer = new Image(ClassLoader.getSystemResourceAsStream("players/Green.png"));
        grayPlayer = new Image(ClassLoader.getSystemResourceAsStream("players/Gray.png"));
    }
}
