package commands;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ResetSequence implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent event) {

		ReplayManagerController rmc = ReplayManagerController.getInstance();
		ReplayManager manager = rmc.getReplayManager();
		
		manager.reset();
	}
}
