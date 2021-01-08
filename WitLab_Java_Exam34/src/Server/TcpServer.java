package Server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;

import Client.LogWriter;

public class TcpServer extends Thread {
	
	ServerSocket ss;
	Socket s;
	ArrayList<String> userName;
	HashMap<String, User> userList;
	
	int cnt;
	String name;
	LogWriter lw;

	public TcpServer(int port, LogWriter lw) {
		try {
			ss = new ServerSocket(port);
			userName=new ArrayList<>();
			userList = new HashMap<>();
			cnt = 1;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.lw=lw;
	}

	public void sendMsg(String msg) {
		for (String str : userName) {
			try {
				User user = userList.get(str);
				user.dos.writeUTF(msg);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void run() {
		while (true) {
			try {
				s = ss.accept();
				System.out.println("Connect "+s);
				name = "User" + cnt++;
				User user = new User(name, s, this, lw);
				userList.put(name, user);
				userName.add(name);
				user.start();
				user.dos.writeUTF("/name "+name);//접속하면 이름전달
				sendMsg("/server "+name+"이(가) 접속하였습니다.");
				lw.write(name+"이(가) 접속하였습니다.");
				String content="이(가) 접속하였습니다.";
				new DBMS().insert("insert into chat_log values ('"+name+"', '"+content+"', now())");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
