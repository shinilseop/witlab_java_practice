package Rand_arr;

import java.util.ArrayList;
import java.util.Random;

public class Rand_arr_Maker {
	Random r;
	int[] before;
	int[][] last;
	int sum;
	int idx;
	
	public Rand_arr_Maker(){
		r=new Random();
		before=new int[15];
		last=new int[5][];
		sum=0;
	}
	
	public void make_arr() {
		idx=0;
		for(int i=1;i<=5;i++) {
			for(int j=0;j<i;j++) {
				before[idx++]=r.nextInt(25)+1;
				sum+=before[j];
			}
		}
		desc();
		beforeTolast();
	}
	
	public void desc() {
		for(int i=0;i<before.length;i++) {
			for(int j=i+1;j<before.length;j++) {
				if(before[i]<before[j]) {
					int tmp=before[i];
					before[i]=before[j];
					before[j]=tmp;
				}
			}
		}
	}
	
	void beforeTolast() {
		idx=0;
		for(int i=1;i<=5;i++) {
			last[i-1]=new int[i];
			for(int j=0;j<i;j++) {
				last[i-1][j]=before[idx++];
			}
		}
	}
	
	public void printArr() {
		for(int i=0;i<last.length;i++) {
			for(int j=0;j<last[i].length;j++) {
				System.out.print(last[i][j]+"\t");
			}
			System.out.println();
		}
		System.out.println("===================================");
		System.out.println("난수들의 총합은 : "+sum+"입니다.");
	}
}
