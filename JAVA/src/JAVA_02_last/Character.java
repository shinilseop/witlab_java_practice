package JAVA_02_last;

public class Character {
	private int x;
	private int score;
	private boolean end=false;
	
	Character(int x){
		this.x=x;
		this.score=0;
	}

	public int getX() {
		return x;
	}

	public synchronized void setX(int x) {
		this.x = x;
	}

	public int getScore() {
		return score;
	}

	public synchronized void setScore(int score) {
		this.score = score;
	}

	public boolean isEnd() {
		return end;
	}

	public synchronized void setEnd(boolean end) {
		this.end = end;
	}
}
