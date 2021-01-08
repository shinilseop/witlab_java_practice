package UI;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class HowUI extends UI {
	Font fTitle, fEx;

	JPanel jpContent;
	JLabel jlTitle, jlEx;

	public HowUI(Container ct) {
		fTitle=new Font("굴림", Font.BOLD, 30);
		fEx=new Font("굴림", Font.PLAIN, 13);
		
		jlTitle=new JLabel("게임 설명");
		jlTitle.setFont(fTitle);
		
		jpContent=new JPanel(new GridLayout(8,1));
		String content[]= {"내려오는 블록들을 화살표를 이용하여 움직여서",
				"빈 공간에 끼워넣어 같은 줄의 블록이 가득차면",
				"사라지면서 점수를 얻을 수 있습니다.", 
				"(화살표 = 블록 움직이기, 스페이스바 = 한번에 내리기)",
				"",
				"",
				"",
				"다시 메뉴로 돌아가시려면 <- 키를 눌러주세요."};
		for(int i=0;i<content.length;i++) {
			JLabel tmp=new JLabel(content[i]);
			tmp.setFont(fEx);
			jpContent.add(tmp);
		}
		
		ct.setLayout(new BorderLayout());
		ct.add(jlTitle, BorderLayout.NORTH);
		ct.add(jpContent, BorderLayout.CENTER);
	}
}
