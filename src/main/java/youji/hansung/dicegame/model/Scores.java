package youji.hansung.dicegame.model;

import org.springframework.stereotype.Component;

import lombok.Getter;

@Component
@Getter
public class Scores {
	private String name;
	private int win;
	private int lose;
	private int draw;
	
	public Scores setName(String name) {
		this.name = name;
		return this;
	}

	public Scores setWin(int win) {
		this.win = win;
		return this;
	}
	
	public Scores setLose(int lose) {
		this.lose = lose;
		return this;
	}
	
	public Scores setDraw(int draw) {
		this.draw = draw;
		return this;
	}
}