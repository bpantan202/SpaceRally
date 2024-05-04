package display;

import GUI.Renderable;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class Arrow implements Renderable {

    String imgPath;
    Integer posX;
    Integer posY;

    public Arrow(String path, int x, int y) {
        this.imgPath = path;
        this.posX = x;
        this.posY = y;
    }

    public int getDisplayPosX() {
        return (posX * 100) + 50;
    }

    public int getDisplayPosY() {
        return (posY * 100) + 170;
    }

    @Override
    public int getZ() {
        return 200;
    }

    @Override
    public void draw(GraphicsContext gc) {
        gc.drawImage(new Image(imgPath),getDisplayPosX() ,getDisplayPosY(),80,80);
    }
}
