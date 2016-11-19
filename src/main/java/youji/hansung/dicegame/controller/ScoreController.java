package youji.hansung.dicegame.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import youji.hansung.dicegame.model.Scores;
import youji.hansung.dicegame.service.ScoreService;

@Controller
public class ScoreController {
	
	@Autowired
	ScoreService scoreService;
	
	@RequestMapping(value="/scoreview", method=RequestMethod.GET)
	public String scoreView(Model model) throws Exception {
		List<Scores> scores = scoreService.scoreView();
		model.addAttribute("scores", scores);
		return "scoreView";
	}
}
