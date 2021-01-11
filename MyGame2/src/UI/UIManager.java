package UI;

public class UIManager {
	UI ui;
	String id;
	UIChanger uic;

	public UIManager() {
		uic = new UIChanger() {
			public void goMenu() {
				ui = new MenuUI(uic);
			}

			public void goHow() {
				ui = new HowUI(uic);
			}

			public void goGame() {
				ui = new GameUI(uic);
			}

			public void goScore() {
				ui = new ScoreUI(uic);
			}

			public void goRegister() {
				ui = new RegisterUI(uic);
			}

			public void goLogin() {
				ui = new LoginUI(uic);
			}
			public String getId() {
				return id;
			}
			public void setId(String idTmp) {
				id=idTmp;
			}
		};
	}

	public void start() {
		ui = new TitleUI(uic);
	}
}
