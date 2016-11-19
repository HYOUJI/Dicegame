package youji.hansung.dicegame.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import youji.hansung.dicegame.dao.ScoreDAO;
import youji.hansung.dicegame.model.Scores;

public class ScoreService {

	@Autowired
	Scores scores;
	@Autowired
	ScoreDAO scoreDAO;
	
	public Scores initScore(String playerId) throws Exception {
		Scores score = scoreDAO.selectScore(playerId);
		if(score == null) {
			score = new Scores().setName(playerId).setWin(0).setLose(0).setDraw(0);
			scoreDAO.insertScore(score);
		}		
		return score;
	}
	
	public List<Scores> scoreView() throws Exception {
		List<Scores> scores = scoreDAO.selectAllScores();
		return scores;
	}
	
	public void updateScore(Scores score) throws Exception {
		scoreDAO.update(score);
	}
}
