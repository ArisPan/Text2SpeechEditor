package commands;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TuneEncoding implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent event) {
		
		EncodingController ec = EncodingController.getInstance();
		ec.setStrategy(event.getActionCommand());
	}
}
