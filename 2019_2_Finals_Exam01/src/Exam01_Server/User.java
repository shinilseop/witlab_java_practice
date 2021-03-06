package Exam01_Server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

import javax.swing.JTextArea;

public class User extends Thread {
	CalendarMaker cm;
	
	Socket s;
	
	InputStream is;
	DataInputStream dis;
	OutputStream os;
	DataOutputStream dos;
	JTextArea log;
	
	User(Socket s, JTextArea log){
		try {
			this.s=s;
			is=s.getInputStream();
			dis=new DataInputStream(is);
			os=s.getOutputStream();
			dos=new DataOutputStream(os);
			this.log=log;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void run() {
		while(true) {
			try {
				String msg=dis.readUTF();
				cm=new CalendarMaker(msg);
				cm.makeCalendar();
				sendCalendar(cm.getCalendar());
				log.append(msg+"\n달력 전송 완료.\n");
			} catch (IOException e) {
				break;
			}
		}
	}
	
	void sendCalendar(String calendar) {
		try {
			dos.writeUTF(calendar);
			s.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
