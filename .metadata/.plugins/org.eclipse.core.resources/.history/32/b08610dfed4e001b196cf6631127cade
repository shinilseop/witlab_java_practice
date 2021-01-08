package JAVA_01_first_02;

import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		Convert_num convertor;
		
		System.out.println("진법변환기를 시작합니다.");
		System.out.print("변환하려는 10진수를 입력해주세요(1~255) : ");
		int num=sc.nextInt();
		convertor=new Convert_num(num);

		convertor.toBinary();
		System.out.println(convertor.getConvert());
		convertor.toOcta();
		System.out.println(convertor.getConvert());
		convertor.toHexa();
		System.out.println(convertor.getConvert());
	}
}
