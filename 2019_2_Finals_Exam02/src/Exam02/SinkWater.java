package Exam02;

import javax.swing.JLabel;
import javax.swing.JTextArea;

public class SinkWater extends Thread {
	
	Water w;
	UI ui;
	
	SinkWater(Water w, UI ui){
		this.w=w;
		this.ui=ui;
	}
	
	public synchronized void sinkWater() {
		w.setWater(w.getWater()-100);
		String sink="100ml 빠짐, "+w.getWater()+"ml 남음\n";
		String water=w.getWater()+"";
		int value=Integer.parseInt(water)/20;
		ui.sinkWater(sink, water, value);
	}
	
	public synchronized void stopThis(SinkWater sw) {
		try {
			sw.wait();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void run() {
		while(true) {
			try {
				if(w.getWater()==2000) {
					ui.win();
				}
				sinkWater();
				if(w.getWater()==0) {
					ui.lose();
				}
				sleep(500);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				break;
			}
		}
	}
}
