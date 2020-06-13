package commands;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.Document;
import view.TextToSpeechEditorView;
import encodingstrategy.EncodingStrategy;

public class EncodeText implements ActionListener {
	
	@Override
	public void actionPerformed(ActionEvent event) {
		
		DocumentController dc = DocumentController.getInstance();
		Document document = dc.getDocument();
		
		ViewController vc = ViewController.getInstance();
		TextToSpeechEditorView view = vc.getEditorView();
		
		EncodingController ec = EncodingController.getInstance();
		EncodingStrategy strategy = ec.getStrategy();
		
		ReplayManagerController rmc = ReplayManagerController.getInstance();
		ReplayManager manager = rmc.getReplayManager();
		
		// Add command to replay sequence only if it isn't called by ReplayCommands.
		if (event.getActionCommand().compareTo("Replay Commands") != 0)
			manager.addCommand(this);
		
		int currentLine = view.getCurrentLine();
		
		if (view.getSelection() == null) {
			document.updateContents(view.getTextArea());
			document.encodeDocument(strategy);
		}
		else {
			document.updateContents(view.getTextArea());
			document.encodeLine(strategy, currentLine);
		}

		view.setTextArea(document.contentsToString());
	}
}
