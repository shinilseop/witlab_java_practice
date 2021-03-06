package TimerTest;

import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class Timer extends JFrame {
	Font font;
	
	JLabel timer1, timer2;
	TimerThread t1,t2;
	
	public Timer() {
		font=new Font("굴림", Font.BOLD, 15);
		
		timer1=new JLabel("1타임 : ");
		timer2=new JLabel("2타임 : ");

		t1=new TimerThread(timer1, 1);
		t2=new TimerThread(timer2, 2);
		
		Container ct=getContentPane();
		ct.setLayout(new GridLayout(1,2));
		ct.add(timer1);
		ct.add(timer2);
		
		setTitle("Timer Test");
		setSize(300,100);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
		t1.start();
		t2.start();
	}
}
