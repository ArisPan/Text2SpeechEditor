package commands;

import java.awt.event.ActionListener;

public class CommandFactory {

	public static ActionListener createCommand(String commandType) {
		
		switch(commandType) {
		case "New":
			return new NewDocument();
		case "Save":
			return new SaveDocument();
		case "Open":
			return new OpenDocument();
		case "Rot13":
		case "AtBash":
			return new TuneEncoding();
		case "Encode Text":
			return new EncodeText();
		case "playDocument":
			return new DocumentToSpeech();
		case "playReverseDocument":
			return new ReverseDocumentToSpeech();
		case "playLine":
			return new LineToSpeech();
		case "playReverseLine":
			return new ReverseLineToSpeech();
		case "Stop Audio":
			return new StopAudio();
		case "Tune Audio":
			return new TuneAudio();
		case "Replay Commands":
			return new ReplayCommands();
		case "Reset Replay Sequence":
			return new ResetSequence();
		default:
			throw new IllegalArgumentException("Command \"" + commandType + "\" is not supported.");
		}
	}
}
