package view.windowframe;

import java.awt.Component;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

import view.Constants;
import view.ViewComponentBehavior;

public class WindowFrame implements ViewComponentBehavior {

	// Concrete implementation class of ViewComponentBehavior.
	
	private JFrame frame;
	
	@Override
	public void initialize() {

		frame = new JFrame(Constants.FRAME_NAME);
		frame.setSize(Constants.FRAME_WIDTH, Constants.FRAME_HEIGHT);
		frame.setLocationRelativeTo(null);
		
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		
		frame.addWindowListener(new WindowAdapter() {
			
			@Override
			public void windowClosing(WindowEvent e) {
				System.out.println("Closing main window.");
//				UnsavedDocumentCheck check = new UnsavedDocumentCheck();
//				if (check.check())
//					if (check.callToAction() == -1)
//						return;
				e.getWindow().dispose();
			}
		});
	}

	@Override
	public Component getComponent() {

		return frame;
	}

}
