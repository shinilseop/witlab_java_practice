package Client;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class LogWriter {
	JTextArea log;
	JScrollPane jsp;
	
	public LogWriter(JTextArea log, JScrollPane jsp) {
		this.log=log;
		this.jsp=jsp;
	}
	
	public void write(String msg) {
		log.append(msg+"\n");
		jsp.getVerticalScrollBar().setValue(jsp.getVerticalScrollBar().getMaximum());
	}

}
