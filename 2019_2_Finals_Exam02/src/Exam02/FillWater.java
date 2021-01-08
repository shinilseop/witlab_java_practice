package Exam02;

import javax.swing.JLabel;
import javax.swing.JTextArea;

public class FillWater {

	Water w;
	UI ui;
	
	FillWater(Water w, UI ui){
		this.w=w;
		this.ui=ui;
	}
	
	public synchronized void fillWater() {
		w.setWater(w.getWater()+100);
		String fill="100ml 부음\n";
		String water=w.getWater()+"";
		int value=Integer.parseInt(water)/20;
		ui.fillWater(fill, water, value);
	}
}
