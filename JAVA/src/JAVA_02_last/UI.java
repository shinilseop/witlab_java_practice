package JAVA_02_last;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.time.Duration;
import java.time.LocalDateTime;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class UI extends JFrame implements ActionListener, KeyListener {
	Font font;

	JLabel jlScore, jlCh;
	JButton jbStart;
	JPanel jpCenter;
	LocalDateTime ldt;
	Duration d;

	Character c;

	UI() {
		addKeyListener(this);
		setFocusable(true);
		font = new Font("굴림", Font.BOLD, 25);
		jlScore = new JLabel("Get Ready!");
		jlScore.setFont(font);
		jlScore.setHorizontalAlignment(JLabel.CENTER);
		jpCenter = new JPanel();
		jbStart = new JButton("게임 시작!");
		jbStart.addActionListener(this);

		Container ct = getContentPane();
		ct.setLayout(new BorderLayout());
		ct.add(jlScore, BorderLayout.NORTH);
		ct.add(jpCenter, BorderLayout.CENTER);
		ct.add(jbStart, BorderLayout.SOUTH);
		ct.setBackground(Color.white);

		jpCenter.setBackground(Color.white);
		jpCenter.setLayout(null);
		jlCh = new JLabel(new ImageIcon("right.png"));

		jlCh.setBounds(190, 570, 75, 75);
		jpCenter.add(jlCh);

		setTitle("SHOW ME THE MONEY");
		setSize(500, 750);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		if (o == jbStart) {
			System.out.println("게임시작");
			jbStart.setEnabled(false);
			c = new Character(190);
			new MoneyGenerator(jpCenter, c).start();
			new Timer(jlScore, c).start();
		}
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		if(c.isEnd()) {
			removeKeyListener(this);
		}
		if (arg0.getKeyCode() == 37) {
			if (c.getX() > 0) {
				c.setX(c.getX() - 5);
				jlCh.setIcon(new ImageIcon("left.png"));
				jlCh.setBounds(c.getX(), 570, 75, 75);
			}
		}
		if (arg0.getKeyCode() == 39) {
			if (c.getX() < 405) {
				c.setX(c.getX() + 5);
				jlCh.setIcon(new ImageIcon("right.png"));
				jlCh.setBounds(c.getX(), 570, 75, 75);
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

}
