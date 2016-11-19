package youji.hansung.dicegame.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import youji.hansung.dicegame.model.Status;
import youji.hansung.dicegame.model.WinningStatus;

@Service
public class DiceService {
	
	@Autowired
	Status status;
	final private int Goal = 29;
	
	public void initGame() {
		status.setAlphaValue(0);
		status.setCell(new int[30]);
		status.setCurCellForAlpha(0);
		status.setCurCellForPlayer(0);
		status.setPlayerValue(0);
		
		int cell[] = status.getCell();
		for(int i=0; i<30; i++) {
			cell[i] = i;
		}
		
	}

	public WinningStatus rollingDice() {
		int playerValue = status.getR1().roll();
		int alphaValue = status.getR2().roll();
		
		int curCellForPlayer = status.getCurCellForPlayer() + playerValue;
		int curCellForAlpha = status.getCurCellForAlpha() + alphaValue;
		
		status.setPlayerValue(playerValue);
		status.setAlphaValue(alphaValue);
		
		status.setCurCellForPlayer(curCellForPlayer);
		status.setCurCellForAlpha(curCellForAlpha);
		
		if(curCellForPlayer > Goal && curCellForAlpha > Goal) return WinningStatus.Draw;
		else if(curCellForPlayer > Goal && curCellForAlpha <= Goal) return WinningStatus.Player;
		else if(curCellForPlayer <=Goal && curCellForAlpha > Goal) return WinningStatus.Alpha;
		else return WinningStatus.NotYet;
	}
}
