package DBMSTest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DBMS {
	private final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	private final String DB_URL = "jdbc:mysql://localhost:3306/test";

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
			e.printStackTrace();
		}
	}

	public ArrayList<User> selectScore() {
		ArrayList<User> userList = new ArrayList<>();

		try {
			ResultSet rs=stmt.executeQuery("select * from score");
			
			while(rs.next()) {
				User user=new User();
				user.setName(rs.getString("id"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return userList;
	}
	
	public boolean login(String id, String pw) {
		try {
			ResultSet rs=stmt.executeQuery("select * from id where id=");
			if(rs.getString("id").equals(id) && rs.getString("password").equals(pw)) {
				return true;
			} else {
				return false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	public int regist(String sql) {
		int update=0;
		try {
			update=stmt.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("DBMS update : "+update);
		return update;
	}
}