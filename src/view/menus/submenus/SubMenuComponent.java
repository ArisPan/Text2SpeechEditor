package view.menus.submenus;

import view.ViewComponent;

public class SubMenuComponent extends ViewComponent {
	
	// Inherits viewComponentBehavior instance variable 
	// from class ViewComponent.

	public SubMenuComponent(String menuType) {
		
		viewComponentBehavior = SubMenuFactory.createMenu(menuType);
	}
}
