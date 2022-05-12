package jp.co.axiz.app;

public class DartsGameApp extends GameApp{
	
	public DartsGameApp() {
		super();
	}
	
	public DartsGameApp(String item) {
		super(item, 10);
	}
	
	protected String play() {
		String message = "10回投げて合計点を競います。";
		return message;
	}

}