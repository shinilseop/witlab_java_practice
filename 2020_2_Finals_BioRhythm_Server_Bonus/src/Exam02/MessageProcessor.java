 package Exam02;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class MessageProcessor extends Thread {
	Socket s;
	InputStream is;
	DataInputStream dis;
	OutputStream os;
	DataOutputStream dos;
	
	Figure_Calculator fc;
	
	MessageProcessor(Socket s){
		try {
			this.s=s;
			is=s.getInputStream();
			dis=new DataInputStream(is);
			os=s.getOutputStream();
			dos=new DataOutputStream(os);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void run() {
		while(true) {
			try {
				String msg=dis.readUTF();
				System.out.println("Client : "+msg);
				fc=new Figure_Calculator(msg.split(" ")[1]);
				if(msg.split(" ")[0].equals("body")) {
					dos.writeUTF(fc.getBody());
				} else if(msg.split(" ")[0].equals("sens")) {
					dos.writeUTF(fc.getSens());
				} else if(msg.split(" ")[0].equals("brain")) {
					dos.writeUTF(fc.getBrain());
				} else if(msg.split(" ")[0].equals("since")) {
					dos.writeUTF(fc.getSince());
				}
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				break;
			}
		}
	}
}
