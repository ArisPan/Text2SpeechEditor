package view;

import commands.CommandFactory;
import commands.UnsavedDocumentCheck;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JSlider;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TextToSpeechEditorView {
	
	private JFrame frame;
	private JTextArea textArea;
	private JSeparator separator;
	private int currentLineIndex;
	private int volumeLevel;
	private int pitchLevel;
	private int rateLevel;

	// Create the application.
	public TextToSpeechEditorView() {
		initialize();
	}

	// Initialize the contents of the frame.
	private void initialize() {		

		frame = new JFrame("Text2Speech Editor");
		frame.setSize(1060, 760);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frame.addWindowListener(new WindowAdapter() {
			
			@Override
			public void windowClosing(WindowEvent e) {
				
				UnsavedDocumentCheck check = new UnsavedDocumentCheck();
				if (check.check())
					if (check.callToAction() == -1)
						return;
				e.getWindow().dispose();
			}
		});
		
		textArea = new JTextArea();
		textArea.setMargin(new Insets(5, 5, 5, 5));
		textArea.setFont(new Font("Arial", Font.PLAIN, 14));
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
		textArea.addCaretListener(new CaretListener() {

			@Override
			public void caretUpdate(CaretEvent event) {

				int lineIndex = 0;
				
				try {
					
					int caretPosition = textArea.getCaretPosition();
					lineIndex = textArea.getLineOfOffset(caretPosition);
				}
				catch (Exception e) {
					e.printStackTrace();
				}
				
				updateLineIndex(lineIndex);
			}
		});
		
		JScrollPane scrollPane = new JScrollPane(textArea);
		frame.getContentPane().add(scrollPane);
		
		// Declare and get icons
		ImageIcon newIcon = null, openIcon = null, 
				saveIcon = null, copyIcon = null,
				pasteIcon = null, deleteIcon = null,
				tuneAudioIcon = null, playIcon = null,
				stopIcon = null, encryptIcon = null,
				tuneEncodingIcon = null, replayIcon = null;
				
		try {
			newIcon = findImage("/icon_folder-add_alt.png");
			openIcon = findImage("/icon_folder-open_alt.png");
			saveIcon = findImage("/icon_floppy.png");
			copyIcon = findImage("/icon_pencil-edit.png");
			pasteIcon = findImage("/icon_documents.png");
			deleteIcon = findImage("/icon_trash.png");
			tuneEncodingIcon = findImage("/icon_key3.png");
			encryptIcon = findImage("/icon_lock_alt.png");
			tuneAudioIcon = findImage("/icon_adjust-horiz.png");
			playIcon = findImage("/arrow_triangle-right_alt2.png");
			stopIcon = findImage("/icon_close_alt2.png");
			replayIcon = findImage("/icon_refresh.png");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Could not locate image.");
		}
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setFont(new Font("Arial", Font.PLAIN, 13));
		frame.setJMenuBar(menuBar);
		
		JMenu menu = new JMenu("File");
		menu.setFont(new Font("Arial", Font.PLAIN, 13));
		menuBar.add(menu);
		
		JMenuItem menuItem = new JMenuItem("New");
		menuItem.setFont(new Font("Arial", Font.PLAIN, 12));
		menuItem.setIcon(resizeImage(newIcon, 20, 20));
		menuItem.addActionListener(CommandFactory.createCommand("New"));
		menu.add(menuItem);
		
		JMenuItem menuItem_1 = new JMenuItem("Open");
		menuItem_1.setFont(new Font("Arial", Font.PLAIN, 12));
		menuItem_1.setIcon(resizeImage(openIcon, 20, 20));
		menuItem_1.addActionListener(CommandFactory.createCommand("Open"));
		menu.add(menuItem_1);
		
		JMenuItem menuItem_2 = new JMenuItem("Save");
		menuItem_2.setFont(new Font("Arial", Font.PLAIN, 12));
		menuItem_2.setIcon(resizeImage(saveIcon, 20, 20));
		menuItem_2.addActionListener(CommandFactory.createCommand("Save"));
		menu.add(menuItem_2);
		
		separator = new JSeparator();
		menu.add(separator);
		
		JMenuItem menuItem_3 = new JMenuItem("Exit");
		menuItem_3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				UnsavedDocumentCheck check = new UnsavedDocumentCheck();
				if (check.check())
					if (check.callToAction() == -1)
						return;

				frame.dispose();
			}
		});
		menuItem_3.setFont(new Font("Arial", Font.PLAIN, 12));
		menu.add(menuItem_3);
		
		JMenu menu_1 = new JMenu("Edit");
		menu_1.setFont(new Font("Arial", Font.PLAIN, 13));
		menuBar.add(menu_1);
		
		JMenuItem menuItem_4 = new JMenuItem("Cut");
		menuItem_4.setFont(new Font("Arial", Font.PLAIN, 12));
		menuItem_4.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				textArea.cut();
			}
		});
		menu_1.add(menuItem_4);
		
		JMenuItem menuItem_5 = new JMenuItem("Copy");
		menuItem_5.setFont(new Font("Arial", Font.PLAIN, 12));
		menuItem_5.setIcon(resizeImage(copyIcon, 20 ,20));
		menuItem_5.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				textArea.copy();
			}
		});
		menu_1.add(menuItem_5);
		
		JMenuItem menuItem_6 = new JMenuItem("Paste");
		menuItem_6.setFont(new Font("Arial", Font.PLAIN, 12));
		menuItem_6.setIcon(resizeImage(pasteIcon, 20 ,20));
		menuItem_6.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				textArea.paste();
			}
		});;
		menu_1.add(menuItem_6);
		
		JMenuItem menuItem_7 = new JMenuItem("Delete");
		menuItem_7.setFont(new Font("Arial", Font.PLAIN, 12));
		menuItem_7.setIcon(resizeImage(deleteIcon, 20 ,20));
		menuItem_7.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				textArea.replaceSelection("");
			}
		});
		menu_1.add(menuItem_7);
		
		JMenu menu_2 = new JMenu("Encode");
		menu_2.setFont(new Font("Arial", Font.PLAIN, 13));
		menuBar.add(menu_2);
		
		JMenu menu_3 = new JMenu("Encoding Technique");
		menu_3.setFont(new Font("Arial", Font.PLAIN, 12));
		menu_3.setIcon(resizeImage(tuneEncodingIcon, 25, 25));
		menu_2.add(menu_3);
		
		JMenuItem menuItem_8 = new JMenuItem("Rot13");
		menuItem_8.setFont(new Font("Arial", Font.PLAIN, 12));
		menuItem_8.addActionListener(CommandFactory.createCommand("Rot13"));
		menu_3.add(menuItem_8);
		
		JMenuItem menuItem_9 = new JMenuItem("AtBash");
		menuItem_9.setFont(new Font("Arial", Font.PLAIN, 12));
		menuItem_9.addActionListener(CommandFactory.createCommand("AtBash"));
		menu_3.add(menuItem_9);
		
		JMenuItem menuItem_10 = new JMenuItem("Encode Text");
		menuItem_10.setFont(new Font("Arial", Font.PLAIN, 12));
		menuItem_10.setIcon(resizeImage(encryptIcon, 19, 19));
		menuItem_10.addActionListener(CommandFactory.createCommand("Encode Text"));
		menu_2.add(menuItem_10);
		
		JMenu menu_4 = new JMenu("Speech");
		menu_4.setFont(new Font("Arial", Font.PLAIN, 13));
		menuBar.add(menu_4);
		
		JMenu menu_5 = new JMenu("Convert to Speech");
		menu_5.setFont(new Font("Arial", Font.PLAIN, 12));
		menu_5.setIcon(resizeImage(playIcon, 20, 20));
		menu_4.add(menu_5);
		
		JMenuItem menuItem_11 = new JMenuItem("Document");
		menuItem_11.setFont(new Font("Arial", Font.PLAIN, 12));
		menuItem_11.addActionListener(CommandFactory.createCommand("playDocument"));
		menu_5.add(menuItem_11);
		
		JMenuItem menuItem_12 = new JMenuItem("Reverse Document");
		menuItem_12.setFont(new Font("Arial", Font.PLAIN, 12));
		menuItem_12.addActionListener(CommandFactory.createCommand("playReverseDocument"));
		menu_5.add(menuItem_12);
		
		JMenuItem menuItem_13 = new JMenuItem("Line");
		menuItem_13.setFont(new Font("Arial", Font.PLAIN, 12));
		menuItem_13.addActionListener(CommandFactory.createCommand("playLine"));
		menu_5.add(menuItem_13);
		
		JMenuItem menuItem_14 = new JMenuItem("Reverse Line");
		menuItem_14.setFont(new Font("Arial", Font.PLAIN, 12));
		menuItem_14.addActionListener(CommandFactory.createCommand("playReverseLine"));
		menu_5.add(menuItem_14);
		
		JMenuItem menuItem_15 = new JMenuItem("Stop Audio");
		menuItem_15.setFont(new Font("Arial", Font.PLAIN, 12));
		menuItem_15.addActionListener(CommandFactory.createCommand("Stop Audio"));
		menuItem_15.setIcon(resizeImage(stopIcon, 20, 20));
		menu_4.add(menuItem_15);
		
		JMenu menu_6 = new JMenu("Tune Audio");
		menu_6.setFont(new Font("Arial", Font.PLAIN, 12));
		menu_6.setIcon(resizeImage(tuneAudioIcon, 25, 25));
		menu_4.add(menu_6);

		// Volume panel contains 2 labels, 
		// one for the title and one for the value.
		// It also contains a slider.
		// Next we will set up this panel and add it to the Tune Audio menu.
		
		JPanel volumePanel = new JPanel();
		volumePanel.setLayout(new GridBagLayout());
		
		GridBagConstraints gbc = new GridBagConstraints();
		
		JLabel volumeTitleLabel = new JLabel("Volume");
		volumeTitleLabel.setFont(new Font("Arial", Font.PLAIN, 14));
		gbc.weightx = 0.5;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 0;
		gbc.gridy = 0;
		// External padding. 5 from the top and bottom, 10 from the left.
		gbc.insets = new Insets(5, 10, 5, 0);
		volumePanel.add(volumeTitleLabel, gbc);
		
		// First we declare volumeLevelLabel to be used in JSliders ChangeListener.
		JLabel volumeLevelLabel = new JLabel("100");
		
		JSlider volume = new JSlider(JSlider.HORIZONTAL, 0, 100, 100);
		gbc.weightx = 0.0;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.insets = new Insets(0, 0, 0, 0);
		volumePanel.add(volume, gbc);
		volume.addChangeListener(new ChangeListener() {

			public void stateChanged(ChangeEvent e) {
				
				updateVolume(volume.getValue());

				volumeLevelLabel.setText("" + volume.getValue());
				
				ActionListener al = CommandFactory.createCommand("Tune Audio");
				ActionEvent event = new ActionEvent(volume, ActionEvent.RESERVED_ID_MAX + 1, "volume");
				al.actionPerformed(event);
			}
		});		
		
		// Following constraints concern volumeLevelLabel
		volumeLevelLabel.setFont(new Font("Arial", Font.PLAIN, 16));
		gbc.weightx = 0.5;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 1;
		gbc.gridy = 1;
		// External padding. 10 from the left and right.
		gbc.insets = new Insets(0, 10, 0, 10);
		volumePanel.add(volumeLevelLabel, gbc);
		
		menu_6.add(volumePanel);
		
		// Pitch panel contains 2 labels, 
		// one for the title and one for the value.
		// It also contains a slider.
		// Next we will set up this panel and add it to the Tune Audio menu.
		
		JPanel pitchPanel = new JPanel();
		pitchPanel.setLayout(new GridBagLayout());
		
		JLabel pitchTitleLabel = new JLabel("Pitch (Hertz)");
		pitchTitleLabel.setFont(new Font("Arial", Font.PLAIN, 14));
		gbc.weightx = 0.5;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 0;
		gbc.gridy = 0;
		// External padding. 5 from the top and bottom, 10 from the left.
		gbc.insets = new Insets(5, 10, 5, 0);
		pitchPanel.add(pitchTitleLabel, gbc);
		
		// First we declare pitchLevelLabel to be used in JSliders ChangeListener.
		JLabel pitchLevelLabel = new JLabel("100");
		pitchLevelLabel.setFont(new Font("Arial", Font.PLAIN, 16));
		
		JSlider pitch = new JSlider(JSlider.HORIZONTAL, 20, 550, 100);
		gbc.weightx = 0.0;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.insets = new Insets(0, 0, 0, 0);
		pitchPanel.add(pitch, gbc);
		pitch.addChangeListener(new ChangeListener() {
			
			public void stateChanged(ChangeEvent e) {
				
				updatePitch(pitch.getValue());
				
				pitchLevelLabel.setText("" + pitch.getValue());
				
				ActionListener al = CommandFactory.createCommand("Tune Audio");
				ActionEvent event = new ActionEvent(pitch, ActionEvent.RESERVED_ID_MAX + 2, "pitch");
				al.actionPerformed(event);
			}
		});
		
		// Following constraints concern pitchLevelLabel
		gbc.weightx = 0.5;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 1;
		gbc.gridy = 1;
		// External padding. 10 from the left and right.
		gbc.insets = new Insets(0, 10, 0, 10);
		pitchPanel.add(pitchLevelLabel, gbc);

		menu_6.add(pitchPanel);
		
		// Rate panel contains 2 labels, 
		// one for the title and one for the value.
		// It also contains a slider.
		// Next we will set up this panel and add it to the Tune Audio menu.
		
		JPanel ratePanel = new JPanel();
		ratePanel.setLayout(new GridBagLayout());
		
		JLabel rateTitleLabel = new JLabel("Rate (Words per Minute)");
		rateTitleLabel.setFont(new Font("Arial", Font.PLAIN, 14));
		gbc.weightx = 0.5;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 0;
		gbc.gridy = 0;
		// External padding. 5 from the top and bottom, 10 from the left.
		gbc.insets = new Insets(5, 10, 5, 0);
		ratePanel.add(rateTitleLabel, gbc);
		
		// First we declare rateLevelLabel to be used in JSliders ChangeListener.
		JLabel rateLevelLabel = new JLabel("150");
		rateLevelLabel.setFont(new Font("Arial", Font.PLAIN, 16));
		
		JSlider rate = new JSlider(JSlider.HORIZONTAL, 50, 500, 150);
		gbc.weightx = 0.0;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.insets = new Insets(0, 0, 0, 0);
		ratePanel.add(rate, gbc);
		rate.addChangeListener(new ChangeListener() {
			
			public void stateChanged(ChangeEvent e) {
				
				updateRate(rate.getValue());
				
				rateLevelLabel.setText("" + rate.getValue());
				
				ActionListener al = CommandFactory.createCommand("Tune Audio");
				ActionEvent event = new ActionEvent(rate, ActionEvent.RESERVED_ID_MAX + 3, "rate");
				al.actionPerformed(event);
			}
		});
		
		// Following constraints concern rateLevelLabel
		gbc.weightx = 0.5;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 1;
		gbc.gridy = 1;
		// External padding. 10 from the left and right.
		gbc.insets = new Insets(0, 10, 0, 10);
		ratePanel.add(rateLevelLabel, gbc);

		menu_6.add(ratePanel);
		
		JMenu menu_7 = new JMenu("Replay");
		menu_7.setFont(new Font("Arial", Font.PLAIN, 13));
		menuBar.add(menu_7);
		
		JMenuItem menuItem_16 = new JMenuItem("Replay Commands");
		menuItem_16.setFont(new Font("Arial", Font.PLAIN, 12));
		menuItem_16.setIcon(resizeImage(replayIcon, 15, 15));
		menuItem_16.addActionListener(CommandFactory.createCommand("Replay Commands"));
		menu_7.add(menuItem_16);
		
		JMenuItem menuItem_17 = new JMenuItem("Reset Sequence");
		menuItem_17.setFont(new Font("Arial", Font.PLAIN, 12));
		menuItem_17.addActionListener(CommandFactory.createCommand("Reset Replay Sequence"));
		menu_7.add(menuItem_17);
	}

	private ImageIcon findImage(String path) {
		
		java.net.URL url = getClass().getResource(path);
		if (url != null)
			return (new ImageIcon(url));
		return null;
	}
	
	private ImageIcon resizeImage(ImageIcon initialImage, int width, int height) {
		
		if (initialImage == null)
			return null;
		
		Image image = initialImage.getImage();
		Image newImage = image.getScaledInstance(width, height, java.awt.Image.SCALE_SMOOTH);
		
		return new ImageIcon(newImage);
	}
	
	public JFrame getFrame() {
		return this.frame;
	}
	
	public String getTextArea() {
		return textArea.getText();
	}
	
	public void setTextArea(String text) {
		textArea.setText(text);
	}
	
	public String[] getTitleAndAuthor() {
		
		String[] input = new String[2]; 
		
		JTextField titleField = new JTextField(10);
		JTextField authorField = new JTextField(10);
		
		JPanel myPanel = new JPanel();
		myPanel.add(new JLabel("Title"));
		myPanel.add(titleField);
		
		myPanel.add(Box.createHorizontalStrut(15));
		
		myPanel.add(new JLabel("Author"));
		myPanel.add(authorField);
		
		int result = JOptionPane.showConfirmDialog(frame, myPanel, 
	               "Please enter document title and author", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
		
		if (result == JOptionPane.OK_OPTION) {
			input[0] = titleField.getText();
			input[1] = authorField.getText();
			
			return input;
		}
		
		return null;
	}
	
	public int showUnsavedDocumentWarning() {
		
		Object[] buttons = { "Save", 
				"Don't save",
				"Cancel" };
		
		int result = JOptionPane.showOptionDialog(frame,
				"Save changes?",
				"Text2SpeechEditor",
				JOptionPane.YES_NO_CANCEL_OPTION,
				JOptionPane.PLAIN_MESSAGE,
				null,
				buttons,
				buttons[0]);

		return result;
	}

	public void updateLineIndex(int newLineIndex) {
		this.currentLineIndex = newLineIndex;
	}
	
	public int getCurrentLine() {
		return this.currentLineIndex;
	}
	
	public int getSelectionStart() {
		return this.textArea.getSelectionStart();
	}
	
	public int getSelectionEnd() {
		return this.textArea.getSelectionEnd();
	}
	
	public String getSelection() {
		return this.textArea.getSelectedText();
	}
	
	public void updateVolume(int level) {
		this.volumeLevel = level;
	}
	
	public int getVolume() {
		return this.volumeLevel;
	}
	
	public void updatePitch(int level) {
		this.pitchLevel = level;
	}
	
	public int getPitch() {
		return this.pitchLevel;
	}
	
	public void updateRate(int level) {
		this.rateLevel = level;
	}
	
	public int getRate() {
		return this.rateLevel;
	}
}
