package youji.hansung.dicegame.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import youji.hansung.dicegame.model.Scores;
import youji.hansung.dicegame.model.Status;
import youji.hansung.dicegame.model.WinningStatus;
import youji.hansung.dicegame.service.DiceService;
import youji.hansung.dicegame.service.ScoreService;

@Controller
public class DiceGameController {
	private String playerId;
	private Scores score;
	
	@Autowired
	DiceService diceService;
	@Autowired
	ScoreService scoreService;
	@Autowired
	Status status;
	
	@RequestMapping(value="/startDiceGame", method=RequestMethod.POST)
	public String startDiceGame(HttpServletRequest request, Model model) throws Exception {
		
		playerId = request.getParameter("playerId");
		
		score = scoreService.initScore(playerId);
		diceService.initGame();
		
		model.addAttribute("playerId", playerId);
		model.addAttribute("playerValue", status.getPlayerValue());
		model.addAttribute("alphaValue", status.getAlphaValue());
		model.addAttribute("curCellForPlayer", status.getCurCellForPlayer());
		model.addAttribute("curcellForAlpha", status.getCurCellForAlpha());
		
		return "playDiceGame";
		
	}
	
	@RequestMapping(value="/rollingDice", method=RequestMethod.POST)
	public String playDiceGame(HttpServletRequest request, Model model) throws Exception {
		WinningStatus resultGame = diceService.rollingDice();
		String resultmsg;
		
		switch(resultGame) {
		case Player:
			scoreService.updateScore(score.setWin(score.getWin()+1));
			resultmsg = "¡Ú " + playerId + " Wins!!!¡Ú";
			model.addAttribute("message", resultmsg);
			model.addAttribute("playerId", playerId);
			model.addAttribute("curCellForPlayer", status.getCurCellForPlayer());
			model.addAttribute("curCellForAlpha", status.getCurCellForAlpha());
			return "resultGame";
		case Alpha:
			scoreService.updateScore(score.setLose(score.getLose()+1));
			resultmsg = "AlphaDice Wins!!!¡Ú";
			model.addAttribute("message", resultmsg);
			model.addAttribute("playerId", playerId);
			model.addAttribute("curCellForPlayer", status.getCurCellForPlayer());
			model.addAttribute("curCellForAlpha", status.getCurCellForAlpha());
			return "resultGame"; 
		case Draw:
			scoreService.updateScore(score.setDraw(score.getDraw()+1));
			resultmsg = "Draw!!!";
			model.addAttribute("message", resultmsg);
			model.addAttribute("playerId", playerId);
			model.addAttribute("curCellForPlayer", status.getCurCellForPlayer());
			model.addAttribute("curCellForAlpha", status.getCurCellForAlpha());
			return "resultGame"; 
		case NotYet:
			model.addAttribute("playerId", playerId);
			model.addAttribute("playerValue", status.getPlayerValue());
			model.addAttribute("alphaValue", status.getAlphaValue());
			model.addAttribute("curCellForPlayer", status.getCurCellForPlayer());
			model.addAttribute("curCellForAlpha", status.getCurCellForAlpha());
			return "playDiceGame";
			
		default: return "playDiceGame";
		}
	}
}
