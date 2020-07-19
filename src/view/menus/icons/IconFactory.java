package view.menus.icons;

import view.Constants;

public class IconFactory {

	public static Icon createIcon(Constants.Icons iconType) {
		
		switch(iconType) {
		case NEW:
			return new Icon(Constants.ICON_PATH_NEW);
		case OPEN:
			return new Icon(Constants.ICON_PATH_OPEN);
		case SAVE:
			return new Icon(Constants.ICON_PATH_SAVE);
		case COPY:
			return new Icon(Constants.ICON_PATH_COPY);
		case PASTE:
			return new Icon(Constants.ICON_PATH_PASTE);
		case DELETE:
			return new Icon(Constants.ICON_PATH_DELETE);
		case TUNE_ENCODING:
			return new Icon(Constants.ICON_PATH_TUNE_ENCODING);
		case ENCRYPT:
			return new Icon(Constants.ICON_PATH_ENCRYPT);
		case TUNE_AUDIO:
			return new Icon(Constants.ICON_PATH_TUNE_AUDIO);
		case PLAY:
			return new Icon(Constants.ICON_PATH_PLAY);
		case STOP:
			return new Icon(Constants.ICON_PATH_STOP);
		case REPLAY:
			return new Icon(Constants.ICON_PATH_REPLAY);
		default:
			throw new IllegalArgumentException("Icon \"" + iconType + "\" is not available.");
		}
	}
}
