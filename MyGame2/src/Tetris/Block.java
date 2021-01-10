package Tetris;

import java.util.Random;

public class Block extends Thread {
	int[][] tetris;
	int block_num;
	boolean isLand;
	
	Block(int[][] tetris){
		this.tetris=tetris;
		isLand=false;
		block_num=new Random().nextInt(7)+1;
	}
	
	public void isLand() {
		for(int i=1;i<tetris.length;i++) {
			for(int j=0;j<tetris[0].length;j++) {
				if(tetris[i][j]==1) {
					
				}
			}
		}
	}
	
	public void run() {
		while(isLand) {
			
		}
	}
}
