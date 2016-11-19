package youji.hansung.dicegame.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Component
public class Status {

	@Autowired
	@Qualifier("playerDice")
	private Dice r1;
	@Autowired
	@Qualifier("alphaDice")
	private Dice r2;
	
	private int playerValue;
	private int alphaValue;
	private int[] cell;
	
	private int curCellForPlayer;
	private int curCellForAlpha;
	
}
