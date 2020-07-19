package view.menus.submenus;

import java.awt.Component;
import java.awt.Font;

import javax.swing.JMenu;

import view.Constants;
import view.ViewComponentBehavior;

public class SubMenu implements ViewComponentBehavior {

	// Concrete implementation class of ViewComponentBehavior.
	
	// TODO
	// Add method for icons.
	
	JMenu menu;
	
	public SubMenu(String menuLabel) {
		
		menu = new JMenu(menuLabel);
	}

	@Override
	public void initialize() {
		menu.setFont(new Font(Constants.TYPEFACE, Constants.FONT_TYPE, Constants.MENU_ITEM_FONT_SIZE));
	}

	@Override
	public Component getComponent() {
		return menu;
	}
}
