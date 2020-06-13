package commands;

import encodingstrategy.EncodingStrategy;
import encodingstrategy.StrategyFactory;

public class EncodingController {

	protected EncodingStrategy strategy;
	
	private static EncodingController ec = null;
	
	private EncodingController() {
		
		// Default strategy will be Rot13.
		strategy = StrategyFactory.createStrategy("Rot13");
	}
	
	public static EncodingController getInstance() {
		
		if (ec == null) {
			ec = new EncodingController();
		}
		return ec;
	}
	
	public EncodingStrategy getStrategy() {
		return strategy;
	}
	
	public void setStrategy(String newStrategy) {
		this.strategy = StrategyFactory.createStrategy(newStrategy);
	}
}
