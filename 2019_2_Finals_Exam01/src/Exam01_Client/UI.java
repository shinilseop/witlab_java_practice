package Exam01_Client;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class UI extends JFrame implements ActionListener {
	Font font;
	
	JPanel jpTop;
	JLabel jlIp, jlPort;
	JTextField jtfIp, jtfPort;
	
	JScrollPane jspCal;
	JTextArea jtaCal;
	
	JPanel jpBottom;
	JTextField jtfDate;
	JButton jbSend, jbReceive;
	
	Connection c;
	
	UI(){
		Font font=new Font("굴림", Font.BOLD, 13);
		//Init_Top
		jpTop=new JPanel(new GridLayout(2,2));
		
		jlIp=new JLabel("Server IP");
		jlIp.setHorizontalAlignment(JLabel.CENTER);
		jlIp.setFont(font);
		jlPort=new JLabel("Server Port");
		jlPort.setHorizontalAlignment(JLabel.CENTER);
		jlPort.setFont(font);
		
		jtfIp=new JTextField("127.0.0.1");
		jtfPort=new JTextField("9999");
		
		//Init_Middle
		jtaCal=new JTextArea();
		jspCal=new JScrollPane(jtaCal);
		
		//Init_Bottom
		jpBottom=new JPanel(new GridLayout(1,3));
		
		jtfDate=new JTextField("2021-01");
		
		jbSend=new JButton("전송");
		jbSend.addActionListener(this);
		jbReceive=new JButton("수신");
		jbReceive.addActionListener(this);
		jbReceive.setEnabled(false);
		
		
		
		//Container
		Container ct=getContentPane();
		ct.setLayout(new BorderLayout());
		ct.add(jpTop, BorderLayout.NORTH);
		ct.add(jspCal, BorderLayout.CENTER);
		ct.add(jpBottom, BorderLayout.SOUTH);
		
		setTitle("달력 반환기 Client");
		setSize(600,400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
		
		
		//Top
		jpTop.add(jlIp);
		jpTop.add(jlPort);
		jpTop.add(jtfIp);
		jpTop.add(jtfPort);
		
		//Bottom
		jpBottom.add(jtfDate);
		jpBottom.add(jbSend);
		jpBottom.add(jbReceive);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o=e.getSource();
		if(o==jbSend) {
			jbReceive.setEnabled(true);
			jbSend.setEnabled(false);
			int port=Integer.parseInt(jtfPort.getText());
			c=new Connection(jtfIp.getText(), port, jtaCal);
			c.sendMsg(jtfDate.getText());
			c.start();
		} else if(o==jbReceive) {
			jbReceive.setEnabled(false);
			jbSend.setEnabled(true);
			c.drawCal();
		}
	}
}
