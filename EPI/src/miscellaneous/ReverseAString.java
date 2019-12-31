package miscellaneous;

public class ReverseAString {

	public static void main(String[] args) {

	}

	private void reverseString(String str) {
		char[] charArray = str.toCharArray();
		int left = 0, right = charArray.length - 1;
		while (left < right) {
			char temp = charArray[left];
			charArray[left++] = charArray[right];
			charArray[right--] = temp;
		}
		System.out.println(new String(charArray));

	}

}
