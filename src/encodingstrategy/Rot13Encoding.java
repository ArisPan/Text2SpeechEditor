package encodingstrategy;

import model.Line;
import java.lang.StringBuilder;

public class Rot13Encoding implements EncodingStrategy {
	
	@Override
	public Line encode(Line line) {
		
		StringBuilder encodedLine = new StringBuilder();
		String initialLine = new String(line.toString());

		for (char nextChar : initialLine.toCharArray()) {
			
			if (nextChar >= 'a' && nextChar <= 'm')			encodedLine.append(nextChar += 13);
			else if (nextChar >= 'A' && nextChar <= 'M')	encodedLine.append(nextChar += 13);
			else if (nextChar >= 'n' && nextChar <= 'z')	encodedLine.append(nextChar -= 13);
			else if (nextChar >= 'N' && nextChar <= 'Z')	encodedLine.append(nextChar -= 13);
			else											encodedLine.append(nextChar);
		}
		
		return Line.toLine(encodedLine.toString());
	}
}
