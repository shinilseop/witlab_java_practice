package Exam02;

import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Arrow extends Things {
	Pig p;
	boolean isCeil;
	JLabel image;
	
	Arrow(JPanel game, int x, int y, int sizeX, int sizeY, JLabel image, Pig p) {
		super(x, y, sizeX, sizeY);
		this.p = p;
		this.image=image;
		new UpdateThings(game, image, this, false).start();
		isCeil = false;
	}

	public void isCatch() {
		if (35<=y && y<=105) {
			if(285<(p.x+135)&&p.x<310) {
				p.isCatch=true;
				isCatch=true;
				try {
					AudioInputStream ais=AudioSystem.getAudioInputStream(new File("hi2.wav"));
					Clip clip=AudioSystem.getClip();
					clip.open(ais);
					clip.start();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}	
			}
		}
	}

	public void isCeil() {
		if (y == 0) {
			isCeil = true;
		}
	}

	public void run() {
		while (true) {
			if (!isCatch && !isCeil) {
				y -= 2;
				isCatch();
				isCeil();
			} else {
				break;
			}
			try {
				sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		isRun=false;
	}
}
