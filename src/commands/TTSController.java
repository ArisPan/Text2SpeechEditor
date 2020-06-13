package commands;


import text2speechstrategy.TTSStrategy;
import text2speechstrategy.TTSStrategyFactory;

public class TTSController {

	protected TTSStrategy strategy;
	
	private static TTSController ttsc = null;
	
	private TTSController() {
		
		// FreeTTS will be our default Text to Speech converter.
		strategy = TTSStrategyFactory.createStrategy("FreeTTS");
	}
	
	public static TTSController getInstance() {
		
		if (ttsc == null) {
			ttsc = new TTSController();
		}
		return ttsc;
	}
	
	public TTSStrategy getStrategy() {
		return strategy;
	}
}
