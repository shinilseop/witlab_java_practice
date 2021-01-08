package Exam01_Server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JTextArea;

public class ServerThread extends Thread {
	ServerSocket ss;
	Socket s;
	JTextArea log;
	
	ServerThread(int port, JTextArea log){
		try {
			ss=new ServerSocket(port);
			this.log=log;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void run() {
		while(true) {
			try {
				s=ss.accept();
				new User(s, log).start();
			} catch (IOException e) {
				break;
			}
		}
	}
}
