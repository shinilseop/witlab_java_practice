package JAVA_01_last;

import java.io.IOException;

public class Main {
	public static void main(String args[]) {
		WordFinder wf=new WordFinder();

		wf.findWord("코로나");
		wf.findWord("마스크");
		wf.findWord("코로나","마스크");
		
		
	}
}
