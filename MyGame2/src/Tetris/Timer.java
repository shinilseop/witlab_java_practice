package Tetris;

public class Timer extends Thread {
	public int time;
	
	public Timer(){
		time=0;
	}

	public void run() {
		while (true) {
			time++;
			try {
				sleep(1000);
			} catch (Exception e) {

			}
		}
	}
}
