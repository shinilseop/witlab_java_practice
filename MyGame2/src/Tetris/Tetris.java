package Tetris;

import Main.*;

public class Tetris extends Thread {
	public int tetris[][];
	public int score;
	public int time;
	public Block next;
	
	public boolean makeBlock;
	
	public Tetris(){
		tetris=new int[21][10];
		score=0;
		time=0;
		next=new Block();
	}
	
	public void isGameOver() {
		for(int i=0;i<tetris[0].length;i++) {
			if(tetris[0][i]>=0) {
				Main.isRun=false;
			}
		}
	}
	
	public void run() {
		while(Main.isRun) {
			if(makeBlock) {
				
			} else {
				isGameOver();
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