package UI;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;

public class SelectUI extends UI {
	Font font;

	JLabel jlStart, jlHow;


	public SelectUI(Container ct) {
		font = new Font("굴림", Font.BOLD, 30);

		jlStart = new JLabel("Game Start");
		jlStart.setFont(font);
		jlStart.setForeground(Color.black);
		jlStart.setBorder(new LineBorder(Color.black, 2));

		jlHow = new JLabel("How To Play");
		jlHow.setFont(font);
		jlHow.setForeground(Color.black);

		isStart = true;

		ct.setLayout(new GridLayout(2, 1));
		ct.add(jlStart);
		ct.add(jlHow);
	}
	
	public void moveMenu() {
		if (isStart) {
			isStart = false;
			jlStart.setBorder(null);
			jlHow.setBorder(new LineBorder(Color.black, 2));
		} else {
			isStart = true;
			jlHow.setBorder(null);
			jlStart.setBorder(new LineBorder(Color.black, 2));
		}
	}
}
