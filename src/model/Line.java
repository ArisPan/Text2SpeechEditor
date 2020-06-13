package model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;
import java.lang.StringBuilder;

public class Line {

	private ArrayList<String> line;
	
	public Line() {
		
		this.line = new ArrayList<String>();
	}
	
	public void addWord(String word) {
		
		this.line.add(word);
	}
	
	public void removeWord(int index) {
		
		this.line.remove(index);
	}
	
	public ArrayList<String> getWordList() {
		
		return this.line;
	}
	
	public String toString() {
		
		StringBuilder stringBuilderLine = new StringBuilder();
		Iterator<String> iterator = line.iterator();

		while (iterator.hasNext()) {
			
			stringBuilderLine.append(iterator.next());
			
			if (iterator.hasNext())
				stringBuilderLine.append(" ");
		}

		return stringBuilderLine.toString();
	}

	public static Line toLine(String lineAsString) {
		
		Line newLine = new Line();
		String[] words = lineAsString.split(" ");

		for (String word : words) {
			
			newLine.addWord(word);
		}
		
		return newLine;
	}

	public Line reverseLine() {
		
		Line reversedLine = new Line();
		ListIterator<String> iterator = this.line.listIterator();
		
		// Get to the end of the ListIterator
		while (iterator.hasNext()) {
			iterator.next();
		}
		while (iterator.hasPrevious()) {
			reversedLine.addWord(iterator.previous());
		}

		return reversedLine;
	}
}
