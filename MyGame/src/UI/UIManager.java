package UI;

import java.awt.Container;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

public class UIManager extends JFrame implements KeyListener {
	UI ui;
	int uiNum;
	Container ct;

	public UIManager() {
		addKeyListener(this);
		setFocusable(true);
		ct = getContentPane();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	public void start() {
		ct.removeAll();
		ui = new TitleUI(ct);

		setTitle("Title");
		setSize(527, 426);

		uiNum = 1;
	}

	public void select() {
		ct.removeAll();
		ui = new SelectUI(ct);

		setTitle("Select");
		setSize(400, 200);

		uiNum = 2;
	}

	public void how() {
		ct.removeAll();
		ui = new HowUI(ct);

		setTitle("Select");
		setSize(350, 300);

		uiNum = 3;
	}

	public void game() {

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		System.out.println(e.getKeyCode());
		if (uiNum == 1) {
			ui.isStart = false;
			select();
			uiNum = 2;
		} else if (uiNum == 2) {
			if (e.getKeyCode() == 38 || e.getKeyCode() == 40) {
				ui.moveMenu();
			} else if (e.getKeyCode() == 10) {
				if (ui.isStart) {
					
				} else {
					how();
					uiNum=3;
				}
			}
		} else if (uiNum == 3) {
			if(e.getKeyCode()==8) {
				select();
				uiNum=2;
			}
		} else if (uiNum == 4) {
			
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
