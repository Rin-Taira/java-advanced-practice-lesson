package app;

public class CardGameApp extends GameApp{
	
	public CardGameApp() {
		super();
	}
	
	public CardGameApp(String item) {
		super(item);
	}
	
	public String start(String name) {
		String message = "";
		message += name + "さんと";
		message += this.item + "でゲームを開始します。";
		message += "ババ抜きを行います。";
		return message;
	}
}
