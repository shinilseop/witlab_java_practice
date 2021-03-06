package JAVA_02_last;

import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Money extends Thread {
	int x, y;
	JLabel label;
	Character c;
	JPanel panel;

	Money(int x, int y, JPanel panel, Character c) {
		this.x = x;
		this.y = y;
		this.c = c;
		label = new JLabel(new ImageIcon("money.png"));
		label.setBounds(x, y, 30, 30);
		this.panel=panel;
		panel.add(label);
	}

	public int getX() {
		return x;
	}

	public synchronized void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public synchronized void setY(int y) {
		this.y = y;
	}

	public synchronized void move() {
		label.setBounds(x, y, 30, 30);
	}

	public void run() {
		Random r = new Random();
		while (true) {
			if(c.isEnd()) {
				panel.remove(label);
				break;
			}
			y += (r.nextInt(4) + 1);
			move();
			if (600 >= y && y >= 545 && c.getX() - 40 <= x && x <= c.getX() + 40) {
				c.setScore(c.getScore() + 1);
				panel.remove(label);
				break;
			} else if (y > 620) {
				panel.remove(label);
				break;
			} else {
				try {
					this.sleep(10);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}
