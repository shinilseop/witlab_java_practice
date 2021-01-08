package Exam02;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Figure_Calculator {
	String strBirth, strNow;
	
	public Figure_Calculator(String strBirth) {
		this.strBirth=strBirth;
	}
	
	public String getFigure() {
		String tmp[]=strBirth.split(" ");
		int year=Integer.parseInt(tmp[0]);
		int month=Integer.parseInt(tmp[1]);
		int day=Integer.parseInt(tmp[2]);
		LocalDate start=LocalDate.of(year, month, day);
		LocalDate end=LocalDate.now();
		
		long t=ChronoUnit.DAYS.between(start, end);

		double body=Math.sin((2*Math.PI*t)/23.0)*100;
		double sens=Math.sin((2*Math.PI*t)/28.0)*100;
		double brain=Math.sin((2*Math.PI*t)/33.0)*100;
		double since=Math.sin((2*Math.PI*t)/38.0)*100;
		
		return body+","+sens+","+brain+","+since;
	}
}
