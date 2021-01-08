package Exam02;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class UpdateThings extends Thread {
	JPanel game;
	JLabel image;
	Things t;
	boolean isPig;

	UpdateThings(JPanel game, JLabel image, Things t, boolean isPig) {
		this.game = game;
		this.image = image;
		this.t = t;
		this.isPig = isPig;
	}

	public void run() {
		while (true) {
			if (t.isRun) {
				image.setBounds(t.x, t.y, t.sizeX, t.sizeY);
			} else {
				if (isPig) {
					image.setBounds(t.x, t.y, t.sizeX+20, t.sizeY+20);
					image.setIcon(new ImageIcon("pig_dead.png"));
				} else {
					image.setIcon(null);
				}
				break;
			}
			try {
				sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
