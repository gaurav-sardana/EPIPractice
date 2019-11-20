package hashtablesbootcamp;

import java.util.HashMap;
import java.util.Map;

public class Problem2IsAAnonymousLetterConstructible {

	public static void main(String[] args) {
		System.out.println(isLetterConstructibleFromMagazine("hellod", "helloWord"));
	}

	public static boolean isLetterConstructibleFromMagazine(String letterText, String magazineText) {

		Map<Character, Integer> charactersMapLetter = new HashMap<Character, Integer>();
		for (int i = 0; i < letterText.length(); i++) {
			char charAt = letterText.charAt(i);
			if (!charactersMapLetter.containsKey(charAt)) {
				charactersMapLetter.put(charAt, 1);
			} else {
				charactersMapLetter.put(charAt, charactersMapLetter.get(charAt));
			}
		}

		for (char c : magazineText.toCharArray()) {
			if (charactersMapLetter.containsKey(c)) {
				charactersMapLetter.put(c, charactersMapLetter.get(c) - 1);
				if (charactersMapLetter.get(c) == 0) {
					charactersMapLetter.remove(c);
					if (charactersMapLetter.isEmpty()) {
						break;
					}
				}
			}
		}
		return charactersMapLetter.isEmpty();
	}

}
