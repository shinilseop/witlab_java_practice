package UI;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import Main.Main;
import Tetris.Tetris;

public class UpdateBoard extends Thread {
	JPanel board;
	JLabel jlBlock[][];
	JLabel jlNext;
	JLabel jlScore;
	JLabel jlTimer;
	
	ImageIcon iiBlock[];
	ImageIcon iiBlockFull[];
	Tetris t;

	UpdateBoard(JPanel board, JLabel jlBlock[][], JLabel jlNext, JLabel jlScore, JLabel jlTimer, Tetris t) {
		this.board = board;
		this.jlBlock = jlBlock;
		this.jlNext = jlNext;
		this.jlScore = jlScore;
		this.jlTimer = jlTimer;
		this.t = t;
		iiBlock = new ImageIcon[9];
		iiBlockFull=new ImageIcon[9];
		iiBlock[0] = scaledImage("image/black_block.png");
		iiBlock[1] = scaledImage("image/blue_block.png");
		iiBlock[2] = scaledImage("image/green_block.png");
		iiBlock[3] = scaledImage("image/orange_block.png");
		iiBlock[4] = scaledImage("image/purple_block.png");
		iiBlock[5] = scaledImage("image/red_block.png");
		iiBlock[6] = scaledImage("image/sky_block.png");
		iiBlock[7] = scaledImage("image/yellow_block.png");
		iiBlock[8] = scaledImage("image/grey_block.png");
		iiBlockFull[0] = scaledImage2("image/black_block.png");
		iiBlockFull[1] = scaledImage2("image/blue_block_full.png");
		iiBlockFull[2] = scaledImage2("image/green_block_full.png");
		iiBlockFull[3] = scaledImage2("image/orange_block_full.png");
		iiBlockFull[4] = scaledImage2("image/purple_block_full.png");
		iiBlockFull[5] = scaledImage2("image/red_block_full.png");
		iiBlockFull[6] = scaledImage2("image/sky_block_full.png");
		iiBlockFull[7] = scaledImage2("image/yellow_block_full.png");
		iiBlockFull[8] = scaledImage2("image/grey_block.png");
		Main.isRun=true;
	}
	
	public ImageIcon scaledImage(String File) {
		Image iTmp=new ImageIcon(File).getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
		return new ImageIcon(iTmp);
	}

	public ImageIcon scaledImage2(String File) {
		Image iTmp=new ImageIcon(File).getImage().getScaledInstance(150, 100, Image.SCALE_SMOOTH);
		return new ImageIcon(iTmp);
	}
	
	public void run() {
		while (Main.isRun) {
			for (int i = 2; i < t.sum.length; i++) {
				for (int j = 0; j < t.sum[0].length; j++) {
					jlBlock[i-2][j].setIcon(iiBlock[t.sum[i][j]]);
				}
			}
			jlNext.setIcon(iiBlockFull[t.next]);
			jlScore.setText("Score : "+t.score);
			
			jlTimer.setText("time : "+t.timer.time);
			board.revalidate();
			board.repaint();
			try {
				sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		// 게임오버이후 정렬(현재 블록이 위에 남아있을수도 있어서)
		for (int i = 2; i < t.tetris.length; i++) {
			for (int j = 0; j < t.tetris[0].length; j++) {
				jlBlock[i - 2][j].setIcon(iiBlock[t.tetris[i][j]]);
			}
		}
		jlTimer.setText("time : "+t.timer.time);
		jlScore.setText("Score : "+t.score);
		board.revalidate();
		board.repaint();

		JOptionPane jopRegist=new JOptionPane();
		JOptionPane.showMessageDialog(null, "Score : "+t.score, "게임 오버!", JOptionPane.INFORMATION_MESSAGE);
	}
}
