package GUI;

import game.GameController;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
//import logic.GameLogic;

public class SpaceCell extends Pane {

	private GameController gameController;
	private boolean isDrawn;
	private Color baseColor;

	private int xPosition;
	private int yPosition;
	private String oURL;
	private String xURL;
	private Button button=new Button();
	private BackgroundSize bgSize;
	private Img img;

	private BackgroundImage imageKey;

	public SpaceCell(int x, int y) {
		super();
		this.oURL = "Key.png";
		this.xURL = "x.png";
		this.setxPosition(x);
		this.setyPosition(y);
		setPrefSize(80, 80);
		setBaseColor(Color.rgb(230, 230, 250));
		initializeCellColor();
		this.img = new Img();
//		this.bgImage = new BackgroundImage[]{};
//		this.bgFill = new BackgroundFill[]{};
		this.bgSize = new BackgroundSize(80,80,false,false,false,false);

		this.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
			public void handle(MouseEvent e) {
					onClickHandler();
			}
		});
	}

	private void onClickHandler()  {
		draw(new Image(ClassLoader.getSystemResource(oURL).toString()),new Image(ClassLoader.getSystemResource(xURL).toString()), Color.AQUA);
//		System.out.println(GameController.getInstance().getGameMap().getLandmarkArrayList());
	}

	public void initializeCellColor() {
		this.setDrawn(false);
		setBackground(new Background(new BackgroundFill(baseColor,null,null)));
	}



	public void draw(Image image,Image image2 , Color backgroundColor) {
//		getChildren().add(button);
//		getChildren().remove(button);
		BackgroundFill bgFill = new BackgroundFill(Color.BLUE, CornerRadii.EMPTY, Insets.EMPTY);
		BackgroundFill[] bgFillA = {bgFill};
//		BackgroundSize bgSize = new BackgroundSize(80,80,false,false,false,false);
//		this.setBackground(new Background(bgFillA));
		BackgroundImage bgImg = new BackgroundImage(image, null, null, null, bgSize);
		BackgroundImage bgImgฺ2 = new BackgroundImage(image2, null, null, null, bgSize);

		BackgroundImage[] bgImgA = {img.getImgNothing(),img.getImgNothing(),img.getImgNothing(),img.getImgNothing()};
		bgImgA[2] = img.getImgKey();
		this.setBackground(new Background(bgFillA,bgImgA));
		this.setDrawn(true);
	}

	public void setImage(BackgroundImage A, BackgroundImage B, BackgroundImage C, BackgroundImage D, Color color) {
		BackgroundFill bgFill = new BackgroundFill(color, CornerRadii.EMPTY, Insets.EMPTY);
		BackgroundFill[] bgFillX = {bgFill};
		BackgroundImage[] bgImgX = {img.getImgNothing(),img.getImgNothing(),img.getImgNothing(),img.getImgNothing()};
		if (A != null) {
			bgImgX[0] = A;
		}
		if (B != null) {
			bgImgX[1] = B;
		}
		if (C != null) {
			bgImgX[2] = C;
		}
		if (D != null) {
			bgImgX[3] = D;
		}
		this.setBackground(new Background(bgFillX, bgImgX));
	}

	public boolean isDrawn() {
		return isDrawn;
	}

	public void setDrawn(boolean isDrawn) {
		this.isDrawn = isDrawn;
	}

	public int getxPosition() {
		return xPosition;
	}

	public void setxPosition(int xPosition) {
		this.xPosition = xPosition;
	}

	public int getyPosition() {
		return yPosition;
	}

	public void setyPosition(int yPosition) {
		this.yPosition = yPosition;
	}

	public Color getBaseColor() {
		return baseColor;
	}

	public void setBaseColor(Color baseColor) {
		this.baseColor = baseColor;
	}

	public void setGameController(GameController gameController) {
		this.gameController = gameController;
	}
}
