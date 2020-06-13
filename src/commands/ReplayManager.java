package commands;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ReplayManager {

	private final int commandSequenceSize = 5;
	private ArrayList<ActionListener> commandSequence;
	
	public ReplayManager() {

		this.commandSequence = new ArrayList<ActionListener>();
	}
	
	public void addCommand(ActionListener newCommand) {
		
		if (checkForVacancy())
			commandSequence.add(newCommand);
		else {
			commandSequence.remove(0);
			commandSequence.add(newCommand);	// ArrayList handles all the moving.
		}
//		System.out.println("Added command: " + newCommand.getClass().toString() + 
//							". New size: " + commandSequence.size());
	}
	
	public boolean checkForVacancy() {

		if (commandSequence.size() < commandSequenceSize)
			return true;
		
		return false;
	}
	
	public void reset() {
		
		commandSequence.clear();
	}
	
	public void replay(ActionEvent event) {
		
		// TODO
		// TuneAudio & TuneEncoding aren't implemented for replaying.
		// They are depending on the ActionEvent to determine their action.
		// We must store their events separately.
		for (ActionListener al : commandSequence) {
			al.actionPerformed(event);
		}
	}
	
	public void printSequence() {

		for (int i = 0; i < commandSequence.size(); i++) {
			System.out.println(commandSequence.get(i).getClass().toString());
		}
	}
}
