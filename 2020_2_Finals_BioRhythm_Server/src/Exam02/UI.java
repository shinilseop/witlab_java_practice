package Exam02;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class UI extends JFrame implements ActionListener {
	JLabel jlPort,jlBlank;
	JTextField jtfPort;
	JButton jbSetting;
	
	ServerThread st;
	
	UI(){
		jlPort=new JLabel("Server Port");
		jlPort.setHorizontalAlignment(JLabel.CENTER);
		jlBlank=new JLabel("");
		jtfPort=new JTextField("7777");
		jbSetting=new JButton("설정");
		jbSetting.addActionListener(this);
		
		Container ct=getContentPane();
		ct.setLayout(new GridLayout(2,2));
		ct.add(jlPort);
		ct.add(jlBlank);
		ct.add(jtfPort);
		ct.add(jbSetting);
		
		setTitle("TCP Buorhythm 서버");
		setSize(350,100);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		Object o=arg0.getSource();
		if(o==jbSetting) {
			int port=Integer.parseInt(jtfPort.getText());
			st=new ServerThread(port);
			st.start();
			jbSetting.setEnabled(false);
			System.out.println("1");
		}
	}
}
