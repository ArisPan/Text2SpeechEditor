package view;

import java.awt.Component;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import view.menus.icons.Icon;
import view.menus.icons.IconFactory;
import view.menus.mainmenus.MenuComponent;
import view.menus.submenus.SubMenuComponent;
import view.textarea.TextAreaComponent;
import view.windowframe.WindowFrameComponent;

public class MainWindow {

	public MainWindow() {

		// Create Frame.
		ViewComponent frameComponent = new WindowFrameComponent();
		frameComponent.performInitialization();

		JFrame frame = (JFrame) frameComponent.performGetComponent();

		// Create TextArea.
		ViewComponent textAreaComponent = new TextAreaComponent();
		textAreaComponent.performInitialization();

		JTextArea textArea = (JTextArea) textAreaComponent.performGetComponent();

		// Create ScrollPane.
		JScrollPane scrollPane = new JScrollPane(textArea);
		scrollPane.setBorder(BorderFactory.createEmptyBorder());

		frame.getContentPane().add(scrollPane);

		// Create MenuBar.
		JMenuBar menuBar = new JMenuBar();
		menuBar.setFont(new Font(Constants.TYPEFACE, Constants.FONT_TYPE, Constants.MENU_FONT_SIZE));

		frame.setJMenuBar(menuBar);

		// Create File menu.
		menuBar.add(createMenu("File"));

		// Create Edit menu.
		menuBar.add(createMenu("Edit"));

		// Create Encode menu.
		JMenu encodeMenu = (JMenu) createMenu("Encode");
		JMenu encodingTechniqueSubMenu = (JMenu) createSubMenu("Encoding Technique");
		encodeMenu.add(encodingTechniqueSubMenu);

		menuBar.add(encodeMenu);

		// Create Speech menu.
		JMenu speechMenu = (JMenu) createMenu("Speech");

		JMenu convertToSpeechSubMenu = (JMenu) createSubMenu("Convert To Speech");
		speechMenu.add(convertToSpeechSubMenu);

		JMenu tuneAudioSubMenu = (JMenu) createSubMenu("Tune Audio");
		tuneAudioSubMenu.setIcon(getIcon(Constants.Icons.TUNE_AUDIO, 25, 25));

		speechMenu.add(tuneAudioSubMenu);

		menuBar.add(speechMenu);

		// Create Replay menu.
		menuBar.add(createMenu("Replay"));

		// Set frame visibility.
		frame.setVisible(true);
	}

	private Component createMenu(String menuType) {

		ViewComponent menuComponent = new MenuComponent(menuType);
		menuComponent.performInitialization();

		return menuComponent.performGetComponent();
	}

	private Component createSubMenu(String menuType) {

		ViewComponent subMenuComponent = new SubMenuComponent(menuType);
		subMenuComponent.performInitialization();

		return subMenuComponent.performGetComponent();
	}

	private ImageIcon getIcon(Constants.Icons iconType, int width, int height) {

		Icon icon = IconFactory.createIcon(iconType);

		return icon.resizeImage(icon.getIcon(), width, height);
	}
}