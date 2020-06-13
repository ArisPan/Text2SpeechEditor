package model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

import encodingstrategy.EncodingStrategy;
import text2speechstrategy.TTSStrategy;

public class Document {

	private Properties properties;
	private ArrayList<Line> contents;
	private FileController fc = new FileController();
	
	/*
	 *	Implementation tests.
	 */
	
	public String getDateLastSaved() {
		
		return properties.getDateLastSaved();
	}
	
	public void printContents() {
		
		for (Line lineToBeRead : contents) {
			for (String wordToBeRead : lineToBeRead.getWordList()) {
				
				System.out.println(wordToBeRead);
			}
		}
	}

	/*
	 *	Document helper methods.
	 */
	
	public void updateContents(String text) {
		
		ArrayList<Line> newContents = new ArrayList<Line>();
		
		String seperator = "\\R";		// Matches any Unicode linebreak sequence
		String[] lines = text.split(seperator);

		for (String line : lines) {
			
			newContents.add(Line.toLine(line));
		}
		createDocument("", "");
		replaceContents(newContents);
	}
	
	public void replaceContents(ArrayList<Line> newContents) {
		
		this.contents.clear();
		
		for (int i = 0; i < newContents.size(); i++) {
			
			this.contents.add(newContents.get(i));
		}
	}
	
	public String contentsToString() {
		
		// Returns a String representation of current this.contents.
		// It's a useful operation for updating the view.
		// It mainly exists to keep the controller away 
		// from the private fields of Document.
		
		StringBuilder stringBuilderContents = new StringBuilder();
		Iterator<Line> iterator = this.contents.iterator();
		
		while (iterator.hasNext()) {
			
			stringBuilderContents.append(iterator.next().toString());
			
			if (iterator.hasNext())
				stringBuilderContents.append(System.lineSeparator());
		}

		return stringBuilderContents.toString();
	}

	public boolean compareContents(String newContents) {
		
		// Compares input string with current this.contents.
		// Returns true if contents are equal, false otherwise.

		String existingContents = contentsToString();
		
		// First we check the length, it's cheaper.
		if (existingContents.length() != newContents.length())
			return false;
		
		if (existingContents.equals(newContents))
			return true;
		
		return false;
	}
	
	public boolean checkForUnsavedDocument(String editorText) {
		
		// Checks if the changes to the editor have been saved to a file.
		// If no file has been created or the changes have not been saved,
		// returns true. Returns false if all changes have already been saved.
		
		if (fc.getFileCreated()) {
			
			// Read file contents to an ArrayList.
			ArrayList<Line> fileText = fc.readFromPath();
			
			// Turn this ArrayList to a single string.
			StringBuilder stringBuilderFileText = new StringBuilder();
			Iterator<Line> iterator = fileText.iterator();
			
			while (iterator.hasNext()) {
				
				stringBuilderFileText.append(iterator.next().toString());
				
				if (iterator.hasNext())
					stringBuilderFileText.append(System.lineSeparator());
			}

			String stringFileText = stringBuilderFileText.toString();
			updateContents(editorText);		// Update document contents with the editors text.

			// Compare those two.
			// Return false if they're the same, true if they differ.
			return !compareContents(stringFileText);
		}
		else {
			
			// This mainly covers the case of trying to open a new file
			// right after opening the application. No changes to the editor text.
			if (editorText.isBlank())
				return false;
		}
		return true;
	}
	
	/*
	 *	Document base functionality.
	 */
	
	public void createDocument(String author, String title) {

		if (properties == null)
			this.properties = new Properties(author, title);
		
		if (contents == null)
			this.contents = new ArrayList<Line>();
	}
	
	public void saveDocument(String fileName, String filePath) {
		
		createDocument("", "");
		
		fc.setFileName(fileName);
		fc.setPath(filePath);
		
		fc.createNewFile();
		
		fc.writeToPath(contents);
		
		this.properties.setDateLastSaved();
	}
	
	public void openDocument(String fileName, String filePath) {
		
		fc.setFileName(fileName);
		fc.setPath(filePath);

		contents = fc.readFromPath();
		
		fc.setFileCreated(true);
	}

	/*
	 *	Document encoding.
	 */
	
	public void encodeDocument(EncodingStrategy strategy) {
		
		ArrayList<Line> encodedContents = new ArrayList<Line>();
		
		for (Line line : contents) {
			
			encodedContents.add(strategy.encode(line));
		}

		replaceContents(encodedContents);
	}

	public void encodeLine(EncodingStrategy strategy, int lineIndex) {
		
		Line encodedLine = strategy.encode(this.contents.get(lineIndex));
		
		this.contents.set(lineIndex, encodedLine);
	}
	
	/*
	 *	Document to speech functionality.
	 */
	
	public void playContents(TTSStrategy strategy) {
		
		strategy.play(contents.toString());
	}
	
	public void playReverseContents(TTSStrategy strategy) {
		
		Line reversedLine = new Line();
		StringBuilder stringBuilderReverseContents = new StringBuilder();
		ListIterator<Line> contentsIterator = this.contents.listIterator();
		
		// Get to the end of the ListIterator
		while (contentsIterator.hasNext()) {
			contentsIterator.next();
		}
		// Build a new string with contents in reverse.
		while (contentsIterator.hasPrevious()) {

			reversedLine = contentsIterator.previous().reverseLine();
			stringBuilderReverseContents.append(reversedLine.toString());
		}
		strategy.play(stringBuilderReverseContents.toString());
	}
	
	public void playLine(TTSStrategy strategy, int lineIndex) {
		
		Line line = contents.get(lineIndex);
		
		strategy.play(line.toString());
	}
	
	public void playReverseLine(TTSStrategy strategy, int lineIndex) {
		
		Line initialLine = contents.get(lineIndex);
		Line reversedLine = new Line();		

		reversedLine = initialLine.reverseLine();

		strategy.play(reversedLine.toString());
	}
	
	public void stopAudio(TTSStrategy strategy) {
		
		strategy.stop();
	}
}
