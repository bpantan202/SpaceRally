package display;

import GUI.Renderable;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundSize;

public class ImgBackground implements Renderable {
    private BackgroundSize bgSize;
    private BackgroundImage imgNothing;
    private BackgroundImage imgKey;

    public ImgBackground(){}

    public BackgroundImage getImgKey() {
        return imgKey;
    }

    public BackgroundImage getImgNothing() {
        return imgNothing;
    }

    @Override
    public int getZ() {
        return -999;
    }

    @Override
    public void draw(GraphicsContext gc) {
        gc.drawImage(new Image("SpaceBackground.png"),0,0,2048,1152);
    }


//    @Override
//    public int getZ() {
//        return 10;
//    }
//
//    @Override
//    public void draw(GraphicsContext gc) {
//        gc.drawImage(new Image("Key.png"),100,100,50,50);
//    }
}
