package view;

import java.awt.Component;

public abstract class ViewComponent {

	// Reference variable for the behavior interface.
	// All view component subclasses (frame, text area, menus etc) inherit it.
	protected ViewComponentBehavior viewComponentBehavior;
	
	public void performInitialization() {
		
		viewComponentBehavior.initialize();
	}
	
	public Component performGetComponent() {
		
		return viewComponentBehavior.getComponent();
	}
}
