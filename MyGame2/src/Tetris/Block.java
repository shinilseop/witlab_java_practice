package Tetris;

public class Block extends Thread {
	int[][] tetris;
	BlockIndex bi[];
	int block_num;
	int rotate;
	boolean isLand;

	int block_index[][][] = { { { 0, 0 }, { 0, 0 }, { 0, 0 }, { 0, 0 } }, { { 4, 0 }, { 4, 1 }, { 5, 1 }, { 6, 1 } },
			{ { 5, 0 }, { 6, 0 }, { 4, 1 }, { 5, 1 } }, { { 6, 0 }, { 4, 1 }, { 5, 1 }, { 6, 1 } },
			{ { 5, 0 }, { 4, 1 }, { 5, 1 }, { 6, 1 } }, { { 4, 0 }, { 5, 0 }, { 5, 1 }, { 6, 1 } },
			{ { 3, 0 }, { 4, 0 }, { 5, 0 }, { 6, 0 } }, { { 4, 0 }, { 5, 0 }, { 4, 1 }, { 5, 1 } } };

	Block(int[][] tetris, int block_num) {
		System.out.println("new Block " + block_num);
		this.tetris = tetris;
		isLand = false;
		rotate = 0;
		this.block_num = block_num;
		bi = new BlockIndex[4];
		setIndex();
	}

	public void setIndex() {
		for (int i = 0; i < block_index[0].length; i++) {
			bi[i] = new BlockIndex(block_index[block_num][i][0], block_index[block_num][i][1]);
		}
	}

	public void isLand() {
		for (int i = 0; i < bi.length; i++) {
			if (bi[i].y == 21 || tetris[bi[i].y + 1][bi[i].x] > 0) {
				tetrisMaker();
				isLand = true;
				return;
			}
		}
	}

	public void tetrisMaker() {
		for (int j = 0; j < bi.length; j++) {
			tetris[bi[j].y][bi[j].x] = block_num;
		}
	}

	public void run() {
		while (!isLand) {
			for (int i = 0; i < bi.length; i++) {
				bi[i].y += 1;
			}
			if(!isLand)
				isLand();
			try {
				sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(!isLand)
				isLand();
		}
	}
}
