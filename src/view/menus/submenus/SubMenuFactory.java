package view.menus.submenus;

public class SubMenuFactory {

	public static SubMenu createMenu(String menuType) {
		
		switch(menuType) {
		case "Encoding Technique":
		case "Convert To Speech":
		case "Tune Audio":
			return new SubMenu(menuType);
		default:
			throw new IllegalArgumentException("SubMenu \"" + menuType + "\" is not supported.");
		}
	}
}
