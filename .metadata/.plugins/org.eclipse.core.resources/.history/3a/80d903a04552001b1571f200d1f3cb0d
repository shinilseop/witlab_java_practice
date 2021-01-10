package UI;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;

public class SelectUI extends UI implements KeyListener {
	private final int MENU_COUNT=3;
	Font font;
	LineBorder lbSelect;
	
	JLabel jlMenu[];
	String strMenu[]={"Game Start", "How To Play", "Score Board"};
	Container ct;
	
	int menu;

	public SelectUI() {
		font = new Font("굴림", Font.BOLD, 30);
		lbSelect=new LineBorder(Color.black, 2);
		
		jlMenu=new JLabel[MENU_COUNT];
		for(int i=0;i<MENU_COUNT;i++) {
			jlMenu[i]=new JLabel(strMenu[i]);
			jlMenu[i].setFont(font);
			jlMenu[i].setForeground(Color.black);
		}
		jlMenu[0].setBorder(lbSelect);

		menu=0;

		ct = getContentPane();
		ct.setLayout(new GridLayout(2, 1));
		for(int i=0;i<MENU_COUNT;i++) {
			ct.add(jlMenu[i]);
		}

		addKeyListener(this);
		setFocusable(true);
		setTitle("Select");
		setSize(400, 200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	public void upMenu() {
		jlMenu[menu].setBorder(null);
		if(menu==0) {
			menu=MENU_COUNT-1;
		} else {
			menu--;
		}
		jlMenu[menu].setBorder(lbSelect);
	}
	
	public void downMenu() {
		jlMenu[menu].setBorder(null);
		if(menu==2) {
			menu=0;
		} else {
			menu++;
		}
		jlMenu[menu].setBorder(lbSelect);
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if (e.getKeyChar() == KeyEvent.VK_UP) {
			upMenu();
		} else if (e.getKeyChar() == KeyEvent.VK_DOWN) {
			downMenu();
		} else if (e.getKeyChar() ==KeyEvent.VK_ENTER) {
			
		}
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
