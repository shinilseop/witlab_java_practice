package Exam02;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class UI extends JFrame implements ActionListener, Runnable {

	JPanel jpGame;
	JLabel jlPig;
	JButton jbThrow;
	JLabel jlArrow;

	UpdateThings update;

	Pig p;

	Container ct;

	UI() {
		// Middle
		jpGame = new JPanel(null);

		jlPig = new JLabel(new ImageIcon("pig_alive.png"));
		jlPig.setBounds(238, 5, 124, 94);

		// Bottom
		jbThrow = new JButton("던지기");
		jbThrow.addActionListener(this);

		// Container
		ct = getContentPane();
		ct.setLayout(new BorderLayout());
		ct.add(jpGame, BorderLayout.CENTER);
		ct.add(jbThrow, BorderLayout.SOUTH);

		setTitle("다트 게임	");
		setSize(600, 600);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Middle
		jpGame.add(jlPig);
	}

	public void OpenGame() {
		setVisible(true);
		p = new Pig(jpGame, 238, 5, 140, 100, jlPig);
		p.start();
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		Object o = arg0.getSource();
		if (o == jbThrow && !p.isCatch) {
			jlArrow = new JLabel(new ImageIcon("arrow.png"));
			jlArrow.setBounds(285, 420, 30, 110);
			jpGame.add(jlArrow);
			new Arrow(jpGame, 285, 420, 30, 110, jlArrow, p).start();

		}
	}
	
	public void run() {
		while(true) {
			if(p.isCatch) {
				jbThrow.setEnabled(false);
				break;
			}
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
