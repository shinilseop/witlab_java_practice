package Exam02;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class MyFileWriter {
	File file;
	FileWriter fw;

	MyFileWriter() {
		file = new File("bio.txt");
	}
	
	void writeFile(String msg) {
		try {
			fw = new FileWriter(file);
			fw.write(msg);
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
