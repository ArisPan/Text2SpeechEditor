package text2speechstrategy;

public class TTSStrategyFactory {

	public static TTSStrategy createStrategy(String textToSpeechAPI) {
		
		switch (textToSpeechAPI) {
			case "FreeTTS":
				return new FreeTTS();
			default:
				throw new IllegalArgumentException();
		}
	}
}
