package DBMSTest;

public class Main {
	public static void main(String args[]) {
		DBMS dbms=new DBMS();
		String sql="insert into user values ('shin', '1234', '신일섭', 'shin@naver.com')";
		dbms.regist(sql);
	}
}
