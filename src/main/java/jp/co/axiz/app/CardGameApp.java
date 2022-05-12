package jp.co.axiz.app;

public class CardGameApp extends GameApp{
	
	public CardGameApp() {
		super();
	}
	
	public CardGameApp(String item) {
		super(item, 5);
	}
	
	protected String play() {
		String message = "ババ抜きを行います。";
		return message;
	}

}