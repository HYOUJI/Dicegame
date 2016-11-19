package youji.hansung.dicegame.model;

import org.springframework.stereotype.Component;

@Component
public class Cell {
	int cell [];
	
	public Cell() {
		cell = new int[30];
		for(int i=0; i<=29; i++) cell[i] = i;
	}
	
	public int[] getCell() {
		return cell;
	}
	
	public void setCell(int[] cell) {
		this.cell = cell;
	}
}
