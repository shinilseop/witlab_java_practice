package DBMS;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DBMS {
	private final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	private final String DB_URL = "jdbc:mysql://localhost:3306/Tetris";

	private final String USER_NAME = "root";
	private final String PASSWORD = "1234";

	Connection conn;
	Statement stmt;

	public DBMS() {
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
			System.out.println("[ DBMS Connection ]");
			stmt = conn.createStatement();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("DB Connection Error");
		}
	}

	public ArrayList<Score> selectScore() {
		ArrayList<Score> scoreList = new ArrayList<>();
		try {
			ResultSet rs = stmt.executeQuery("select * from score order by score desc");
			while (rs.next() && scoreList.size()<10) {
				Score score = new Score();
				score.setId(rs.getString("id"));
				score.setScore(rs.getInt("score"));
				score.setTime(rs.getString("time"));
				scoreList.add(score);
				System.out.println(score.getId()+" "+score.getScore()+" "+score.getTime());
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Score Load Error");
		}
		System.out.println("Load Score List");
		return scoreList;
	}

	public boolean login(String id, String pw) {
		System.out.println("Login Try...");
		try {
			ResultSet rs = stmt.executeQuery("select * from user where id='" + id + "'");
			if (rs.next()) {
				if (rs.getString("id").equals(id) && rs.getString("password").equals(pw)) {
					return true;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Login Error");
		}
		return false;
	}

	public int regist(String sql) {
		System.out.println("Regist Try...");
		int update = 0;
		try {
			update = stmt.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Regist Error!");
		}
		return update;
	}
	
	public int record(String sql) {
		System.out.println("Record Try...");
		int update = 0;
		try {
			update = stmt.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Record Score Error");
		}
		System.out.println("Record Complete");
		return update;
	}
}
