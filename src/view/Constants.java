package view;

import java.awt.Font;

public class Constants {

	// Frame Constants.
	public static final String FRAME_NAME = "Text2Speech Editor";
	public static final int FRAME_WIDTH = 1060;
	public static final int FRAME_HEIGHT = 760;

	// Font Constants.
	public static final String TYPEFACE = "Arial";
	public static final int FONT_TYPE = Font.PLAIN;
	public static final int MENU_FONT_SIZE = 13;
	public static final int MENU_ITEM_FONT_SIZE = 12;

	// Text Area Constants.
	public static final int TEXT_FONT_SIZE = 14;
	public static final int TEXT_INSETS = 5;

	// Available Icons.
	public enum Icons {
		NEW, OPEN, SAVE,
		COPY, PASTE, DELETE,
		TUNE_ENCODING, ENCRYPT,
		TUNE_AUDIO, PLAY, STOP,
		REPLAY
	}

	// Icon Path Constants.

	// File Menu Icons.
	public static final String ICON_PATH_NEW = "/icon_folder-add_alt.png";
	public static final String ICON_PATH_OPEN = "/icon_folder-open_alt.png";
	public static final String ICON_PATH_SAVE = "/icon_floppy.png";

	// Edit Menu Icons.
	public static final String ICON_PATH_COPY = "/icon_pencil-edit.png";
	public static final String ICON_PATH_PASTE = "/icon_documents.png";
	public static final String ICON_PATH_DELETE = "/icon_trash.png";

	// Encoding Menu Icons.
	public static final String ICON_PATH_TUNE_ENCODING = "/icon_key3.png";
	public static final String ICON_PATH_ENCRYPT = "/icon_lock_alt.png";

	// Speech Menu Icons.
	public static final String ICON_PATH_TUNE_AUDIO = "/icon_adjust-horiz.png";
	public static final String ICON_PATH_PLAY = "/arrow_triangle-right_alt2.png";
	public static final String ICON_PATH_STOP = "/icon_close_alt2.png";

	// Replay Menu Icons.
	public static final String ICON_PATH_REPLAY = "/icon_refresh.png";
}