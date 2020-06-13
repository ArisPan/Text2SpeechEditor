package model;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.charset.Charset;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Iterator;

public class FileController {

	private String name;
	private Path path;
	private boolean fileCreated = false;
	
	public void setFileName(String name) {
		
		this.name = name;
	}
	
	public void setPath(String filePath) {
		
		this.path = Path.of(filePath);
	}
	
	public String getPath() {
		
		return this.path.toString();
	}
	
	public void createNewFile() {
		
		try {
			if (!Files.exists(this.path)) {
				
				this.path = Files.createFile(this.path);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		this.fileCreated = true;
	}

	public boolean getFileCreated() {
		return this.fileCreated;
	}

	public void setFileCreated(boolean fileCreated) {
		this.fileCreated = fileCreated;
	}
	
	public ArrayList<Line> readFromPath() {
		
		ArrayList<Line> contents = new ArrayList<Line>();
		
		try {
			Scanner scanner = new Scanner(this.path);
			
			while (scanner.hasNextLine()) {
				
				String line = scanner.nextLine();

				contents.add(Line.toLine(line));
			}
			scanner.close();
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("File " + this.name + " not found.");
		}
		
		return contents;
	}
	
	public void writeToPath(ArrayList<Line> contents) {
		
		try (BufferedWriter writer = Files.newBufferedWriter(this.path, Charset.forName("UTF-8"))) {
			
			Iterator<Line> lineIterator = contents.iterator();
			
			while (lineIterator.hasNext()) {
				
				Line lineToBeWritten = lineIterator.next();
				ArrayList<String> wordsToBeWritten = lineToBeWritten.getWordList();				
				Iterator<String> wordIterator = wordsToBeWritten.iterator();
				
				while (wordIterator.hasNext()) {
					
					writer.write(wordIterator.next());
					
					if (wordIterator.hasNext())
						writer.write(" ");
				}
				
				if (lineIterator.hasNext())
					writer.write("\n");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
