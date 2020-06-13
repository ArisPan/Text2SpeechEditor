package commands;

import view.TextToSpeechEditorView;
import model.Document;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFileChooser;

public class SaveDocument implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent event) {
		
		DocumentController dc = DocumentController.getInstance();
		Document document = dc.getDocument();
		
		ViewController vc = ViewController.getInstance();
		TextToSpeechEditorView view = vc.getEditorView();
		
		ReplayManagerController rmc = ReplayManagerController.getInstance();
		ReplayManager manager = rmc.getReplayManager();
		
		// event is null when UnsavedDocumentCheck performs a Document save.
		if (event != null)
			// Add command to replay sequence only if it isn't called by ReplayCommands.
			if (event.getActionCommand().compareTo("Replay Commands") != 0)
				manager.addCommand(this);
		
		JFileChooser fileChooser = new JFileChooser("C:");
		
		int dialogCheck = fileChooser.showSaveDialog(null);
		
		if (dialogCheck == JFileChooser.APPROVE_OPTION) {
			
			String newContents = view.getTextArea();
			String path = fileChooser.getSelectedFile().getAbsolutePath();
			String name = fileChooser.getSelectedFile().getName();
			
			document.updateContents(newContents);
			document.saveDocument(name, path);
		}
	}
}
