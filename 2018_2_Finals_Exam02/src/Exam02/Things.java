package Exam02;

import javax.swing.JLabel;

public class Things extends Thread {
	int x, y;
	int sizeX, sizeY;
	boolean isCatch, isRun;
	
	
	Things(int x, int y, int sizeX, int sizeY){
		this.x=x;
		this.y=y;
		this.sizeX=sizeX;
		this.sizeY=sizeY;
		isCatch=false;
		isRun=true;
	}
}
