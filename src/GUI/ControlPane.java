package GUI;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

import static java.awt.Font.BOLD;

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
		setSpacing(10);
		initializeGameText();
		initializeLeftButton();
		initializeRightButton();
		initializeUpButton();
		initializeDownButton();

		HBox leftRightBox = new HBox(70);
		leftRightBox.getChildren().add(leftButton);
		leftRightBox.getChildren().add(rightButton);
		leftRightBox.setAlignment(Pos.CENTER_RIGHT);
		VBox.setMargin(leftRightBox, new Insets(0, 20, 0, 0));

		getChildren().addAll(gameText,upButton,leftRightBox,downButton);
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
		leftButton.setPrefSize(50,50);
		leftButton.setOnAction(e->newLeftButtonHandler());
		leftButton.setStyle("-fx-text-fill: blue");
	}
	private void initializeRightButton() {
		this.rightButton=new Button("Right");
		rightButton.setPrefSize(50,50);
		rightButton.setOnAction(e->newRightButtonHandler());
		rightButton.setStyle("-fx-text-fill: blue");
	}

	private void initializeUpButton() {
		this.upButton=new Button("Up");
		upButton.setPrefSize(50,50);
		upButton.setOnAction(e->newUpButtonHandler());
		upButton.setStyle("-fx-text-fill: blue");
		VBox.setMargin(upButton, new Insets(0, 80, 0, 0));
	}
	private void initializeDownButton() {
		this.downButton=new Button("Down");
		downButton.setPrefSize(50,50);
		downButton.setOnAction(e->newDownButtonHandler());
		downButton.setStyle("-fx-text-fill: blue");
		VBox.setMargin(downButton, new Insets(0, 80, 20, 0));
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
}
