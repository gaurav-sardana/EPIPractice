package miscellaneous;

import java.util.Deque;
import java.util.LinkedList;

public class ValidateParenthesisExpression {

	public static void main(String[] args) {
		String wellFormed = "[(])";
		System.out.println(isWellFormed(wellFormed));

	}

	public static boolean isWellFormed(String s) {
		Deque<Character> leftBrackets = new LinkedList<>();
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[') {
				leftBrackets.addFirst(s.charAt(i));
			} else {
				if (leftBrackets.isEmpty()) {
					return false;
				}
				if ((s.charAt(i) == ')' && leftBrackets.peekFirst() != '(') || (s.charAt(i) == '}' && leftBrackets.peekFirst() != '{')
						|| (s.charAt(i) == ']' && leftBrackets.peekFirst() != '[')) {
					return false;
				}
				leftBrackets.removeFirst();
			}
		}
		return leftBrackets.isEmpty();
	}

}
