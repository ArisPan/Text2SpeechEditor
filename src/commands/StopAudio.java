package commands;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.Document;
import text2speechstrategy.TTSStrategy;

public class StopAudio implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent event) {

		DocumentController dc = DocumentController.getInstance();
		Document document = dc.getDocument();
		
		TTSController ttsc = TTSController.getInstance();
		TTSStrategy strategy = ttsc.getStrategy();
		
		ReplayManagerController rmc = ReplayManagerController.getInstance();
		ReplayManager manager = rmc.getReplayManager();
		
		// Add command to replay sequence only if it isn't called by ReplayCommands.
		if (event.getActionCommand().compareTo("Replay Commands") != 0)
			manager.addCommand(this);
		
		document.stopAudio(strategy);
	}

}
