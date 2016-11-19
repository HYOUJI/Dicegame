package youji.hansung.dicegame.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import youji.hansung.dicegame.model.Scores;

@Repository
public class ScoreDAO {

	Connection connection;
	
	public ScoreDAO() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/DiceGame", "root", "mysqlpassword");
	}
	
	public void insertScore(Scores score) throws SQLException {
		PreparedStatement ps = connection.prepareStatement("insert into scores(username,win,lose,draw) value(?,?,?,?)");
		
		ps.setString(1, score.getName());
		ps.setInt(2, score.getWin());
		ps.setInt(3, score.getLose());
		ps.setInt(4, score.getDraw());
		
		ps.executeUpdate();
		ps.close();
		
	}
	
	public List<Scores> selectAllScores() throws Exception {
		Statement st = null;
		ResultSet rs = null;
		
		try {
			st = connection.createStatement();
			rs = st.executeQuery("select * from scores");
			
			ArrayList<Scores> scores = new ArrayList<Scores>();
			
			while(rs.next()) {
				scores.add(new Scores().setName(rs.getString("username")).setWin(rs.getInt("win"))
						.setLose(rs.getInt("lose")).setDraw(rs.getInt("draw")));
			}
			return scores;
			
		} catch (Exception e) {
			throw e;
		} finally {
			try {
				if (rs != null)	rs.close();
			} catch (Exception e) {	}
			try {
				if (st != null) st.close();
			} catch (Exception e) { }
		}
	}
	
	public Scores selectScore(String playerId) throws Exception {
		Statement st = null;
		ResultSet rs = null;
		
		try {
			st = connection.createStatement();
			rs = st.executeQuery(
					"SELECT USERNAME, WIN, LOSE, DRAW FROM SCORES" + " WHERE USERNAME=" + "'" + playerId + "'");
			if (rs.next()) {
				return new Scores().setName(rs.getString("username")).setWin(rs.getInt("win"))
						.setLose(rs.getInt("lose")).setDraw(rs.getInt("draw"));

			} else {
				return null;
			}

		} catch (Exception e) {
			throw e;
		} finally {
			try {
				if (rs != null)	rs.close();
			} catch (Exception e) {	}
			try {
				if (st != null)	st.close();
			} catch (Exception e) {	}
		}
		
		
	}
	
	public int update(Scores score) throws Exception {
		PreparedStatement pst = null;
		String playerId = score.getName();
		
		try {
			pst = connection.prepareStatement(
					"update scores set username=?,win=?,lose=?,draw=? where username=" + "'" + playerId + "'");
			pst.setString(1, score.getName());
			pst.setInt(2, score.getWin());
			pst.setInt(3, score.getLose());
			pst.setInt(4, score.getDraw());

			return pst.executeUpdate();

		} catch (Exception e) {
			throw e;

		} finally {
			try {
				if (pst != null)
					pst.close();
			} catch (Exception e) {
			}
		}
	}
	
	
}
