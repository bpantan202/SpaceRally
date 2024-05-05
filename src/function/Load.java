package function;

import javafx.scene.image.Image;

import java.util.Objects;

public class Load {
    public static Image yellowPlayer,redPlayer,grayPlayer,greenPlayer;
    public static void loadPlayer() {
        yellowPlayer = new Image(Objects.requireNonNull(ClassLoader.getSystemResourceAsStream("players/Yellow.png")));
        redPlayer = new Image(Objects.requireNonNull(ClassLoader.getSystemResourceAsStream("players/Red.png")));
        greenPlayer = new Image(Objects.requireNonNull(ClassLoader.getSystemResourceAsStream("players/Green.png")));
        grayPlayer = new Image(Objects.requireNonNull(ClassLoader.getSystemResourceAsStream("players/Gray.png")));
    }
}
