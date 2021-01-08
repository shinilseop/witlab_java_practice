package Server;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBMS {
	private final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	private final String DB_URL = "jdbc:mysql://localhost:3306/chat";

	private final String USER_NAME = "root";
	private final String PASSWORD = "1234";

	Connection conn;
	Statement state;
	
	public DBMS() {
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
			System.out.println("[ MySQL Connection ]\n");
			state = conn.createStatement();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	void select(String sql) {
		try {
			ResultSet rs = state.executeQuery(sql);

			while (rs.next()) {
				String id = rs.getString("id");
				String chat_content = rs.getString("chat_content");
				String time = rs.getString("time");
				System.out.println(id + "(" + time + ")" + ":" + chat_content);
			}
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	void insert(String sql) {
		try {
			int result=state.executeUpdate(sql);
			System.out.println("Insert Result="+result);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
