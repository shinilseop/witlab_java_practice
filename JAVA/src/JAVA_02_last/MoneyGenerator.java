package JAVA_02_last;

import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MoneyGenerator extends Thread {
	JPanel panel;
	Character c;
	MoneyGenerator(JPanel panel, Character c){
		this.panel=panel;
		this.c=c;
	}
	public void run() {
		Random r=new Random();
		while(true) {
			if(c.isEnd()) {
				break;
			}
			Money m = new Money(r.nextInt(405)+5, 20, panel, c);
			m.start();
			try {
				sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
