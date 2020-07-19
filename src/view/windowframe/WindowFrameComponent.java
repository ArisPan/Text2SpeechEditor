package view.windowframe;

import view.ViewComponent;

public class WindowFrameComponent extends ViewComponent {

	public WindowFrameComponent() {
		
		// WindowFrameComponent uses the WindowFrame class to handle its behavior.
		// When performInitialization() is called, the responsibility for the
		// initialization is delegated to the WindowFrame object.
		
		viewComponentBehavior = new WindowFrame();
	}
}
