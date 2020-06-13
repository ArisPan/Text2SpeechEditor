package encodingstrategy;

import model.Line;
import java.lang.StringBuilder;

public class AtBashEncoding implements EncodingStrategy {

	@Override
	public Line encode(Line line) {
		
		StringBuilder encodedLine = new StringBuilder();
		String initialLine = new String(line.toString());

		for (char nextChar : initialLine.toCharArray()) {
			
			if (Character.isLetter(nextChar)) {
				
				if (Character.isUpperCase(nextChar))		encodedLine.append((char) ('A' + ('Z' - nextChar)));				
				else if (Character.isLowerCase(nextChar))	encodedLine.append((char) ('a' + ('z' - nextChar)));
			}
			else
				encodedLine.append(nextChar);
		}
		
		return Line.toLine(encodedLine.toString());
	}
}
