package stacksandqueuesbootcamp;

import java.util.Deque;
import java.util.LinkedList;

public class Problem3TestAStringOverForWellFormedness {

	public static void main(String[] args) {
		System.out.println(wellFormed("{[({})]}"));

	}

	//time complexity O(n),since for each character we perform O(1) operation and  space complexity O(1) 
	public static boolean wellFormed(String str) {
		Deque<Character> leftChars = new LinkedList<Character>();
		for (int i = 0; i < str.length(); i++) {
			Character charAt = str.charAt(i);
			if (charAt == '(' || charAt == '{' || charAt == '[') {
				leftChars.addFirst(charAt);
			} else {
				if (leftChars.isEmpty())
					return false;
				Character peekFirst = leftChars.peekFirst();
				if ((charAt == ')' && peekFirst != '(') || (charAt == ']' && peekFirst != '[')
						|| (charAt == '}' && peekFirst != '{')) {
					return false;
				}
				leftChars.removeFirst();
			}
		}
		return leftChars.isEmpty();
	}

}
