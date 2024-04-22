package GUI;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

import java.util.ArrayList;

public class spacePane extends GridPane{
	
	private ArrayList<spaceCell> allCells;
	
	public spacePane() {
		super();
		this.allCells = new ArrayList<spaceCell>();
		this.setHgap(8);
		this.setVgap(8);
		this.setPadding(new Insets(8));
		this.setAlignment(Pos.CENTER);
		this.setPrefWidth(1500);
		this.setPrefHeight(800);
		this.setBorder(new Border(new BorderStroke(Color.LIGHTGRAY, BorderStrokeStyle.SOLID, 
				CornerRadii.EMPTY, BorderWidths.DEFAULT)));
		this.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
		
		for(int i = 0;i<10;i++) {
			for(int j =0;j<7;j++) {
				this.allCells.add(new spaceCell(i,j));
				this.add(allCells.get((i*7)+j), i, j);
				//System.out.println("help");
			}
		}
	}

	public ArrayList<spaceCell> getAllCells() {
		return allCells;
	}
	
	
}
