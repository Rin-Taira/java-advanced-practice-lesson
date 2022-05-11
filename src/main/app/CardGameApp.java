package app;

public class CardGameApp extends GameApp{
	
	public CardGameApp() {
		super();
	}
	
	public CardGameApp(String item) {
		super(item);
	}
	
	public String play() {
		String message = "ババ抜きを行います。";
		return message;
	}

}