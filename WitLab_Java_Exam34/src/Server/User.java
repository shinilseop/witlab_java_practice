package Server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

import Client.LogWriter;

public class User extends Thread {

	String name;
	Socket s;
	TcpServer ts;

	InputStream is;
	DataInputStream dis;
	OutputStream os;
	DataOutputStream dos;

	boolean isOut;
	LogWriter lw;
	DBMS dbms;

	public User(String name, Socket s, TcpServer ts, LogWriter lw) {
		this.name = name;
		this.s = s;
		this.ts = ts;
		try {
			is = s.getInputStream();
			dis = new DataInputStream(is);
			os = s.getOutputStream();
			dos = new DataOutputStream(os);
			isOut = false;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.lw = lw;
		dbms = new DBMS();
	}

	public void run() {
		while (true) {
			try {
				if (isOut) {
					ts.userList.remove(name);
					for (int i = 0; i < ts.userName.size(); i++) {
						if (ts.userName.get(i).equals(name)) {
							ts.userName.remove(i);
							break;
						}
					}
					break;
				} else {
					String msg = dis.readUTF();
					System.out.println("Client : " + msg);
					String tmp[] = msg.split(" ");
					if (tmp[0].equals("/msg")) {
						String content=msg.substring(5);
						ts.sendMsg("/msg " + name + " : " + content);
						lw.write(name + " : " + content);
						dbms.insert("insert into chat_log values ('"+name+"', '"+content+"', now())");
					} else if (tmp[0].equals("/out")) {
						ts.sendMsg("/server " + name + "이(가) 나갔습니다.");
						lw.write(name + "이(가) 나갔습니다.");
						String content="이(가) 나갔습니다.";
						dbms.insert("insert into chat_log values ('"+name+"', '"+content+"', now())");
						isOut = true;
					}
				}
			} catch (IOException e) {
				break;
			}
		}
	}
}
