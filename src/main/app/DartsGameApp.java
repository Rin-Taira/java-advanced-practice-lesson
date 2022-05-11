package app;

public class DartsGameApp extends GameApp{
	
	public DartsGameApp() {
		super();
	}
	
	public DartsGameApp(String item) {
		super(item);
	}
	
	public String play() {
		String message = "10回投げて合計点を競います。";
		return message;
	}

}