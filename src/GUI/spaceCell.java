package GUI;

import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
//import logic.GameLogic;

public class spaceCell extends Pane {

	private boolean isDrawn;
	private Color baseColor;

	private int xPosition;
	private int yPosition;
	private String oURL;
	private String xURL;
	private Button button=new Button();

	public spaceCell(int x, int y) {
		super();
		this.oURL = "o.png";
		this.xURL = "x.png";
		this.setxPosition(x);
		this.setyPosition(y);
		setPrefSize(80, 80);
		setBaseColor(Color.rgb(230, 230, 250));
		initializeCellColor();

		this.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
			public void handle(MouseEvent e) {
					onClickHandler();
			}
		});
	}

	private void onClickHandler()  {

	}

	public void initializeCellColor() {
		this.setDrawn(false);
		setBackground(new Background(new BackgroundFill(baseColor,null,null)));
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


}
