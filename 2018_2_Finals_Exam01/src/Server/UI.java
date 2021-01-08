package Server;

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
	JLabel jlServer,jlIp,jlClient;
	JTextField jtfServer, jtfIp, jtfClient;
	JButton jbConn;
	
	JTextArea jtaLog;
	JScrollPane jspLog;
	
	MsgSender ms;
	MsgReicever mr;
	
	UI(){
		font=new Font("굴림", Font.BOLD, 13);
		
		//init_Top
		jpTop=new JPanel(new GridLayout(2,4));

		jlServer=new JLabel("Server Port");
		jlServer.setFont(font);
		jlIp=new JLabel("Client IP");
		jlIp.setFont(font);
		jlClient=new JLabel("Client Port");
		jlClient.setFont(font);

		jtfServer=new JTextField("9001");
		jtfIp=new JTextField("127.0.0.1");
		jtfClient=new JTextField("9000");
		
		jbConn=new JButton("설정");
		jbConn.addActionListener(this);
		
		//init_Middle
		jtaLog=new JTextArea();
		jspLog=new JScrollPane(jtaLog);
		
		
		//Container
		Container ct=getContentPane();
		ct.setLayout(new BorderLayout());
		ct.add(jpTop, BorderLayout.NORTH);
		ct.add(jspLog, BorderLayout.CENTER);
		
		setTitle("김범수 콘서트 예약 시스템 서버");
		setSize(400, 450);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
		//Top
		jpTop.add(jlServer);
		jpTop.add(jlIp);
		jpTop.add(jlClient);
		jpTop.add(new JLabel(""));
		jpTop.add(jtfServer);
		jpTop.add(jtfIp);
		jpTop.add(jtfClient);
		jpTop.add(jbConn);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o=e.getSource();
		if(o==jbConn) {
			if(mr!=null) {
				mr.stop=true;
			}
			int port=Integer.parseInt(jtfClient.getText());
			ms=new MsgSender(jtfIp.getText(), port);
			port=Integer.parseInt(jtfServer.getText());
			Ticket t=new Ticket(100, jtaLog);
			mr=new MsgReicever(port, t, ms);
			mr.start();
		}
	}
}
