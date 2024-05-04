package GUI;

import javafx.scene.canvas.GraphicsContext;

public interface Renderable {
    int getZ();
    void draw(GraphicsContext gc);

}
