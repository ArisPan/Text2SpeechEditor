package commands;

import view.TextToSpeechEditorView;
import model.Document;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFileChooser;

public class OpenDocument implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent event) {
		
		DocumentController dc = DocumentController.getInstance();
		Document document = dc.getDocument();
		
		ViewController vc = ViewController.getInstance();
		TextToSpeechEditorView view = vc.getEditorView();
		
		ReplayManagerController rmc = ReplayManagerController.getInstance();
		ReplayManager manager = rmc.getReplayManager();
		
		// Add command to replay sequence only if it isn't called by ReplayCommands.
		if (event.getActionCommand().compareTo("Replay Commands") != 0)
			manager.addCommand(this);
		
		// Check for differences between TextArea
		// and current document contents.
		// If so, ask to save before opening a new document. 
		UnsavedDocumentCheck udc = new UnsavedDocumentCheck();
		if (udc.check())
			if (udc.callToAction() == -1)
				return;
		
		JFileChooser fileChooser = new JFileChooser("C:");
		
		int dialogCheck = fileChooser.showOpenDialog(null);
		
		if (dialogCheck == JFileChooser.APPROVE_OPTION) {
			
			String path = fileChooser.getSelectedFile().getAbsolutePath();
			String name = fileChooser.getSelectedFile().getName();
			
			document.openDocument(name, path);
			
			view.setTextArea(document.contentsToString());
		}
	}
}
