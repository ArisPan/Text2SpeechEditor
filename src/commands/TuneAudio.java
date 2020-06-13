package commands;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import text2speechstrategy.TTSStrategy;
import view.TextToSpeechEditorView;

public class TuneAudio implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent event) {
		
		ViewController vc = ViewController.getInstance();
		TextToSpeechEditorView view = vc.getEditorView();
		
		TTSController ttsc = TTSController.getInstance();
		TTSStrategy strategy = ttsc.getStrategy();
		
		switch (event.getActionCommand()) {
		case "volume":
			strategy.setVolume(view.getVolume());
			break;
		case "pitch":
			strategy.setPitch(view.getPitch());
			break;
		case "rate":
			strategy.setRate(view.getRate());
			break;
		}
	}
}
