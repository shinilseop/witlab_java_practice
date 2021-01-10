package TimerTest;

import javax.swing.JLabel;

public class TimerThread extends Thread {
	JLabel label;
	int num;
	int time;
	
	public TimerThread(JLabel label, int num) {
		this.label=label;
		this.num=num;
		time=0;
	}
	
	public void run() {
		while(true) {
			label.setText(num+" 시간 : "+time);
			try {
				sleep(1000);
			}catch(Exception e) {
				
			}
			time++;
		}
	}
}
