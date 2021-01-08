package Exam01_Server;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.JTextArea;

public class CalendarMaker {
	String date;
	StringBuffer calendar = new StringBuffer();

	CalendarMaker(String date) {
		this.date = date;
	}

	void makeCalendar() {
		String[] tmp = date.split("-");

		calendar.append("<" + tmp[0] + "년 " + tmp[1] + "월>\n");
		calendar.append("Sun\tMon\tTue\tWed\tThu\tFri\tSat\n");

		int year=Integer.parseInt(tmp[0]);
		int month=Integer.parseInt(tmp[1]);
		GregorianCalendar cal = new GregorianCalendar(year, month-1, 1);
		int day = 1;
		int lastDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
		int startWeek = cal.get(Calendar.DAY_OF_WEEK)-1;

		for (int i = 0; i < startWeek; i++) {
			calendar.append("\t");
		}
		
		for (int i = 0; i < 6; i++) {
			for (int j = startWeek; j < 7; j++) {
				if (day == lastDay) {
					break;
				}
				if(j==6)
					calendar.append((day++));
				else
					calendar.append((day++)+"\t");
			}
			calendar.append("\n");
			if (startWeek != 0)
				startWeek = 0;
			if (day == lastDay) {
				calendar.append((day) + "\n\n");
				break;
			}
		}

	}

	String getCalendar() {
		return calendar.toString();
	}
}
