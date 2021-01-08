package UI;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class TitleUI extends UI implements Runnable {
	Font font;

	ImageIcon iiBack;
	JLabel jlPress, jlBack;

	public TitleUI(Container ct) {
		font = new Font("굴림", Font.BOLD, 15);
		iiBack = new ImageIcon("image/TetrisTitle.png");

		jlPress = new JLabel("Press Any Key");
		jlPress.setFont(font);
		jlPress.setForeground(Color.white);
		jlPress.setBounds(200, 330, 200, 50);
		jlBack = new JLabel(iiBack);
		jlBack.setBounds(0, 0, 512, 388);

		ct.setLayout(null);
		ct.add(jlPress);
		ct.add(jlBack);

		isStart = true;

		new Thread(this).start();
	}

	public void run() {
		boolean pressVisible = true;
		int timer = 0;
		while (true) {
			if (isStart) {
				if (timer == 750) {
					jlPress.setVisible(!pressVisible);
					pressVisible = !pressVisible;
					timer=0;
				} else {
					timer++;
				}
				try {
					Thread.sleep(1);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else {
				System.out.println("out");
				break;
			}
		}
	}
}
