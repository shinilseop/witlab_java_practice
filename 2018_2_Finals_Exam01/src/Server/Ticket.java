package Server;

import javax.swing.JTextArea;

public class Ticket {
	private int ticket;
	JTextArea jtaLog;
	
	Ticket(int ticket, JTextArea jtaLog){
		this.ticket=ticket;
		this.jtaLog=jtaLog;
	}
	
	public synchronized boolean buyTicket(int id) {
		if(ticket==0) {
			jtaLog.append("티켓이 완판되었습니다!");
			return true;
		} else {
			jtaLog.append(id+":티켓을 구매했습니다.(남은 개수 : "+--ticket+")\n");
			return false;
		}
	}

	public synchronized int getTicket() {
		return ticket;
	}
}
