package JAVA_01_last;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class WordFinder {
	File f;
	FileReader fr;
	String content;

	WordFinder() {
		try {
			f = new File("sentence.txt");
			fr = new FileReader(f);
			BufferedReader br = new BufferedReader(fr);
			String line;
			while ((line = br.readLine()) != null) {
				content += line;
			}
		} catch (Exception e) {
		}
	}

	void findWord(String word) {
		int cnt=0;
		String copy=content;
		int key = copy.indexOf(word);
		while(key!=-1) {
			cnt++;
			copy=copy.substring(key+word.length());
			key = copy.indexOf(word);
		}
		System.out.println("단어 \""+word+"\"의 갯수 : "+cnt);
	}

	void findWord(String word1, String word2) {
		int cnt=0;
		String copy=content;
		int key1 = copy.indexOf(word1);
		int key2 = copy.indexOf(word2);
		
		while(key1!=-1 || key2!=-1) {
			if(key1!=-1 && key2!=-1) {
				if(key1>key2) {
					copy=copy.substring(key2+word2.length());
					key2 = copy.indexOf(word2);
					key1 = copy.indexOf(word1);
				} else {
					copy=copy.substring(key1+word1.length());
					key1 = copy.indexOf(word1);
					key2 = copy.indexOf(word2);
				}
				cnt++;
			} else if(key1!=-1) {
				cnt++;
				copy=copy.substring(key1+word1.length());
				key1 = copy.indexOf(word1);
			} else if(key2!=-1) {
				cnt++;
				copy=copy.substring(key2+word2.length());
				key2 = copy.indexOf(word2);
			}
		}
		System.out.println("단어 \""+word1+"\"와 \""+word2+"\"의 갯수 : "+cnt);
	}
}
