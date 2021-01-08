package Server;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class MsgReicever extends Thread {
	int port;
	Ticket t;
	MsgSender ms;

	byte buffer[];
	boolean stop;
	
	DatagramSocket ds;
	DatagramPacket dp;


	MsgReicever(int port, Ticket t, MsgSender ms) {
		this.port = port;
		this.t=t;
		this.ms=ms;
		
		try {
			stop = false;
			ds = new DatagramSocket(port);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public synchronized void stopMR(MsgReicever mr) {
		try {
			mr.wait();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void run() {
		while (true) {
			if (stop) {
				stopMR(this);
			}
			try {
				buffer = new byte[66536];
				dp = new DatagramPacket(buffer, buffer.length);
				ds.receive(dp);
				int id = Integer.parseInt(new String(dp.getData()).replaceAll("[^0-9]", ""));
				if(t.buyTicket(id)) {
					ms.sendMsg("0");
					break;
				} else 
					ms.sendMsg(id+"");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				break;
			}
		}
	}
}
