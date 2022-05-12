package jp.co.axiz.app;

public abstract class GameApp implements App {
	private String item;
	private int playTime;
	
	
	public GameApp() {
	}
	
	public GameApp(String item, int time) {
		this.item = item;
		this.playTime = time;
	}
	
	public void setItem(String item) {
		this.item = item;
	}
	
	public void setPlayTime(int time) {
		this.playTime = time;
	}
	
	public String getItem() {
		return this.item;
	}
	
	public int getPlayTime() {
		return this.playTime;
	}
	
	protected abstract String play();
	
	public String start(String userName) {
		String message = "";
		message += userName + "さんと";
		message += this.item + "でゲームを開始します。";
		message += play();
		return message;
	}
}