package commands;

import view.TextToSpeechEditorView;

public class ViewController {

	protected TextToSpeechEditorView editorView;
	
	private static ViewController vc = null;
	
	private ViewController() {
		
		editorView = new TextToSpeechEditorView();
	}
	
	public static ViewController getInstance() {
		
		if (vc == null)
			vc = new ViewController();
		
		return vc;
	}
	
	public TextToSpeechEditorView getEditorView() {
		
		return editorView;
	}
}
