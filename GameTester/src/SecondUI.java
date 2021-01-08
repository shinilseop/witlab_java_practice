import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class SecondUI extends JFrame implements ActionListener, KeyListener {
	JButton jbChange;
	

	Container ct;
	
	SecondUI(){
		jbChange=new JButton("2번 닫기");
		jbChange.addActionListener(this);
		
		ct=getContentPane();
		ct.setLayout(new GridLayout(1,1));
		ct.add(jbChange);
		addKeyListener(this);
		setFocusable(true);
		
		setTitle("2번");
		setSize(600,300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if(arg0.getSource()==jbChange) {
			setVisible(false);
		}
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		System.out.println("2 "+e.getKeyCode());
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
