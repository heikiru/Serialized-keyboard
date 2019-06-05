import java.util.ArrayList;

public class StringToChar {
	
	public ArrayList<Character> stringToChar(String pan) {
		ArrayList<Character> chars = new ArrayList<Character>();
		for (char c : pan.toCharArray()) {
		  chars.add(c);
		}
		return chars;
	}

}
