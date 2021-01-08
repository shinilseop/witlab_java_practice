package Exam02;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTextField;

public class UI extends JFrame implements ActionListener {
	Font font;
	
	JPanel jpTop;
	JLabel jlIp,jlPort,jlBlank;
	JTextField jtfIp,jtfPort;
	JButton jbConn;
	
	JPanel jpCenter,jpBar;
	JProgressBar jpbBody,jpbSens,jpbBrain,jpbSince;
	JPanel jpFigure, jpBirth, jpInput;
	JLabel jlBody,jlSens, jlBrain, jlSince, jlBirth,jlYear,jlMonth,jlDays;
	JTextField jtfYear,jtfMonth,jtfDays;
	
	JButton jbCal;
	
	Connection c;
	
	UI(){
		font=new Font("굴림", Font.BOLD, 13);
		
		
		//상단설정
		jpTop=new JPanel(new GridLayout(2,3));
		
		//서버 아이피, 포트 입력
		jlIp=new JLabel("Server IP");
		jlIp.setFont(font);
		jlIp.setHorizontalAlignment(JLabel.CENTER);
		jlPort=new JLabel("Server Port");
		jlPort.setFont(font);
		jlPort.setHorizontalAlignment(JLabel.CENTER);
		jlBlank=new JLabel("");
		
		jtfIp=new JTextField("127.0.0.1");
		jtfPort=new JTextField("7777");
		jbConn=new JButton("통신 설정");
		jbConn.addActionListener(this);
		
		
		//중단설정
		jpCenter=new JPanel(new BorderLayout());
		jpBar=new JPanel(new GridLayout(1,4));

		//진행바
		jpbBody=new JProgressBar();
		jpbBody.setOrientation(JProgressBar.VERTICAL);
		jpbBody.setValue(50);
		jpbSens=new JProgressBar();
		jpbSens.setOrientation(JProgressBar.VERTICAL);
		jpbSens.setValue(50);
		jpbBrain=new JProgressBar();
		jpbBrain.setOrientation(JProgressBar.VERTICAL);
		jpbBrain.setValue(50);
		jpbSince=new JProgressBar();
		jpbSince.setOrientation(JProgressBar.VERTICAL);
		jpbSince.setValue(50);
		
		jpFigure=new JPanel(new GridLayout(1,4));
		jpBirth=new JPanel(new BorderLayout());
		jpBirth.setBackground(Color.LIGHT_GRAY);
		jpInput=new JPanel(new GridLayout(2,3));
		
		//지수
		jlBody=new JLabel("신체지수");
		jlBody.setFont(font);
		jlBody.setHorizontalAlignment(JLabel.CENTER);
		jlSens=new JLabel("감성지수");
		jlSens.setFont(font);
		jlSens.setHorizontalAlignment(JLabel.CENTER);
		jlBrain=new JLabel("지성지수");
		jlBrain.setFont(font);
		jlBrain.setHorizontalAlignment(JLabel.CENTER);
		jlSince=new JLabel("지각지수");
		jlSince.setFont(font);
		jlSince.setHorizontalAlignment(JLabel.CENTER);
		
		//생년월일 입력
		jlBirth=new JLabel("생년월일 입력");
		jlBirth.setFont(font);
		jlBirth.setHorizontalAlignment(JLabel.CENTER);
		jlYear=new JLabel("월");
		jlYear.setFont(font);
		jlYear.setHorizontalAlignment(JLabel.CENTER);
		jlMonth=new JLabel("일");
		jlMonth.setFont(font);
		jlMonth.setHorizontalAlignment(JLabel.CENTER);
		jlDays=new JLabel("일");
		jlDays.setFont(font);
		jlDays.setHorizontalAlignment(JLabel.CENTER);
		
		jtfYear=new JTextField("1997");
		jtfMonth=new JTextField("12");
		jtfDays=new JTextField("26");
		
		
		
		//하단설정
		jbCal=new JButton("계 산");
		jbCal.setEnabled(false);
		jbCal.addActionListener(this);
		
		
		
		//Container
		Container ct=getContentPane();
		ct.setLayout(new BorderLayout());
		ct.add(jpTop, BorderLayout.NORTH);
		ct.add(jpCenter, BorderLayout.CENTER);
		ct.add(jbCal, BorderLayout.SOUTH);
		
		//Top
		jpTop.add(jlIp);
		jpTop.add(jlPort);
		jpTop.add(jlBlank);
		jpTop.add(jtfIp);
		jpTop.add(jtfPort);
		jpTop.add(jbConn);
		
		
		
		//Center
		jpCenter.add(jpBar, BorderLayout.CENTER);
		jpCenter.add(jpBirth, BorderLayout.SOUTH);
		
		//Center_bar
		jpBar.add(jpbBody);
		jpBar.add(jpbSens);
		jpBar.add(jpbBrain);
		jpBar.add(jpbSince);
		
		//Center_birth
		jpBirth.add(jpFigure, BorderLayout.NORTH);
		jpBirth.add(jlBirth, BorderLayout.CENTER);
		jpBirth.add(jpInput, BorderLayout.SOUTH);
		
		//Center_birth_figure
		jpFigure.add(jlBody);
		jpFigure.add(jlSens);
		jpFigure.add(jlBrain);
		jpFigure.add(jlSince);
		
		//Center_birth_input
		jpInput.add(jlYear);
		jpInput.add(jlMonth);
		jpInput.add(jlDays);
		jpInput.add(jtfYear);
		jpInput.add(jtfMonth);
		jpInput.add(jtfDays);
		
		
		
		//라스트
		setTitle("TCP Biorhythm 클라이언트");
		setSize(500, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	public void updateBar(double iBody, double iSens, double iBrain, double iSince) {
		jlBody.setText("신체지수:"+iBody);
		jlSens.setText("감성지수:"+iSens);
		jlBrain.setText("지성지수:"+iBrain);
		jlSince.setText("지각지수:"+iSince);
		if(iBody>=0) {
			iBody=(iBody/2)+50;
			jpbBody.setForeground(Color.green);
			jpbBody.setValue((int) iBody);
		} else {
			iBody=(iBody+100)/2;
			jpbBody.setForeground(Color.red);
			jpbBody.setValue((int) (iBody));
		}
		if(iSens>=0) {
			iSens=(iSens/2)+50;
			jpbSens.setForeground(Color.green);
			jpbSens.setValue((int) iSens);
		} else {
			iSens=(iSens+100)/2;
			jpbSens.setForeground(Color.red);
			jpbSens.setValue((int) (iSens*-1));
		}
		if(iBrain>=0) {
			iBrain=(iBrain/2)+50;
			jpbBrain.setForeground(Color.green);
			jpbBrain.setValue((int) iBrain);
		} else {
			iBrain=(iBrain+100)/2;
			jpbBrain.setForeground(Color.red);
			jpbBrain.setValue((int) (iBrain*-1));
		}
		if(iSince>=0) {
			iSince=(iSince/2)+50;
			jpbSince.setForeground(Color.green);
			jpbSince.setValue((int) iSince);
		} else {
			iSince=(iSince+100)/2;
			jpbSince.setForeground(Color.red);
			jpbSince.setValue((int) (iSince*-1));
		}
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		Object o=arg0.getSource();
		if(o==jbConn) {
			if(!jtfIp.getText().equals("") && !jtfPort.getText().equals("")) {
				String ip=jtfIp.getText();
				int port=Integer.parseInt(jtfPort.getText());
				jbCal.setEnabled(true);
				jbConn.setEnabled(false);
				System.out.println("conntect try...");
				c=new Connection(ip, port, this);
				System.out.println("conntect finish!");
				c.start();
			}
		} else if(o==jbCal) {
			if(!jtfYear.getText().equals("") && !jtfMonth.getText().equals("") & !jtfDays.getText().equals("")) {
				String msg = jtfYear.getText()+" "+jtfMonth.getText()+" "+jtfDays.getText();
				c.sendMsg(msg);
			}
		}
	}
}
