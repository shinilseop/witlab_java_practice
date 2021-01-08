package JAVA_02_last;

import javax.swing.JLabel;

public class Timer extends Thread {
	int time;
	JLabel label;
	Character c;

	Timer(JLabel label, Character c) {
		time = 60;
		this.label = label;
		this.c = c;
	}

	public void run() {
		while (time > 0) {
			if (c.getScore() == 15 || time==0) {
				label.setText("your score : " + c.getScore());
				c.setEnd(true);
				break;
			}
			label.setText("남은시간 : " + time + "초, score : " + c.getScore());
			time--;
			try {
				sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
