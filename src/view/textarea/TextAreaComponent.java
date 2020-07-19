package view.textarea;

import view.ViewComponent;

public class TextAreaComponent extends ViewComponent {

	// Inherits viewComponentBehavior instance variable 
	// from class ViewComponent. 
	
	public TextAreaComponent() {
		
		// TextAreaComponent uses the TextArea class to handle its behavior.
		// When performInitialization() is called, the responsibility for the
		// initialization is delegated to the TextArea object.
		
		viewComponentBehavior = new TextArea();
	}
}
