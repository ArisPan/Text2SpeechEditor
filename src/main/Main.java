package main;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.UIManager;

import commands.ViewController;
import view.TextToSpeechEditorView;

public class Main {

	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					
					ViewController vc = ViewController.getInstance();
					
					TextToSpeechEditorView window = vc.getEditorView();
					JFrame frame = window.getFrame();
					frame.setVisible(true);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
