package Exam02;

public class Water {
	private int water;
	
	Water(int water){
		this.water=water;
	}

	public synchronized int getWater() {
		return water;
	}

	public synchronized void setWater(int water) {
		this.water = water;
	}
}
