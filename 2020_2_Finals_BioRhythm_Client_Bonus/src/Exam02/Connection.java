package Exam02;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Connection extends Thread {
	Socket s;
	
	ValueProcess vp;
	
	InputStream is;
	DataInputStream dis;
	OutputStream os;
	DataOutputStream dos;
	
	Connection(String ip, int port, UI ui){
		try {
			s=new Socket(ip, port);
			is=s.getInputStream();
			dis=new DataInputStream(is);
			os=s.getOutputStream();
			dos=new DataOutputStream(os);
			vp=new ValueProcess(ui);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void sendMsg(String msg) {
		try {
			dos.writeUTF(msg);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void run() {
		while(true) {
			try {
				String msg=dis.readUTF();
				System.out.println("Server : "+msg);
				vp.write(msg);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				break;
			}
		}
	}
}