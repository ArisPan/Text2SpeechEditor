package commands;

import java.awt.event.ActionListener;

import model.Document;
import view.TextToSpeechEditorView;

/*
 * A new object of UnsavedDocumentCheck is created
 * every time the user chooses to abandon working TextArea.
 * Currently there are four such cases:
 * 1. creating a new document
 * 2. opening an existing one
 * 3. exiting through File menu
 * 4. closing app's main window.
 * For each case we want to make sure that users work is not lost.
 * We check for differences between TextArea
 * and current document contents and if such differences exist
 * we call the user to action.
 */

public class UnsavedDocumentCheck {

	DocumentController dc;
	Document document;

	ViewController vc;
	TextToSpeechEditorView view;
	
	public UnsavedDocumentCheck() {
		
		dc = DocumentController.getInstance();
		document = dc.getDocument();
		
		vc = ViewController.getInstance();
		view = vc.getEditorView();
	}
	
	// Checks for differences between TextArea and current document contents.
	// Returns true if there are unsaved changes, false otherwise.
	public boolean check() {
		
		if (document.checkForUnsavedDocument(view.getTextArea()))
			return true;
		
		return false;
	}
	
	// Display UnsavedDocumentWarning and proceed according to users choice.
	// Returns 1 if the user saved or opted to not save,
	// -1 if he/she canceled the operation.
	public int callToAction() {
		
		// Result is 0 for "Save" option,
		// 1 for "Don't save" option,
		// 2 for "Cancel" and
		// -1 if the user closes the dialog window.
		int result = view.showUnsavedDocumentWarning();

		if (result == 0) {

			ActionListener al = CommandFactory.createCommand("Save");
			al.actionPerformed(null);
		}
		else if (result == 2 || result == -1)
			return -1;
	
		return 1;
	}
}
