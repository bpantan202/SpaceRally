package GUI;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

import java.util.ArrayList;

public class SpacePane extends GridPane{
	
	private ArrayList<SpaceCell> allCells;
	
	public SpacePane() {
		super();
		this.allCells = new ArrayList<SpaceCell>();
		this.setHgap(10);
		this.setVgap(10);
		this.setPadding(new Insets(20));
		this.setAlignment(Pos.CENTER);
		this.setPrefWidth(1000);
		this.setPrefHeight(500);
		this.setBorder(new Border(new BorderStroke(Color.LIGHTGRAY, BorderStrokeStyle.SOLID, 
				CornerRadii.EMPTY, BorderWidths.DEFAULT)));
		this.setBackground(new Background(new BackgroundFill(null, CornerRadii.EMPTY, Insets.EMPTY)));
		
		for(int i = 0;i<10;i++) {
			for(int j =0;j<7;j++) {
				this.allCells.add(new SpaceCell(i,j));
				this.add(allCells.get((i*7)+j), i, j);
				//System.out.println("help");
			}
		}
	}

	public ArrayList<SpaceCell> getAllCells() {
		return allCells;
	}
	
	
}
