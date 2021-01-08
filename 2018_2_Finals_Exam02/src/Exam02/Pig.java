package Exam02;

import java.util.Random;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class Pig extends Things {

	boolean goLeft;

	Pig(JPanel game, int x, int y, int sizeX, int sizeY, JLabel image) {
		super(x, y, sizeX, sizeY);
		goLeft = false;
		new UpdateThings(game, image, this, true).start();
	}

	public void run() {
		Random r = new Random();

		while (true) {
			if (!isCatch) {
				int move = r.nextInt(30) + 20;
				if (goLeft) {
					if (x - move <= 0) {
						x = 0;
						goLeft = false;
					} else {
						x -= move;
					}
				} else {
					if (x + move >= 465) {
						x = 465;
						goLeft = true;
					} else {
						x += move;
					}
				}
			} else {
				break;
			}
			try {
				sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		isRun=false;
	}
}
