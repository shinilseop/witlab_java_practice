package Exam02;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class MyFileReader {
	File file;
	FileReader fr;
	MyFileReader(){
		file=new File("bio.txt");
	}
	
	String readFile() {
		String line = "";
		String check="";
		try {
			fr=new FileReader(file);
			BufferedReader br=new BufferedReader(fr);
			while((line=br.readLine())!=null) {
				check=line;
			}
			fr.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return check;
	}
}
