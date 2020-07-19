package view.menus.mainmenus;

import java.awt.Component;
import java.awt.Font;

import javax.swing.JMenu;

import view.Constants;
import view.ViewComponentBehavior;

public class Menu implements ViewComponentBehavior {

	// Concrete implementation class of ViewComponentBehavior.
	
	JMenu menu;
	
	public Menu(String menuLabel) {
		
		menu = new JMenu(menuLabel);
	}

	@Override
	public void initialize() {
		menu.setFont(new Font(Constants.TYPEFACE, Constants.FONT_TYPE, Constants.MENU_FONT_SIZE));
	}

	@Override
	public Component getComponent() {
		return menu;
	}
}
