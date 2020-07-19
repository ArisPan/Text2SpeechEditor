package view.textarea;

import java.awt.Component;
import java.awt.Font;
import java.awt.Insets;

import javax.swing.JTextArea;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;

import view.Constants;
import view.ViewComponentBehavior;

public class TextArea implements ViewComponentBehavior, TextDataBehavior {

	// Concrete implementation class of ViewComponentBehavior.
	
	private JTextArea textArea;
	private int currentLineIndex;
	
	@Override
	public void initialize() {

		textArea = new JTextArea();
		
		textArea.setMargin(new Insets(Constants.TEXT_INSETS, Constants.TEXT_INSETS,
									Constants.TEXT_INSETS, Constants.TEXT_INSETS));
		textArea.setFont(new Font(Constants.TYPEFACE, Constants.FONT_TYPE, Constants.TEXT_FONT_SIZE));
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
		
		textArea.addCaretListener(new CaretListener() {

			@Override
			public void caretUpdate(CaretEvent event) {

				try {
					
					int caretPosition = textArea.getCaretPosition();
					currentLineIndex = textArea.getLineOfOffset(caretPosition);
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	@Override
	public Component getComponent() {

		return textArea;
	}

	@Override
	public void setText(String text) {
		textArea.setText(text);
	}

	@Override
	public String getText() {
		return textArea.getText();
	}

	@Override
	public String getSelection() {
		return textArea.getSelectedText();
	}
	
	@Override
	public int getCurrentLineIndex() {
		return currentLineIndex;
	}
}
