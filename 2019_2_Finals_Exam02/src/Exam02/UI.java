package Exam02;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class UI extends JFrame implements ActionListener, KeyListener {
	Font font;

	JPanel jpTop;
	JLabel jlSink, jlWater, jlFill;

	JPanel jpMiddle;
	JTextArea jtaSink, jtaFill;
	JScrollPane jspSink, jspFill;
	JProgressBar jpbWater;

	JButton jbStart;

	Water w;
	SinkWater sw;
	FillWater fw;
	
	boolean gameRun;

	UI() {
		font = new Font("굴림", Font.BOLD, 13);

		// init_Top
		jpTop = new JPanel(new GridLayout(1, 3));
		jlSink = new JLabel("물 빠짐");
		jlSink.setHorizontalAlignment(JLabel.CENTER);
		jlSink.setFont(font);
		jlWater = new JLabel("1000");
		jlWater.setHorizontalAlignment(JLabel.CENTER);
		jlWater.setFont(font);
		jlFill = new JLabel("물 부음");
		jlFill.setHorizontalAlignment(JLabel.CENTER);
		jlFill.setFont(font);

		// init_Middle
		jpMiddle = new JPanel(new GridLayout(1, 3));
		jtaSink = new JTextArea();
		jtaFill = new JTextArea();
		jpbWater = new JProgressBar();
		jpbWater.setOrientation(JProgressBar.VERTICAL);
		jpbWater.setValue(50);
		jspSink = new JScrollPane(jtaSink);
		jspFill = new JScrollPane(jtaFill);

		// init_Bottom
		jbStart = new JButton("시작");
		jbStart.addActionListener(this);

		// init_Game
		w = new Water(1000);
		gameRun=false;

		// Container
		Container ct = getContentPane();
		ct.setLayout(new BorderLayout());
		ct.add(jpTop, BorderLayout.NORTH);
		ct.add(jpMiddle, BorderLayout.CENTER);
		ct.add(jbStart, BorderLayout.SOUTH);

		addKeyListener(this);
		setFocusable(true);

		setTitle("밑 빠진 독에 물 붓기");
		setSize(600, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);

		// Top
		jpTop.add(jlSink);
		jpTop.add(jlWater);
		jpTop.add(jlFill);

		// Middle
		jpMiddle.add(jspSink);
		jpMiddle.add(jpbWater);
		jpMiddle.add(jspFill);
	}

	public synchronized void fillWater(String fill, String water, int value) {		
		jtaFill.append(fill);
		jlWater.setText(water);
		jpbWater.setValue(value);
	}

	public synchronized void sinkWater(String sink, String water, int value) {
		jtaSink.append(sink);
		jspSink.getVerticalScrollBar().setValue(jspSink.getVerticalScrollBar().getMaximum());
		jlWater.setText(water);
		jpbWater.setValue(value);
	}
	
	public synchronized void lose() {
		jtaSink.append("미션 실패!");
		jspSink.getVerticalScrollBar().setValue(jspSink.getVerticalScrollBar().getMaximum());
		removeKeyListener(this);
		sw.stopThis(sw);
	}
	
	public synchronized void win() {
		jtaFill.append("미션 성공!");
		sw.stopThis(sw);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		if (o == jbStart) {
			sw = new SinkWater(w, this);
			fw = new FillWater(w, this);
			jbStart.setEnabled(false);
			gameRun=true;
			sw.start();
		}
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		if (arg0.getKeyCode() == 32 && gameRun) {
			fw.fillWater();
			if(w.getWater()==2000) {
				removeKeyListener(this);
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
