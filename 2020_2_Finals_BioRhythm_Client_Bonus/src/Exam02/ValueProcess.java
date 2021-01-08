package Exam02;

public class ValueProcess {
	MyFileWriter fw;
	MyFileReader fr;
	UI ui;

	ValueProcess(UI ui){
		this.ui=ui;
		fw=new MyFileWriter();
		fr=new MyFileReader();
	}

	public void write(String msg) {
		StringBuffer figureSB=new StringBuffer();
		String tmp[]=msg.split(",");
		double figure[]=new double[10];
		for(int i=0;i<figure.length;i++) {
			figure[i]=Math.round(Double.parseDouble(tmp[i])*100)/100.0;
			figureSB.append(figure[i]+",");
		}
		fw.writeFile(figureSB.toString());
		read();
	}
	
	public void read() {
		String readFile[]=fr.readFile().split(",");
		double figure[]=new double[10];
		for(int i=0;i<figure.length;i++) {
			figure[i]=Double.parseDouble(readFile[i]);
		}
		ui.updateBar(figure);
	}
}
