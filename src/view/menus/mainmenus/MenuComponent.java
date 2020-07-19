package view.menus.mainmenus;

import view.ViewComponent;

public class MenuComponent extends ViewComponent {

	// Inherits viewComponentBehavior instance variable 
	// from class ViewComponent.
	
	public MenuComponent(String menuType) {
		
		viewComponentBehavior = MenuFactory.createMenu(menuType);
	}
}
