package Client;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class MsgReicever extends Thread {
	int port;

	DatagramSocket ds;
	DatagramPacket dp;

	byte buffer[];
	UI ui;

	MsgReicever(int port, UI ui) {
		this.port = port;
		this.ui=ui;
		try {
			ds = new DatagramSocket(port);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public synchronized void stopThis() {
		try {
			this.wait();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void run() {
		while (true) {
			try {
				buffer = new byte[66536];
				dp = new DatagramPacket(buffer, buffer.length);
				ds.receive(dp);
				int id = Integer.parseInt(new String(dp.getData()).replaceAll("[^0-9]", ""))-1;
				if(id==-1) {
					ui.jtaLog.append("티켓완판\n");
					for(int i=0;i<ui.f.length;i++) {
						ui.f[i].stopThis();
					}
					stopThis();
				} else
					ui.f[id].buyTicket();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				break;
			}
		}
	}
}
