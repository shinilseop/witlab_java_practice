package JAVA_02_first;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;

public class UI extends JFrame implements ActionListener {

	File file;
	FileWriter fw;
	FileReader fr;

	Font fFont;
	JPanel jpCenter, jpCenter_center, jpBottom;
	JLabel jlBirth, jlStart, jlEnd;
	JTextField jtfBirth, jtfStart, jtfEnd;
	JTable jtTable;
	DefaultTableModel dtm;
	JScrollPane jspTable;
	JButton jbInit, jbLoad;
	String colHeads[] = { "날짜", "신체지수", "감성지수", "지성지수", "지각지수" };
	Object data[][] = new Object[0][5];
	int v, h;

	UI() {
		file = new File("bio.txt");
		try {
			fw = new FileWriter(file);
			fr = new FileReader(file);
		} catch (IOException e) {

		}

		fFont = new Font("굴림", Font.BOLD, 15);

		jpCenter = new JPanel();
		jpCenter_center = new JPanel();
		jpBottom = new JPanel();

		jlBirth = new JLabel("생년월일(yyyy-mm-dd)");
		jlBirth.setFont(fFont);
		jlBirth.setHorizontalAlignment(JLabel.CENTER);

		jlStart = new JLabel("계산 시작 구간(yyyy-mm-dd)");
		jlStart.setFont(fFont);
		jlStart.setHorizontalAlignment(JLabel.CENTER);

		jlEnd = new JLabel("계산 끝 구간(yyyy-mm-dd)");
		jlEnd.setFont(fFont);
		jlEnd.setHorizontalAlignment(JLabel.CENTER);

		jtfBirth = new JTextField("2020-01-01");
		jtfStart = new JTextField("2020-12-01");
		jtfEnd = new JTextField("2020-12-30");

		v = ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED;
		h = ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED;
		dtm=new DefaultTableModel(data, colHeads);
		jtTable = new JTable(dtm);
		jspTable = new JScrollPane(jtTable, v, h);

		jbInit = new JButton("바이오리듬 초기값 설정");
		jbInit.addActionListener(this);
		jbLoad = new JButton("테이블 로드하기");
		jbLoad.setEnabled(false);
		jbLoad.addActionListener(this);

		Container ct = getContentPane();
		ct.setLayout(new BorderLayout());
		ct.add(jpCenter, BorderLayout.CENTER);
		ct.add(jpBottom, BorderLayout.SOUTH);

		jpCenter.setLayout(new GridLayout(2, 1));
		jpCenter.add(jpCenter_center);
		jpCenter.add(jspTable);

		jpCenter_center.setLayout(new GridLayout(3, 2));
		jpCenter_center.add(jlBirth);
		jpCenter_center.add(jtfBirth);
		jpCenter_center.add(jlStart);
		jpCenter_center.add(jtfStart);
		jpCenter_center.add(jlEnd);
		jpCenter_center.add(jtfEnd);

		jpBottom.setLayout(new GridLayout(1, 2));
		jpBottom.add(jbInit);
		jpBottom.add(jbLoad);

		setTitle("바이오 리듬_table");
		setSize(500, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		if (o == jbInit) {
			jbInit.setEnabled(false);
			jbLoad.setEnabled(true);
			String str = "";

			String strEnd = jtfEnd.getText();
			int year = Integer.parseInt(strEnd.substring(0, 4));
			int month = Integer.parseInt(strEnd.substring(5, 7));
			int day = Integer.parseInt(strEnd.substring(8));
			LocalDate end = LocalDate.of(year, month, day);
			
			String strBirth = jtfBirth.getText();
			year = Integer.parseInt(strBirth.substring(0, 4));
			month = Integer.parseInt(strBirth.substring(5, 7));
			day = Integer.parseInt(strBirth.substring(8));
			LocalDate birth = LocalDate.of(year, month, day);

			String strStart = jtfStart.getText();
			year = Integer.parseInt(strStart.substring(0, 4));
			month = Integer.parseInt(strStart.substring(5, 7));
			day = Integer.parseInt(strStart.substring(8));
			LocalDate start = LocalDate.of(year, month, day);

			while(true) {
				double t=ChronoUnit.DAYS.between(birth, start);

				double sinche=Math.round((Math.sin((2*Math.PI*t)/23)*100)*100)/100.0;
				double gamsung=Math.round((Math.sin((2*Math.PI*t)/28)*100)*100)/100.0;
				double jisung=Math.round((Math.sin((2*Math.PI*t)/33)*100)*100)/100.0;
				double jigack=Math.round((Math.sin((2*Math.PI*t)/38)*100)*100)/100.0;
				
				str+=start.toString()+","+sinche+","+gamsung+","+jisung+","+jigack+",\n";
				
				if(start.toString().equals(end.toString())) {
					break;
				}
				start = start.plusDays(1);
			}

			try {
				fw.write(str);
				fw.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		if (o == jbLoad) {
			try {
				String line;
				BufferedReader br=new BufferedReader(fr);
				while((line=br.readLine())!=null	) {
					String tmp[]=line.split(",");
					String add[]= {tmp[0],tmp[1],tmp[2],tmp[3],tmp[3]};
					dtm.addRow(add);
				}
				fr.close();
				jbLoad.setEnabled(false);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
}
