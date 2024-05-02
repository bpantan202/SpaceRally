package GUI;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class ControlPane extends VBox{
	
	private Text gameText;
	private Button leftButton;
	private Button rightButton;
	private Button upButton;
	private Button downButton;
	
	public ControlPane() {
		super();
		setAlignment(Pos.BOTTOM_RIGHT);
		setPrefWidth(300);
		setSpacing(20);
		initializeGameText();
		initializeLeftButton();
		initializeRightButton();
		initializeUpButton();
		initializeDownButton();

		getChildren().addAll(gameText,leftButton,rightButton,upButton,downButton);

	}
	
	private void initializeGameText() {
		gameText=new Text("Chose walk");
		gameText.setFont(new Font(35));

	}
	
	public void updateGameText(String text) {
		gameText.setText(text);
	}
	
	private void initializeLeftButton() {
		this.leftButton=new Button("Left");
		leftButton.setPrefWidth(100);
		leftButton.setOnAction(e->newLeftButtonHandler());
	}
	private void initializeRightButton() {
		this.rightButton=new Button("Right");
		rightButton.setPrefWidth(100);
		rightButton.setOnAction(e->newRightButtonHandler());
	}

	private void initializeUpButton() {
		this.upButton=new Button("Up");
		upButton.setPrefWidth(100);
		upButton.setOnAction(e->newUpButtonHandler());
	}
	private void initializeDownButton() {
		this.downButton=new Button("Down");
		downButton.setPrefWidth(100);
		downButton.setOnAction(e->newDownButtonHandler());
	}
	private void newLeftButtonHandler() {
		updateGameText("Left");
	}
	private void newRightButtonHandler() {
		updateGameText("Right");
	}
	private void newUpButtonHandler() {
		updateGameText("Up");
	}
	private void newDownButtonHandler() {
		updateGameText("Down");
	}

	public void setValidButton(boolean left, boolean right, boolean up, boolean down) {
		if(left) { leftButton.setDisable(false); }
		else { leftButton.setDisable(true); }
		if(right) { rightButton.setDisable(false); }
		else { rightButton.setDisable(true); }
		if(up) { upButton.setDisable(false); }
		else { upButton.setDisable(true); }
		if(down) { downButton.setDisable(false); }
		else { downButton.setDisable(true); }
	}
	public String getGameText() {
		return gameText.getText();
	}

	public void setGameText(Text gameText) {
		this.gameText = gameText;
	}
}
