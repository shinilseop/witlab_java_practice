package TimerTest;

import javax.swing.JLabel;

public class TimerThread2 extends Thread {
	JLabel label;
	int num;
	int time;

	public TimerThread2(JLabel label, int num) {
		this.label = label;
		this.num = num;
		time = 0;
	}

	public void run() {
		int timeTmp = 0;
		while (true) {
			timeTmp++;
			if (timeTmp == 1000) {
				time++;
				timeTmp = 0;
			}
			label.setText(num + " 시간 : " + time);
			try {
				sleep(1);
			} catch (Exception e) {

			}
			time++;
		}
	}
}
