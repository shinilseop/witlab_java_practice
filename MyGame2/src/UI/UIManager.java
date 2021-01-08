package UI;

import java.awt.Container;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

public class UIManager {
	UI ui;
	UIChanger uic;

	public UIManager() {
		uic=new UIChanger() {
			public void changeSelect() {
				ui = new SelectUI();
			}
			public void changeHow() {
				ui = new HowUI();
			}
			public void changeGame() {
				ui = new GameUI();
			}
			public void changeScore() {
				ui = new ScoreUI();
			}
		};
	}

	public void start() {
		ui = new Title();
	}

	public void select() {
		ui = new SelectUI();
	}

	public void how() {
		ui = new HowUI();
	}

	public void game() {

	}
	
	public void score() {

	}

}
