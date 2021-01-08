package Exam02;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Figure_Calculator {
	String strBirth, strNow;
	
	public Figure_Calculator(String strBirth) {
		this.strBirth=strBirth;
	}
	
	public String getBody() {
		StringBuffer figureValue=new StringBuffer();
		String tmp[]=strBirth.split(",");
		int year=Integer.parseInt(tmp[0]);
		int month=Integer.parseInt(tmp[1]);
		int day=Integer.parseInt(tmp[2]);
		LocalDate start=LocalDate.of(year, month, day);
		LocalDate end=LocalDate.now();
		
		
		long t=ChronoUnit.DAYS.between(start, end);
		for(int i=0;i<10;i++) {
			double body=Math.sin((2*Math.PI*t)/23.0)*100;
			figureValue.append(body+",");
			t++;
		}
		
		return figureValue.toString();
	}
	
	public String getSens() {
		StringBuffer figureValue=new StringBuffer();
		String tmp[]=strBirth.split(",");
		int year=Integer.parseInt(tmp[0]);
		int month=Integer.parseInt(tmp[1]);
		int day=Integer.parseInt(tmp[2]);
		LocalDate start=LocalDate.of(year, month, day);
		LocalDate end=LocalDate.now();
		
		
		long t=ChronoUnit.DAYS.between(start, end);
		for(int i=0;i<10;i++) {
			double sens=Math.sin((2*Math.PI*t)/28.0)*100;
			figureValue.append(sens+",");
			t++;
		}
		
		return figureValue.toString();
	}
	
	public String getBrain() {
		StringBuffer figureValue=new StringBuffer();
		String tmp[]=strBirth.split(",");
		int year=Integer.parseInt(tmp[0]);
		int month=Integer.parseInt(tmp[1]);
		int day=Integer.parseInt(tmp[2]);
		LocalDate start=LocalDate.of(year, month, day);
		LocalDate end=LocalDate.now();
		
		
		long t=ChronoUnit.DAYS.between(start, end);
		for(int i=0;i<10;i++) {
			double brain=Math.sin((2*Math.PI*t)/33.0)*100;
			figureValue.append(brain+",");
			t++;
		}
		
		return figureValue.toString();
	}
	
	public String getSince() {
		StringBuffer figureValue=new StringBuffer();
		String tmp[]=strBirth.split(",");
		int year=Integer.parseInt(tmp[0]);
		int month=Integer.parseInt(tmp[1]);
		int day=Integer.parseInt(tmp[2]);
		LocalDate start=LocalDate.of(year, month, day);
		LocalDate end=LocalDate.now();
		
		
		long t=ChronoUnit.DAYS.between(start, end);
		for(int i=0;i<10;i++) {
			double since=Math.sin((2*Math.PI*t)/38.0)*100;
			figureValue.append(since+",");
			t++;
		}
		
		return figureValue.toString();
	}
}
