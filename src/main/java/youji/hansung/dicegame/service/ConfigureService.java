package youji.hansung.dicegame.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import youji.hansung.dicegame.model.Cell;
import youji.hansung.dicegame.model.Status;

@Service
public class ConfigureService {
	
	@Autowired
	Status status;
	@Autowired
	Cell cell;
	
	public void initConfigure() {
		int tmpCell[]  = cell.getCell();
		
		for(int i=0; i<tmpCell.length; i++){
			tmpCell[i] = i;
		}
	}
	
	public void setConfigure(int originalCell, int replacedCell) {
		int tmpCell[] = cell.getCell();

		tmpCell[originalCell] = replacedCell;
		cell.setCell(tmpCell);		
		status.setCell(cell.getCell());
	}
	
}
