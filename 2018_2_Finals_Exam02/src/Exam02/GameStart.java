package Exam02;

public class GameStart {
	UI ui;
	
	GameStart(){
		ui=new UI();
		ui.OpenGame();
		new Thread(ui).start();
	}
}
