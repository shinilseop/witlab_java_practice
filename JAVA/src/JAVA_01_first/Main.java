package JAVA_01_first;

import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);

		int gcd = 1;
		int lcm = 1;
		int large = 1;

		System.out.print("최대공약수, 최소공배수 계산할 숫자의 갯수 : ");
		int len = sc.nextInt();
		int arr[] = new int[len];
		for (int i = 0; i < len; i++) {
			System.out.print((i + 1) + "번째 숫자입력 : ");
			arr[i] = sc.nextInt();
			large = Math.max(large, arr[i]);
		}

		boolean prime[] = new boolean[large+1];
		int cnt[][]=new int[large+1][len];
		for (int i = 2; i <= large; i++) {
			if (!prime[i]) {
				for (int j = i + i; j <= large; j += i) {
					prime[j] = true;
				}
			}
		}
		
		for(int i=0;i<arr.length;i++) {
			for(int j=2;j<prime.length;j++) {
				if(!prime[j] && arr[i]%j==0) {
					cnt[j][i]++;
					arr[i]/=j;
					j--;
				}
			}
		}
		
		for(int i=2;i<cnt.length;i++) {
			int min=Integer.MAX_VALUE;
			for(int j=0;j<cnt[0].length;j++) {
				min=Math.min(cnt[i][j], min);
			}
			if(min!=Integer.MAX_VALUE) {
				int mul=1;
				for(int j=0;j<min;j++) {
					mul*=i;
				}
				gcd*=mul;
			}
		}
		
		for(int i=2;i<cnt.length;i++) {
			int max=0;
			for(int j=0;j<cnt[0].length;j++) {
				max=Math.max(cnt[i][j], max);
			}
			if(max!=0) {
				int mul=1;
				for(int j=0;j<max;j++) {
					mul*=i;
				}
				lcm*=mul;
			}
		}
		
		System.out.println("최대공약수 : "+gcd);
		System.out.println("최소공배수 : "+lcm);
	}
}
