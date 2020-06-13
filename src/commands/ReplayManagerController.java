package commands;

public class ReplayManagerController {

	protected ReplayManager manager;
	
	private static ReplayManagerController rmc = null;
	
	private ReplayManagerController() {
		
		manager = new ReplayManager();
	}
	
	public static ReplayManagerController getInstance() {
		
		if (rmc == null)
			rmc = new ReplayManagerController();
		
		return rmc;
	}
	
	public ReplayManager getReplayManager() {
		
		return manager;
	}
}
