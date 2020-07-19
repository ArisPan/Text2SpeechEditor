package view;

import java.awt.Component;

public interface ViewComponentBehavior {

	// The interface that all view components implement.
	
	public void initialize();
	
	public Component getComponent();
}
