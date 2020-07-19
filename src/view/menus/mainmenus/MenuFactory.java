package view.menus.mainmenus;

public class MenuFactory {

	public static Menu createMenu(String menuType) {
		
		switch(menuType) {
		case "File":
		case "Edit":
		case "Encode":
		case "Speech":
		case "Replay":
			return new Menu(menuType);
		default:
			throw new IllegalArgumentException("Menu \"" + menuType + "\" is not supported.");
		}
	}
}
