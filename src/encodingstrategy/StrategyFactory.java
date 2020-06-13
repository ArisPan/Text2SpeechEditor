package encodingstrategy;

public class StrategyFactory {

	public static EncodingStrategy createStrategy(String encodingType) {
		
		switch (encodingType) {
		case "Rot13":
			return new Rot13Encoding();
		case "AtBash":
			return new AtBashEncoding();
		default:
			throw new IllegalArgumentException();
		}
	}
}
